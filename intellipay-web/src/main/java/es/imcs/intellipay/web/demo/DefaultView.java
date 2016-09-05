package es.imcs.intellipay.web.demo;

import java.io.File;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

import com.vaadin.server.FileResource;

import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";

    @PostConstruct
    void init() {

    //	String basepath = "D:/ws/code/intellipay-microservices/intellipay-web/";
    	
    	String basepath = "D:/ws/code/intellipay/intellipay-web/";
    	// La imagen como un recurso de fichero
    	FileResource resource = new FileResource(new File(basepath +
    	"ms.png"));
    	Image image = new Image("", resource);
    	addComponent(image);
    	setSizeFull();
    }
 
    @Override
    public void enter(ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}