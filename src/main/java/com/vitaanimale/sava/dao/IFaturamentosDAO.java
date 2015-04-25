package com.vitaanimale.sava.dao;

import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.DescricaoFaturamentos;
import com.vitaanimale.sava.to.Faturamentos;
import com.vitaanimale.sava.to.ItensProdutos;
import com.vitaanimale.sava.to.Servicos;
import com.vitaanimale.sava.to.TiposPagamentos;
import java.util.List;

/**
 *
 * @author Elisa
 */
public interface IFaturamentosDAO {
    public List<Faturamentos> buscarFaturamentosPorCliente(Integer idCliente) throws SavaDAOException;
    
    public Integer inserirFaturamento(final Faturamentos faturamento) throws SavaDAOException;
    
    public Integer excluirFaturamento(Integer idFaturamento) throws SavaDAOException;
    
    public Integer atualizarFaturamento(Faturamentos faturamento) throws SavaDAOException;
    
    public List<TiposPagamentos> buscarTiposPagamentos() throws SavaDAOException;
    
    public List<Servicos> buscarListaServicos() throws SavaDAOException;
    
    public ItensProdutos buscarProdutoPorCodBarra(String codBarra) throws SavaDAOException;
    
    public List<DescricaoFaturamentos> buscarDescricaoFaturamentosPorFaturamento(Integer idFaturamento) throws SavaDAOException;
    
    public Integer inserirServicoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaDAOException;
    
    public Integer inserirProdutoDescricaoFaturamento(final DescricaoFaturamentos descricaoFaturamento) throws SavaDAOException;
    
    public Integer excluirDescricaoFaturamento(Integer idDescricaoFaturamento) throws SavaDAOException;
    
    public Integer atualizarServicoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaDAOException;
    
    public Integer atualizarProdutoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaDAOException;
    
    public Integer atualizarSaidaItensProdutos(String codBarra, Double valorVendaProduto, Integer idDescricaoFaturamento, String tipoAtualizacao) throws SavaDAOException;
    
    public List<ItensProdutos> buscarListaItensProdutosPorDescricaoFaturamento(Integer idDescricaoFaturamento) throws SavaDAOException;
    
    public Integer atualizarValorVendaProdutoItensProdutos(Double valorVendaProduto, Integer idItemProduto) throws SavaDAOException;
}
