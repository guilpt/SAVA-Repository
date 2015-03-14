package com.vitaanimale.sava.controller.menu;

import com.vitaanimale.sava.controller.AnimaisController;
import com.vitaanimale.sava.controller.ClientesController;
import com.vitaanimale.sava.controller.MedicosVeterinariosController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Elisa
 */
@ManagedBean
@ViewScoped
public class MenuController implements Serializable {
    private static final long serialVersionUID = 4715205197117834348L;

    @ManagedProperty("#{clientesController}")
    private ClientesController clientesController;
    
    @ManagedProperty("#{animaisController}")
    private AnimaisController animaisController;
    
    @ManagedProperty("#{medicosVeterinariosController}")
    private MedicosVeterinariosController medicosVeterinariosController;

    public void setClientesController(ClientesController clientesController) {
        this.clientesController = clientesController;
    }

    public void setAnimaisController(AnimaisController animaisController) {
        this.animaisController = animaisController;
    }

    public void setMedicosVeterinariosController(MedicosVeterinariosController medicosVeterinariosController) {
        this.medicosVeterinariosController = medicosVeterinariosController;
    }
    
    private MenuModel model;

    public MenuModel getModel() {
        return model;
    }
    
    public MenuController() {
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Cadastro");
        DefaultMenuItem item;
        
        DefaultMenuItem item1 = new DefaultMenuItem("Clientes");
        //item1.setUrl("/faces/pages/cadastro/clientes.xhtml");
        item1.setCommand("#{clientesController.init()}");
        item1.setIcon("ui-icon-disk");
        firstSubmenu.addElement(item1);
        
        DefaultMenuItem item2 = new DefaultMenuItem("Animais");
        //item2.setUrl("/faces/pages/cadastro/animais.xhtml");
        item2.setCommand("#{animaisController.init()}");
        item2.setIcon("ui-icon-disk");
        firstSubmenu.addElement(item2);
        
        DefaultMenuItem item3 = new DefaultMenuItem("Veterinários");
        //item1.setUrl("/faces/pages/cadastro/clientes.xhtml");
        item3.setCommand("#{medicosVeterinariosController.init()}");
        item3.setIcon("ui-icon-disk");
        firstSubmenu.addElement(item3);

        model.addElement(firstSubmenu);

    }  

}
