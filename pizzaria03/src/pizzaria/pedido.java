
package pizzaria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

public class pedido {
    private int id;
    private int numeroPedido;
    private String cliente;
    private LocalDate dataPedido;
    private float total;
    private List<pizza> allPizzas = new ArrayList();
    DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter().withResolverStyle(ResolverStyle.SMART);

    public pedido(int id, int numeroPedido, String cliente, String dataPedido, float total, List<pizza> allPizzas) {
        this.id = id;
        this.numeroPedido = numeroPedido;
        this.cliente = cliente.toLowerCase();
        this.dataPedido = LocalDate.parse(dataPedido, formatter);
        this.total = total;
        this.allPizzas = allPizzas;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = LocalDate.parse(dataPedido, formatter);
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getTotal() {
        return total;
    }
    
    public void setTotal(float totalPedidos) {
        this.total = totalPedidos;
    }

    public List<pizza> getAllPizzas() {
        return allPizzas;
    }
    
    public void setAllPizzas(List<pizza> allPizzas) {
        this.allPizzas = allPizzas;
    }
    
    public void imprimir(){
        System.out.println("ID: " + id);
        System.out.println("Total:: " + total);
        System.out.println("Cliente: "+ cliente);
        for(pizza p: allPizzas){
            System.out.println(p +"\t");
        }
    }
}
