import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        /*
        2.- Desarrolla una segunda aplicación en Java que abra el número de ventanas del navegador de tu
        elección que indique el usuario. Puede indicarlo como entrada de teclado o como argumento del
        ejecutable. Los procesos deben terminar 500 ms después de arrancar. Cada proceso debe indicar la
        hora de inicio y la hora de finalización. (3 puntos)
        */

        // Página con información relacionada al ejercicio. (Fuentes)
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/ProcessBuilder.html
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Process.html

        // Instanciamos un Scanner para leer por teclado el num de ventanas
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de ventanas que quieres abrir: ");
        int numVentanas = scanner.nextInt();
        scanner.nextLine();


        // Creamos un ArrayList de procesos para almacenar los procesos que iniciamos
        ArrayList<Process> listaProcesos = new ArrayList<Process>();

        // Configuramos un pb con el comando notepad
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("notepad");

        try {
            // Ejecutamos tantos procesos como nos pida el usuario y pintamos
            // por pantalla la hora de inicio del proceso
            for (int i = 0; i < numVentanas; i++) {
                listaProcesos.add(processBuilder.start());
                String horaInicio = listaProcesos.get(i).info().startInstant().get().toString();
                horaInicio = horaInicio.substring(11,23);
                System.out.println("Hora de inicio del proceso " + i + " " + horaInicio);
            }

            // Le damos una parada de 500 milisegundos después de iniciar los procesos
            listaProcesos.get(0).waitFor(500, TimeUnit.MILLISECONDS);

            // Destruimos/cerramos todos los procesos y pintamos por pantalla
            // la hora de finalización del proceso
            for (int i = 0; i < listaProcesos.size(); i++) {
                listaProcesos.get(i).destroyForcibly();
                String horaFinalizacion = LocalTime.now(ZoneId.of("UTC")).toString();
                horaFinalizacion = horaFinalizacion.substring(0, 12);
                System.out.println("Hora de finalización del proceso " + i + " " + horaFinalizacion);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
