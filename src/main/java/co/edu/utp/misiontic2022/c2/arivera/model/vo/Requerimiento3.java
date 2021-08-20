package co.edu.utp.misiontic2022.c2.arivera.model.vo;

public class Requerimiento3 {
    private Integer idLider;
    private String nombre;
    private String apellido;
    
    public Requerimiento3() {
    }

    public Requerimiento3(Integer idLider, String nombre, String apellido) {
        this.idLider = idLider;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdLider() {
        return idLider;
    }

    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }   
}
