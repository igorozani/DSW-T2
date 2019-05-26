/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PromocaoDAO;
import dao.TeatroDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import pojo.Promocao;
import pojo.Teatro;

/**
 *
 * @author clauc
 */

@ManagedBean
@SessionScoped
public class PromocaoBean implements Serializable {

    private Promocao promocao = new Promocao();

    public String lista() {
        return "promo/index.xhtml";
    }

    public String cadastra() {
        
        return "formsCadastraPromocoes.xhtml";
    }

    
    public String edita(int id) {
        PromocaoDAO dao = new PromocaoDAO();
        promocao = dao.get(id);
        return "formsCadastrarPromocoes.xhtml";
    }

    public String salva() {
        PromocaoDAO dao = new PromocaoDAO();
        if (promocao.getId() == null) {
            dao.save(promocao);
        } else {
            dao.update(promocao);
        }
        return "index.xhtml";
    }

    public String delete(Promocao promocao) {
        PromocaoDAO dao = new PromocaoDAO();
        dao.delete(promocao);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    
    
     private List<Promocao> listaPromocoes;

    public List<Promocao> getListaPromocoes() {
        return listaPromocoes;
    }

    public String verTodasPromocoes() throws SQLException {
        PromocaoDAO promocaoDAO = new PromocaoDAO();
        listaPromocoes = promocaoDAO.getAll();
        return "listaPromocoes";
    }
    
    public String verTodasPromocoes(String teatro) throws SQLException {
        PromocaoDAO promocaoDAO = new PromocaoDAO();
        listaPromocoes = promocaoDAO.getAllPorTeatro(teatro);
        return "listaPromocoes";
    }

    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.getAll();
    }

    public Promocao getPromocao() {
        return promocao;
    }
}
