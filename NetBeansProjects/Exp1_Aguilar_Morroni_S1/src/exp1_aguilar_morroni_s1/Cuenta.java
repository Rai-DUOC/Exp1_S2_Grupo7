package exp1_aguilar_morroni_s1;

public class Cuenta extends Cliente {

    private int numCuenta;
    private int saldo;

    public Cuenta() {
    }

    public Cuenta(int numCuenta, int saldo) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;

    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {

        this.saldo = saldo;

    }

    public void girarSaldo(int montoGiro) {
        if (this.saldo - montoGiro < 0) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Su saldo es insuficiente para el monto de giro, saldo actual $: " + this.saldo + " " + "Intente nuevamente o deposite.");
            System.out.println("-----------------------------------------------------------");
        } else {
            this.saldo = this.saldo - montoGiro;
            System.out.println("-----------------------------------------------------------");
            System.out.println("Giro de $" + montoGiro + " completado exitosamente" + "\nSu nuevo Saldo es de $" + this.saldo);
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void depositarSaldo(int montDeposito) {
        if (this.saldo + montDeposito > 0) {
            this.saldo = this.saldo + montDeposito;
            System.out.println("-----------------------------------------------------------");
            System.out.println("Su deposito es de $" + montDeposito);
            System.out.println("Deposito realizado de manera exitosa");
            System.out.println("Su nuevo saldo es de $" + this.saldo);
            System.out.println("-----------------------------------------------------------");
        } else {
            System.out.println("Error en la transacción");
        }
    }

}
  
    