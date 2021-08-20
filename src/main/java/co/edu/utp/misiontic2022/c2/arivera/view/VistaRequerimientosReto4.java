package co.edu.utp.misiontic2022.c2.arivera.view;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.arivera.controller.ControladorRequerimientosReto4;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento1;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento2;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento3;

/* carpeta view */
public class VistaRequerimientosReto4 {
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    public static void requerimiento1(){
        System.out.println("*** Lideres por Salario ***");   

        try{
            ArrayList<Requerimiento1> liderSalario = controlador.requerimiento_1();
            for(Requerimiento1 liderSal: liderSalario){
                System.out.printf("El Lider %s %s con Id %d Tiene un salario de %d %n",
               liderSal.getNombre(),
               liderSal.getPrimerApellido(),
               liderSal.getIdLider(),
               liderSal.getSalario()
                );
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void requerimiento2(){  
        System.out.println("*** Proyectos por Tipo ***");   

        try{
            // su codigo
            ArrayList <Requerimiento2> proyectoTipo = controlador.requerimiento_2();
            for(Requerimiento2 proTipo: proyectoTipo){
                System.out.printf("El proyecto con ID %d de la constructora: %s de la ciudad %s, tiene un estrato asignado igual a %d\n",
                proTipo.getIdProyecto(),
                proTipo.getConstructora(),
                proTipo.getCiudad(),
                proTipo.getEstrato()
                );
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error! "+e.getMessage());
        }
    }

    public static void requerimiento3(){
        System.out.println("*** Lideres por Nombre ***");

        try{
            // su codigo
            ArrayList<Requerimiento3> liderTipo = controlador.requerimiento_3();
            for(Requerimiento3 liTipo : liderTipo){
                System.out.printf("El Lider con Id %d se llama %s %s\n",
                liTipo.getIdLider(),
                liTipo.getNombre(),
                liTipo.getApellido()
                );
            }                       
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error! " + e);
        }
    }
}
