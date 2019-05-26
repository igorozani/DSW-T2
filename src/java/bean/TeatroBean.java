/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.TeatroDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pojo.Teatro;

/**
 *
 * @author clauc
 */

@ManagedBean
@RequestScoped
public class TeatroBean implements Serializable {
    
    private Teatro teatro = new Teatro();
       
    public String lista() {
        return "livro/index.xhtml";
    }

    public String cadastra() {
       
        return "formsCadastrarTeatros.xhtml";
    }

    public String edita(Long id) {
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
         TeatroDAO dao = new TeatroDAO();
        if (teatro.getId() == null) {
            dao.save(teatro);
        } else {
            dao.update(teatro);
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String delete(Teatro teatro) {
         TeatroDAO dao = new TeatroDAO();
        dao.delete(teatro);
        return "index.xhtml";
    }

    public String volta() {
        return "index.xhtml?faces-redirect=true";
    }
    
    private List<Teatro> listaTeatros;
    
   public Teatro getTeatro(){
       return teatro;
   }

    public List<Teatro> getListaTeatros() {
        return listaTeatros;
    }

    public String verTodosTeatros() throws SQLException {
        TeatroDAO teatroDAO = new TeatroDAO();
        listaTeatros = teatroDAO.getAll();
        return "listaTeatros";
    }
    
    public String verTodosTeatros(String cidade) throws SQLException {
        TeatroDAO teatroDAO = new TeatroDAO();
        listaTeatros = teatroDAO.getAllPorCidade(cidade);
        return "listaTeatros";
    }
    
}