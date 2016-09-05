package es.imcs.intellipay.web.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import es.imcs.intellipay.payments.entity.Payer;
import lombok.extern.slf4j.Slf4j;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormLayout;

@Slf4j
@SpringView(name = PayerUI.VIEW_NAME)
public class PayerUI extends VerticalLayout implements View {
	
	public static final String VIEW_NAME = "payer";
	
	private final TextField paymentMethod;
	private final TextField phone;
	private final TextField code;
	private final TextField recipientName;
	private final TextField name;
	private final TextField lastname;
	private final Button save;
	private Payer payer;

	@Autowired
	private PayerFeignClient payerClient;
	
	public PayerUI(){
		
		payer = new Payer();
		this.paymentMethod = new TextField("Payment Method");
		this.phone = new TextField("Phone");
		this.code = new TextField("Code");
		this.recipientName = new TextField("Recipient Name");
		this.name = new TextField("Name");
		this.lastname = new TextField("Lastname");
		this.save = new Button("Save", FontAwesome.SAVE);
	}
	
	

	@PostConstruct
	protected void init() {
		
		VerticalLayout infoname = new VerticalLayout(this.name, lastname,recipientName);
		VerticalLayout info = new VerticalLayout(paymentMethod, phone, code);
		HorizontalLayout payerInfo = new HorizontalLayout(infoname, info);
		VerticalLayout mainLayout = new VerticalLayout(payerInfo,save);		
		
		infoname.setSpacing(true);
		info.setSpacing(true);
		payerInfo.setSpacing(true);
		
		mainLayout.setSpacing(true);
		mainLayout.setMargin(true);
		// Now create the binder and bind the fields
	
		this.setMargin(true);
		addComponent(mainLayout);
		
		save.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				payer.setName(name.getValue());
				payer.setLastname(lastname.getValue());
				payer.setPaymentMethod(paymentMethod.getValue());
				payer.setCode(code.getValue());
				payer.setPhone(phone.getValue());
				payer.setRecipientName(recipientName.getValue());

				log.info("Entramos por el evento click Añadir Payer");
				
				log.info(payer.toString());
			
				Payer payerAdded = payerClient.createPayer(payer);
				log.info("Hemos insertado en la BBDD");
				log.info(payerAdded.toString());
			}
		});
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {

		
	}



}
