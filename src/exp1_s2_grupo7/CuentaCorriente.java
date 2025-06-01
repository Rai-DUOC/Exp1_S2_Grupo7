package exp1_s2_grupo7;

public class CuentaCorriente extends CuentaBancaria implements InformacionCliente {

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);

    }
    //Depositar monto.
    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Deposito de $" + monto + " realizado en Cuenta Corriente " + numeroCuenta + ".");
            System.out.println("Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Error: El monto a depositar debe ser mayor a $0.");
            System.out.println("-----------------------------------------------------------");
        }
    }
    //Girar/retirar monto.
    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Error: El monto a retirar debe ser mayor a $0.");
            System.out.println("-----------------------------------------------------------");
            return;
        }
        if (this.saldo >= monto) {
            this.saldo -= monto;
            System.out.println("Retiro de $" + monto + " realizado de Cuenta Corriente " + numeroCuenta + ".");
            System.out.println("Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Error: Fondos insuficientes para Cuenta Corriente " + numeroCuenta + ".");
            System.out.println("Saldo actual: $" + this.saldo + ", disponible para girar: $" + this.saldo);
            System.out.println("-----------------------------------------------------------");
        }
    }

    @Override
    public void mostrarInformacionDetallada() {
        System.out.println("--- Informacion Detallada Cuenta Corriente ---");
        System.out.println("Titular: " + getTitular());
        System.out.println("Numero de Cuenta: " + getNumeroCuenta());
        System.out.println("Saldo disponible: $" + getSaldo());
        System.out.println("---------------------------------------------");
    }
}
