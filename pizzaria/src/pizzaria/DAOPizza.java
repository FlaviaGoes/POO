
package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class DAOPizza {
    private List<pizza> databasePizza = new ArrayList();
    
    public void addPizza(int id, int quantidade){
        for(pizza p:databasePizza){
            if(p.getId() == id){
                quantidade += p.getQuantidade();
                p.setQuantidade(quantidade);
            }
        }
    }
    
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
            paux.setPreco(p.getPreco());
            paux.setQuantidade(p.getQuantidade());
            paux.setDescricao(p.getDescricao());
            return true;
        }
        return false;
    }
    
    public boolean delete(int id, int quantidade){
        int resto;
        for(pizza p:databasePizza){
            resto = 0;
            if(p.getId() == id){
                resto = p.getQuantidade() - quantidade;
                if(resto >= 0){
                    p.setQuantidade(resto);
                    return true;
                }
            }
        }
        return false;
    }
    
    public pizza accessPizzas(int id, int quantidade){
        for(pizza p: databasePizza){
            if(p.getId() == id){
                if(delete(id, quantidade)){
                    return p;
                }
            }
        }
        
        return null;
    }
    
    public String listAll(){
        String report="";
        for(pizza p: databasePizza){
            report += p.getId()+"\n" + p.getPreco()+"\n" + p.getQuantidade()+"\n" + p.getDescricao();
        }
        return report;
    }
}
