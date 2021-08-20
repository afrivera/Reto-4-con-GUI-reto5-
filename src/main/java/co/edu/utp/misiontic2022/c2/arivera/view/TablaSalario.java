package co.edu.utp.misiontic2022.c2.arivera.view;

import javax.swing.table.AbstractTableModel;
import co.edu.utp.misiontic2022.c2.arivera.model.vo.Requerimiento1;
import java.util.ArrayList;
import java.util.List;
public class TablaSalario extends AbstractTableModel{

    private List<Requerimiento1> liderSalario;

    public TablaSalario(){
        this(new ArrayList<>());
    }
    public TablaSalario(List<Requerimiento1> liderSalario){
        this.liderSalario = liderSalario;        
    }

    public void getRowCount(int row, Requerimiento1 requerimiento1) {
        liderSalario.set(row, requerimiento1);
    }

    @Override
    public int getRowCount() {
        return liderSalario.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        var lidersalario = liderSalario.get(row);
        switch (column){
            case 0:
                return lidersalario.getNombre();
                            
            case 1:
                return lidersalario.getPrimerApellido();
            
            case 2:
                return lidersalario.getIdLider();
            
            case 3 :
                return lidersalario.getSalario();
            
            default:                
            
        }
        return null;
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0 : {
                return "NOMBRE";
            }
            case 1 : {
                return "APELLIDO";
            }
            case 2 : {
                return "ID LIDER";
            }
            case 3 : {
                return "SALARIO";
            }
            default:{                
            }
        }
        return super.getColumnName(column);
    } 
    
}
