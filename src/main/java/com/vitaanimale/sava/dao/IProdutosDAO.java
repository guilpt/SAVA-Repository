package com.vitaanimale.sava.dao;

import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.ItensProdutos;
import com.vitaanimale.sava.to.Produtos;
import com.vitaanimale.sava.to.TiposProdutos;
import java.util.List;

/**
 *
 * @author Elisa
 */
public interface IProdutosDAO { 
    public List<TiposProdutos> buscarTiposProdutos() throws SavaDAOException;
    
    public List<Produtos> buscarProdutosPorIdTipoProduto(Integer idTipoProduto) throws SavaDAOException;
    
    public Produtos buscarInformacaoProduto(Integer idProduto) throws SavaDAOException;
            
    public Integer inserirItemProduto(ItensProdutos itemProduto) throws SavaDAOException;
    
    public List<ItensProdutos> buscarUltimosItensProdutosAdicionados() throws SavaDAOException;
}
