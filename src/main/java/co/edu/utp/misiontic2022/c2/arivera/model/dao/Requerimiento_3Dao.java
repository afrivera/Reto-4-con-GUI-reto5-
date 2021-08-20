package co.edu.utp.misiontic2022.c2.arivera.model.dao;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento3;
import co.edu.utp.misiontic2022.c2.arivera.util.JDBCUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class Requerimiento_3Dao {
   
   public ArrayList<Requerimiento3> requerimiento3() throws SQLException {

    ArrayList<Requerimiento3> retornoConsulta = new ArrayList<>();
    Connection conexion = JDBCUtilities.getConnection();

    try{       

        String select =   "select ID_Lider, Nombre, Primer_Apellido from Lider where Primer_Apellido LIKE '%z' order by Nombre asc";


        PreparedStatement stm = conexion.prepareStatement(select);
        ResultSet rs = stm.executeQuery();

        //Recorrer los registros en los VO específicos
        while(rs.next()){
            Requerimiento3 reque3 = new Requerimiento3();
            reque3.setIdLider(rs.getInt("ID_Lider"));
            reque3.setNombre(rs.getString("Nombre"));
            reque3.setApellido(rs.getString("Primer_Apellido"));

            //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
            retornoConsulta.add(reque3);
        }

        rs.close();
        stm.close();

    }catch(SQLException e){
        System.err.println("Error consultando los proyectos de tipo Apartaestudio en Quibdo: "+e);
    }finally{
        if(conexion != null){
            conexion.close();
        }
    }

    //Retornar la colección de vo's
    return retornoConsulta;
    }      
}