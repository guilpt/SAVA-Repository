package com.vitaanimale.sava.business;

import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.Clientes;
import java.util.List;

/**
 *
 * @author Elisa
 */
public interface IClientesBO {
    
    public List<Clientes> buscarClientes() throws SavaBusinessException;
    
    public Integer inserirCliente(Clientes cliente) throws SavaBusinessException;
    
    public Integer excluirCliente(Integer idCliente) throws SavaBusinessException;
    
    public Integer atualizarCliente(Clientes cliente) throws SavaBusinessException;
    
    public List<Clientes> buscarClientesComParametro(String cpf, String nomeCliente, String telefone) throws SavaBusinessException;
}
