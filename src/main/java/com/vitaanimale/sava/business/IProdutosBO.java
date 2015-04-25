package com.vitaanimale.sava.business;

import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.ItensProdutos;
import com.vitaanimale.sava.to.Produtos;
import com.vitaanimale.sava.to.TiposProdutos;
import java.util.List;

/**
 *
 * @author Elisa
 */
public interface IProdutosBO {
    public List<TiposProdutos> buscarTiposProdutos() throws SavaBusinessException;
    
    public List<Produtos> buscarProdutosPorIdTipoProduto(Integer idTipoProduto) throws SavaBusinessException;
    
    public Produtos buscarInformacaoProduto(Integer idProduto) throws SavaBusinessException;
    
    public Integer inserirItemProduto(ItensProdutos itemProduto) throws SavaBusinessException;
    
    public List<ItensProdutos> buscarUltimosItensProdutosAdicionados() throws SavaBusinessException;
}
