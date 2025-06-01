package exp1_s2_grupo7;

public class CuentaAhorro extends CuentaBancaria implements InformacionCliente {

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);
    }
    //Depositar monto
    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Deposito de $" + monto + " realizado en Cuenta de Ahorro " + numeroCuenta + ". Nuevo saldo: $" + this.saldo);
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
            System.out.println("Retiro de $" + monto + " realizado de Cuenta de Ahorro " + numeroCuenta + ". Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Fondos insuficientes en Cuenta de Ahorro " + numeroCuenta + ".");
            System.out.println("-----------------------------------------------------------");
        }
    }

    @Override
    public void mostrarInformacionDetallada() {
        System.out.println("--- Informacion Detallada Cuenta de Ahorro ---");
        System.out.println(super.toString()); // Reutilizar el toString de la clase abstract base
        System.out.println("----------------------------------------------");
    }
}
