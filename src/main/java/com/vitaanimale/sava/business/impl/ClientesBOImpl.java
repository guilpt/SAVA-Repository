package com.vitaanimale.sava.business.impl;

import com.vitaanimale.sava.business.IClientesBO;
import com.vitaanimale.sava.dao.IClientesDAO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.Clientes;
import com.vitaanimale.sava.infra.SavaDAOException;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elisa
 */
@Service
@ManagedBean(name = "clientesBO")
@ApplicationScoped
public class ClientesBOImpl implements IClientesBO {

    @Autowired
    private IClientesDAO clientesDAO;

    @Override
    public List<Clientes> buscarClientes() throws SavaBusinessException {
        List<Clientes> listaClientes = null;

        try {
            listaClientes = clientesDAO.buscarClientes();
        } catch (SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método ClientesBOImpl.buscarClientes", e);
        }

        return listaClientes;
    }

    @Override
    public Integer inserirCliente(Clientes cliente) throws SavaBusinessException {
        try {
            return clientesDAO.inserirCliente(cliente);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método ClientesBOImpl.inserirCliente", e);
        }
    }

    @Override
    public Integer excluirCliente(Integer idCliente) throws SavaBusinessException {
        try {
            return clientesDAO.excluirCliente(idCliente);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método ClientesBOImpl.excluirCliente", e);
        }
    }

    @Override
    public Integer atualizarCliente(Clientes cliente) throws SavaBusinessException {
        try {
            return clientesDAO.atualizarCliente(cliente);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método ClientesBOImpl.atualizarCliente", e);
        }
    }

    @Override
    public List<Clientes> buscarClientesComParametro(String cpf, String nomeCliente, String telefone) throws SavaBusinessException {
        List<Clientes> listaClientes = null;
        String parametroCPF;
        String parametroNomeCliente;
        String parametroTelefone;
        
        if(cpf.equals("")) {
            parametroCPF = "%";
        } else {
            parametroCPF = "%" + cpf + "%";
        }
        
        if(nomeCliente.equals("")) {
            parametroNomeCliente = "%";
        } else {
            parametroNomeCliente = "%" + nomeCliente + "%";
        }

        if(telefone.equals("")) {
            parametroTelefone = "%";
        } else {
            parametroTelefone = "%" + telefone + "%";
        }     
        
        try {
            listaClientes = clientesDAO.buscarClientesComParametro(parametroCPF, parametroNomeCliente, parametroTelefone);
        } catch (SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método ClientesBOImpl.buscarClientesComParametro", e);
        }

        return listaClientes;
    }

}
