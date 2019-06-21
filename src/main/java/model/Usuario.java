package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private int id_cliente;

    @Column(name= "nome")
    private String nome;

    @Column(name= "telefone")
    private String telefone;

    @Column(name= "email")
    private String email;

    @Column(name= "nascimento")
    private Date nascimento;

    @Column(name= "cpf")
    private String cpf;

    @Column(name= "login")
    private String login;

    @Column(name= "senha")
    private String senha;


    private String repete;


    private Boolean admin;

    public Usuario() {
    }

    public Usuario(String nome, String telefone, String email, Date nascimento, String cpf, String login, String senha, String repete, Boolean admin) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.repete = repete;
        this.admin = admin;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRepete() {
        return repete;
    }

    public void setRepete(String repete) {
        this.repete = repete;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
    
}
