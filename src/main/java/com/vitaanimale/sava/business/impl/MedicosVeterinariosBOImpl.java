package com.vitaanimale.sava.business.impl;

import com.vitaanimale.sava.business.IMedicosVeterinariosBO;
import com.vitaanimale.sava.dao.IMedicosVeterinariosDAO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.MedicosVeterinarios;
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
@ManagedBean(name = "medicosVeterinariosBO")
@ApplicationScoped
public class MedicosVeterinariosBOImpl implements IMedicosVeterinariosBO {

    @Autowired
    private IMedicosVeterinariosDAO medicosVeterinariosDAO;
    
    @Override
    public List<MedicosVeterinarios> buscarMedicosVeterinarios() throws SavaBusinessException {
        List<MedicosVeterinarios> listaMedicosVeterinarios = null;

        try {
            listaMedicosVeterinarios = medicosVeterinariosDAO.buscarMedicosVeterinarios();
        } catch (SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método MedicosVeterinariosBOImpl.buscarMedicosVeterinarios", e);
        }

        return listaMedicosVeterinarios;
    }

    @Override
    public Integer inserirMedicoVeterinario(MedicosVeterinarios medicoVeterinario) throws SavaBusinessException {
        try {
            return medicosVeterinariosDAO.inserirMedicoVeterinario(medicoVeterinario);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método MedicosVeterinariosBOImpl.inserirMedicoVeterinario", e);
        }
    }

    @Override
    public Integer excluirMedicoVeterinario(Integer idMedicoVeterinario) throws SavaBusinessException {
        try {
            return medicosVeterinariosDAO.excluirMedicoVeterinario(idMedicoVeterinario);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método MedicosVeterinariosBOImpl.excluirMedicoVeterinario", e);
        }
    }

    @Override
    public Integer atualizarMedicoVeterinario(MedicosVeterinarios medicoVeterinario) throws SavaBusinessException {
        try {
            return medicosVeterinariosDAO.atualizarMedicoVeterinario(medicoVeterinario);
        } catch(SavaDAOException e) {
            throw new SavaBusinessException("Erro ao executar o método MedicosVeterinariosBOImpl.atualizarMedicoVeterinario", e);
        }
    }
    
}
