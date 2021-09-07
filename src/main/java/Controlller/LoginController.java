/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlller;

import Controlller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author Arthur
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
        
    }
    
    public void entrarNoSistema() {
       //Pegar um Usuario da View
       Usuario usuario = helper.obterModelo();
       
       //Pesquisa Usuario no Banco
       UsuarioDAO usuarioDAO = new UsuarioDAO();
       Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
       
     if(usuarioAutenticado != null){
         MenuPrincipal menu = new MenuPrincipal();
         menu.setVisible(true);
         this.view.dispose();
     }else{
         view.exibeMensagem("Usuario ou senha invalidos");       
     }
        
    }
    
    
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
    
}
