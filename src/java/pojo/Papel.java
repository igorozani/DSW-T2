package pojo;
//E-mail, senha, url, nome e telefone

import java.io.Serializable;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Cacheable(value = false)
public class Papel implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String email;
    private String nome;
    
    @ManyToMany(mappedBy = "papel")
    private List<Usuario> usuario;

    public Papel() {
    }

    public Papel(String email, String role) {
        this.email = email;
        this.nome = role;
    }

    

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}
    public void setId(Integer id) {this.email = email;}

    public List<Usuario> getUsuario() {return usuario;}
    public void setUsuario(List<Usuario> usuario) {this.usuario = usuario;}

}
