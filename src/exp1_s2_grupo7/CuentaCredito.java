package exp1_s2_grupo7;

//Igual a cuenta de ahorro por el momento.

public class CuentaCredito extends CuentaBancaria implements InformacionCliente {
    
    public CuentaCredito(String numeroCuenta, String titular, double saldoCredito) {
        super(numeroCuenta, titular, 0); // Monto inicial 0.
        
    }
    //Depositar monto
  @Override
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Deposito de $" + monto + " realizado en Cuenta de Credito " + numeroCuenta + ". Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("-----------------------------------------------------------");
            System.out.println("El monto a depositar debe ser mayor a $0.");
            System.out.println("-----------------------------------------------------------");
        }
    }
    //Girar/retirar monto
    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("El monto a retirar debe ser mayor a $0.");
            System.out.println("-----------------------------------------------------------");
            return;
        }
        if (this.saldo >= monto) {
            this.saldo -= monto;
            System.out.println("Retiro de $" + monto + " realizado de Cuenta de Credito " + numeroCuenta + ". Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Fondos insuficientes en Cuenta de Credito " + numeroCuenta + ".");
            System.out.println("-----------------------------------------------------------");
        }
    }

    @Override
    public void mostrarInformacionDetallada() {
        System.out.println("--- Informacion Detallada Cuenta de Credito ---");
        System.out.println(super.toString()); // Reutilizar el toString de la clase abstract base.
        System.out.println("----------------------------------------------");
    }
}