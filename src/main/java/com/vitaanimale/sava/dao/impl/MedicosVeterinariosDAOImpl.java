package com.vitaanimale.sava.dao.impl;

import com.vitaanimale.sava.dao.AbstractSAVADao;
import com.vitaanimale.sava.dao.IMedicosVeterinariosDAO;
import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.MedicosVeterinarios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.collections.ListUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Elisa
 */
@Repository(value="medicosVeterinariosDAO")
@Scope("singleton")
public class MedicosVeterinariosDAOImpl extends AbstractSAVADao implements IMedicosVeterinariosDAO {

    @Override
    public List<MedicosVeterinarios> buscarMedicosVeterinarios() throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<MedicosVeterinarios> listaMedicosVeterinarios = null;
        
        sb.append(" select id_medico_veterinario,");
        sb.append("        nome_medico_veterinario,");
        sb.append("        uf_crmv,");
        sb.append("        nro_crmv,");
        sb.append("        sexo_medico_veterinario,");
        sb.append("        telefone_celular,");
        sb.append("        ind_ativo");
        sb.append("   from va_medicos_veterinarios");
        
        try{
            listaMedicosVeterinarios = (List<MedicosVeterinarios>) this.jdbcTemplate.query(sb.toString(), new Object[] {}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    MedicosVeterinarios medicoVeterinario = new MedicosVeterinarios();
                    
                    medicoVeterinario.setIdMedicoVeterinario(rs.getInt("ID_MEDICO_VETERINARIO"));
                    medicoVeterinario.setNomeMedicoVeterinario(rs.getString("NOME_MEDICO_VETERINARIO"));
                    medicoVeterinario.setUfCRMV(rs.getString("UF_CRMV"));
                    medicoVeterinario.setNroCRMV(rs.getInt("NRO_CRMV"));
                    medicoVeterinario.setSexoMedicoVeterinario(rs.getString("SEXO_MEDICO_VETERINARIO"));
                    medicoVeterinario.setTelefoneCelular(rs.getString("TELEFONE_CELULAR"));
                    medicoVeterinario.setIndAtivo(rs.getString("IND_ATIVO"));
                             
                    return medicoVeterinario;
                }
            });
            
            if(listaMedicosVeterinarios.iterator().hasNext()){
                return listaMedicosVeterinarios;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método MedicosVeterinariosDAOImpl.buscarMedicosVeterinarios", e);
        }
    }

    @Override
    public Integer inserirMedicoVeterinario(MedicosVeterinarios medicoVeterinario) throws SavaDAOException {
        Integer linhasAfetadas = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" insert into va_medicos_veterinarios (");
        sb.append(" id_medico_veterinario,");
        sb.append(" nome_medico_veterinario,");
        sb.append(" uf_crmv,");
        sb.append(" nro_crmv,");
        sb.append(" sexo_medico_veterinario,");
        sb.append(" telefone_celular,");
        sb.append(" ind_ativo");
        sb.append(" ) values (");
        sb.append(" default,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?)");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {medicoVeterinario.getNomeMedicoVeterinario(), medicoVeterinario.getUfCRMV(),
                medicoVeterinario.getNroCRMV(), medicoVeterinario.getSexoMedicoVeterinario(), medicoVeterinario.getTelefoneCelular(),
                medicoVeterinario.getIndAtivo()});
        } catch(Exception e){
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método MedicosVeterinariosDAOImpl.inserirMedicoVeterinario", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer excluirMedicoVeterinario(Integer idMedicoVeterinario) throws SavaDAOException {
        Integer linhasAfetadas;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" delete from va_medicos_veterinarios");
        sb.append("  where id_medico_veterinario = ?");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {idMedicoVeterinario});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método MedicosVeterinariosDAOImpl.excluirMedicoVeterinario", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer atualizarMedicoVeterinario(MedicosVeterinarios medicoVeterinario) throws SavaDAOException {
        Integer linhasAfetadas;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" update va_medicos_veterinarios");
        sb.append("    set nome_medico_veterinario = ?,");
        sb.append("        uf_crmv                 = ?,");
        sb.append("        nro_crmv                = ?,");
        sb.append("        sexo_medico_veterinario = ?,");
        sb.append("        telefone_celular        = ?,");
        sb.append("        ind_ativo               = ? ");
        sb.append("  where id_medico_veterinario   = ? ");
        
        try{
           linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {medicoVeterinario.getNomeMedicoVeterinario(), medicoVeterinario.getUfCRMV(),
                medicoVeterinario.getNroCRMV(), medicoVeterinario.getSexoMedicoVeterinario(), medicoVeterinario.getTelefoneCelular(), 
                medicoVeterinario.getIndAtivo(), medicoVeterinario.getIdMedicoVeterinario()});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método MedicosVeterinariosDAOImpl.atualizarMedicoVeterinario", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public List<MedicosVeterinarios> buscarMedicosVeterinariosAtivos() throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<MedicosVeterinarios> listaMedicosVeterinarios = null;
        
        sb.append(" select id_medico_veterinario,");
        sb.append("        nome_medico_veterinario");
        sb.append("   from va_medicos_veterinarios");
        sb.append("  where ind_ativo = 'S'");
        
        try{
            listaMedicosVeterinarios = (List<MedicosVeterinarios>) this.jdbcTemplate.query(sb.toString(), new Object[] {}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    MedicosVeterinarios medicoVeterinario = new MedicosVeterinarios();
                    
                    medicoVeterinario.setIdMedicoVeterinario(rs.getInt("ID_MEDICO_VETERINARIO"));
                    medicoVeterinario.setNomeMedicoVeterinario(rs.getString("NOME_MEDICO_VETERINARIO"));
                             
                    return medicoVeterinario;
                }
            });
            
            if(listaMedicosVeterinarios.iterator().hasNext()){
                return listaMedicosVeterinarios;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método MedicosVeterinariosDAOImpl.buscarMedicosVeterinariosAtivos", e);
        }
    }
    
}
