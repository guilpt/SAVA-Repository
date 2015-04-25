package com.vitaanimale.sava.business;

import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.MedicosVeterinarios;
import java.util.List;

/**
 *
 * @author Elisa
 */
public interface IMedicosVeterinariosBO {
    public List<MedicosVeterinarios> buscarMedicosVeterinarios() throws SavaBusinessException;
    
    public Integer inserirMedicoVeterinario(MedicosVeterinarios medicoVeterinario) throws SavaBusinessException;
    
    public Integer excluirMedicoVeterinario(Integer idMedicoVeterinario) throws SavaBusinessException;
    
    public Integer atualizarMedicoVeterinario(MedicosVeterinarios medicoVeterinario) throws SavaBusinessException;
    
    public List<MedicosVeterinarios> buscarMedicosVeterinariosAtivos() throws SavaBusinessException;
}
