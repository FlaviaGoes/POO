/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzaria;

import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.LocalDate;
import java.time.format.ResolverStyle;

/**
 *
 * @author flavi
 */
public class DiaTrabalho {
    private LocalDate data;
    private String user;
    private List<pedido> allPedidos = new ArrayList();
    DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter().withResolverStyle(ResolverStyle.SMART);

    public DiaTrabalho(String data, String user){
        this.data = LocalDate.parse(data, formatter);
        this.user = user;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<pedido> getAllPedidos() {
        return allPedidos;
    }

    public void setAllPedidos(List<pedido> allPedidos) {
        this.allPedidos = allPedidos;
    }
}
