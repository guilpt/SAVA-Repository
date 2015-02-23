package com.vitaanimale.sava.business.impl;

import com.vitaanimale.sava.business.IAnimaisBO;
import com.vitaanimale.sava.dao.IAnimaisDAO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.Animais;
import com.vitaanimale.sava.to.Especies;
import com.vitaanimale.sava.to.Racas;
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
@ManagedBean(name = "animaisBO")
@ApplicationScoped
public class AnimaisBOImpl implements IAnimaisBO {

    @Autowired
    private IAnimaisDAO animaisDAO;
    
    @Override
    public List<Animais> buscarAnimaisPorIdCliente(Integer idCliente) throws SavaBusinessException {
        List<Animais> listaAnimais = null;

        try {
            listaAnimais = animaisDAO.buscarAnimaisPorIdCliente(idCliente);
        } catch (SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método AnimaisBOImpl.buscarAnimaisPorIdCliente", e);
        }

        return listaAnimais;
    }

    @Override
    public Integer inserirAnimal(Animais animal) throws SavaBusinessException {
        try {
            return animaisDAO.inserirAnimal(animal);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método AnimaisBOImpl.inserirAnimal", e);
        }
    }

    @Override
    public Integer excluirAnimal(Integer idAnimal) throws SavaBusinessException {
        try {
            return animaisDAO.excluirAnimal(idAnimal);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método AnimaisBOImpl.excluirAnimal", e);
        }
    }

    @Override
    public Integer atualizarAnimal(Animais animal) throws SavaBusinessException {
        try {
            return animaisDAO.atualizarAnimal(animal);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método AnimaisBOImpl.atualizarAnimal", e);
        }
    }

    @Override
    public List<Especies> buscarEspecies() throws SavaBusinessException {
        try {
            return animaisDAO.buscarEspecies();
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método AnimaisBOImpl.buscarEspecies", e);
        }
    }

    @Override
    public List<Racas> buscarRacaPorIdEspecie(Integer idEspecie) throws SavaBusinessException {
        try {
            return animaisDAO.buscarRacaPorIdEspecie(idEspecie);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método AnimaisBOImpl.buscarRacaPorIdEspecie", e);
        }
    }
    
}
