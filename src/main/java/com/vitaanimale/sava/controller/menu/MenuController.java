package com.vitaanimale.sava.controller.menu;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Elisa
 */
@ManagedBean
@ViewScoped
public class MenuController implements Serializable {
    private static final long serialVersionUID = 4715205197117834348L;

    private MenuModel model;

    public MenuModel getModel() {
        return model;
    }
    
    public MenuController() {
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Cadastro");
        DefaultMenuItem item;
        
        DefaultMenuItem item1 = new DefaultMenuItem("Cadastro de Clientes");
        item1.setUrl("/faces/pages/cadastro/clientes.xhtml");
        item1.setIcon("ui-icon-disk");
        firstSubmenu.addElement(item1);
        
        DefaultMenuItem item2 = new DefaultMenuItem("Cadastro de Animais");
        item2.setUrl("/faces/pages/cadastro/animais.xhtml");
        item2.setIcon("ui-icon-disk");
        firstSubmenu.addElement(item2);

        model.addElement(firstSubmenu);

    }  

}
