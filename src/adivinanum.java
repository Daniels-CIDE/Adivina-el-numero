import java.util.Scanner;

public class adivinanum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numMaquina = (int) ((Math.random() * 100)+1);
        int introducido;
        int contador = 0;
        int saldoMaquina = 25;
        int saldoPersona = 5;
        int premio = 5;
        boolean jugardenuevo = true;


        System.out.println("Tienes "+saldoPersona+"€, tambien tienes 5 tiradas gratis");
        System.out.println("El juego consiste en averiguar un número secreto de 100 posibles.");

        System.out.print("Tienes 5 intentos. Escribe un número entre 1 y 100: ");
        introducido = sc.nextInt();
        do {

            if (numMaquina == introducido) {
                System.out.println("¡Has acertado!");
                contador = 5;
            } else if (contador == 4) {
                System.out.println("Lo siento: ¡has perdido!.");
                contador++;
            } else if (numMaquina > introducido)
                System.out.println("El número secreto es MAYOR que " + introducido);
            else if (numMaquina < introducido)
                System.out.println("El número secreto es MENOR que " + introducido);

            if (contador <= 1) {
                System.out.print("Otro intento: ");
                introducido = sc.nextInt();
                contador++;
            } else if (contador == 2) {
                System.out.print("Inténtalo de nuevo: ");
                introducido = sc.nextInt();
                contador++;
            } else if (contador == 3) {
                System.out.print("Oh, oh... ÚLTIMO intento: ");
                introducido = sc.nextInt();
                contador++;
            }
        } while (contador < 5);

        //Jugar de nuevo
        if (jugardenuevo == true){
            Scanner jdn = new Scanner(System.in);
            System.out.println("¿Quieres pagar 1€ para jugar otra vez?");
            System.out.println("Tienes "+saldoPersona+"€");
            System.out.println("  1.Si");
            System.out.println("  2.No");
            System.out.println("  3.Salir ");
            int opcion = jdn.nextInt();
            int salir = 0;
            while (salir == 0) {
                switch (opcion) {
                    case 1:
                        System.out.println("Has pagado 1€, por lo que tienes 1 intento mas");
                        saldoMaquina++;
                        saldoPersona--;

                        contador = 0;
                        do {
                            if (numMaquina == introducido) {
                                System.out.println("¡Has acertado!");
                                contador = 1;
                            } else if (contador == 1) {
                                System.out.println("Lo siento: ¡has perdido!.");
                                contador++;
                            } else if (numMaquina > introducido)
                                System.out.println("El número secreto es MAYOR que " + introducido);
                            else if (numMaquina < introducido)
                                System.out.println("El número secreto es MENOR que " + introducido);

                            if (contador == 0) {
                                System.out.print("Otro intento: ");
                                introducido = sc.nextInt();
                                contador++;
                            }
                        } while (contador < 1);
                        break;
                    case 2:
                        System.out.println("Pues el numero era: "+numMaquina);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Selecciona una opción del 1 al 3");
                        salir = 1;
                        break;
                }
            }
        }
    }
}
