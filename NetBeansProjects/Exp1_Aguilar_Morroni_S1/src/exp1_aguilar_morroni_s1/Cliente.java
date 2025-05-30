
    package exp1_aguilar_morroni_s1;

public class Cliente {

    static void setrut(String rut) {
    }

    private String rut;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String direccion;
    private String comuna;
    private int telefono;
    private boolean registro;
    private Cuenta cuenta;

    public Cliente() {
        this.cuenta = null;
    }

    public Cliente(String rut, String nombre, String apellidoP, String apellidoM, String direccion, String comuna, int telefono, boolean registro, Cuenta cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.comuna = comuna;
        this.telefono = telefono;
        this.registro = registro;
        this.cuenta = cuenta;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isRegistro() {
        return registro;
    }

    public void setRegistro(boolean registro) {

        this.registro = registro;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "\nrut=" + rut + ", \nnombre=" + nombre + ", \napellidoP=" + apellidoP + ", \napellidoM=" + apellidoM + ", \ndireccion=" + direccion + ", \ncomuna=" + comuna + ", \ntelefono=" + telefono + ", \nregistro=" + registro + ", \ncuenta=" + cuenta + '}';
    }

    public void datos() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Datos del cliente");
        System.out.println("RUT: " + rut);
        System.out.println("Nombre: " + nombre + " " + apellidoP + " " + apellidoM);
        System.out.println("Domicilio: " + direccion);
        System.out.println("Comuna: " + comuna);
        System.out.println("Telefono: " + telefono);
        System.out.println("-----------------------------------------------------------");

        if (this.cuenta != null) {            
            System.out.println("Numero de Cuenta: " + this.cuenta.getNumCuenta());
            System.out.println("Saldo Actual: $" + this.cuenta.getSaldo());
        } else {
            System.out.println("Numero de Cuenta: No registrado");
            System.out.println("Saldo Actual: No disponible");
        }
        System.out.println("-------------------------");
    }
}

