package testbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import writer.Encripta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MySpringWriterBeanWithDependency {
    private Encripta writer;
    @Autowired
    public void setWriter (Encripta pWriter){
        this.writer = pWriter;
    }

    static PrintStream out = System.out;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public void run() throws IOException {
        int op = -1;

        out.println("Examen 1 / Parte 3");
        out.println("Alonso Cortés");
        out.println(" ");
        out.println("Menu Principal");
        out.println(" ");
        out.println("1. Encriptar una palabra ");
        out.println("2. Desencriptar una palabra");
        out.println("0. Salir");
        out.println(" ");
        out.println("Elija una opción");
        op = Integer.parseInt(in.readLine());

        procesarOpcion(op);
    }

    private void procesarOpcion(int op) throws IOException {

        switch (op) {
            case 1:
                menuEncriptar();
                break;
            case 2:
                menuDesencriptar();
                break;
            case 0:
                out.println("Ha salido de la aplicación");
                break;

            default:
                out.println("Opción incorrecta. Digite 1, 2 o 0");
                run();
                break;
        }
    }

    private void menuEncriptar() throws IOException {

        out.println(" ");
        out.println("Digite el texto a encriptar sin espacios");
        String texto = in.readLine();
        writer.encripta(texto);

        run();
    }
    private void menuDesencriptar() throws IOException {

        out.println(" ");
        out.println("Digite el texto a desencriptar sin espacios");
        String texto = in.readLine();
        writer.desencripta(texto);

        run();
    }
}
