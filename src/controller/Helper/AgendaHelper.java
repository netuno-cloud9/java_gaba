package controller.Helper;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import model.Cliente;
import model.Servico;
import view.Agenda;

public class AgendaHelper implements IHelper{
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        
        //Pegar o modelo (Conteúdo) da tabela
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaAgenda().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo a tabela
        for (Agendamento agendamento : agendamentos){
            
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente(),
                agendamento.getServico(),
                agendamento.getValor(),
                agendamento.getData(),
                agendamento.getObservacao()
            });
            
        }
        
        
        
    }
    
    public void preencherClientes(ArrayList<Cliente> clientes){
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCaixaCliente().getModel();
        
        //Preencher a lista de clientes e preencher
        for (Cliente cliente : clientes) {
             
            comboBoxModel.addElement(cliente); //Aqui está o truque
             
        }
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCaixaServico().getModel();
        
        //Preencher a lista de serviços e preencher
        for (Servico servico : servicos) {
             
            comboBoxModel.addElement(servico); //Aqui está o truque
             
        }        
    }
    
    public Cliente obterCliente() {
        return (Cliente) view.getCaixaCliente().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getTxtValor().setText(valor+""); //Macete: toda vez que concatena toda a operação vira String
    }

    public Servico obterServico() {
        return (Servico) view.getCaixaServico().getSelectedItem();
    }


    @Override
    public Agendamento obterModelo() { //polimorfismo: uma classe tem várias formas
        
        String idString = view.getTxtId().getText();
        int id = Integer.parseInt(idString);
        
        Cliente cliente = obterCliente(); //Reutilização de função já criada
        
        Servico servico = obterServico(); //Reutilização de função já criada
        
        String valorString = view.getTxtValor().getText();
        float valor = Float.parseFloat(valorString);
        
        String data = view.getTxtData().getText();
        
        String observacao = view.getTxtObservacoes().getText();
        
        //new Agendamento();
        Agendamento agendamento = new Agendamento(id, cliente, servico, valor, data, observacao);
        return agendamento;
    }

    @Override
    public void limparTela() {
        view.getTxtId().setText("0");
        view.getTxtData().setText("");
        view.getTxtObservacoes().setText("");
    }
    


    
}
