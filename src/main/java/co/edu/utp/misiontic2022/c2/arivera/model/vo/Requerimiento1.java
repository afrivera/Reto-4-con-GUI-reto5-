package co.edu.utp.misiontic2022.c2.arivera.model.vo;
/* carpeta Model */
/* Archivos vo */
public class Requerimiento1 {
    private String nombre;
    private Integer idLider;
    private Integer salario;
    private String primerApellido;

    public Requerimiento1() {
    }

    public Requerimiento1(String nombre, Integer idLider, Integer salario, String primerApellido) {
        this.nombre = nombre;
        this.idLider = idLider;
        this.salario = salario;
        this.primerApellido = primerApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdLider() {
        return idLider;
    }

    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }    
}
