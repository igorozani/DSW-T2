package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import login.JDBCUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pojo.Papel;
import pojo.Usuario;
 

public class UsuarioDAO {
     private final String INSERIR_USUARIO = "INSERT INTO Usuario(email, senha, ativo) values (?,?,1)";   
     private final String INSERIR_ROLE = "INSERT INTO Papel(id, nome) values (?,?)"; 
     private final String GET_USUARIO = "SELECT * FROM Usuario where email=?";
     private final String LISTAR_USUARIOS = "SELECT * FROM Usuario";
     private final String LISTAR_ROLES = "SELECT * FROM Papel";
     private final String LISTAR_USUARIOS_ROLES = "SELECT u.id \"ID\" u.email \"email\", u.senha \"senha\", u.ativo \"ativo\", r.nome \"papel\" FROM Usuario u INNER JOIN Papel r ON u.email = r.email";                                                        
     private final String ATUALIZAR_USUARIO = "UPDATE Usuario SET email=?, senha=? WHERE id=?"; 
     private final String ATUALIZAR_ROLE = "UPDATE Usuario SET nome=?, WHERE email=?"; 
     private final String ATIVA_DESATIVA = "UPDATE Usuario SET ativo=?, WHERE email=?"; 
     private final String DELETAR_ID = "DELETE FROM Usuario WHERE id=?";
     private final String DELETAR_EMAIL = "DELETE FROM Usuario WHERE email=?";   

     public void inserir_usuario(Usuario usuario) throws ClassNotFoundException {
        try {
            
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            DataSource ds = JDBCUtil.getDataSource();
            Connection conn = ds.getConnection();
            
            PreparedStatement userStatement = conn.prepareStatement(INSERIR_USUARIO);
            userStatement.setString(1, usuario.getEmail());
            userStatement.setString(2, encoder.encode(usuario.getSenha()));
            userStatement.execute();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void inserirpapel(Papel papel) throws ClassNotFoundException {
        try {
            DataSource ds = JDBCUtil.getDataSource();
            Connection conn = ds.getConnection();
            
            PreparedStatement roleStatement = conn.prepareStatement(INSERIR_ROLE);
            roleStatement.setString(1, papel.getEmail());
            roleStatement.setString(2, papel.getNome());
            roleStatement.execute();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }   
    
}