import java.util.Scanner;

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
    }
}
