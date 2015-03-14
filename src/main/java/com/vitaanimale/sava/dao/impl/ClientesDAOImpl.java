package com.vitaanimale.sava.dao.impl;

import com.vitaanimale.sava.dao.AbstractSAVADao;
import com.vitaanimale.sava.dao.IClientesDAO;
import com.vitaanimale.sava.to.Clientes;
import com.vitaanimale.sava.infra.SavaDAOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.collections.ListUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Elisa
 */
@Repository(value="clientesDAO")
@Scope("singleton")
public class ClientesDAOImpl extends AbstractSAVADao implements IClientesDAO {
    
    @Override
    public List<Clientes> buscarClientes() throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<Clientes> listaClientes = null;
        
        sb.append(" select id_cliente,");
        sb.append("        nome_cliente,");
        sb.append("        cpf,");
        sb.append("        sexo_cliente,");
        sb.append("        to_char(data_nascimento, 'dd/mm/yyyy') as data_nascimento,");
        sb.append("        endereco,");
        sb.append("        telefone_residencial,");
        sb.append("        telefone_celular,");
        sb.append("        email");
        sb.append("   from va_clientes");
        
        try{
            listaClientes = (List<Clientes>) this.jdbcTemplate.query(sb.toString(), new Object[] {}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Clientes cliente = new Clientes();
                    
                    cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                    cliente.setNomeCliente(rs.getString("NOME_CLIENTE"));
                    cliente.setCpf(rs.getString("CPF"));
                    cliente.setSexoCliente(rs.getString("SEXO_CLIENTE"));
                    cliente.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
                    cliente.setEndereco(rs.getString("ENDERECO"));
                    cliente.setTelefoneResidencial(rs.getString("TELEFONE_RESIDENCIAL"));
                    cliente.setTelefoneCelular(rs.getString("TELEFONE_CELULAR"));
                    cliente.setEmail(rs.getString("EMAIL"));                   
                    
                    return cliente;
                }
            });
            
            if(listaClientes.iterator().hasNext()){
                return listaClientes;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método ClientesDAOImpl.buscarClientes", e);
        }
    }

    @Override
    public Integer inserirCliente(Clientes cliente) throws SavaDAOException {
        Integer linhasAfetadas = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        
        sb.append(" insert into va_clientes (");
        sb.append(" id_cliente,");
        sb.append(" nome_cliente,");
        sb.append(" cpf,");
        sb.append(" data_nascimento,");
        sb.append(" sexo_cliente,");
        sb.append(" endereco,");
        sb.append(" telefone_residencial,");
        sb.append(" telefone_celular,");
        sb.append(" email");
        sb.append(" ) values (");
        sb.append(" default,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?");
        sb.append(" );");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {cliente.getNomeCliente(), cliente.getCpf(),
                sdf.parse(cliente.getDataNascimento()), cliente.getSexoCliente(), cliente.getEndereco(), cliente.getTelefoneResidencial(),
                cliente.getTelefoneCelular(), cliente.getEmail()});
        } catch(Exception e){
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método ClientesDAOImpl.inserirCliente", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer excluirCliente(Integer idCliente) throws SavaDAOException {
        Integer linhasAfetadas;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" delete from va_clientes");
        sb.append("  where id_cliente = ?");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {idCliente});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método ClientesDAOImpl.inserirCliente", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer atualizarCliente(Clientes cliente) throws SavaDAOException {
        Integer linhasAfetadas;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        
        sb.append(" update va_clientes");
        sb.append("    set nome_cliente         = ?,");
        sb.append("        cpf                  = ?,");
        sb.append("        data_nascimento      = ?,");
        sb.append("        sexo_cliente         = ?,");
        sb.append("        endereco             = ?,");
        sb.append("        telefone_residencial = ?,");
        sb.append("        telefone_celular     = ?,");
        sb.append("        email                = ?");
        sb.append("  where id_cliente           = ?");
        
        try{
           linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {cliente.getNomeCliente(), cliente.getCpf(),
                sdf.parse(cliente.getDataNascimento()), cliente.getSexoCliente(), cliente.getEndereco(), cliente.getTelefoneResidencial(),
                cliente.getTelefoneCelular(), cliente.getEmail(), cliente.getIdCliente()});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método ClientesDAOImpl.atualizarCliente", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public List<Clientes> buscarClientesComParametro(String cpf, String nomeCliente, String telefone) throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<Clientes> listaClientes = null;
        
        sb.append(" select id_cliente,");
        sb.append("        nome_cliente,");
        sb.append("        cpf,");
        sb.append("        telefone_residencial,");
        sb.append("        telefone_celular");
        sb.append("   from va_clientes");
        sb.append("  where cpf like ?");
        sb.append("    and lower(nome_cliente) like lower(?)");
        sb.append("    and (telefone_residencial like ? or");
        sb.append("         telefone_celular like ?)");
        
        try{
            listaClientes = (List<Clientes>) this.jdbcTemplate.query(sb.toString(), new Object[] {cpf, nomeCliente, telefone, telefone}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Clientes cliente = new Clientes();
                    
                    cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                    cliente.setNomeCliente(rs.getString("NOME_CLIENTE"));
                    cliente.setCpf(rs.getString("CPF"));
                    cliente.setTelefoneResidencial(rs.getString("TELEFONE_RESIDENCIAL"));
                    cliente.setTelefoneCelular(rs.getString("TELEFONE_CELULAR"));                
                    
                    return cliente;
                }
            });
            
            if(listaClientes.iterator().hasNext()){
                return listaClientes;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método ClientesDAOImpl.buscarClientesComParametro", e);
        }
    }
    
}
