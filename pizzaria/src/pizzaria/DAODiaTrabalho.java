
package pizzaria;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

public class DAODiaTrabalho {
    private List<DiaTrabalho> databaseDia = new ArrayList();
    DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter().withResolverStyle(ResolverStyle.SMART);
    LocalDate InputData = null;
    
    public void create(DiaTrabalho d){
        databaseDia.add(d);
    }
    
    public DiaTrabalho read(LocalDate DateData){
            for(DiaTrabalho d:databaseDia){
                if(d.getData().equals(DateData)){
                    return d;
                }
            }  
        return null;
    }
    
   public boolean update(DiaTrabalho dia){
        DiaTrabalho daux = read(dia.getData());
        if(daux != null){
            daux.setAllPedidos(dia.getAllPedidos());
            daux.setData(dia.getData());
            daux.setUser(dia.getUser());
            return true;
        }
        return false;
    }
    
    public boolean delete(DiaTrabalho d){
        DiaTrabalho daux = read(d.getData());
        if(daux!=null){
            databaseDia.remove(daux);
            return true;
        }
        return false;
    }
    
    public String listDia(String data){
        String report="";
        InputData = LocalDate.parse(data, formatter);
        for(DiaTrabalho d: databaseDia){
            if(d.getData().equals(InputData))
            report += d.getUser() + "\n" + d.getData() + "\n" + d.getAllPedidos();
        }
        return report;
    }
    
    public String listAll(){
        String report="";
        for(DiaTrabalho d: databaseDia){
            report += d.getUser() + "\n" + d.getData() + "\n" + d.getAllPedidos();
        }
        return report;
    }
}
