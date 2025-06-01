package exp1_s2_grupo7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exp1_S2_Grupo7 {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        int op = 0;
        Scanner dato = new Scanner(System.in);

        while (op != 6) {
            System.out.println("\nBienvenido al Sistema de Gestion de Cuentas Bank Boston");
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Registrar cliente y aperturar cuenta.");
            System.out.println("2. Ver datos del cliente y cuenta.");
            System.out.println("3. Depositar dinero a cuenta.");
            System.out.println("4. Girar o retirar dinero desde cuenta.");
            System.out.println("5. Consultar saldo e informacion de cuenta.");
            System.out.println("6. Salir.");
            try {
                System.out.println("\nIngrese la opcion deseada:");
                op = dato.nextInt();
                dato.nextLine(); //Consumir entrada consola.

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
                                System.out.println("Error: Formato de RUT incorrecto. Use formato XX.XXX.XXX-X (incluyendo puntos y guion).");
                            }
                        } catch (InputMismatchException e) {
                            dato.nextLine(); //Consumir entrada consola.
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Entrada invalida. Por favor, ingrese el RUT en formato '12.345.678-9'");
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

                    System.out.println("Ingrese nombre:");
                    String nombre = dato.nextLine();
                    cliente.setNombre(nombre);

                    System.out.println("Ingrese su apellido paterno:");
                    String apellidoP = dato.nextLine();
                    cliente.setApellidoP(apellidoP);

                    System.out.println("Ingrese su apellido materno:");
                    String apellidoM = dato.nextLine();
                    cliente.setApellidoM(apellidoM);

                    System.out.println("Ingrese domicilio:");
                    String domicilio = dato.nextLine();
                    cliente.setDireccion(domicilio);

                    System.out.println("Ingrese comuna:");
                    String comuna = dato.nextLine();
                    cliente.setComuna(comuna);

                    int telefono = 0;
                    boolean telefonoValido = false;
                    while (!telefonoValido) {
                        try {
                            System.out.println("Ingrese telefono (formato de 9 digitos):");
                            telefono = dato.nextInt();
                            dato.nextLine(); //Consumir entrada consola.
                            telefonoValido = true;
                        } catch (InputMismatchException e) {
                            dato.nextLine(); //Consumir entrada consola.
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Entrada no valida. Por favor, ingrese un numero para el telefono.");
                            System.out.println("-----------------------------------------------------------");
                        }
                    }
                    cliente.setTelefono(telefono);

                    // Logica para seleccionar el tipo de cuenta
                    int tipoCuentaOpcion = 0;
                    boolean tipoCuentaValido = false;
                    System.out.println("\n--- Creacion de Cuenta ---");
                    while (!tipoCuentaValido) {
                        System.out.println("Seleccione el tipo de cuenta deseada:");
                        System.out.println("1. Cuenta Corriente");
                        System.out.println("2. Cuenta de Ahorro");
                        System.out.println("3. Cuenta de Credito");
                        System.out.print("Ingrese su opcion: ");
                        try {
                            tipoCuentaOpcion = dato.nextInt();
                            dato.nextLine(); //Consumir entrada consola.
                            if (tipoCuentaOpcion >= 1 && tipoCuentaOpcion <= 3) {
                                tipoCuentaValido = true;
                            } else {
                                System.out.println("Opcion no valida. Por favor, intente nuevamente.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Opcion no valida. Por favor, intente nuevamente.");
                            dato.nextLine(); //Consumir entrada consola.
                        }
                    }

                    String numCuentaIngresado = "";
                    boolean cuentaNumeroValido = false;
                    while (!cuentaNumeroValido) {
                        System.out.println("Ingrese numero para la nueva cuenta (9 digitos):");
                        numCuentaIngresado = dato.nextLine();
                        if (cuentaNumValidacion(numCuentaIngresado)) {
                            cuentaNumeroValido = true;
                        }
                    }

                    String titularCuenta = cliente.getNombre() + " " + cliente.getApellidoP();
                    CuentaBancaria nuevaCuenta = null; // Crear cuenta 'vacia' para luego asignarle el tipo despues de elegir el tipo.

                    switch (tipoCuentaOpcion) {
                        case 1: // Cuenta Corriente                                                                                
                            nuevaCuenta = new CuentaCorriente(numCuentaIngresado, titularCuenta, 0);
                            System.out.println("Cuenta Corriente creada exitosamente.");
                            break;
                        case 2: // Cuenta de Ahorro                                                                                    
                            nuevaCuenta = new CuentaAhorro(numCuentaIngresado, titularCuenta, 0);
                            System.out.println("Cuenta de Ahorro creada exitosamente.");
                            break;
                        case 3: // Cuenta de Crédito                            
                            nuevaCuenta = new CuentaCredito(numCuentaIngresado, titularCuenta, 0);
                            System.out.println("Cuenta de Credito creada exitosamente.");
                            break;
                    }
                    if (nuevaCuenta != null) { //Valida la creacion de la cuenta.
                        cliente.setCuenta(nuevaCuenta);
                        System.out.println("\n-----------------------------------------------------------");
                        System.out.println("Cliente y nueva cuenta registrados exitosamente.");
                        cliente.datos(); // Mostrar datos para confirmar
                        System.out.println("-----------------------------------------------------------");
                    } else {
                        System.out.println("Error: No se pudo crear la cuenta.");
                    }
                    break;
                case 2: //Ver datos.
                    if (cliente.getRut() == null) { //Mensaje en caso de que no existan clientes registrados.
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("No se registra ningun cliente ingresado al sistema.");
                        System.out.println("-----------------------------------------------------------");
                    } else {
                        cliente.datos();
                    }
                    break;
                case 3: //Depositar.
                    if (cliente.getCuenta() == null) { //Mensaje en caso de que no existan cuentas creadas.
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("No se registra ningun cliente ingresado al sistema.");
                        System.out.println("-----------------------------------------------------------");
                        break;
                    }
                    double montoDeposito = 0;
                    boolean montoDepositoValido = false;
                    while (!montoDepositoValido) {
                        try {
                            System.out.println("Ingrese el monto a depositar:");
                            montoDeposito = dato.nextDouble();
                            dato.nextLine(); //Consumir entrada consola.
                            if (montoDeposito > 0) {
                                cliente.getCuenta().depositar(montoDeposito); //Metodo para depositar monto.
                                montoDepositoValido = true;
                            } else {
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("Error: El monto a depositar debe ser mayor a $0.");
                                System.out.println("-----------------------------------------------------------");
                            }
                        } catch (InputMismatchException e) {
                            dato.nextLine(); //Consumir entrada consola.
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Entrada no valida. Por favor, ingrese un monto valido.");
                            System.out.println("-----------------------------------------------------------");
                        }
                    }
                    break;
                case 4: //Girar.
                    if (cliente.getCuenta() == null) { ////Mensaje en caso de que no existan cuentas creadas.
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("No se registra ningun cliente ingresado al sistema.");
                        System.out.println("-----------------------------------------------------------");
                        break;
                    }
                    double montoGirar = 0;
                    boolean montoGiroValido = false;
                    while (!montoGiroValido) {
                        try {
                            System.out.println("Ingrese monto a girar");
                            montoGirar = dato.nextDouble();
                            dato.nextLine(); //Consumir entrada consola.
                            if (montoGirar > 0) {
                                cliente.getCuenta().retirar(montoGirar); //Metodo para girar/retirar monto.
                                montoGiroValido = true;
                            } else {
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("Error: El monto a girar debe ser mayor a $0.");
                                System.out.println("-----------------------------------------------------------");
                            }
                        } catch (InputMismatchException e) {
                            dato.nextLine(); //Consumir entrada consola.
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Entrada no valida. Por favor, ingrese un monto valido.");
                            System.out.println("-----------------------------------------------------------");
                        }
                    }
                    break;
                case 5:
                    if (cliente.getCuenta() == null) {
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("No se registra ningun cliente ingresado al sistema.");
                        System.out.println("-----------------------------------------------------------");
                        break;
                    } else {
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Su saldo es de $ " + cliente.getCuenta().getSaldo());
                        System.out.println("-----------------------------------------------------------");
                    }
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

    public static boolean cuentaNumValidacion(String cuentaNum) {
        if (cuentaNum != null && cuentaNum.length() == 9) { //Para validar que el num de cuenta sea de 9 digitos.
            return true;
        } else {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Error, el numero de cuenta debe tener 9 digitos");
            System.out.println("-----------------------------------------------------------");
            return false;
        }
    }
}
