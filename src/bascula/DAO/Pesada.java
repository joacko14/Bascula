package bascula.DAO;

public class Pesada {
    private int idUsuario;
    private int iDPesada;
    private String placas;
    private String operador;
    private String entrada;
    private String pesoEntrada;
    private String salida;
    private String pesoSalida;
    private char tipoPesada;

    public int getiDPesada() {
        return iDPesada;
    }

    public void setiDPesada(int iDPesada) {
        this.iDPesada = iDPesada;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getPesoEntrada() {
        return pesoEntrada;
    }

    public void setPesoEntrada(String pesoEntrada) {
        this.pesoEntrada = pesoEntrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getPesoSalida() {
        return pesoSalida;
    }

    public void setPesoSalida(String pesoSalida) {
        this.pesoSalida = pesoSalida;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public char getTipoPesada() {
        return tipoPesada;
    }

    public void setTipoPesada(char tipoPEsada) {
        this.tipoPesada = tipoPEsada;
    }

    
    
}
