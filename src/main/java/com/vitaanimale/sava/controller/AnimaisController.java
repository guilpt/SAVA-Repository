package com.vitaanimale.sava.controller;

import com.vitaanimale.sava.business.IAnimaisBO;
import com.vitaanimale.sava.business.IClientesBO;
import com.vitaanimale.sava.infra.SavaBusinessException;
import com.vitaanimale.sava.to.Animais;
import com.vitaanimale.sava.to.Clientes;
import com.vitaanimale.sava.to.Especies;
import com.vitaanimale.sava.to.Racas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Elisa
 */
@Controller
@ManagedBean
@ViewScoped
public class AnimaisController extends SAVAAbstractController implements Serializable {

    private static final long serialVersionUID = 1741168426757323415L;

    @ManagedProperty("#{animaisBO}")
    @Autowired
    private IAnimaisBO animaisBO;

    @ManagedProperty("#{clientesBO}")
    @Autowired
    private IClientesBO clientesBO;

    private Integer idAnimal;
    private Integer idCliente;
    private Integer idEspecie;
    private Integer idRaca;
    private String nomeAnimal;
    private String sexoAnimal;
    private String corPelagem;
    private Integer idadeAno;
    private Integer idadeMes;
    private Double peso;
    private String obito;
    private String disponibilidadeCruzamento;

    private String nomeCliente;
    private String cpf;
    private String telefoneResidencial;
    private String telefoneCelular;
    private String nomeClienteBusca;
    private String cpfBusca;
    private String telefoneBusca;

    private List<Clientes> listaClientes;
    private List<Animais> listaAnimaisPorCliente;
    private List<Especies> listaEspecies;
    private List<Racas> listaRacas;

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Integer getIdRaca() {
        return idRaca;
    }

