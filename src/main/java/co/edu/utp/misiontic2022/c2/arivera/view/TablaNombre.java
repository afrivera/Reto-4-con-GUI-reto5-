package co.edu.utp.misiontic2022.c2.arivera.view;

import javax.swing.table.AbstractTableModel;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento3;
import java.util.ArrayList;
import java.util.List;
public class TablaNombre extends AbstractTableModel{

    private List<Requerimiento3> liderNombre;

    public TablaNombre(){
        this(new ArrayList<>());
    }

    public TablaNombre(List<Requerimiento3> liderNombre){
        this.liderNombre = liderNombre;
    }
    
    public void getRowCount(int row, Requerimiento3 requerimiento3) {
        liderNombre.set(row, requerimiento3);
    }

    @Override
    public int getRowCount() {
        return liderNombre.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        var nombreLider = liderNombre.get(row);
        switch (column){
            case 0: {
                return nombreLider.getIdLider();
            }
            case 1: {
                return nombreLider.getNombre();
            }
            case 2:{
                return nombreLider.getApellido();
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
                        return "ID LIDER";
                    }
                    case 1 : {
                        return "NOMBRE";
                    }
                    case 2 : {
                        return "APELLIDO";
                    }                            
                }
        return super.getColumnName(column);
    }
    
}
