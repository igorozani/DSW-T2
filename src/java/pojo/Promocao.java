/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author clauc
 */
@Entity 
public class Promocao implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne 
    private Site site;
    
    @ManyToOne 
    private Teatro teatro;
    
    @Column(nullable = false, unique=false)
    private String url;
    
    @Column(nullable = false, unique=false)
    private String nome_peca;
    
    @Column(nullable = false, unique=false)
    private Float preco;
    
    @Column(nullable = false, unique=false)
    @Temporal(TemporalType.DATE)
    private Date dia_hora;
    
    @Column(nullable = false, unique=false)
    private String cnpj;
    private LocalDate dia;

    /**
     *
     * @param url
     * @param nome_peca
     * @param preco
     * @param dia_hora
     * @param dia
     * @param hora
     * @param cnpj
     */
    public Promocao(String url, String nome_peca, Float preco, LocalDate dia_hora, String cnpj) {
       
     
    }

    public Promocao() {
        
    }

    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}

    public String getNome_peca() {return nome_peca;}
    public void setNome_peca(String nome_peca) {this.nome_peca = nome_peca;}

    public Float getPreco() {return preco;}
    public void setPreco(Float preco) {this.preco = preco;}

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Date getDia_hora() {return dia_hora;}
    public void setDia_hora(Date dia_hora) {this.dia_hora = dia_hora;}

    public Site getSite() {return site;}
    public void setSite(Site site) {this.site = site;}

    public Teatro getTeatro() {return teatro;}
    public void setTeatro(Teatro teatro) {this.teatro = teatro;}
}
