package co.edu.utp.misiontic2022.c2.arivera.controller;

import java.util.ArrayList;
import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.arivera.model.dao.Requerimiento_1Dao;
import co.edu.utp.misiontic2022.c2.arivera.model.dao.Requerimiento_2Dao;
import co.edu.utp.misiontic2022.c2.arivera.model.dao.Requerimiento_3Dao;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento1;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento2;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento3;


/* Carpeta controller */
public class ControladorRequerimientosReto4 {
     //Su codigo
    private final Requerimiento_1Dao CONSULTA1;
    private final Requerimiento_2Dao CONSULTA2;
    private final Requerimiento_3Dao CONSULTA3;

    public ControladorRequerimientosReto4() {
        this.CONSULTA1 = new Requerimiento_1Dao();
        this.CONSULTA2 = new Requerimiento_2Dao();
        this.CONSULTA3 = new Requerimiento_3Dao();
    }

    public ArrayList<Requerimiento1> requerimiento_1() throws SQLException {
        //Su codigo
        return this.CONSULTA1.requerimiento1();
    }
    
    public ArrayList<Requerimiento2> requerimiento_2() throws SQLException {
        //Su codigo
        return this.CONSULTA2.requerimiento2();
    }

    public ArrayList<Requerimiento3> requerimiento_3() throws SQLException {
        //Su codigo
        return this.CONSULTA3.requerimiento3();
    }
}
