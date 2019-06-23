/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.Endereco;
import model.Usuario;

/**
 *
 * @author marci
 */
@ManagedBean(name = "cadastrar")
@RequestScoped
public class CadastarUsuarioBean {

    private Usuario usuario;
    private Endereco endereco;
    
    @ManagedProperty(value = "#{login}")
    private LoginBean usuarioAtual;

    public CadastarUsuarioBean(Usuario usuario, LoginBean usuarioAtual) {
        this.usuario = usuario;
        this.usuarioAtual = usuarioAtual;
    }

    public CadastarUsuarioBean() {
        usuario = new Usuario();
        endereco = new Endereco();
        
    }

    public CadastarUsuarioBean(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    public void cadastrar(){
        UsuarioDAO daoUsuario = new UsuarioDAO(); //preparando dao usuario
        daoUsuario.save(usuario); //adiciona o usuario no banco               
        
        usuario = new Usuario();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public CadastarUsuarioBean(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LoginBean getUsuarioAtual() {
        return usuarioAtual;
    }

    public void setUsuarioAtual(LoginBean usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
    }
    
    
}
