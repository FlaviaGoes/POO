
package gestaohospitalar;

import java.util.Scanner;

public class GerenciaMedicos {
    private Medico medicos[];
    private Scanner leitor;
    
    public GerenciaMedicos(Medico meds[]){
        medicos = meds;
        leitor = new Scanner(System.in);
    }
    
    public void cadastrar(){
        String nome, id, cpf, end, tel, crm, esp, ctps;
        
        // Verifica se existem posições vazias no vetor.
        int i = 0;
        while((i < medicos.length) && (medicos[i] != null)){
            i++;
        }
        if(i < medicos.length){
            System.out.println("--==[Cadastro de Médicos]==--");
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
            System.out.println("C.R.M.: ");
            crm = leitor.nextLine();
            System.out.println("Especialidade: ");
            esp = leitor.nextLine();
            System.out.println("C.T.P.S.: ");
            ctps = leitor.nextLine();
            
            medicos[i] = new Medico(nome, id, cpf, end, tel, crm, esp, ctps);
        }
        else{
            System.out.println("Vetor cheio.");
        } 
    }
    
    public Medico[] getMedicos(){
        return medicos;
    }
    
    public Medico retornaMedico(String crm){
        int i;
        for(i=0; i < medicos.length; i++){
            if(medicos[i] != null)
                if(medicos[i].getCrm().equals(crm))
                    return medicos[i];
        }
        return null;
    }
    
    public void alterar(){
        String nome, id, cpf, end, tel, crm, esp, ctps;
        int pos, resp;
        
        System.out.println("--==[Alteração de Médicos]==--");
        System.out.println("Qual posição deseja alterar? ");
        pos = leitor.nextInt();
        leitor.skip("\n");
        if(medicos[pos] != null){
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + medicos[pos].getNome());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo nome: ");
                nome = leitor.nextLine();
                medicos[pos].setNome(nome);
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + medicos[pos].getIdentidade());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova identidade: ");
                id = leitor.nextLine();
                medicos[pos].setIdentidade(id);
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + medicos[pos].getCpf());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo C.P.F.: ");
                cpf = leitor.nextLine();
                medicos[pos].setCpf(cpf);
            }
            System.out.println("----------------------------------");
            System.out.println("Endereço atual: " + medicos[pos].getEndereco());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Endereço: ");
                end = leitor.nextLine();
                medicos[pos].setEndereco(end);
            }
            System.out.println("----------------------------------");
            System.out.println("Telefone atual: " + medicos[pos].getTelefone());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Telefone: ");
                tel = leitor.nextLine();
                medicos[pos].setTelefone(tel);
            }
            System.out.println("----------------------------------");
            System.out.println("C.R.M. atual: " + medicos[pos].getCrm());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo C.R.M.: ");
                crm = leitor.nextLine();
                medicos[pos].setCrm(crm);
            }
            System.out.println("----------------------------------");
            System.out.println("Especialidade atual: " + medicos[pos].getEspecialidade());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova Especialidade: ");
                esp = leitor.nextLine();
                medicos[pos].setEspecialidade(esp);
            }
            System.out.println("----------------------------------");
            System.out.println("C.T.P.S. atual: " + medicos[pos].getCtps());
            System.out.println("Alterar? (1-sim/2-não");
            resp = leitor.nextInt();
            leitor.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova C.T.P.S.: ");
                ctps = leitor.nextLine();
                medicos[pos].setCtps(ctps);
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
        
        System.out.println("--==[Exclusão de Médicos]==--");
        System.out.println("Qual posição deseja excluir? ");
        pos = leitor.nextInt();
        leitor.skip("\n");
        
        if(medicos[pos] != null){
            System.out.println("-=[Dados do Paciente]=-");
            medicos[pos].imprimir();
            System.out.println("\nConfirma exclusão? (1-sim/2-não)");
            resp = leitor.nextInt();
            leitor.skip("\n");
            
            if(resp == 1){
                medicos[pos] = null;
                System.out.println("Exclusão efetuada com sucesso.");
            }
            else{
                System.out.println("Exclusão não efetuada.");
            }
        }
        else{
            System.out.println("Médico não existe.");
        }
    }
    
    public void consultar(){
        int pos;
        
        System.out.println("--==[Consulta de Médicos]==--");
        System.out.println("Qual posição deseja consultar? ");
        pos = leitor.nextInt();
        leitor.skip("\n");
        
        if(medicos[pos] != null){
            System.out.println("-=[Dados do Médico]=-");
            medicos[pos].imprimir();
        }
        else{
            System.out.println("Médico não existe.");
        }
    }
    
    public void relatorio(){
        int pos = 0;
        
        System.out.println("--==[Relatório de Médicos]==--");
        
        while(pos < medicos.length){
            if(medicos[pos] != null){
                medicos[pos].imprimir();
                System.out.println("\n-----------------------------------\n");
            }
            
            pos++;
        }
    }
}    
