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
public class ListaTeatros implements Serializable {
    
    private List<Teatro> listaTeatros;

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
