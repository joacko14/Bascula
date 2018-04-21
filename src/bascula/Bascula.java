package bascula;

import java.util.*;
import javax.comm.*;

public class Bascula {

    static CommPortIdentifier portId;
    static Enumeration portList;
    static String estatus;
    static String nombrePuerto;

    public static void main(String[] args) {
////        try {
////            buscarPuerto();
////        } catch (Exception e) {
////            System.out.println("Error al iniciar puerto en ");
////        }

        estatus = "puerto no inicializado";
        Principal frame = new Principal();
        frame.setVisible(true);
    }

    public static void buscarPuerto() throws Exception {
        portList = CommPortIdentifier.getPortIdentifiers();
        nombrePuerto = "COM1";
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            System.out.println("Id de puerto: " + portId.getName());
            System.out.println("Tipo de puerto: " + portId.getPortType());
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if (portId.getName().equals(nombrePuerto)) {
//                    if (portId.getName().equals("/dev/term/a")) {
                    estatus = "Puerto serie COM encontrado";
                    System.out.println(estatus);
                    break;
                }
            }
        }
    }

}
