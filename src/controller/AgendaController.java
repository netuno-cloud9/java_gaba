package controller;

import controller.Helper.AgendaHelper;
import java.util.ArrayList;
import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.modelDAO.AgendamentoDAO;
import model.modelDAO.ClienteDAO;
import model.modelDAO.ServicoDAO;
import view.Agenda;

public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    
    public void atualizaTabela(){
        
        //Buscar lista com os agendamentos no Banco de Dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        //Exibir essa lista na view
        helper.preencherTabela(agendamentos);
        
    }
    
    public void atualizaCliente(){
        
        //Buscar Clientes do Banco de Dados
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        //Exibir Clientes no Condobox cliente
        helper.preencherClientes(clientes);
    }
    
    public void atualizaServico(){
        
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.preencherServicos(servicos);
    }
    
    public void atualizaValor(){
        
        //Obter o servico na tela
        Servico servico = helper.obterServico();
        
        //Seta valor na tela
        helper.setarValor(servico.getValor());
        
    }
    
    public void agendar(){
        
        //Buscar Objeto Agendamento da Tela
        Agendamento agendamento = helper.obterModelo();
        
        //Salvar Objeto no Banco de Dados
        new AgendamentoDAO().insert(agendamento);
        
        //Inserir elemento na Tabela
        atualizaTabela();
        helper.limparTela();
        
    }
    
    
    
}
