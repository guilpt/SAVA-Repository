package com.vitaanimale.sava.business;

import com.vitaanimale.sava.infra.SavaBusinessException;
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
public interface IFaturamentosBO {
    public List<Faturamentos> buscarFaturamentosPorCliente(Integer idCliente) throws SavaBusinessException;
    
    public Integer inserirFaturamento(Faturamentos faturamento) throws SavaBusinessException;
    
    public Integer excluirFaturamento(Integer idFaturamento) throws SavaBusinessException;
    
    public Integer atualizarFaturamento(Faturamentos faturamento) throws SavaBusinessException;
    
    public List<TiposPagamentos> buscarTiposPagamentos() throws SavaBusinessException;
    
    public List<Servicos> buscarListaServicos() throws SavaBusinessException;
    
    public ItensProdutos buscarProdutoPorCodBarra(String codBarra) throws SavaBusinessException;
            
    public List<DescricaoFaturamentos> buscarDescricaoFaturamentosPorFaturamento(Integer idFaturamento) throws SavaBusinessException;
    
    public Integer inserirServicoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaBusinessException;
    
    public Integer inserirProdutoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaBusinessException;
    
    public Integer excluirDescricaoFaturamento(Integer idDescricaoFaturamento) throws SavaBusinessException;
    
    public Integer atualizarServicoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaBusinessException;
    
    public Integer atualizarProdutoDescricaoFaturamento(DescricaoFaturamentos descricaoFaturamento) throws SavaBusinessException;
    
    public Integer atualizarSaidaItensProdutos(String codBarra, Double valorVendaProduto, Integer idDescricaoFaturamento, String tipoAtualizacao) throws SavaBusinessException;
    
    public List<ItensProdutos> buscarListaItensProdutosPorDescricaoFaturamento(Integer idDescricaoFaturamento) throws SavaBusinessException;
    
    public Integer atualizarValorVendaProdutoItensProdutos(Double valorVendaProduto, Integer idItemProduto) throws SavaBusinessException;
}
