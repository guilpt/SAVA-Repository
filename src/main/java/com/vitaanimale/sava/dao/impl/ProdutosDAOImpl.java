package com.vitaanimale.sava.dao.impl;

import com.vitaanimale.sava.dao.AbstractSAVADao;
import com.vitaanimale.sava.dao.IProdutosDAO;
import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.ItensProdutos;
import com.vitaanimale.sava.to.Produtos;
import com.vitaanimale.sava.to.TiposProdutos;
import java.util.Date;
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
        sb.append("        va_produtos.descricao_produto");
        sb.append("   from va_produtos inner join va_fornecedores on (va_produtos.id_fornecedor = va_fornecedores.id_fornecedor )");
        sb.append("  where va_produtos.id_tipo_produto = ?");
        sb.append("  order by va_produtos.descricao_produto");
        
        try {
            listaProdutos = (List<Produtos>) this.jdbcTemplate.query(sb.toString(), new Object[] {idTipoProduto}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Produtos produto = new Produtos();
                    
                    produto.setIdProduto(rs.getInt("ID_PRODUTO"));
                    produto.setDescricaoProduto(rs.getString("DESCRICAO_PRODUTO"));
                    
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
    public Produtos buscarInformacaoProduto(Integer idProduto) throws SavaDAOException {
        StringBuilder sb = new StringBuilder();
        Produtos produto = null;
        
        sb.append(" select valor_compra_produto,");
        sb.append("        valor_venda_produto");
        sb.append("   from va_produtos");
        sb.append("  where id_produto = ?");
        
        try {
            produto = (Produtos) this.jdbcTemplate.queryForObject(sb.toString(), new Object[] {idProduto}, new RowMapper() {

                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Produtos produto = new Produtos();
                    
                    produto.setValorCompraProduto(rs.getDouble("VALOR_COMPRA_PRODUTO"));
                    produto.setValorVendaProduto(rs.getDouble("VALOR_VENDA_PRODUTO"));
                    
                    return produto;
                }
            });
            
            return produto;
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método ProdutosDAOImpl.buscarProdutosPorIdTipoProduto", e);
        }
    }
    
    @Override
    public Integer inserirItemProduto(ItensProdutos itemProduto) throws SavaDAOException {
        Integer linhasAfetadas = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date parametroDataEntrada  = null;
        Date parametroDataValidade = null;
        
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
            if (!("".equals(itemProduto.getDataEntrada()))) {
                parametroDataEntrada = sdf.parse(itemProduto.getDataEntrada());
            }
            if (!("".equals(itemProduto.getDataValidade()))) {
                parametroDataValidade = sdf.parse(itemProduto.getDataValidade());
            }
                    
            linhasAfetadas = jdbcTemplate.update(sb.toString(), new Object[] {itemProduto.getIdProduto(), itemProduto.getCodBarra(),
                itemProduto.getValorCompraProduto(), itemProduto.getValorVendaProduto(), parametroDataEntrada, parametroDataValidade});
        } catch(Exception e) {
            e.printStackTrace();
            throw new SavaDAOException("Erro ao executar o método ProdutosDAOImpl.inserirItemProduto", e);
        }
        
        return linhasAfetadas;
    }


    
}
