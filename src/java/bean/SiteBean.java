/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.GenericDAO;
import dao.SiteDAO;
import dao.TeatroDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pojo.Site;
import pojo.Teatro;

/**
 *
 * @author clauc
 */

@ManagedBean
@RequestScoped
public class SiteBean implements Serializable {
    
    private Site site = new Site();
       
    public String lista() {
        return "livro/index.xhtml";
    }

    public String cadastra() {
       
        return "formsCadastrarSites.xhtml";
    }

    public String edita(Long id) {
        SiteDAO dao = new SiteDAO();
        site = dao.get(id);
        return "formsCadastrarSites.xhtml";
    }

    public String salva() {
        SiteDAO dao = new SiteDAO();
        if (site.getId() == null) {
            dao.save(site);
        } else {
            dao.update(site);
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String delete(Site site) {
        SiteDAO dao = new SiteDAO();
        dao.delete(site);
        return "index.xhtml";
    }

    public String volta() {
        return "index.xhtml?faces-redirect=true";
    }
    
    private List<Site> listaSites;
    
   public Site getSite(){
       return site;
   }

    public List<Site> getListaSites() {
        return listaSites;
    }

    public String verTodosSites() throws SQLException {
        SiteDAO dao = new SiteDAO();
        listaSites = dao.getAll();
        return "listaSites";
    }
    
   /* public String verTodosTeatros(String cidade) throws SQLException {
        TeatroDAO teatroDAO = new TeatroDAO();
        listaTeatros = teatroDAO.getAllPorCidade(cidade);
        return "listaTeatros";
    } */
    
    
}
