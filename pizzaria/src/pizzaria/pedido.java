
package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class pedido {
    private int id;
    private String cliente;
    private float total;
    private List<pizza> allPizzas = new ArrayList();

    public int getId() {
        return id;
    }

    public List<pizza> getAllPizzas() {
        return allPizzas;
    }

    public String getCliente() {
        return cliente;
    }

    public float getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAllPizzas(List<pizza> allPizzas) {
        this.allPizzas = allPizzas;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public void imprimir(){
        System.out.println("ID: " + id);
        System.out.println("Total:: " + total);
        System.out.println("Cliente: "+ cliente);
        for(pizza p: allPizzas){
            System.out.println(p+"\t");
        }
    }
}
