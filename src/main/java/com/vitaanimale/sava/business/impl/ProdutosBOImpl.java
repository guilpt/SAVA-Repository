package com.vitaanimale.sava.business.impl;

import com.vitaanimale.sava.business.IProdutosBO;
import com.vitaanimale.sava.dao.IProdutosDAO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.ItensProdutos;
import com.vitaanimale.sava.to.Produtos;
import com.vitaanimale.sava.to.TiposProdutos;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elisa
 */
@Service
@ManagedBean(name = "produtosBO")
@ApplicationScoped
public class ProdutosBOImpl implements IProdutosBO{

    @Autowired
    private IProdutosDAO produtosDAO;
    
    @Override
    public List<TiposProdutos> buscarTiposProdutos() throws SavaBusinessException {
        try {
            return produtosDAO.buscarTiposProdutos();
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método ProdutosBOImpl.buscarTiposProdutos", e);
        }
    }

    @Override
    public List<Produtos> buscarProdutosPorIdTipoProduto(Integer idTipoProduto) throws SavaBusinessException {
        try {
            return produtosDAO.buscarProdutosPorIdTipoProduto(idTipoProduto);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método ProdutosBOImpl.buscarProdutosPorIdTipoProduto", e);
        }
    }

    @Override
    public Produtos buscarInformacaoProduto(Integer idProduto) throws SavaBusinessException {
        try {
            return produtosDAO.buscarInformacaoProduto(idProduto);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método ProdutosBOImpl.buscarInformacaoProduto", e);
        }
    }
    @Override
    public Integer inserirItemProduto(ItensProdutos itemProduto) throws SavaBusinessException {
        try {
            return produtosDAO.inserirItemProduto(itemProduto);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método ProdutosBOImpl.inserirItemProduto", e);
        }
    }

    
}
