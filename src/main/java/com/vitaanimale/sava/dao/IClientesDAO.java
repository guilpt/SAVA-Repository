package com.vitaanimale.sava.dao;

import com.vitaanimale.sava.to.Clientes;
import com.vitaanimale.sava.infra.SavaDAOException;
import java.util.List;

/**
 *
 * @author Elisa
 */
public interface IClientesDAO {
    public List<Clientes> buscarClientes() throws SavaDAOException;
    
    public Integer inserirCliente(Clientes cliente) throws SavaDAOException;
    
    public Integer excluirCliente(Integer idCliente) throws SavaDAOException;
    
    public Integer atualizarCliente(Clientes cliente) throws SavaDAOException;
    
    public List<Clientes> buscarClientesComParametro(String cpf, String nomeCliente, String telefone) throws SavaDAOException;
}
