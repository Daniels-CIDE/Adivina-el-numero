//Importamos la utility de Java llamada Scanner, la cual vamos a usar para leer lo que el usuario introduce.
import java.util.Scanner;

public class adivinanum {
    /*Lo primero es que nada mas crear la clase introducimos
    todos los valores que vayamos a usar para nuestro programa */

    //Aqui creamos el numero entero que hay que adivinar.
    public int numMaquina = (int) ((Math.random() * 100)+1);
    //Este será el numero entero introducido por el usuario.
    public static int  introducido;
    //Este numero es un numero que utilizamos para contar las veces que el usuario pone el numero.
    public int contador = 0;
    //El saldo con el que empiza la maquina.
    public int saldoMaquina = 25;
    //Saldo con el que el usuario empieza la parida
    public int saldoPersona = 5;
    //Premio con numero entero
    public int premio = 5;
    //Parametro si el jugador quiere jugar apartir de que ha perdido los primero intentos.
    public boolean jugardenuevo = true;


    //Llamamiento al metodo principal que hara comenzar el programa
    public static void main(String[] args) {
        adivinanum vi = new adivinanum();
        vi.primeraParte();
    }

    public void primeraParte (){
        //Primero, creamos un scanner con la utility de java llamado "sc"
            Scanner sc = new Scanner(System.in);


            //Lo siguiente va ser el mensaje en el que el programa te dirá tu saldo y en que consiste el juego:
            System.out.println("Tienes "+saldoPersona+"€, tienes gratis las primero 5 tiradas");
            System.out.println("El juego consiste en averiguar un número secreto de 100 posibles.");
            System.out.print("Tienes 5 intentos. Escribe un número entre 1 y 100: ");
            //Aqui, empezamos leyendo el numero entero introducciodo por el usuario
            introducido = sc.nextInt();
            //Y nos meteremos en el bucle do-while
            do {
                //Si el usuario acierta el numero salen los mensajes siguientes
                if (numMaquina == introducido) {
                    System.out.println("¡Has acertado!");
                    System.out.println("Has ganado 5€");
                    //Se resta el premio de la maquina y se le añade al usuario
                    saldoMaquina=saldoMaquina-premio;
                    saldoPersona=saldoPersona+premio;
                    //El contador sube a 5 (dado a que el bucle continua si es menor a 5)
                    contador = 5;
                    //Y jugar de nuevo se convierte en "false", es decir que no le pedira dinero por acertar el mismo numero.
                    jugardenuevo=false;
                //Si el usuario repite los numeros hasta que pierda le saldra el siguiente mensaje
                } else if (contador == 4) {
                    //Este es el mensaje cuando pierde
                    System.out.println("Lo siento: ¡has perdido!.");
                    //Con esta suma de 1, el contador sube a 5 por lo que el bucle acaba, y como jugardenuevo=true, el usuario juega de nuevo.
                    contador++;
                    //Si el numero de la maquina es MAYOR a el introducido sale el siguiente mensaje:
                } else if (numMaquina > introducido)
                    System.out.println("El número secreto es MAYOR que " + introducido);
                    //Si el numero de la maquina es MENOR a el introducido sale el siguiente mensaje:
                else if (numMaquina < introducido)
                    System.out.println("El número secreto es MENOR que " + introducido);

                //Aqui podia haber usado la misma frase cada vez que fallase, pero decidi poner una diferente para cada intento:
                if (contador <= 1) {
                    System.out.print("Otro intento: ");
                    introducido = sc.nextInt();
                    //Contador = 2;
                    contador++;
                } else if (contador == 2) {
                    System.out.print("Inténtalo de nuevo: ");
                    introducido = sc.nextInt();
                    //Contador = 3;
                    contador++;
                } else if (contador == 3) {
                    System.out.print("Oh, oh... ÚLTIMO intento: ");
                    introducido = sc.nextInt();
                    //Contador = 4; gracias a esto, si no hemos adivinado el numero iremos a la parte de perder.
                    contador++;
                }
            } while (contador < 5); //Se acaba el bucle do-while
        //Llamamos a al metodo que consiste en la segunda parte.
            segundaParte();
        }

