package com.vitaanimale.sava.dao;

import com.vitaanimale.sava.infra.SavaDAOException;
import com.vitaanimale.sava.to.MedicosVeterinarios;
import java.util.List;

/**
 *
 * @author Elisa
 */
public interface IMedicosVeterinariosDAO {
    public List<MedicosVeterinarios> buscarMedicosVeterinarios() throws SavaDAOException;
    
    public Integer inserirMedicoVeterinario(MedicosVeterinarios medicoVeterinario) throws SavaDAOException;
    
    public Integer excluirMedicoVeterinario(Integer idMedicoVeterinario) throws SavaDAOException;
    
    public Integer atualizarMedicoVeterinario(MedicosVeterinarios medicoVeterinario) throws SavaDAOException;
    
    public List<MedicosVeterinarios> buscarMedicosVeterinariosAtivos() throws SavaDAOException;
}
