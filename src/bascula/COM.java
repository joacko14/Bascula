package bascula;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.*;

public class COM implements Runnable, SerialPortEventListener {

    InputStream inputStream;
    SerialPort serialPort;
    Thread readThread;

    private String lectura;
    private String cadena = "";

    public COM() {
        try {
            serialPort = (SerialPort) Bascula.portId.open("Bascula", 2000);
        } catch (PortInUseException e) {
            System.out.println("Port in use exception " + e);
        }finally{
            serialPort.close();
        }
        try {
            inputStream = serialPort.getInputStream();
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            serialPort.addEventListener(this);
        } catch (TooManyListenersException e) {
            System.out.println(e);
        }
        serialPort.notifyOnDataAvailable(true);
        try {
            serialPort.setSerialPortParams(9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        } catch (UnsupportedCommOperationException e) {
            System.out.println(e);
        }
        System.out.println("Inicializacion completada");
        readThread = new Thread(this);
        readThread.start();
    }

    public String getLectura() {
        return lectura;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
//        System.out.println("Evento: " + event.getEventType());
        switch (event.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                break;
            case SerialPortEvent.DATA_AVAILABLE:
                byte[] readBuffer = new byte[20];
                try {
                    while (inputStream.available() > 0) {
                        inputStream.read(readBuffer);
                    }
                    lectura = new String(readBuffer);
                    cadena = cadena.concat(lectura);
                    System.out.println("lectura: %" + cadena + "%");
                } catch (IOException e) {
                    System.out.println(e);
                }
                if (cadena.length() >= 14) {
                    System.out.println("cadena de " + cadena.length());
                    serialPort.close();
                }
                break;
        }
    }

    public String getCadena() {
        return cadena;
    }
}