    public void segundaParte (){
        //Aqui es donde se comprueba si has ganado o si has perdido
        if (jugardenuevo == true){
            //Aqui tenemos 2 scanners para diferenciar (jdn para la opcion del case y rec para introducir el numero que deve adivinar)
            Scanner jdn = new Scanner(System.in);
            Scanner rec = new Scanner(System.in);
            /*En este "sout" te pregunta si quieres pagar si dices que si te cobra 1€ por cada tirada.
            Si dices que no saltara a la linea dode dice el numero de la maquina, tu saldo y el saldo de la maquina.*/
            System.out.println("¿Quieres pagar 1€ para jugar otra vez?");
            System.out.println("Tienes "+saldoPersona+"€");
            System.out.println("  1.Si");
            System.out.println("  2.No");
            //Aqui lee el scanner y le pone el nombre de oopcion que se usara para el switch
            int opcion = jdn.nextInt();
                switch (opcion) {
                    //En caso de la opcion 1
                    case 1:
                        //Si el saldo del usuario es MAYOR a 0, paga el euro
                        if (saldoPersona > 0) {
                            System.out.println("Has pagado 1€, por lo que tienes 1 intento mas");
                            //Incrementamos el saldo de la maquina y decrementamos el saldo del usuario.
                            saldoMaquina++;
                            saldoPersona--;
                            //El constador se establece a 0
                            contador = 0;
                            //Continuamos con otro bucle do-while
                            do {
                                //Si el numero introducido por el usuario es == al de la maquina pasará lo siguiente:
                                if (numMaquina == introducido) {
                                    //Mensajes de que has ganado y cuanto has ganado
                                    System.out.println("¡Has acertado!");
                                    System.out.println("Has ganado 5€");
                                    //Se te otorga el premio
                                    saldoMaquina = saldoMaquina - premio;
                                    saldoPersona = saldoPersona + premio;
                                    //Mensaje de cuanto te queda y cuanto le queda a la maquina
                                    System.out.println("Saldo Maquina: "+saldoMaquina+"€");
                                    System.out.println("Saldo Persona: "+saldoPersona+"€");
                                    //El contador iguala a 2 para salir del bucle
                                    contador = 2;
                                //Si el contador iguala a 1 saldrá el mensaje de que hemos perdido y volvera al principio del la segundaParte.
                                } else if (contador == 1) {
                                    System.out.println("Lo siento: ¡has perdido!.");
                                    segundaParte();
                                //Si el numero de la maquina es MAYOR al introducido, sale el siguiente mensaje
                                } else if (numMaquina > introducido){
                                    System.out.println("El número secreto es MAYOR que " + introducido);
                                }
                                //Si el numero de la maquina es MENOR al introducido, sale el siguiente mensaje
                                else if (numMaquina < introducido) {
                                    System.out.println("El número secreto es MENOR que " + introducido);
                                }
                                //Este mensaje sale una vez pagado el EURO
                                if (contador == 0) {
                                    System.out.print("Otro intento: ");
                                    introducido = rec.nextInt();
                                    contador=1;
                                    //Contador es igual a 5 convierte jugardenuevo a false.
                                }else if (contador == 5) {
                                    jugardenuevo = false;
                                }

                            } while (contador <= 1);
                        //Si el usuario no le queda dinero la maquina se lo diara y lo echara:
                        }else{
                            System.out.println("No te queda dinero");
                            jugardenuevo = false;
                        }
                        break;
                        //Si pulsas 2 en el switch, saldran los siguientes mensajes y el programa terminara
                    case 2:
                        System.out.println("Pues el numero era: "+numMaquina);
                        System.out.println("Saldo Maquina: "+saldoMaquina+"€");
                        System.out.println("Saldo Persona: "+saldoPersona+"€");
                        jugardenuevo = false;
                        break;
                        //Te pide de que selecciones o el 1 o el 2
                    default:
                        System.out.println("Selecciona una opción del 1 o 2");
                        break;
                }
        //Si acabas el programa ganando en la primera parte te saldra estos mensajes.
        }else{
            System.out.println("Has acabado");
            System.out.println("Saldo Maquina: "+saldoMaquina+"€");
            System.out.println("Saldo Persona: "+saldoPersona+"€");
        }
    }
}

