package Projects.Omnibus.Model;

public class Pasajero {
    private Long id;
    private String nombre;
    private double saldo;

    public Pasajero(Long id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }



    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }
}
