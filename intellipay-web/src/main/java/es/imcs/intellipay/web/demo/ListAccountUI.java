package es.imcs.intellipay.web.demo;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import es.imcs.intellipay.accounts.entity.Account;

@SpringView(name = ListAccountUI.VIEW_NAME)
public class ListAccountUI extends VerticalLayout implements View{

    public static final String VIEW_NAME = "listAccount";
    private final Grid grid;

	@Autowired
	private AccountClient accountClient;
	
	
	public ListAccountUI(){
	    this.grid = new Grid();
	    
	}
	
	@PostConstruct
	protected void init() {
	    VerticalLayout mainLayout = new VerticalLayout(grid);
	    //setParent(mainLayout);
	    
	    mainLayout.setSpacing(true);
	    mainLayout.setMargin(true);
	    
	    grid.setHeight(300, Unit.PIXELS);
	    grid.setWidth(100,Unit.PERCENTAGE);
	   // grid.setColumns("id","Account Type", "CitizenShip Country Code");
	    addComponent(mainLayout);
	    
	    if (!accountClient.getAccounts().isEmpty())
	    	grid.setContainerDataSource(new BeanItemContainer(Account.class,accountClient.getAccounts()));

	}
    
    
    @Override
    public void enter(ViewChangeEvent event) {
	// TODO Auto-generated method stub
	
    }
    
 

}
