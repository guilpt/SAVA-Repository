package com.vitaanimale.sava.business;

import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.Animais;
import com.vitaanimale.sava.to.Especies;
import com.vitaanimale.sava.to.Racas;
import java.util.List;

/**
 *
 * @author Elisa
 */
public interface IAnimaisBO {
    public List<Animais> buscarAnimaisPorIdCliente(Integer idCliente) throws SavaBusinessException;
    
    public Integer inserirAnimal(Animais animal) throws SavaBusinessException;
    
    public Integer excluirAnimal(Integer idAnimal) throws SavaBusinessException;
    
    public Integer atualizarAnimal(Animais animal) throws SavaBusinessException;
    
    public List<Especies> buscarEspecies() throws SavaBusinessException;
            
    public List<Racas> buscarRacaPorIdEspecie(Integer idEspecie) throws SavaBusinessException;
}
