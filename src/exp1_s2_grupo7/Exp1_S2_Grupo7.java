package exp1_s2_grupo7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Rai
 */
public class Exp1_S2_Grupo7 {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        int op = 0;
        int cuentaVal = 0;
        Scanner dato = new Scanner(System.in);

        while (op != 6) {
            System.out.println("\nBienvenido al Sistema de Gestion de Cuentas");
            System.out.println("\n--- Menu Bank Boston ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos del cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            try {
                System.out.println("\nIngrese la opcion deseada:");
                op = dato.nextInt();
                dato.nextLine();

            } catch (InputMismatchException e) {
                dato.next(); //Entrada para evitar bucle infinito.
                System.out.println("-----------------------------------------------------------");
                System.out.println("Opcion ingresada no valida. Por favor, intente nuevamente.");
                System.out.println("-----------------------------------------------------------");
                System.out.println(""); //Linea en blanco.                
            }

            switch (op) {
                case 1:
                    boolean rutValido = false;
                    String rutIngresado = ""; // Para almacenar el RUT

                    do {
                        System.out.println("Ingrese su RUT con puntos y guion (ej: 12.345.678-9):");
                        try {
                            rutIngresado = dato.nextLine();
                            if (rutIngresado.length() >= 11 && rutIngresado.length() <= 12) {
                                rutValido = true;
                            } else {
                                System.out.println("Error: El RUT debe tener entre 11 y 12 caracteres (incluyendo puntos y guion).");
                            }
                        } catch (InputMismatchException e) {
                            dato.nextLine(); //Limpiar entrada
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Entrada inválida. Por favor, ingrese el RUT en formato '12.345.678-9'");
                            System.out.println("-----------------------------------------------------------");
                        }
                        if (!rutValido) {
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Por favor, intente nuevamente.");
                            System.out.println("-----------------------------------------------------------");
                            System.out.println(""); // Línea en blanco
                        }
                    } while (!rutValido);
                    cliente.setRut(rutIngresado);

                    System.out.println("Ingrese nombre");
                    String nombre = dato.nextLine();
                    cliente.setNombre(nombre);

                    System.out.println("Ingrese su apellido paterno");
                    String apellidoP = dato.nextLine();
                    cliente.setApellidoP(apellidoP);

                    System.out.println("Ingrese su apellido materno");
                    String apellidoM = dato.nextLine();
                    cliente.setApellidoM(apellidoM);

                    System.out.println("Ingrese domicilio");
                    String domicilio = dato.nextLine();
                    cliente.setDireccion(domicilio);

                    System.out.println("Ingrese comuna");
                    String comuna = dato.nextLine();
                    cliente.setComuna(comuna);

                    int telefono = 0;
                    boolean telefonoValido = false;
                    while (!telefonoValido) {
                        try {
                            System.out.println("Ingrese telefono:");
                            telefono = dato.nextInt();
                            dato.nextLine(); //Limpiar entrada
                            telefonoValido = true;
                        } catch (InputMismatchException e) {
                            dato.nextLine(); //Limpiar entrada
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Entrada no valida. Por favor, ingrese un numero para el telefono.");
                            System.out.println("-----------------------------------------------------------");
                        }
                    }
                    cliente.setTelefono(telefono);

                    int numCuentaIngresado = 0;
                    boolean cuentaNumeroValido = false;
                    while (!cuentaNumeroValido) {
                        try {
                            System.out.println("Ingrese numero de cuenta corriente (9 digitos):");
                            numCuentaIngresado = dato.nextInt();
                            dato.nextLine(); //Limpiar entrada

                            if (cuentaNumValidacion(numCuentaIngresado)) {
                                cuentaNumeroValido = true;
                            } else {
                            }
                        } catch (InputMismatchException e) {
                            dato.nextLine(); //Limpiar entrada
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Entrada no valida. Por favor, ingrese un numero para la cuenta (9 digitos).");
                            System.out.println("-----------------------------------------------------------");
                        }
                    }
                    Cuenta cuentaCliente = new Cuenta(numCuentaIngresado, 0); // Saldo inicial 0                    
                    cliente.setCuenta(cuentaCliente);
                    System.out.println("\n-----------------------------------------------------------");
                    System.out.println("Cliente y cuenta registrados exitosamente.");
                    System.out.println("-----------------------------------------------------------");
                    break;
                case 2:
                    cliente.datos();
                    break;
                case 3:
                    int montDeposito;
                    boolean montoValido = false;
                    while (!montoValido) {
                        try {
                            System.out.println("Ingrese el monto a depositar:");
                            montDeposito = dato.nextInt();
                            dato.nextLine(); //Limpiar entrada
                            if (montDeposito > 0) {
                                cliente.getCuenta().depositarSaldo(montDeposito);
                                montoValido = true;
                            } else {
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("Error: El monto a depositar debe ser mayo a $1.");
                                System.out.println("-----------------------------------------------------------");
                            }
                        } catch (InputMismatchException e) {
                            dato.nextLine(); //Limpiar entrada
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Entrada no valida. Por favor, ingrese un monto valido.");
                            System.out.println("-----------------------------------------------------------");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese monto a girar");
                    int montoGirar = dato.nextInt();
                    cliente.getCuenta().girarSaldo(montoGirar);
                    break;
                case 5:
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Su saldo es de $ " + cliente.getCuenta().getSaldo());
                    System.out.println("-----------------------------------------------------------");
                    break;
                case 6:
                    System.out.println("---------------------------");
                    System.out.println("Saliendo del programa...");
                    System.out.println("Hasta pronto!");
                    System.out.println("---------------------------");
                    break;
            }
        }
    }

    public static boolean cuentaNumValidacion(int cuentaNum) {
        String cuentaNumStr = Integer.toString(cuentaNum);
        if (cuentaNumStr.length() == 9) {

            return true;

        } else {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Error, el numero de cuenta debe tener 9 carateres");
            System.out.println("-----------------------------------------------------------");
            return false;
        }
    }
}
