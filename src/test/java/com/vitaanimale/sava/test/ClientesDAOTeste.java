package com.vitaanimale.sava.test;

import com.vitaanimale.sava.business.IClientesBO;
import com.vitaanimale.sava.controller.ClientesController;
import com.vitaanimale.sava.dao.IClientesDAO;
import com.vitaanimale.sava.to.Clientes;
import com.vitaanimale.sava.infra.SavaTesteDAO;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Elisa
 */
public class ClientesDAOTeste extends SavaTesteDAO{
    
    @Autowired
    private IClientesDAO clientesDAO;
    
    @Autowired 
    private ClientesController clientesController;

    public void setClientesController(ClientesController clientesController) {
        this.clientesController = clientesController;
    }
    
    @Test
    public void buscarClientesControllerTeste() {
		
        for (Clientes cliente : clientesController.getListaClientes()) {
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Teste buscarClientesControllerTeste");
            System.out.println(cliente.toString());
            System.out.println("-------------------------------------------------------------------------------------------------");
	}
        
        assertTrue(true);
    }

    @Ignore @Test
    public void buscarClientesTeste() throws Exception {
        List<Clientes> listaClientes = clientesDAO.buscarClientes();
		
        for (Clientes cliente : listaClientes) {
            System.out.println(cliente.toString());
	}
        
        assertTrue(true);
    }
    
    @Ignore @Test
    public void inserirClienteTeste() throws Exception {
        Clientes cliente = new Clientes();
        
        cliente.setNomeCliente("Elisa Ferreira Boleli");
        cliente.setCpf("111.111.111-11");
        cliente.setSexo("F");
        cliente.setDataNascimento("13/10/1989");
        cliente.setEndereco("Rua Paraná nº 1071 Apartamento 504");
        cliente.setTelefoneResidencial("(34) 3227-5404");
        cliente.setTelefoneCelular("(34) 9209-9269");
        cliente.setEmail("elisafb.vet@gmail.com");
        
        Integer linhasAfetadas = clientesDAO.inserirCliente(cliente);
        
        assertTrue(1 == linhasAfetadas);
    }
}
