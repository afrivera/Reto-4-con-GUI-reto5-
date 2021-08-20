package co.edu.utp.misiontic2022.c2.arivera.view;

import javax.swing.table.AbstractTableModel;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento2;
import java.util.ArrayList;
import java.util.List;
public class TablaTipoProyecto extends AbstractTableModel{
    private List<Requerimiento2> tipoProyecto;

    public TablaTipoProyecto(){
        this(new ArrayList<>());
    }
    public TablaTipoProyecto(List<Requerimiento2> tipoProyecto){
        this.tipoProyecto = tipoProyecto;
    }

    public void getRowCount(int row, Requerimiento2 requerimiento2) {
        tipoProyecto.set(row, requerimiento2);
    }

    @Override
    public int getRowCount() {
        return tipoProyecto.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        var proyectoTipo = tipoProyecto.get(row);
        switch (column){
            case 0: {
                return proyectoTipo.getIdProyecto();
            }
            case 1: {
                return proyectoTipo.getConstructora();
            }
            case 2:{
                return proyectoTipo.getCiudad();
            }
            case 3 :{
                return proyectoTipo.getEstrato();
            }
            default:{                
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
                    case 0 : {
                        return "ID PROYECTO";
                    }
                    case 1 : {
                        return "CONSTRUCTORA";
                    }
                    case 2 : {
                        return "CIUDAD";
                    }            
                    case 3 : {
                        return "ESTRATO";
                    }            
                    default:{                
                    }
                }
        return super.getColumnName(column);
    }
    
}
