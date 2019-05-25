/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author clauc
 */
@Entity
public class Site implements Serializable {
    
    @Column(nullable = false, unique=true)
    private String email;
    
    @Column(nullable = false, unique=false)
    private String senha;
    
    @Column(nullable = false, unique=true)
    private String url;
    
    @Column(nullable = false, unique=false)
    private String nome;
    
    @Column(nullable = false, unique=false)
    private Long telefone;
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(mappedBy = "site", fetch = FetchType.LAZY)
    private List<Promocao> promocoes;
    
    public Integer getId() {return id;}
    public String getEmail() {return email;}
    public String getSenha() {return senha;}
    public String getUrl() {return url;}
    public String getNome() {return nome;}
    public Long getTelefone() {return telefone;}
    public List<Promocao> getPromocoes() {return promocoes;}
    
    public void setEmail(String email) {this.email = email;}
    public void setSenha(String senha) {this.senha = senha;}
    public void setUrl(String url) {this.url = url;}
    public void setNome(String nome) {this.nome = nome;}
    public void setTelefone(Long telefone) {this.telefone = telefone;}
    public void setId(Integer id) {this.id = id;}
    public void setPromocoes(List<Promocao> promocoes) {this.promocoes = promocoes;}
    
}
