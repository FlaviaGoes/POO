
package pizzaria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

public class DAOPedido {
    private List<pedido> databasePedidos = new ArrayList();
    private List<pedido> databasePedidosAux = new ArrayList();
    private float totalPedido;
    private LocalDate data;
    DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter().withResolverStyle(ResolverStyle.SMART);
    
    public List<pedido> getDatabasePedidos(String dataPedidos) {
        data = LocalDate.parse(dataPedidos, formatter);
        for (pedido d : databasePedidos){
            if(d.getDataPedido().equals(data)){
                databasePedidosAux.add(d);
            }
        }
        return databasePedidosAux;
    }
    
    public pedido accessPedido(int id){
        for(pedido p: databasePedidos){
            if(p.getId() == id){
                return p;
            }
        }
        
        return null;
    }
    
    public void create(pedido p){
        databasePedidos.add(p);
    }
    
    public pedido read(int id){
        for(pedido p:databasePedidos){
            if(p.getId()==id)
                return p;
        }
        return null;
    }
    
    public boolean update(pedido p){
        pedido Pedido = read(p.getId());
        if(Pedido!=null){
            Pedido.setCliente(p.getCliente());
            Pedido.setAllPizzas(p.getAllPizzas());
            Pedido.setTotal(p.getTotal());
            return true;
        }
        return false;
    }
    
    public boolean delete(int id){
        
        for(pedido p : databasePedidos){
            if(p.getId() == id){
                databasePedidos.remove(p);
                return true;
            }
        }
        return false;
    }
    
    public String listAll(){
        String report="";
        for(pedido p: databasePedidos){
            report += p.getId() + "\n" + p.getCliente() +"\n" + p.getAllPizzas();
        }
        return report;
    }
    
    public String ListClient(String cliente){
        String report="";
        for(pedido p: databasePedidos){
            if(p.getCliente().contentEquals(cliente.toLowerCase())){
               report += p.getId() + "\n" + p.getCliente() + "\n" + p.getNumeroPedido() + "\n" + p.getAllPizzas() + "\n" + p.getTotal();
            }
        }
        return report;
    }
    
    public float calculaTotal(List<pizza> allPizzas){
        totalPedido = 0;
        for(pizza p:allPizzas){
            totalPedido += p.getPreco() * p.getQuantidade(); 
        }
        return totalPedido;
    }
}
