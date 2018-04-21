package bascula.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JoaquinArmando
 */
public class UsuarioDAO implements DAO {

    Connection c;
    PreparedStatement ps;
    ResultSet rs;
    String query;

    @Override
    public boolean insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultar(int id) {
        Usuario usuario = new Usuario();
        query = "select * from usuarios where idUsuario = ?;";
        c = new DataSource().getConexion();
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                usuario.setIdUsuario(id);
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contraseña"));
            }
        } catch (Exception e) {
        }
        return usuario;
    }

    @Override
    public ArrayList consultar() {
        ArrayList<Usuario> usuarios = new ArrayList();
        Usuario usuario = null;

        query = "Select * from usuarios";
        c = new DataSource().getConexion();
        try {
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuarios.add(usuario);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("UsuarioDAO.consutlar() exception: " + e.getMessage());
        }

        return usuarios;
    }

    public int getIdUsuario(String usuario) {
        Usuario u = new Usuario();

        query = "select idUsuario from usuarios where usuario = ?;";
        c = new DataSource().getConexion();
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                u.setIdUsuario(rs.getInt("idUsuario"));
            }
        } catch (Exception e) {
        }

        return u.getIdUsuario();
    }

}
