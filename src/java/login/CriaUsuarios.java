/*package Login;


import dao.PromocaoDAO;
import dao.SiteDAO;
import dao.TeatroDAO;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pojo.Papel;
import pojo.Site;
import pojo.Usuario;

public class CriaUsuarios {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            TeatroDAO teatroDAO = new TeatroDAO();
            SiteDAO siteDAO = new SiteDAO();
            PromocaoDAO promocaoDAO = new PromocaoDAO();

            // insere admins
            for(int i = 1; i <= 5; i++){
                String email = "admin" + i + "@gmail.com";
                String senha = "admin" + i + "_pass";
                String role = "ROLE_ADMIN";
                
                usuarioDAO.inserir_usuario(new Usuario(email, senha));
                usuarioDAO.inserir_role(new Papel(email, role));
            }

            // insere teatros
            for(int i = 1; i <= 5; i++){
                String email = "teatro" + i + "@gmail.com";
                String senha = "teatro" + i + "_pass";
                String cidade = "Cidade" + i;
                String nome = "Teatro da Cidade" + i;
                String cnpj = "111000000" + i;
                String role = "ROLE_TEATRO";
                
                teatroDAO.inserir(new Teatro(email, senha, cidade, nome, cnpj));
                usuarioDAO.inserir_usuario(new Usuario(email, senha));
                usuarioDAO.inserir_role(new Papel(email, "ROLE_TEATRO"));
            }
            
            // insere sites
            for(int i = 1; i <= 5; i++){
                
                String email = "site" + i + "@gmail.com";
                String senha = "site" + i + "_pass";
                String url = "https://www.site" + i + ".com.br";
                String nome = "Site" + i;
                int telefone = 999965070 + i;
                String role = "ROLE_SITE";
                Site site =  new Site(email, senha, url, nome, telefone);
                Usuario usuario = new Usuario(email, senha);
                siteDAO.inserir(site);
                usuarioDAO.inserir_usuario(usuario);
                usuarioDAO.inserir_role(new Papel(email, "ROLE_SITE"));
            }

            // insere promocoes
            for(int i = 1; i <= 5; i++){
                String url = "https://www.site" + i + ".com.br";
                String nome_peca = "promocao" + i;
                Float preco = 20+i*0.1f;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dia = LocalDate.parse("20/05/2000", formatter);
                LocalTime hora = LocalTime.parse("05:05");
                String cnpj = "111000000" + i;
                promocaoDAO.inserir(new Promocao(url, nome_peca, preco, dia, hora, cnpj));
            }
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/