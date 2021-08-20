package co.edu.utp.misiontic2022.c2.arivera.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento2;
import co.edu.utp.misiontic2022.c2.arivera.util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento2> requerimiento2() throws SQLException {
        //su codigo
        ArrayList<Requerimiento2> retornoConsulta = new ArrayList<>();
        Connection conexion = JDBCUtilities.getConnection();
        try {
            String select ="select ID_Proyecto, Constructora, Ciudad, Estrato from Proyecto natural join Tipo where Ciudad = 'Cartagena' order by Estrato ASC ";
            PreparedStatement stm = conexion.prepareStatement(select);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Requerimiento2 reque2 = new Requerimiento2();
                reque2.setIdProyecto(rs.getInt("ID_Proyecto"));
                reque2.setConstructora(rs.getString("Constructora"));
                reque2.setCiudad(rs.getString("Ciudad"));
                reque2.setEstrato(rs.getInt("Estrato"));
                retornoConsulta.add(reque2);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e.getMessage());
        }finally{
            if(conexion!=null){                
                conexion.close();
            }
        }
        return retornoConsulta;
    }
}
