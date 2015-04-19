package com.vitaanimale.sava.dao.impl;

import com.vitaanimale.sava.dao.AbstractSAVADao;
import com.vitaanimale.sava.dao.IFaturamentosDAO;
import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.DescricaoFaturamentos;
import com.vitaanimale.sava.to.Faturamentos;
import com.vitaanimale.sava.to.Servicos;
import com.vitaanimale.sava.to.TiposPagamentos;
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
@Repository(value="faturamentosDAO")
@Scope("singleton")
public class FaturamentosDAOImpl extends AbstractSAVADao implements IFaturamentosDAO {

    @Override
    public List<Faturamentos> buscarFaturamentosPorCliente(Integer idCliente) throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<Faturamentos> listaFaturamentos = null;
        
        sb.append(" select va_faturamentos.id_faturamento,");
        sb.append("        va_faturamentos.id_cliente,");
        sb.append("        va_faturamentos.id_animal,");
        sb.append("        to_char(va_faturamentos.data_faturamento, 'dd/mm/yyyy') as data_faturamento,");
        sb.append("        va_faturamentos.valor_total,");
        sb.append("        va_faturamentos.id_tipo_pagamento,");
        sb.append("        va_tipos_pagamentos.descricao_tipo_pagamento,");
        sb.append("        va_faturamentos.recebido,");
        sb.append("        case va_faturamentos.recebido when 'S' then 'Sim'");
        sb.append("                                      when 'N' then 'Não'");
        sb.append("         end as recebido_extenso,");
        sb.append("        va_faturamentos.obs_pagamento");
        sb.append("   from va_faturamentos left join va_animais          on ( va_faturamentos.id_cliente        = va_animais.id_cliente and");
        sb.append("                                                           va_faturamentos.id_animal         = va_animais.id_animal                  )");
        sb.append("                        left join va_tipos_pagamentos on ( va_faturamentos.id_tipo_pagamento = va_tipos_pagamentos.id_tipo_pagamento )");
        sb.append("  where va_faturamentos.id_cliente = ?");
        
