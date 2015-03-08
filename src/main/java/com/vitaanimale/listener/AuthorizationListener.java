package com.vitaanimale.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elisa
 */
public class AuthorizationListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        //poderia ter sido escrito nesse evento depois da "fase" (lembra do básico do jsf, o ciclo de vida e as fases...
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        //adiquirindo o FacesContext.
        FacesContext context = event.getFacesContext();
        
        
        //adiquirindo a HttpSesson.
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        //adquirindo a sessão (essa mesma onde você deverá guardar seu usuário no nível de sessão com descritor currentUser).
        String currentPage = context.getViewRoot().getViewId();
        //armazenando a página que fez a requisição. (a string da pág. atual ex: "/pag.jsf")
        //Usuarios user = (Usuarios) session.getAttribute("usuario");
        
        //System.out.println("currentPage="+currentPage);

        //bem, se não está logado redireciona pra lógica que (navigatio rule) atende a loginPage

//        if (user == null) {
//
//            // se já esta na pagina login, não redireciona, para evitar loop infinito
//            if (!currentPage.equals(new String("/login.xhtml"))) {
//                NavigationHandler nh = context.getApplication().getNavigationHandler();
//                nh.handleNavigation(context, null, "/login.xhtml?faces-redirect=true");
//            }
//
//        } else {
            //verificar se o usuario atual tem acesso a página atual.

            //if (currentPage.contains(".xhtml")) {
                //if (!verificarAutorizacao(currentPage, user)) {
                    //aqui a logica de não ter acesso... redicione novamente? faça algo... ??? 
                    //if (!currentPage.equals(new String("/restrito.xhtml"))) {
                    //    NavigationHandler nh = context.getApplication().getNavigationHandler();
                    //    context.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O acesso a esta página não está AUTORIZADO!", ""));
                    //    nh.handleNavigation(context, null, "/principal.xhtml");
                    //}
                //}
            //}
            //caso contrário o jsf passa tranquilamente por aqui!!!
        //}
    }

    @Override
    public PhaseId getPhaseId() {
         return PhaseId.RENDER_RESPONSE;
    }
    
}
