package bascula.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PesadaDAO implements DAO {

    Pesada pesada = null;
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query;
    boolean estatus = false;

    @Override
    public boolean insertar(Object obj) {
        pesada = (Pesada) obj;

        System.out.println("Usuario: " + pesada.getIdUsuario());
        System.out.println("ID: " + pesada.getiDPesada());
        System.out.println("Placas:" + pesada.getPlacas());
        System.out.println("Operador: " + pesada.getOperador());
        System.out.println("Entrada: " + pesada.getEntrada());
        System.out.println("Peso de entrada: " + pesada.getPesoEntrada());
        System.out.println("Salida: " + pesada.getSalida());
        System.out.println("Peso de salida: " + pesada.getPesoSalida());

        return estatus;
    }

    public int nuevo() {
        int id = 0;
//        String query = "insert into pesadas (placas,operador,horaEntrada,pesoEntrada,horaSalida,pesoSalida) values(' ',' ',' ',' ',' ',' ');";
        c = new DataSource().getConexion();
//        try {
//            ps = c.prepareStatement(query);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        String query = "select top 1 idPesada from pesadas order by 1 desc;";
        try {
            ps = c.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    @Override
    public boolean eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object obj) {
        pesada = (Pesada) obj;
        c = new DataSource().getConexion();
        String query = "update pesadas set "
                + "idUsuario = ?, "
                + "placas = ?, "
                + "operador = ?, "
                + "horaEntrada = ?, "
                + "pesoEntrada = ?, "
                + "horaSalida = ?, "
                + "pesoSalida = ?, "
                + "tipoPesada = ? "
                + "where idPesada = ?";
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, pesada.getIdUsuario());
            ps.setString(2, pesada.getPlacas());
            ps.setString(3, pesada.getOperador());
            ps.setString(4, pesada.getEntrada());
            ps.setString(5, pesada.getPesoEntrada());
            ps.setString(6, pesada.getSalida());
            ps.setString(7, pesada.getPesoSalida());
            ps.setString(8, String.valueOf(pesada.getTipoPesada()));
            ps.setInt(9, pesada.getiDPesada());

            if (ps.executeUpdate() == 1) {
                estatus = true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return estatus;
    }

    @Override
    public Object consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdUsuario(int idPesada) {
        pesada = new Pesada();
        query = "select idUsuario from pesadas where idPesada = ?;";

        c = new DataSource().getConexion();
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, idPesada);
            rs = ps.executeQuery();
            while(rs.next()){
                pesada.setIdUsuario(rs.getInt("idUsuario"));
            }
            c.close();
        } catch (Exception e) {
        }

        return pesada.getIdUsuario();
    }

}