    public void setIdRaca(Integer idRaca) {
        this.idRaca = idRaca;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(String sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public String getCorPelagem() {
        return corPelagem;
    }

    public void setCorPelagem(String corPelagem) {
        this.corPelagem = corPelagem;
    }

    public Integer getIdadeAno() {
        return idadeAno;
    }

    public void setIdadeAno(Integer idadeAno) {
        this.idadeAno = idadeAno;
    }

    public Integer getIdadeMes() {
        return idadeMes;
    }

    public void setIdadeMes(Integer idadeMes) {
        this.idadeMes = idadeMes;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getObito() {
        return obito;
    }

    public void setObito(String obito) {
        this.obito = obito;
    }

    public String getDisponibilidadeCruzamento() {
        return disponibilidadeCruzamento;
    }

    public void setDisponibilidadeCruzamento(String disponibilidadeCruzamento) {
        this.disponibilidadeCruzamento = disponibilidadeCruzamento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getNomeClienteBusca() {
        return nomeClienteBusca;
    }

    public void setNomeClienteBusca(String nomeClienteBusca) {
        this.nomeClienteBusca = nomeClienteBusca;
    }

    public String getCpfBusca() {
        return cpfBusca;
    }

    public void setCpfBusca(String cpfBusca) {
        this.cpfBusca = cpfBusca;
    }

    public String getTelefoneBusca() {
        return telefoneBusca;
    }

    public void setTelefoneBusca(String telefoneBusca) {
        this.telefoneBusca = telefoneBusca;
    }

    public List<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Animais> getListaAnimaisPorCliente() {
        return listaAnimaisPorCliente;
    }

    public void setListaAnimaisPorCliente(List<Animais> listaAnimaisPorCliente) {
        this.listaAnimaisPorCliente = listaAnimaisPorCliente;
    }

    public List<Especies> getListaEspecies() {
        return listaEspecies;
    }

    public void setListaEspecies(List<Especies> listaEspecies) {
        this.listaEspecies = listaEspecies;
    }

    public List<Racas> getListaRacas() {
        return listaRacas;
    }

    public void setListaRacas(List<Racas> listaRacas) {
        this.listaRacas = listaRacas;
    }

    public Collection<SelectItem> getCollectionEspecies() {
        Collection<SelectItem> collectionEspecies = new ArrayList<>();
        collectionEspecies.add(new SelectItem(-1, "Selecione..."));
        for (Especies especie : listaEspecies) {
            collectionEspecies.add(new SelectItem(especie.getIdEspecie(), especie.getDescricaoEspecie()));
        }

        return collectionEspecies;
    }

    public Collection<SelectItem> getCollectionRacas() {
        Collection<SelectItem> collectionRacas = new ArrayList<>();
        collectionRacas.add(new SelectItem(-1, "Selecione..."));
        if (this.listaRacas != null) {
            for (Racas raca : listaRacas) {
                collectionRacas.add(new SelectItem(raca.getIdRaca(), raca.getDescricaoRaca()));
            }
        }

        return collectionRacas;
    }

    @PostConstruct
    public void init() {
        FacesContext initAnimalcontext = FacesContext.getCurrentInstance();

        try {
            this.listaEspecies = animaisBO.buscarEspecies();
            this.listaRacas = new ArrayList<>();
        } catch (SavaBusinessException e) {
            initAnimalcontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível buscar a lista de espécies!"));
        }

        this.controlarExibicao(false, true);

//        this.idCliente = 1;
//        this.nomeCliente = "Guilherme Palhares Theodoro";
//        this.cpf = "731.685.481.20";
//        this.telefoneCelular = "(34) 9275-8556";
//        this.telefoneResidencial = "(34) 3227-5404";
//        try {
//            listaAnimaisPorCliente = animaisBO.buscarAnimaisPorIdCliente(this.idCliente);
//        } catch (SavaBusinessException e) {
//            initAnimalcontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível buscar a lista de animais por cliente!"));
//        }
    }

    public String buscarClientesComParametro() {
        FacesContext buscarClienteContext = FacesContext.getCurrentInstance();

        try {
            listaClientes = clientesBO.buscarClientesComParametro(cpfBusca, nomeClienteBusca, telefoneBusca);
        } catch (SavaBusinessException e) {
            buscarClienteContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível buscar o cliente!"));
        }

        return ACTION_INPUT;
    }

    public String selecionarCliente(Clientes cliente) {
        FacesContext selecionarClienteContext = FacesContext.getCurrentInstance();
        
        if (cliente != null) {
            this.idCliente = cliente.getIdCliente();
            this.nomeCliente = cliente.getNomeCliente();
            this.cpf = cliente.getCpf();
            this.telefoneResidencial = cliente.getTelefoneResidencial();
            this.telefoneCelular = cliente.getTelefoneCelular();

            try {
                listaAnimaisPorCliente = animaisBO.buscarAnimaisPorIdCliente(this.idCliente);
            } catch (SavaBusinessException e) {
                selecionarClienteContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível buscar a lista de animais por cliente!"));
            }

            this.controlarExibicao(true, false);
        }

        return ACTION_INPUT;
    }

    public String novo() {
        this.idAnimal = null;
        this.idEspecie = -1;
        this.idRaca = -1;
        this.nomeAnimal = "";
        this.sexoAnimal = "-1";
        this.corPelagem = "";
        this.idadeAno = null;
        this.idadeMes = null;
        this.peso = null;
        this.obito = "-1";
        this.disponibilidadeCruzamento = "-1";

        this.controlarExibicao(true, false);

        return ACTION_INPUT;
    }

    public String selecionarAnimal(Animais animal) {
        if (animal != null) {
            this.idAnimal = animal.getIdAnimal();
            this.idEspecie = animal.getIdEspecie();
            this.buscarRacaPorIdEspecie();
            this.idRaca = animal.getIdRaca();
            this.nomeAnimal = animal.getNomeAnimal();
            this.sexoAnimal = animal.getSexoAnimal();
            this.corPelagem = animal.getCorPelagem();
            this.idadeAno = animal.getIdadeAno();
            this.idadeMes = animal.getIdadeMes();
            this.peso = animal.getPeso();
            this.obito = animal.getObito();
            this.disponibilidadeCruzamento = animal.getDisponibilidadeCruzamento();

            this.controlarExibicao(true, false);
        }

        return ACTION_INPUT;
    }

    public String selecionarAnimalExclusao(Animais animal) {
        if (animal != null) {
            this.idAnimal = animal.getIdAnimal();
            this.nomeAnimal = animal.getNomeAnimal();
        }

        return ACTION_INPUT;
    }

    public String excluirAnimal() {
        FacesContext excluirAnimalcontext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.idAnimal != null) {
            try {
                linhasAfetadas = animaisBO.excluirAnimal(this.idAnimal);

                if (linhasAfetadas == 1) {
                    this.init();
                    excluirAnimalcontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Animal excluído com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                excluirAnimalcontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível excluir o animal!"));
            } finally {
                this.idCliente = null;
                this.nomeCliente = "";
            }
        }

        return ACTION_INPUT;
    }

    public String salvarAnimal() {
        FacesContext salvarAnimalcontext = FacesContext.getCurrentInstance();
        Integer linhasAfetadas = 0;

        if (this.validaDados()) {
            Animais animalFormulario = new Animais(this.idAnimal, this.idCliente, this.idEspecie, this.idRaca, this.nomeAnimal,
                    this.sexoAnimal, this.corPelagem, this.idadeAno, this.idadeMes, this.peso,
                    this.obito, this.disponibilidadeCruzamento);

            try {
                if (this.idAnimal == null) {
                    linhasAfetadas = animaisBO.inserirAnimal(animalFormulario);
                } else {
                    linhasAfetadas = animaisBO.atualizarAnimal(animalFormulario);
                }

                if (linhasAfetadas == 1) {
                    this.init();
                    salvarAnimalcontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", "Animal salvo com sucesso!"));
                }
            } catch (SavaBusinessException e) {
                salvarAnimalcontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível salvar o animal!"));
            }
        } else {
            salvarAnimalcontext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", this.getMensagemValidacao()));
        }

        return ACTION_INPUT;
    }

    private Boolean validaDados() {
        Boolean resultado = true;

        if (this.idEspecie == -1) {
            this.setMensagemValidacao("Informe uma espécie válida!");
            resultado = false;
        } else if (this.idRaca == -1) {
            this.setMensagemValidacao("Informe uma raça válida!");
            resultado = false;
        } else if ("".equals(this.nomeAnimal) || this.nomeAnimal.length() < 2) {
            this.setMensagemValidacao("Informe uma nome válido!");
            resultado = false;
        } else if ("-1".equals(this.sexoAnimal)) {
            this.setMensagemValidacao("Informe uma sexo válido!");
            resultado = false;
        } else if ("-1".equals(this.obito)) {
            this.setMensagemValidacao("Selecione uma opção para o campo Óbito!");
            resultado = false;
        } else if ("-1".equals(this.disponibilidadeCruzamento)) {
            this.setMensagemValidacao("Informe uma opção para o campo Disponibilidade para Cruzamento!");
            resultado = false;
        }

        return resultado;
    }

    public String cancelar() {
        this.controlarExibicao(false, true);

        return ACTION_INPUT;
    }

    public String buscarRacaPorIdEspecie() {
        FacesContext buscarRacaPorIdContext = FacesContext.getCurrentInstance();

        try {
            listaRacas = animaisBO.buscarRacaPorIdEspecie(this.getIdEspecie());
        } catch (SavaBusinessException e) {
            buscarRacaPorIdContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", "Não foi possível buscar o cliente!"));
        }

        return ACTION_INPUT;
    }

}
