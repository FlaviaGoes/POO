
package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class DAOPizza {
    private List<pizza> databasePizza = new ArrayList();
    
    public void create(pizza p){
        databasePizza.add(p);
    }
    
    public pizza read(int id){
        for(pizza p:databasePizza){
            if(p.getId()==id)
                return p;
        }
        return null;
    }
    
    public boolean update(pizza p){
        pizza paux=read(p.getId());
        if(paux!=null){
            paux.setValor(p.getValor());
            paux.setQuantidade(p.getQuantidade());
            paux.setDescricao(p.getDescricao());
            return true;
        }
        return false;
    }
    
    public boolean delete(pizza p){
        pizza paux=read(p.getId());
        if(paux!=null){
            databasePizza.remove(p);
            return true;
        }
        return false;
    }
    
    public String listAll(){
        String report="";
        for(pizza p: databasePizza){
            report += p.getId()+"\n" + p.getValor()+"\n" + p.getQuantidade()+"\n" + p.getDescricao();
        }
        return report;
    }
}
