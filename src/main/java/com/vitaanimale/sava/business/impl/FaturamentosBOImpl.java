package com.vitaanimale.sava.business.impl;

import com.vitaanimale.sava.business.IFaturamentosBO;
import com.vitaanimale.sava.dao.IFaturamentosDAO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.DescricaoFaturamentos;
import com.vitaanimale.sava.to.Faturamentos;
import com.vitaanimale.sava.to.ItensProdutos;
import com.vitaanimale.sava.to.Servicos;
import com.vitaanimale.sava.to.TiposPagamentos;
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
@ManagedBean(name = "faturamentosBO")
@ApplicationScoped
public class FaturamentosBOImpl implements IFaturamentosBO {

    @Autowired
    private IFaturamentosDAO faturamentosDAO;
    
    @Override
    public List<Faturamentos> buscarFaturamentosPorCliente(Integer idCliente) throws SavaBusinessException {
        List<Faturamentos> listaFaturamentos = null;

        try {
            listaFaturamentos = faturamentosDAO.buscarFaturamentosPorCliente(idCliente);
        } catch (SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método FaturamentosBOImpl.buscarFaturamentosPorCliente", e);
        }

        return listaFaturamentos;
    }

    @Override
    public Integer inserirFaturamento(Faturamentos faturamento) throws SavaBusinessException {
        try {
            return faturamentosDAO.inserirFaturamento(faturamento);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método buscarFaturamentosPorCliente.inserirFaturamento", e);
        }
    }

    @Override
    public Integer excluirFaturamento(Integer idFaturamento) throws SavaBusinessException {
        try {
            return faturamentosDAO.excluirFaturamento(idFaturamento);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método buscarFaturamentosPorCliente.excluirFaturamento", e);
        }
    }

    @Override
    public Integer atualizarFaturamento(Faturamentos faturamento) throws SavaBusinessException {
        try {
            return faturamentosDAO.atualizarFaturamento(faturamento);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método buscarFaturamentosPorCliente.atualizarFaturamento", e);
        }
    }

    @Override
    public List<TiposPagamentos> buscarTiposPagamentos() throws SavaBusinessException {
        List<TiposPagamentos> listaTiposPagamentos = null;

        try {
            listaTiposPagamentos = faturamentosDAO.buscarTiposPagamentos();
        } catch (SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método FaturamentosBOImpl.buscarTiposPagamentos", e);
        }

        return listaTiposPagamentos;
    }
    
    @Override
    public List<Servicos> buscarListaServicos() throws SavaBusinessException {
        List<Servicos> listaServicos = null;

        try {
            listaServicos = faturamentosDAO.buscarListaServicos();
        } catch (SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método FaturamentosBOImpl.buscarListaServicos", e);
        }

        return listaServicos;
    }
    
    
    @Override
    public ItensProdutos buscarProdutoPorCodBarra(String codBarra) throws SavaBusinessException {
        ItensProdutos itemProduto = null;

        try {
            itemProduto = faturamentosDAO.buscarProdutoPorCodBarra(codBarra);
        } catch (SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método FaturamentosBOImpl.buscarProdutoPorCodBarra", e);
        }

        return itemProduto;
    }
    
    @Override
    public List<DescricaoFaturamentos> buscarDescricaoFaturamentosPorFaturamento(Integer idFaturamento) throws SavaBusinessException {
        List<DescricaoFaturamentos> listaDescricaoFaturamentos = null;

        try {
            listaDescricaoFaturamentos = faturamentosDAO.buscarDescricaoFaturamentosPorFaturamento(idFaturamento);
        } catch (SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método FaturamentosBOImpl.buscarDescricaoFaturamentosPorFaturamento", e);
        }

        return listaDescricaoFaturamentos;
    }

    @Override
    public Integer inserirServicoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaBusinessException {
        try {
            return faturamentosDAO.inserirServicoDescricaoFaturamento(descricaoFaturamento);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método buscarFaturamentosPorCliente.inserirServicoDescricaoFaturamento", e);
        }
    }

    @Override
    public Integer inserirProdutoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaBusinessException {
        try {
            return faturamentosDAO.inserirProdutoDescricaoFaturamento(descricaoFaturamento);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método buscarFaturamentosPorCliente.inserirProdutoDescricaoFaturamento", e);
        }
    }

    @Override
    public Integer excluirDescricaoFaturamento(Integer idDescricaoFaturamento) throws SavaBusinessException {
        try {
            return faturamentosDAO.excluirDescricaoFaturamento(idDescricaoFaturamento);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método buscarFaturamentosPorCliente.excluirDescricaoFaturamento", e);
        }
    }
    
    @Override
    public Integer atualizarServicoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaBusinessException {
        try {
            return faturamentosDAO.atualizarServicoDescricaoFaturamento(descricaoFaturamento);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método buscarFaturamentosPorCliente.atualizarServicoDescricaoFaturamento", e);
        }
    }

    @Override
    public Integer atualizarProdutoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaBusinessException {
        try {
            return faturamentosDAO.atualizarProdutoDescricaoFaturamento(descricaoFaturamento);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método buscarFaturamentosPorCliente.atualizarProdutoDescricaoFaturamento", e);
        }
    }

    @Override
    public Integer atualizarSaidaItensProdutos(String codBarra, Double valorVendaProduto, Integer idDescricaoFaturamento, String tipoAtualizacao) throws SavaBusinessException {
        try {
            return faturamentosDAO.atualizarSaidaItensProdutos(codBarra, valorVendaProduto, idDescricaoFaturamento, tipoAtualizacao);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método buscarFaturamentosPorCliente.atualizarSaidaItensProdutos", e);
        }
    }

    @Override
    public List<ItensProdutos> buscarListaItensProdutosPorDescricaoFaturamento(Integer idDescricaoFaturamento) throws SavaBusinessException {
        List<ItensProdutos> listaItensProdutos = null;

        try {
            listaItensProdutos = faturamentosDAO.buscarListaItensProdutosPorDescricaoFaturamento(idDescricaoFaturamento);
        } catch (SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método FaturamentosBOImpl.buscarListaItensProdutosPorDescricaoFaturamento", e);
        }

        return listaItensProdutos;
    }

    @Override
    public Integer atualizarValorVendaProdutoItensProdutos(Double valorVendaProduto, Integer idItemProduto) throws SavaBusinessException {
        try {
            return faturamentosDAO.atualizarValorVendaProdutoItensProdutos(valorVendaProduto, idItemProduto);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método buscarFaturamentosPorCliente.atualizarValorVendaProdutoItensProdutos", e);
        }
    }
    
}
