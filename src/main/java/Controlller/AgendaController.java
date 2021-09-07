/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlller;

import Controlller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
        
    
    
    public void atualizaTabela(){
    
        //Buscar Lista com agendamentos do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        //Exibir esta lista na View
        helper.preencherTabela(agendamentos);
        
        
    }
    
    public void atualizaCliente(){
    
    //Buscar Clientes do Banco de Dados
    ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        //Exibir Clientes no Combobox Cliente
        helper.preencherClientes(clientes);
    }
    
    public void atualizaServico(){
    
    ServicoDAO servicoDAO = new ServicoDAO();
    ArrayList<Servico> servicos = servicoDAO.selectAll();
    
    helper.preencherServicos(servicos);
    
    }
    
    public void atualizaValor(){
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    
    }
    
    public void agendar(){
    //Buscar Objeto Agendamento da Tela
    Agendamento agendamento = helper.obterModelo();
    //Salvar Objeto no banco de dados
    new AgendamentoDAO().insert(agendamento);
    
    //Inserir elemento na tabela
    atualizaTabela();
    helper.limparTela();
    
    }
    
}
