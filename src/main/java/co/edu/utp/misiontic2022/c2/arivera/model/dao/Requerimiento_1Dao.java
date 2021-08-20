package co.edu.utp.misiontic2022.c2.arivera.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento1;
import co.edu.utp.misiontic2022.c2.arivera.util.JDBCUtilities;

/* Archivos dao */
public class Requerimiento_1Dao {
    public ArrayList<Requerimiento1> requerimiento1() throws SQLException {
        ArrayList<Requerimiento1> retorno = new ArrayList<>();
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String select = "Select Id_Lider, Nombre, Primer_Apellido, salario from Lider where salario<=500000 order by salario ";
            PreparedStatement stm = conexion.prepareStatement(select);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Requerimiento1 requerimiento1 = new Requerimiento1();
                requerimiento1.setNombre(rs.getString("Nombre"));
                requerimiento1.setPrimerApellido(rs.getString("Primer_Apellido"));
                requerimiento1.setIdLider(rs.getInt("Id_Lider"));
                requerimiento1.setSalario(rs.getInt("salario"));
                retorno.add(requerimiento1);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            if(conexion!=null){
                conexion.close();
            }
        }

        return retorno;
    }
}
