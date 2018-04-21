package bascula.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.JOptionPane;

public class DataSource {

    private Connection conexion = null;
    private Properties propiedades = null;
    private String url;
    private String ip;
    private String puerto;
    private String bd;
    private String usuario;
    private String contrasena;
    private String DBEngine;

    public DataSource() {
        
        try {
            propiedades = new Properties();
        FileInputStream fis = new FileInputStream("C:\\BasculaCamionera\\ParametrosBD.properties");
//            propiedades.load(getClass().getResourceAsStream("ParametrosBD.properties"));
            propiedades.load(fis);
            ip = propiedades.getProperty("ip");
            puerto = propiedades.getProperty("puerto");
            bd = propiedades.getProperty("bd");
            usuario = propiedades.getProperty("usuario");
            contrasena = propiedades.getProperty("contrasena");
            DBEngine = propiedades.getProperty("DBEngine");
            if (DBEngine.equals("MSSQL")) {
                url = "jdbc:sqlserver://" + ip + ":" + puerto + ";"
                        + "databaseName=" + bd + ";"
                        + "user=" + usuario + ";"
                        + "password=" + contrasena;
            } else if (DBEngine.equals("MySQL")) {
                url = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;
            }
            
            fis.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConexion() {
        if (DBEngine.equals("MSSQL")) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexion = DriverManager.getConnection(url);
            } catch (Exception e) {
                if(e.getMessage().matches("Login failed for user '(.*)'(.*)")){
                    String msg = "Problema de Login con la Base de datos, revise el archivo de configuración: 'C:\\BasculaCamionera\\ParametrosBD.properties'";
                    JOptionPane.showMessageDialog(null,msg);
                }else{
                    System.out.println(e.getMessage());
                }
            }
        }
        if (DBEngine.equals("MySQL")) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, contrasena);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return conexion;
    }

}
