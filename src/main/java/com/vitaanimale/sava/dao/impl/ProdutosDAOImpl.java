package com.vitaanimale.sava.dao.impl;

import com.vitaanimale.sava.dao.AbstractSAVADao;
import com.vitaanimale.sava.dao.IProdutosDAO;
import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.ItensProdutos;
import com.vitaanimale.sava.to.Produtos;
import com.vitaanimale.sava.to.TiposProdutos;
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
@Repository(value="produtosDAO")
@Scope("singleton")
public class ProdutosDAOImpl extends AbstractSAVADao implements IProdutosDAO{

    @Override
    public List<TiposProdutos> buscarTiposProdutos() throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<TiposProdutos> listaTiposProdutos = null;
        
        sb.append(" select id_tipo_produto,");
        sb.append("        descricao_tipo_produto");
        sb.append("   from va_tipos_produtos");
        sb.append("  order by descricao_tipo_produto");
        
        try {
            listaTiposProdutos = (List<TiposProdutos>) this.jdbcTemplate.query(sb.toString(), new Object[] {}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    TiposProdutos tipoProduto = new TiposProdutos();
                    
                    tipoProduto.setIdTipoProduto(rs.getInt("ID_TIPO_PRODUTO"));
                    tipoProduto.setDescricaoTipoProduto(rs.getString("DESCRICAO_TIPO_PRODUTO"));
                    
                    return tipoProduto;
                }
            });
            
            if(listaTiposProdutos.iterator().hasNext()){
                return listaTiposProdutos;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método ProdutosDAOImpl.buscarTiposProdutos", e);
        }
    }

    @Override
    public List<Produtos> buscarProdutosPorIdTipoProduto(Integer idTipoProduto) throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        List<Produtos> listaProdutos = null;
        
        sb.append(" select va_produtos.id_produto,");
        sb.append("        va_fornecedores.nome_fornecedor,");
        sb.append("        va_produtos.marca,");
        sb.append("        va_produtos.descricao_produto,");
        sb.append("        va_produtos.valor_compra_produto,");
        sb.append("        va_produtos.valor_venda_produto");
        sb.append("   from va_produtos inner join va_fornecedores on (va_produtos.id_fornecedor = va_fornecedores.id_fornecedor )");
        sb.append("  where va_produtos.id_tipo_produto = ?");
        sb.append("  order by va_produtos.descricao_produto");
        
        try {
            listaProdutos = (List<Produtos>) this.jdbcTemplate.query(sb.toString(), new Object[] {idTipoProduto}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Produtos produto = new Produtos();
                    
                    produto.setIdProduto(rs.getInt("ID_PRODUTO"));
                    produto.setNomeFornecedor(rs.getString("NOME_FORNECEDOR"));
                    produto.setMarca(rs.getString("MARCA"));
                    produto.setDescricaoProduto(rs.getString("DESCRICAO_PRODUTO"));
                    produto.setValorCompraProduto(rs.getDouble("VALOR_COMPRA_PRODUTO"));
                    produto.setValorVendaProduto(rs.getDouble("VALOR_VENDA_PRODUTO"));
                    
                    return produto;
                }
            });
            
            if(listaProdutos.iterator().hasNext()){
                return listaProdutos;
            }
            return ListUtils.EMPTY_LIST;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método ProdutosDAOImpl.buscarProdutosPorIdTipoProduto", e);
        }
    }

    @Override
    public Integer inserirTipoProduto(ItensProdutos itemProduto) throws SavaDAOException {
        Integer linhasAfetadas = 0;
        StringBuilder sb = new StringBuilder();
        
        sb.append(" insert into va_itens_produtos (");
        sb.append(" id_item_produto,");
        sb.append(" id_produto,");
        sb.append(" cod_barra,");
        sb.append(" valor_compra_produto,");
        sb.append(" valor_venda_produto,");
        sb.append(" data_entrada,");
        sb.append(" data_validade");
        sb.append(" ) values (");
        sb.append(" default,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?,");
        sb.append(" ?");
        sb.append(" )");
        
        try {
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {itemProduto.getIdProduto(), itemProduto.getCodBarra(),
                itemProduto.getValorCompraProduto(), itemProduto.getValorVendaProduto(), itemProduto.getDataEntrada(), itemProduto.getDataValidade()});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método ProdutosDAOImpl.inserirTipoProduto", e);
        }
        
        return linhasAfetadas;
    }
    
}
