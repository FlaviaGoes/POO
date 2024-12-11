
package gestaohospitalar;

import java.util.Scanner;

public class GerenciaPacientes {
    private Paciente pacientes[];
    private Scanner leitor;
    
    public GerenciaPacientes(Paciente pacs[]){
        pacientes = pacs;
        leitor = new Scanner(System.in);
    }
    
    public void cadastrar(){
        String nome, id, cpf, end, tel, nomeConv, numConv;
        
        // Verifica se existem posições vazias no vetor.
        int i = 0;
        while((i < pacientes.length) && (pacientes[i] != null)){
            i++;
        }
        if(i < pacientes.length){
            System.out.println("--==[Cadastro de Pacientes]==--");
            System.out.println("Nome: ");
            nome = leitor.nextLine();
            System.out.println("Identidade: ");
            id = leitor.nextLine();
            System.out.println("C.P.F.: ");
            cpf = leitor.nextLine();
            System.out.println("Endereço: ");
            end = leitor.nextLine();
            System.out.println("Telefone: ");
            tel = leitor.nextLine();
            System.out.println("Nome Convênio: ");
            nomeConv = leitor.nextLine();
            System.out.println("Número Convênio: ");
            numConv = leitor.nextLine();
            
            pacientes[i] = new Paciente(nome, id, cpf, end, tel, nomeConv, numConv);
        }
        else{
            System.out.println("Vetor cheio.");
        }
    }
    
    public Paciente[] getPacientes(){
        return pacientes;
    }
    
    public Paciente retornaPaciente(String id){
        int i;
        for(i=0; i < pacientes.length; i++){
            if(pacientes[i] != null)
                if(pacientes[i].getIdentidade().equals(id))
                    return pacientes[i];
        }
        return null;
    }
    
    public void alterar(){
        String nome, id, cpf, end, tel, nomeConv, numConv;
        int pos, resp;
        
        System.out.println("--==[Alteração de Pacientes]==--");
        System.out.println("Qual posição deseja alterar? ");
        pos = leitor.nextInt();
        leitor.skip("\n");
        if(pacientes[pos] != null){
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + pacientes[pos].getNome());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo nome: ");
                nome = leitor.nextLine();
                pacientes[pos].setNome(nome);
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + pacientes[pos].getIdentidade());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova identidade: ");
                id = leitor.nextLine();
                pacientes[pos].setIdentidade(id);
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + pacientes[pos].getCpf());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo C.P.F.: ");
                cpf = leitor.nextLine();
                pacientes[pos].setCpf(cpf);
            }
            System.out.println("----------------------------------");
            System.out.println("Endereço atual: " + pacientes[pos].getEndereco());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Endereço: ");
                end = leitor.nextLine();
                pacientes[pos].setEndereco(end);
            }
            System.out.println("----------------------------------");
            System.out.println("Telefone atual: " + pacientes[pos].getTelefone());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Telefone: ");
                tel = leitor.nextLine();
                pacientes[pos].setTelefone(tel);
            }
            System.out.println("----------------------------------");
            System.out.println("Nome do Convêncio atual: " + pacientes[pos].getNomeConvenio());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Nome do Convênio: ");
                 nomeConv = leitor.nextLine();
                pacientes[pos].setNomeConvenio(nomeConv);
            }
            System.out.println("----------------------------------");
            System.out.println("Número do Convêncio atual: " + pacientes[pos].getNumeroConvenio());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Número do Convênio: ");
                 numConv = leitor.nextLine();
                pacientes[pos].setNumeroConvenio(numConv);
            }
            System.out.println("----------------------------------");

            System.out.println("Atualização realizada com sucesso.");
        }
        else{
            System.out.println("Vetor cheio.");
        }
    }
    
    public void excluir(){
        int pos, resp;
        
        System.out.println("--==[Exclusão de Pacientes]==--");
        System.out.println("Qual posição deseja excluir? ");
        pos = leitor.nextInt();
        leitor.skip("\n");
        
        if(pacientes[pos] != null){
            System.out.println("-=[Dados do Paciente]=-");
            pacientes[pos].imprimir();
            System.out.println("\nConfirma exclusão? (1-sim/2-não)");
            resp = leitor.nextInt();
            leitor.skip("\n");
            
            if(resp == 1){
                pacientes[pos] = null;
                System.out.println("Exclusão efetuada com sucesso.");
            }
            else{
                System.out.println("Exclusão não efetuada.");
            }
        }
        else{
            System.out.println("Paciente não existe.");
        }
    }
    
    public void consultar(){
        int pos;
        
        System.out.println("--==[Consulta de Pacientes]==--");
        System.out.println("Qual posição deseja consultar? ");
        pos = leitor.nextInt();
        leitor.skip("\n");
        
        if(pacientes[pos] != null){
            System.out.println("-=[Dados do Paciente]=-");
            pacientes[pos].imprimir();
        }
        else{
            System.out.println("Paciente não existe.");
        }
    }
    
    public void relatorio(){
        int pos = 0;
        
        System.out.println("--==[Relatório de Pacientes]==--");
        
        while(pos < pacientes.length){
            if(pacientes[pos] != null){
                pacientes[pos].imprimir();
                System.out.println("\n-----------------------------------\n");
            }
            
            pos++;
        }
    }
}