        try{
            listaFaturamentos = (List<Faturamentos>) this.jdbcTemplate.query(sb.toString(), new Object[] {idCliente}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Faturamentos faturamento = new Faturamentos();
                    
                    faturamento.setIdFaturamento(rs.getInt("ID_FATURAMENTO"));
                    faturamento.setIdCliente(rs.getInt("ID_CLIENTE"));
                    faturamento.setIdAnimal(rs.getInt("ID_ANIMAL"));
                    faturamento.setDataFaturamento(rs.getString("DATA_FATURAMENTO"));
                    faturamento.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                    faturamento.setIdTipoPagamento(rs.getInt("ID_TIPO_PAGAMENTO"));
                    faturamento.setDescricaoTipoPagamento(rs.getString("DESCRICAO_TIPO_PAGAMENTO"));
                    faturamento.setRecebido(rs.getString("RECEBIDO"));
                    faturamento.setRecebidoExtenso(rs.getString("RECEBIDO_EXTENSO"));
                    faturamento.setObsPagamento(rs.getString("OBS_PAGAMENTO"));
                    
                    return faturamento;
                }
            });
            
            if(listaFaturamentos.iterator().hasNext()){
                return listaFaturamentos;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.buscarFaturamentosPorCliente", e);
        }
    }

    @Override
    public Integer inserirFaturamento(Faturamentos faturamento) throws SavaDAOException {
        Integer linhasAfetadas = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        
        sb.append(" insert into va_faturamentos(");
        sb.append(" id_faturamento, ");
        sb.append(" id_cliente, ");
        sb.append(" id_animal, ");
        sb.append(" data_faturamento, ");
        sb.append(" valor_total,");
        sb.append(" id_tipo_pagamento,");
        sb.append(" recebido,");
        sb.append(" obs_pagamento");
        sb.append(" ) values (");
        sb.append(" default,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?");
        sb.append(" )");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {faturamento.getIdCliente(), faturamento.getIdAnimal(),
                sdf.parse(faturamento.getDataFaturamento()), faturamento.getValorTotal(), faturamento.getIdTipoPagamento(), 
                faturamento.getRecebido(), faturamento.getObsPagamento()});
        } catch(Exception e){
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.inserirFaturamento", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer excluirFaturamento(Integer idFaturamento) throws SavaDAOException {
        Integer linhasAfetadas;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" delete from va_faturamentos");
        sb.append("  where id_faturamento = ?");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {idFaturamento});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.excluirFaturamento", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer atualizarFaturamento(Faturamentos faturamento) throws SavaDAOException {
        Integer linhasAfetadas;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        
        sb.append(" update va_faturamentos");
        sb.append("    set id_animal         = ?,");
        sb.append("        data_faturamento  = ?,");
        sb.append("        valor_total       = ?,");
        sb.append("        id_tipo_pagamento = ?,");
        sb.append("        recebido          = ?,");
        sb.append("        obs_pagamento     = ?");
        sb.append("  where id_faturamento    = ?");
        
        try{
           linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {faturamento.getIdAnimal(),
                sdf.parse(faturamento.getDataFaturamento()), faturamento.getValorTotal(), faturamento.getIdTipoPagamento(), 
                faturamento.getRecebido(), faturamento.getObsPagamento(), faturamento.getIdFaturamento()});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.atualizarFaturamento", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public List<TiposPagamentos> buscarTiposPagamentos() throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<TiposPagamentos> listaTipoPagamentos = null;
        
        sb.append(" select id_tipo_pagamento,");
        sb.append("        descricao_tipo_pagamento");
        sb.append("   from va_tipos_pagamentos");
        
        try{
            listaTipoPagamentos = (List<TiposPagamentos>) this.jdbcTemplate.query(sb.toString(), new Object[] {}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    TiposPagamentos tipoPagamento = new TiposPagamentos();
                    
                    tipoPagamento.setIdTipoPagamento(rs.getInt("ID_TIPO_PAGAMENTO"));
                    tipoPagamento.setDescricaoTipoPagamento(rs.getString("DESCRICAO_TIPO_PAGAMENTO"));
                    
                    return tipoPagamento;
                }
            });
            
            if(listaTipoPagamentos.iterator().hasNext()){
                return listaTipoPagamentos;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.buscarTiposPagamentos", e);
        }
    }
    
    @Override
    public List<Servicos> buscarListaServicos() throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<Servicos> listaServicos = null;
        
        sb.append(" select id_servico,");
        sb.append("        descricao_servico,");
        sb.append("        valor_venda_servico");
        sb.append("   from va_servicos");
        
        try{
            listaServicos = (List<Servicos>) this.jdbcTemplate.query(sb.toString(), new Object[] {}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Servicos servico = new Servicos();
                    
                    servico.setIdServico(rs.getInt("ID_SERVICO"));
                    servico.setDescricaoServico(rs.getString("DESCRICAO_SERVICO"));
                    servico.setValorVendaServico(rs.getDouble("VALOR_VENDA_SERVICO"));
                    
                    return servico;
                }
            });
            
            if(listaServicos.iterator().hasNext()){
                return listaServicos;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.buscarListaServicos", e);
        }
    }
    
    @Override
    public List<DescricaoFaturamentos> buscarDescricaoFaturamentosPorFaturamento(Integer idFaturamento) throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<DescricaoFaturamentos> listaDescricaoFaturamentos = null;
        
        sb.append(" select va_descricao_faturamentos.id_descricao_faturamento,");
        sb.append("        va_descricao_faturamentos.id_faturamento,");
        sb.append("        case when va_descricao_faturamentos.id_servico is not null then 'Serviço'");
        sb.append("             when va_descricao_faturamentos.id_produto is not null then 'Produto'");
        sb.append("         end                                                                                                  as tipo_descricao_faturamento,");
        sb.append("        va_descricao_faturamentos.id_servico,");
        sb.append("        va_descricao_faturamentos.qtd_servico,");
        sb.append("        va_descricao_faturamentos.valor_venda_servico,");
        sb.append("        va_descricao_faturamentos.id_produto,");
        sb.append("        va_descricao_faturamentos.qtd_produto,");
        sb.append("        va_descricao_faturamentos.valor_venda_produto,");
        sb.append("        coalesce(va_descricao_faturamentos.id_servico         , va_descricao_faturamentos.id_produto	        ) as id,");
        sb.append("        coalesce(va_servicos.descricao_servico        	 , va_produtos.descricao_produto                ) as descricao,");
        sb.append("        coalesce(va_descricao_faturamentos.qtd_servico        , va_descricao_faturamentos.qtd_produto        ) as qtd,");
        sb.append("        coalesce(va_descricao_faturamentos.valor_venda_servico, va_descricao_faturamentos.valor_venda_produto) as valor_venda");
        sb.append("   from va_descricao_faturamentos left join va_servicos on ( va_descricao_faturamentos.id_servico = va_servicos.id_servico )");
        sb.append("                                  left join va_produtos on ( va_descricao_faturamentos.id_produto = va_produtos.id_produto )");
        sb.append("  where id_faturamento = ?");
        
        try{
            listaDescricaoFaturamentos = (List<DescricaoFaturamentos>) this.jdbcTemplate.query(sb.toString(), new Object[] {idFaturamento}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    DescricaoFaturamentos descricaoFaturamento = new DescricaoFaturamentos();
                    
                    descricaoFaturamento.setIdDescricaoFaturamento(rs.getInt("ID_DESCRICAO_FATURAMENTO"));
                    descricaoFaturamento.setIdFaturamento(rs.getInt("ID_FATURAMENTO"));
                    descricaoFaturamento.setTipoDescricaoFaturamento(rs.getString("TIPO_DESCRICAO_FATURAMENTO"));
                    descricaoFaturamento.setIdServico(rs.getInt("ID_SERVICO"));
                    descricaoFaturamento.setQtdServico(rs.getInt("QTD_SERVICO"));
                    descricaoFaturamento.setValorVendaServico(rs.getDouble("VALOR_VENDA_SERVICO"));
                    descricaoFaturamento.setIdProduto(rs.getInt("ID_PRODUTO"));
                    descricaoFaturamento.setQtdProduto(rs.getInt("QTD_PRODUTO"));
                    descricaoFaturamento.setValorVendaProduto(rs.getDouble("VALOR_VENDA_PRODUTO"));
                    descricaoFaturamento.setId(rs.getInt("ID"));
                    descricaoFaturamento.setDescricao(rs.getString("DESCRICAO"));
                    descricaoFaturamento.setQtd(rs.getInt("QTD"));
                    descricaoFaturamento.setValorVenda(rs.getDouble("VALOR_VENDA"));
                    
                    return descricaoFaturamento;
                }
            });
            
            if(listaDescricaoFaturamentos.iterator().hasNext()){
                return listaDescricaoFaturamentos;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.buscarDescricaoFaturamentosPorFaturamento", e);
        }
    }

    @Override
    public Integer inserirServicoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaDAOException {
        Integer linhasAfetadas = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" insert into va_descricao_faturamentos(");
        sb.append(" id_descricao_faturamento,");
        sb.append(" id_faturamento,");
        sb.append(" id_servico,");
        sb.append(" qtd_servico,");
        sb.append(" valor_venda_servico");
        sb.append(" ) values (");
        sb.append(" default,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?");
        sb.append(" )");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {descricaoFaturamento.getIdFaturamento(),
                descricaoFaturamento.getIdServico(), descricaoFaturamento.getQtdServico(), descricaoFaturamento.getValorVendaServico()});
        } catch(Exception e){
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.inserirServicoDescricaoFaturamento", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer inserirProdutoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaDAOException {
        Integer linhasAfetadas = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" insert into va_descricao_faturamentos(");
        sb.append(" id_descricao_faturamento,");
        sb.append(" id_faturamento,");
        sb.append(" id_produto,");
        sb.append(" qtd_produto,");
        sb.append(" valor_venda_produto");
        sb.append(" ) values (");
        sb.append(" default,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?");
        sb.append(" )");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {descricaoFaturamento.getIdFaturamento(),
                descricaoFaturamento.getIdProduto(), descricaoFaturamento.getQtdProduto(), descricaoFaturamento.getValorVendaProduto()});
        } catch(Exception e){
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.inserirProdutoDescricaoFaturamento", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer excluirDescricaoFaturamento(Integer idDescricaoFaturamento) throws SavaDAOException {
        Integer linhasAfetadas;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" delete from va_descricao_faturamentos");
        sb.append("  where id_descricao_faturamento = ?");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {idDescricaoFaturamento});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.excluirDescricaoFaturamento", e);
        }
        
        return linhasAfetadas;
    }
    
    @Override
    public Integer atualizarServicoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaDAOException {
        Integer linhasAfetadas;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" update va_descricao_faturamentos");
        sb.append("    set id_servico               = ?,");
        sb.append("        qtd_servico              = ?,");
        sb.append("        valor_venda_servico      = ?");
        sb.append("  where id_descricao_faturamento = ?");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {descricaoFaturamento.getIdServico(),
                descricaoFaturamento.getQtdServico(), descricaoFaturamento.getValorVendaServico(),
                descricaoFaturamento.getIdDescricaoFaturamento()});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.atualizarServicoDescricaoFaturamento", e);
        }
        
        return linhasAfetadas;
    }

    @Override
    public Integer atualizarProdutoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaDAOException {
        Integer linhasAfetadas;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" update va_descricao_faturamentos");
        sb.append("    set id_produto               = ?,");
        sb.append("        qtd_produto              = ?,");
        sb.append("        valor_venda_produto      = ?");
        sb.append("  where id_descricao_faturamento = ?");
        
        try{
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {descricaoFaturamento.getIdProduto(),
                descricaoFaturamento.getQtdProduto(), descricaoFaturamento.getValorVendaProduto(),
                descricaoFaturamento.getIdDescricaoFaturamento()});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método FaturamentosDAOImpl.atualizarProdutoDescricaoFaturamento", e);
        }
        
        return linhasAfetadas;
    }
    
}
