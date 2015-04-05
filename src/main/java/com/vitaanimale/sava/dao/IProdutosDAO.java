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
//    public List<Animais> buscarAnimaisPorIdCliente(Integer idCliente) throws SavaDAOException;
//    
//    public Integer inserirAnimal(Animais animal) throws SavaDAOException;
//    
//    public Integer excluirAnimal(Integer idAnimal) throws SavaDAOException;
//    
//    public Integer atualizarAnimal(Animais animal) throws SavaDAOException;
    
    public List<TiposProdutos> buscarTiposProdutos() throws SavaDAOException;
    
    public List<Produtos> buscarProdutosPorIdTipoProduto(Integer idTipoProduto) throws SavaDAOException;
    
    public Integer inserirTipoProduto(ItensProdutos itemProduto) throws SavaDAOException;
    
}
