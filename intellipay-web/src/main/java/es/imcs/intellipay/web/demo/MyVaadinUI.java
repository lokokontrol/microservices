package es.imcs.intellipay.web.demo;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;

@Theme("valo")
@SpringUI
public class MyVaadinUI extends UI {

	    @Autowired
	    private SpringViewProvider viewProvider;
	
    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);
        

        final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        
        //Añadimos Componentes al menu
        navigationBar.addComponent(createNavigationButton("Home",
        		DefaultView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("New Payer",
        		PayerUI.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("New Account",
			AccountUI.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("New Payment",
    			PaymentUI.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Payers",
    			PayersUI.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Accounts",
			ListAccountUI.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Payments",
    			PaymentsUI.VIEW_NAME));

        //Añadimos la barra de menu al layout
        
        root.addComponent(navigationBar);

        //Creamos un Panel y lo añadimos al layout
        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0f);

        
        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
    }

    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        // If you didn't choose Java 8 when creating the project, convert this to an anonymous listener class
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }
}