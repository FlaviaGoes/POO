
package pizzaria;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Pizzaria {

    public static void main(String[] args) throws ParseException {
        Scanner leitor = new Scanner(System.in);
        Scanner reader = new Scanner(System.in);
        
        int op, op1, op2, op3, op4, id, idPizza, quantidade, numeroPedido;
        String data, user, descricao, cliente, dataPedido;
        float preco;
        
        List<pizza> databasePizza = new ArrayList();
        pizza pizzaAux;
        pedido pedidoAux;
        
        DAODiaTrabalho dayOfWork = new DAODiaTrabalho(); 
        DAOPedido Pedidos = new DAOPedido();
        DAOPizza Pizzas = new DAOPizza();
        calabresa Calabresa = new calabresa(01, 45.5f, "Calabresa", 0);
        Pizzas.create(Calabresa);
        pepperoni Pepperoni = new pepperoni(02, 40.5f, "Pepperoni", 0);
        Pizzas.create(Pepperoni);
        margherita Margherita = new margherita(03, 45.5f, "Margherita", 0);
        Pizzas.create(Margherita);
        
        
        
        do {
            System.out.println("--==PIZZARIA==--");
            System.out.println("[1] DIA DE TRABALHO");
            System.out.println("[2] PEDIDOS");
            System.out.println("[3] PIZZAS");
            System.out.println("Opcao: ");
            op = leitor.nextInt();
            
            switch(op){
                case 1:
                    do{
                        System.out.println("--==DIA DE TRABALHO==--");
                        System.out.println("[1] Cadastrar dia");
                        System.out.println("[2] Atualizar dia");
                        System.out.println("[3] Remover dia");
                        System.out.println("[4] Relatório do Dia");
                        System.out.println("[5] Listar dias");
                        System.out.println("Opcao: ");
                        op1 = leitor.nextInt();
                        
                        switch(op1){
                            case 1:
                                System.out.println("Insira a data (dd/MM/yyyy): ");
                                data = reader.nextLine();
                                System.out.println("Insira seu nome: ");
                                user = reader.nextLine();
                                DiaTrabalho WorkingDay = new DiaTrabalho(data, user);
                                dayOfWork.create(WorkingDay);
                                break;
                            case 2:
                                System.out.println("Insira a data (dd/MM/yyyy): ");
                                data = reader.nextLine();
                                System.out.println("Insira seu nome: ");
                                user = reader.nextLine();
                                WorkingDay = new DiaTrabalho(data, user);
                                WorkingDay.setAllPedidos(Pedidos.getDatabasePedidos(data));
                                dayOfWork.update(WorkingDay);
                                break;
                            case 3:
                                System.out.println("Insira a data (dd/MM/yyyy): ");
                                data = reader.nextLine();
                                System.out.println("Insira seu nome: ");
                                user = reader.nextLine();
                                WorkingDay = new DiaTrabalho(data, user);
                                if(dayOfWork.delete(WorkingDay))
                                    System.out.println("Dia excluido!");
                                break;
                            case 4:
                                System.out.println("Insira a data (dd/MM/yyyy): ");
                                data = reader.nextLine();
                                System.out.println(dayOfWork.listDia(data));
                                break;
                            case 5:
                                System.out.println(dayOfWork.listAll());
                                break; 
                        }
                    } while (op1 > 0 && op1 < 6);
                    break;
                case 2:
                    do{
                        System.out.println("--==PEDIDOS==--");
                        System.out.println("[1] Adicionar Pedido");
                        System.out.println("[2] Atualizar Pedido");
                        System.out.println("[3] Remover Pedido");
                        System.out.println("[4] Pedido por Cliente");
                        System.out.println("[5] Listar Pedidos");
                        System.out.println("Opcao: ");
                        op2 = leitor.nextInt();
                        
                        switch(op2){
                            case 1:
                                System.out.println("Id:");
                                id = leitor.nextInt();
                                System.out.println("Numero do Pedido:");
                                numeroPedido = leitor.nextInt();
                                System.out.println("Cliente:");
                                cliente = reader.nextLine();
                                System.out.println("Data do Pedido");
                                dataPedido = reader.nextLine();
                                do{
                                    System.out.println("1 - Calabresa");
                                    System.out.println("2 - Pepperoni");
                                    System.out.println("3 - Margherita");
                                    System.out.println("Informe o numero da pizza: ");
                                    idPizza = leitor.nextInt();
                                    System.out.println("Informe a quantidade: ");
                                    quantidade = leitor.nextInt();
                                    pizzaAux = Pizzas.accessPizzas(idPizza, quantidade);
                                    databasePizza.add(pizzaAux);
                                    op4 = leitor.nextInt();
                                } while(op4 > 0 && op4 < 4);
                                
                                pedido pedidoAux2 = new pedido(id, numeroPedido, cliente, dataPedido, Pedidos.calculaTotal(databasePizza), databasePizza);
                                Pedidos.create(pedidoAux2);
                                databasePizza.clear();
                                break;
                            case 2:
                                System.out.println("Informe o ID do pedido: ");
                                id = leitor.nextInt();
                                System.out.println("Informe o cliente: ");
                                cliente = reader.nextLine();
                                do{
                                    System.out.println("1 - Calabresa");
                                    System.out.println("2 - Pepperoni");
                                    System.out.println("3 - Margherita");
                                    System.out.println("Informe o numero da pizza: ");
                                    idPizza = leitor.nextInt();
                                    System.out.println("Informe a quantidade: ");
                                    quantidade = leitor.nextInt();
                                    pizzaAux = Pizzas.accessPizzas(idPizza, quantidade);
                                    databasePizza.add(pizzaAux);
                                    op4 = leitor.nextInt();
                                } while(op4 > 0 && op4 < 4);
                                pedidoAux = Pedidos.accessPedido(id);
                                pedidoAux.setCliente(cliente);
                                pedidoAux.setAllPizzas(databasePizza);
                                pedidoAux.setTotal(Pedidos.calculaTotal(databasePizza));
                                databasePizza.clear();
                                if(Pedidos.update(pedidoAux))
                                    System.out.println("Atualizado");
                                
                            case 3:
                                System.out.println("Informe o ID do pedido: ");
                                id = leitor.nextInt();
                                if(Pedidos.delete(id)){
                                    System.out.println("Removido com sucesso!");
                                }
                                break;
                            case 4:
                                System.out.println("Informe o nome do cliente: ");
                                cliente = leitor.nextLine().toLowerCase();
                                System.out.println(Pedidos.ListClient(cliente));
                                break;
                            case 5:
                                System.out.println(Pedidos.listAll());
                                break; 
                        }
                    } while (op2 > 0 && op2 < 6);
                case 3:
                    do{
                        System.out.println("--==PIZZAS==--");
                        System.out.println("[1] Adicionar Pizzas");
                        System.out.println("[2] Atualizar Pizzas");
                        System.out.println("[3] Remover Pizzas");
                        System.out.println("[4] Listar Pizzas");
                        System.out.println("Opcao: ");
                        op3 = leitor.nextInt();
                        
                        switch(op3){
                            case 1:
                                System.out.println("Informe o id da Pizza: ");
                                id = leitor.nextInt();
                                System.out.println("Informe a quantidade que deseja adicionar: ");
                                quantidade = leitor.nextInt();
                                Pizzas.addPizza(id, quantidade);
                                break;
                            case 2:
                                System.out.println("Informe o id da Pizza: ");
                                id = leitor.nextInt();
                                System.out.println("Informe o preco da Pizza: ");
                                preco = leitor.nextFloat();
                                System.out.println("Informe a descricao da pizza: ");
                                descricao = reader.nextLine();
                                System.out.println("Informe a quantidade de pizzas: ");
                                quantidade = leitor.nextInt();
                                break;
                            case 3:
                                System.out.println("Informe o id da Pizza: ");
                                id = leitor.nextInt();
                                System.out.println("Informe a quantidade que deseja remover: ");
                                quantidade = leitor.nextInt();
                                if(Pizzas.delete(id, quantidade)){
                                    System.out.println("Removido com sucesso!");
                                }
                                break;
                            case 4:
                                System.out.println(Pizzas.listAll());
                                break;
                        }
                    } while (op3 > 0 && op3 < 5);
            }
        } while (op > 0 && op < 4);
    }
    
}
