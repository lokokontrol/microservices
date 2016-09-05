package es.imcs.intellipay.web.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import es.imcs.intellipay.accounts.boundary.AccountService;
import es.imcs.intellipay.accounts.entity.Account;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import lombok.extern.slf4j.Slf4j;

@SpringView(name = AccountUI.VIEW_NAME)
@Slf4j
public class AccountUI extends VerticalLayout implements View {
	
	public static final String VIEW_NAME = "account";
	
	private final TextField accountType;
	private final TextField citizenshipCountryCode;
	private final TextField contactPhoneNumber;
	private final TextField mobilePhoneNumber;
	private final TextField currencyCode;
	private final TextField dateOfBirth;
	private final TextField email;
	private final TextField addressType;
	private final TextField line1;
	private final TextField line2;
	private final TextField city;
	private final TextField countryCode;
	private final TextField postalCode;
	private final TextField state;
	private final TextField businessName;
	private final TextField businessType;
	private final Button save;
	private Account account;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountClient accountClient;
	

	public AccountUI(){
		this.accountType = new TextField("Account Type");
		this.citizenshipCountryCode = new TextField("Citizenship Country Code");
		this.contactPhoneNumber = new TextField("Contact Phone Number");
		this.mobilePhoneNumber = new TextField("Mobile Phone Number");
		this.currencyCode = new TextField("Currency Code");
		this.dateOfBirth = new TextField("Date Of Birth");
		this.email = new TextField("Email");
		this.addressType = new TextField("Address Type");
		this.line1 = new TextField("Number, street, etc");
		this.line2 = new TextField("Suite, apt");
		this.city = new TextField("City");
		this.countryCode = new TextField("Country Code");
		this.postalCode = new TextField("Postal Code");
		this.state = new TextField("State");
		this.businessName = new TextField("Business Name");
		this.businessType = new TextField("Business Type");
		this.save = new Button("Save", FontAwesome.SAVE);
		account = new Account();
		

		
	}

	@PostConstruct
	protected void init() {
		
		VerticalLayout layout1 = new VerticalLayout(accountType,citizenshipCountryCode,contactPhoneNumber,
					 mobilePhoneNumber,currencyCode,dateOfBirth,email,addressType);
		VerticalLayout layout2 = new VerticalLayout(line1,line2,city,countryCode,postalCode,state,
					 businessName,businessType);
		HorizontalLayout accountInfo = new HorizontalLayout(layout1, layout2);
		VerticalLayout mainLayout = new VerticalLayout(accountInfo,save);
		
		
		layout1.setSpacing(true);
		layout2.setSpacing(true);
		accountInfo.setSpacing(true);
		mainLayout.setSpacing(true);
		mainLayout.setMargin(true);
		
		this.setMargin(true);
		
		addComponent(mainLayout);
		
		save.addClickListener(new ClickListener() {
		    
		    @Override
		    public void buttonClick(ClickEvent event) {
			account.setAccountType(accountType.getValue());
			account.setCitizenshipCountryCode(citizenshipCountryCode.getValue());
			//log.info(account.toString());
			//accountClient.getAccounts();
			//accountClient.createAccount(account);
			
			log.info("Hemos dado al botón");
			
			Account account2 = accountClient.createAccount(account);
			log.info("Lo guardamos en BBDD");
			log.info(account2.toString());
			
			
			
		    }
		});
		
		

	}
	
	

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}

