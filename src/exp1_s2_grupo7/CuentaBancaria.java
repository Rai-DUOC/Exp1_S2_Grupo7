/*
 * Clase base abstracta con los atributos y metodos comunes para las demas cuentas.
 */
package exp1_s2_grupo7;

public abstract class CuentaBancaria {

    protected String numeroCuenta;
    protected double saldo;
    protected String titular;

    //Constructor para cuenta con saldo inicial $0.
    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0; //Saldo inicial 0.
    }

    //Métodos de clase abstracta para las subclases
    public abstract void depositar(double monto);
    public abstract void retirar(double monto);


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    // Método para actualizar saldo usado por subclases
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta [Numero: " + numeroCuenta + ", Titular: " + titular + ", Saldo: $" + saldo + "]";
    }
}
