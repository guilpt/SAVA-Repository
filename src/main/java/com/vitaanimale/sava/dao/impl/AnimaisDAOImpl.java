package com.vitaanimale.sava.dao.impl;

import com.vitaanimale.sava.dao.AbstractSAVADao;
import com.vitaanimale.sava.dao.IAnimaisDAO;
import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.Animais;
import com.vitaanimale.sava.to.Especies;
import com.vitaanimale.sava.to.Racas;
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
@Repository(value="animaisDAO")
@Scope("singleton")
public class AnimaisDAOImpl extends AbstractSAVADao implements IAnimaisDAO {

    @Override
    public List<Animais> buscarAnimaisPorIdCliente(Integer idCliente) throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<Animais> listaAnimais = null;
        
        sb.append(" select id_animal,");
        sb.append("        id_cliente,");
        sb.append("        id_especie,");
        sb.append("        id_raca,");
        sb.append("        nome_animal,");
        sb.append("        sexo_animal,");
        sb.append("        cor_pelagem,");
        sb.append("        idade_ano,");
        sb.append("        idade_mes,");
        sb.append("        peso,");
        sb.append("        obito,");
        sb.append("        disponibilidade_cruzamento");
        sb.append("   from va_animais");
        sb.append("  where id_cliente = ?");
        
        try {
            listaAnimais = (List<Animais>) this.jdbcTemplate.query(sb.toString(), new Object[] {idCliente}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Animais animal = new Animais();
                    
                    animal.setIdAnimal(rs.getInt("ID_ANIMAL"));
                    animal.setIdCliente(rs.getInt("ID_CLIENTE"));
                    animal.setIdEspecie(rs.getInt("ID_ESPECIE"));
                    animal.setIdRaca(rs.getInt("ID_RACA"));
                    animal.setNomeAnimal(rs.getString("NOME_ANIMAL"));
                    animal.setSexoAnimal(rs.getString("SEXO_ANIMAL"));
                    animal.setCorPelagem(rs.getString("COR_PELAGEM"));
                    animal.setIdadeAno(rs.getInt("IDADE_ANO"));
                    animal.setIdadeMes(rs.getInt("IDADE_MES"));
                    animal.setPeso(rs.getDouble("PESO"));
                    animal.setObito(rs.getString("OBITO"));
                    animal.setDisponibilidadeCruzamento(rs.getString("DISPONIBILIDADE_CRUZAMENTO"));
                    
                    return animal;
                }
            });
            
            if(listaAnimais.iterator().hasNext()){
                return listaAnimais;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método AnimaisDAOImpl.buscarAnimaisPorIdCliente", e);
        }
    }

    @Override
    public Integer inserirAnimal(Animais animal) throws SavaDAOException {
        Integer linhasAfetadas = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" insert into va_animais (");
        sb.append(" id_animal,");
        sb.append(" id_cliente,");
        sb.append(" id_especie,");
        sb.append(" id_raca,");
        sb.append(" nome_animal,");
        sb.append(" sexo,");
        sb.append(" cor_pelagem,");
        sb.append(" idade_ano,");
        sb.append(" idade_mes,");
        sb.append(" peso,");
        sb.append(" obito,");
        sb.append(" disponibilidade_cruzamento");
        sb.append(" ) values (");
        sb.append(" default,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?");
        sb.append(" );");
        
        try {
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {animal.getIdCliente(), animal.getIdEspecie(),
                animal.getIdRaca(), animal.getNomeAnimal(), animal.getSexoAnimal(), animal.getCorPelagem(), animal.getIdadeAno(),
                animal.getIdadeMes(), animal.getPeso(), animal.getObito(), animal.getDisponibilidadeCruzamento()});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método AnimaisDAOImpl.inserirAnimal", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer excluirAnimal(Integer idAnimal) throws SavaDAOException {
        Integer linhasAfetadas;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" delete from va_animais");
        sb.append("  where id_animal = ?");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {idAnimal});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método AnimaisDAOImpl.excluirAnimal", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer atualizarAnimal(Animais animal) throws SavaDAOException {
        Integer linhasAfetadas;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" update va_animais");
        sb.append("    set id_especie                 = ?,");
        sb.append("        id_raca                    = ?,");
        sb.append("        nome_animal                = ?,");
        sb.append("        sexo                       = ?,");
        sb.append("        cor_pelagem                = ?,");
        sb.append("        idade_ano                  = ?,");
        sb.append("        idade_mes                  = ?,");
        sb.append("        peso                       = ?,");
        sb.append("        obito                      = ?,");
        sb.append("        disponibilidade_cruzamento = ?");
        sb.append("  where id_animal                  = ?");
        
        try{
           linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {animal.getIdEspecie(), animal.getIdRaca(), 
                animal.getNomeAnimal(), animal.getSexoAnimal(), animal.getCorPelagem(), animal.getIdadeAno(), animal.getIdadeMes(),
                animal.getPeso(), animal.getObito(), animal.getDisponibilidadeCruzamento(), animal.getIdAnimal()});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método AnimaisDAOImpl.atualizarAnimal", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public List<Especies> buscarEspecies() throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<Especies> listaEspecies = null;
        
        sb.append(" select id_especie,");
        sb.append("        descricao_especie");
        sb.append("   from va_especies");
        sb.append("  order by descricao_especie");
        
        try {
            listaEspecies = (List<Especies>) this.jdbcTemplate.query(sb.toString(), new Object[] {}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Especies especie = new Especies();
                    
                    especie.setIdEspecie(rs.getInt("ID_ESPECIE"));
                    especie.setDescricaoEspecie(rs.getString("DESCRICAO_ESPECIE"));
                    
                    return especie;
                }
            });
            
            if(listaEspecies.iterator().hasNext()){
                return listaEspecies;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método AnimaisDAOImpl.buscarEspecies", e);
        }
    }

    @Override
    public List<Racas> buscarRacaPorIdEspecie(Integer idEspecie) throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<Racas> listaRacas = null;
        
        sb.append(" select id_raca,");
        sb.append("        descricao_raca");
        sb.append("   from va_racas");
        sb.append("  where id_especie = ?");
        sb.append("  order by descricao_raca");
        
        try {
            listaRacas = (List<Racas>) this.jdbcTemplate.query(sb.toString(), new Object[] {idEspecie}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Racas raca = new Racas();
                    
                    raca.setIdRaca(rs.getInt("ID_RACA"));
                    raca.setDescricaoRaca(rs.getString("DESCRICAO_RACA"));
                    
                    return raca;
                }
            });
            
            if(listaRacas.iterator().hasNext()){
                return listaRacas;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método AnimaisDAOImpl.buscarRacaPorIdEspecie", e);
        }
    }

   
}
