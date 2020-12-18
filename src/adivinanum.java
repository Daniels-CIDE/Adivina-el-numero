import java.util.Scanner;

public class adivinanum {

    public int numMaquina = (int) ((Math.random() * 100)+1);
    public static int  introducido;
    public int contador = 0;
    public int saldoMaquina = 25;
    public int saldoPersona = 5;
    public int premio = 5;
    public boolean jugardenuevo = true;

    public static void main(String[] args) {
        adivinanum vi = new adivinanum();
        vi.primeraParte();
    }

    public void primeraParte (){
            Scanner sc = new Scanner(System.in);



            System.out.println("Tienes "+saldoPersona+"€, te cobramos 1€ por las primero 5 tiradas");
            System.out.println("El juego consiste en averiguar un número secreto de 100 posibles.");
            saldoPersona--;
            saldoMaquina++;
            System.out.print("Tienes 5 intentos. Escribe un número entre 1 y 100: ");
            introducido = sc.nextInt();
            do {

                if (numMaquina == introducido) {
                    System.out.println("¡Has acertado!");
                    System.out.println("Has ganado 5€");
                    saldoMaquina=saldoMaquina-5;
                    saldoPersona=saldoPersona+5;
                    contador = 5;
                    jugardenuevo=false;
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
            segundaParte();
        }

    public void segundaParte (){
        if (jugardenuevo == true){
            Scanner jdn = new Scanner(System.in);
            Scanner rec = new Scanner(System.in);
            System.out.println("¿Quieres pagar 1€ para jugar otra vez?");
            System.out.println("Tienes "+saldoPersona+"€");
            System.out.println("  1.Si");
            System.out.println("  2.No");
            int opcion = jdn.nextInt();
            int salir = 0;
            while (salir == 0) {
                switch (opcion) {
                    case 1:
                        if (saldoPersona > 0) {
                            System.out.println("Has pagado 1€, por lo que tienes 1 intento mas");
                            saldoMaquina++;
                            saldoPersona--;
                            contador = 0;

                            do {
                                if (numMaquina == introducido) {
                                    System.out.println("¡Has acertado!");
                                    System.out.println("Has ganado 5€");
                                    saldoMaquina = saldoMaquina - premio;
                                    saldoPersona = saldoPersona + premio;
                                    contador = 2;
                                    salir = 1;
                                } else if (contador == 1) {
                                    System.out.println("Lo siento: ¡has perdido!.");
                                    segundaParte();
                                    salir = 1;
                                    contador = 5;
                                } else if (numMaquina > introducido){
                                    System.out.println("El número secreto es MAYOR que " + introducido);
                                }
                                else if (numMaquina < introducido) {
                                    System.out.println("El número secreto es MENOR que " + introducido);
                                }
                                if (contador == 0) {
                                    System.out.print("Otro intento: ");
                                    introducido = rec.nextInt();
                                    contador=1;
                                }else if (contador == 5) {
                                    jugardenuevo = false;
                                    salir = 1;
                                }

                            } while (contador <= 1);
                        }else{
                            System.out.println("No te queda dinero");
                            jugardenuevo = false;
                            salir = 1;
                        }
                        break;
                    case 2:
                        System.out.println("Pues el numero era: "+numMaquina);
                        jugardenuevo = false;
                        salir = 1;
                        break;
                    default:
                        System.out.println("Selecciona una opción del 1 al 3");
                        break;
                }
            }
        }else{
            System.out.println("Has acabado");
            System.out.println("Saldo Maquina: "+saldoMaquina+"€");
            System.out.println("Saldo Persona: "+saldoPersona+"€");
        }
    }
}
