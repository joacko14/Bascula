package bascula.DAO;

import java.util.ArrayList;

public interface DAO {
    public boolean insertar(Object obj);
    public boolean eliminar(Object obj);
    public boolean modificar(Object obj);
    public Object consultar(int id);
    public ArrayList consultar();
}
