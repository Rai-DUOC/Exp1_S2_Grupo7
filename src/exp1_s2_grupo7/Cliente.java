package exp1_s2_grupo7;

public class Cliente {

    private String rut;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String direccion;
    private String comuna;
    private int telefono;
    private CuentaBancaria cuenta;

    public Cliente() {
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public int getTelefono() {
        return telefono;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public void datos() {
        System.out.println("--- Datos del Cliente ---");
        System.out.println("RUT: " + rut);
        System.out.println("Nombre: " + nombre + " " + apellidoP + " " + apellidoM);
        System.out.println("Domicilio: " + direccion);
        System.out.println("Comuna: " + comuna);
        System.out.println("Telefono: " + telefono);
        System.out.println("-----------------------------------------------------------");

        if (this.cuenta != null && this.cuenta instanceof InformacionCliente) {
            ((InformacionCliente) this.cuenta).mostrarInformacionDetallada();
        } else {
            if (this.cuenta != null) {
                System.out.println(this.cuenta.toString()); //Desplegar informacion si no aplica InformacionCliente no esta.
            } else {
                System.out.println("-----------------------------------------------------------");
                System.out.println("Cliente sin numero de Cuenta registrada");
                System.out.println("-----------------------------------------------------------");
            }
        }
    }
}
