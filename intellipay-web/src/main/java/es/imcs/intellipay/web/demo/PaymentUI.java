package es.imcs.intellipay.web.demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import es.imcs.intellipay.basetypes.Amount;
import es.imcs.intellipay.basetypes.Name;
import es.imcs.intellipay.payments.entity.Payer;
import es.imcs.intellipay.payments.entity.PayerInfo;
import es.imcs.intellipay.payments.entity.Payment;
import es.imcs.intellipay.payments.entity.Transaction;
import lombok.extern.slf4j.Slf4j;

@SpringView(name = PaymentUI.VIEW_NAME)
@EntityScan(basePackageClasses={Amount.class})
@Slf4j
public class PaymentUI extends VerticalLayout implements View {
	
	public static final String VIEW_NAME = "payment";
	
	private final TextField state;
	private final TextField intent;
	private final ComboBox combo;
	private final Button savebutton;
	private Label info;
	private Label paymentTittle;
	private final TextField description;
	private final TextField currency;
	private final TextField total;
	private final Button savetransactionbutton;
	private Label transactionTittle; 
	
	private HorizontalLayout body;
	private VerticalLayout paymentLayout;
	private VerticalLayout transactionLayout;
	
	@Autowired
	private PayerFeignClient payerClient;
	
	private Payer payer;
	private Payment payment;
	
	
	public PaymentUI(){
		
		body = new HorizontalLayout();
		

		this.transactionTittle = new Label("Transaction's Fields");
		this.currency = new TextField("Currency");
		this.total = new TextField("Total");
		this.description = new TextField("Description");
		this.savetransactionbutton = new Button("Save Transaction");
		transactionLayout = new VerticalLayout(transactionTittle,currency,total,description,savetransactionbutton);
		
		
		this.paymentTittle = new Label("Payment's Fields");
		this.state = new TextField("State");
		this.intent = new TextField("Intent");
		this.combo =  new ComboBox("Payers");
		savebutton = new Button("Save");
		paymentLayout = new VerticalLayout(paymentTittle,state,intent,combo,savebutton);
		
		
		info =  new Label();
		payer = new Payer();
		payment = new Payment();
		
		
	}

	@PostConstruct
	protected void init() {
		
		
		transactionLayout.setSpacing(true);
		paymentLayout.setSpacing(true);
		body.setMargin(true);
		body.setSpacing(true);
		
		body.addComponent(transactionLayout);
		
		
		
		addComponent(body);
		
		savetransactionbutton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Amount amount = new Amount();
				amount.setTotal(total.getValue());
				amount.setCurrency(currency.getValue());
			
				String desc = description.getValue();
				Transaction trans = new Transaction();
				
				trans.setAmount(amount);
				trans.setDescription(desc);
				
				
				payment.setTransaction(trans);
				
				body.addComponent(paymentLayout);

				
			}
		});
		
		savebutton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				payment.setIntent(intent.getValue());
				payment.setState(state.getValue());
				payment.setPayer(payer);
				payerClient.createPayment(payment);
				log.info(payment.toString());
			}
		});
		
		if (!payerClient.getPayers().isEmpty())
			combo.setContainerDataSource(new BeanItemContainer(Payer.class, payerClient.getPayers()));
	
		combo.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		
		combo.setItemCaptionPropertyId("name");
		
		
		
		combo.addValueChangeListener(new ValueChangeListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				
				log.info(combo.getValue().toString());
				payer = (Payer) combo.getConvertedValue();
				info.setCaption("Has seleccionado a "+combo.getValue().toString() + " con ID " + payer.getPayerId());
				addComponent(info);
			}
		});

		setMargin(true);
		
	}
	
	
	

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	

}



	