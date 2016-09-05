package es.imcs.intellipay.web.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StringUtils;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Component.Event;

import es.imcs.intellipay.payments.boundary.PayerService;
import es.imcs.intellipay.payments.control.PayerServiceImp;
import es.imcs.intellipay.payments.control.PaymentRepository;
import es.imcs.intellipay.payments.entity.Payer;
import es.imcs.intellipay.payments.entity.Payment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringView(name = PaymentsUI.VIEW_NAME)
@EntityScan(basePackageClasses={Payment.class})
@EnableJpaRepositories(basePackageClasses={PaymentRepository.class})
public class PaymentsUI extends VerticalLayout implements View{
	
	public static final String VIEW_NAME = "payments";

	private final Grid grid;

	private final TextField filter;
	
	

	
	@Autowired
	private PayerFeignClient payerClient;

	
	public PaymentsUI() {
		this.grid = new Grid();
		this.filter = new TextField();
	}

	@PostConstruct
	protected void init() {

		// build layout
		HorizontalLayout actions = new HorizontalLayout(filter);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid);
		addComponent(mainLayout);

		// Configure layouts and components
		actions.setSpacing(true);
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);

		grid.setHeight(300, Unit.PIXELS);
		grid.setWidth(80, Unit.PERCENTAGE);

		filter.setInputPrompt("Filter by last name");

		// Hook logic to components

		// Metodo q se llama cuando buscas a uno por el buscador.
		// Replace listing with filtered content when user changes filter
		filter.addTextChangeListener(e -> listPayments(e.getText()));

		// Initialize listing
		listPayments(null);
	
	}


	private void listPayments(String text) {
		log.info("Texto introducido buscador "+ text);
		if (StringUtils.isEmpty(text)) {
			if(!payerClient.getPayments().isEmpty())
				grid.setContainerDataSource(new BeanItemContainer(Payment.class, payerClient.getPayments()));
			//grid.setColumnOrder("payerId","name","lastname","phone","code","paymentMethod");

		} else {
			log.info("Entramos " + payerClient.getPayersHandled(text).toString());
			grid.setContainerDataSource(new BeanItemContainer(Payment.class, payerClient.getPayersHandled(text)));
		}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
// end::listCustomers[]