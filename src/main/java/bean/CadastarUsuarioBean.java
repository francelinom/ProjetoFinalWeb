/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EnderecoDAO;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import model.Endereco;
import model.Usuario;

/**
 *
 * @author marci
 */
@ManagedBean(name = "cadastrar")
//@RequestScoped
@SessionScoped
public class CadastarUsuarioBean {
    private List<Endereco> listaEndereco;
    private List<Usuario> listaUsuario;
    UsuarioDAO daoUsuario;
    EnderecoDAO daoEndereco;

    private Usuario usuario = new Usuario();
    private Endereco endereco = new Endereco();
    
    public void inicializarUsuario(){
        listaUsuario = new ArrayList<>();
        daoUsuario = new UsuarioDAO(); //preparando dao Estoque
        listaEndereco = new ArrayList<>();
        daoEndereco = new EnderecoDAO();
        
        listaUsuario = daoUsuario.listAll();
        
    }

    @ManagedProperty(value = "#{login}")
    private LoginBean usuarioAtual;

    public CadastarUsuarioBean(Usuario usuario, LoginBean usuarioAtual) {
        this.usuario = usuario;
        this.usuarioAtual = usuarioAtual;
    }

    public CadastarUsuarioBean() {
        //usuario = new Usuario();
        //endereco = new Endereco();

    }

    public CadastarUsuarioBean(Endereco endereco) {
        this.endereco = endereco;
    }

    public String cadastrar() {
        UsuarioDAO daoUsuario = new UsuarioDAO(); //preparando dao usuario
        daoUsuario.save(usuario); //adiciona o usuario no banco               

       endereco.setUsuarios(usuario);
        
       //Endereco n = new Endereco(rua, 0, bairro, cidade, estado);
        EnderecoDAO endDao = new EnderecoDAO();//preparando dao endereco
        endDao.save(endereco);//adiciona o endereco no banco   
        
        endereco = new Endereco();
        usuario = new Usuario();
        
        return "/index.xhtml";
        
    }
    
    
    public List<Usuario> usuarioList(){
        daoUsuario = new UsuarioDAO();
        listaUsuario = daoUsuario.listAll();
        return listaUsuario;
    }
    
    
    public String excluirUsuario(Usuario u){
        daoUsuario = new UsuarioDAO();
        daoUsuario.delete(u);
        
        return "/admin/BemVindo.xhtml";
    }
    
    public String editarUsuario(Usuario u){
        usuario = u;
        
        return "/admin/ListaClientes.xhtml";
    }
    public String salvarUsuario(){
        
        daoUsuario = new UsuarioDAO();
        daoUsuario.save(usuario);
        
       
        return "/admin/BemVindo.xhtml";
    }
    
    
    /*public List<Endereco> enderecoList(){
        daoEndereco = new EnderecoDAO();
        listaEndereco = daoEndereco.listAll();
        return listaEndereco;
    }*/

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

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public UsuarioDAO getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(UsuarioDAO daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public EnderecoDAO getDaoEndereco() {
        return daoEndereco;
    }

    public void setDaoEndereco(EnderecoDAO daoEndereco) {
        this.daoEndereco = daoEndereco;
    }

    public CadastarUsuarioBean(List<Endereco> listaEndereco, List<Usuario> listaUsuario, UsuarioDAO daoUsuario, EnderecoDAO daoEndereco, LoginBean usuarioAtual) {
        this.listaEndereco = listaEndereco;
        this.listaUsuario = listaUsuario;
        this.daoUsuario = daoUsuario;
        this.daoEndereco = daoEndereco;
        this.usuarioAtual = usuarioAtual;
    }

}
