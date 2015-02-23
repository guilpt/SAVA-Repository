package com.vitaanimale.sava.dao;

import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.Animais;
import com.vitaanimale.sava.to.Especies;
import com.vitaanimale.sava.to.Racas;
import java.util.List;

/**
 *
 * @author Elisa
 */
public interface IAnimaisDAO {
    public List<Animais> buscarAnimaisPorIdCliente(Integer idCliente) throws SavaDAOException;
    
    public Integer inserirAnimal(Animais animal) throws SavaDAOException;
    
    public Integer excluirAnimal(Integer idAnimal) throws SavaDAOException;
    
    public Integer atualizarAnimal(Animais animal) throws SavaDAOException;
    
    public List<Especies> buscarEspecies() throws SavaDAOException;
    
    public List<Racas> buscarRacaPorIdEspecie(Integer idEspecie) throws SavaDAOException;
}
