
package gestaohospitalar;

import java.util.Scanner;

public class GerenciaAtendimento {
    private Atendimento atendimentos[];
    private Scanner leitor;
    private Scanner reader;
    
    public GerenciaAtendimento(Atendimento atends[]){
        atendimentos = atends;
        leitor = new Scanner(System.in);
        reader = new Scanner(System.in);
    }
    
    public void cadastrar(GerenciaMedicos daoMedicos, GerenciaPacientes daoPacientes){
        String crm, id;
        
        // Verifica se existem posições vazias no vetor.
        int i = 0;
        while((i < atendimentos.length) && (atendimentos[i] != null)){
            i++;
        }
        if(i < atendimentos.length){
            System.out.println("--==[Registro de Atendimento]==--");
            System.out.println("Informe o CRM do médico: ");
            crm = reader.nextLine();
            System.out.println("Informe o id do paciente: ");
            id = reader.nextLine();
           
            Paciente paciente = daoPacientes.retornaPaciente(id);
            Medico medico = daoMedicos.retornaMedico(crm);
            if (paciente == null || medico == null) {
                System.out.println("Erro: Paciente ou Medico nao encontrado.");
                return;
            }
            atendimentos[i] = new Atendimento(paciente, medico);
        }
        else{
            System.out.println("Vetor cheio.");
        } 
    }
    
    public void alterar(){
        String crm;
        int id, resp, op;
        
        System.out.println("--==[Alteração de Atendimentos]==--");
        System.out.println("Insira o protocolo do atendimento: ");
        id = leitor.nextInt();
        System.out.println("Insira seu CRM: ");
        crm = reader.nextLine();
        leitor.skip("\n");
        
        for(int i=0; i<atendimentos.length; i++){
            if(atendimentos[i] != null)
                if(atendimentos[i].getProtocolo() == id && atendimentos[i].getMedico().getCrm().equals(crm)){
                    System.out.println("-=[Dados Atendimento]=-");
                    System.out.println("Status atual: " + atendimentos[i].getStatus());
                    System.out.println("Alterar? (1-sim/2-não");
                    resp = leitor.nextInt();
                    leitor.skip("\n");
                    if(resp == 1){
                        System.out.println("[1] TRATAMENTO CLINICO GERAL [2] PREPARAÇÃO PRÉ CIRURGIA\n");
                        System.out.println("[3] CIRURGIA [4] PÓS CIRURGIA [5] ALTA CLÍNICA\n");
                        System.out.println("Selecione o status da consulta:");
                        op = leitor.nextInt();
                        switch(op){
                            case 1:
                                atendimentos[i].setStatus("TRATAMENTO CLINICO GERAL");
                                System.out.println("Status atualizado!");
                                break;
                            case 2:
                                atendimentos[i].setStatus("PREPARAÇÃO PRÉ CIRURGIA");
                                System.out.println("Status atualizado!");
                                break;
                            case 3:
                                atendimentos[i].setStatus("CIRURGIA");
                                System.out.println("Status atualizado!");
                                break;
                            case 4:
                                atendimentos[i].setStatus("PÓS CIRURGIA");
                                System.out.println("Status atualizado!");
                                break;
                            case 5:
                                atendimentos[i].setStatus("ALTA CLÍNICA");
                                System.out.println("Status atualizado!");
                                break;
                            default:
                                System.out.println("Opcao Inválida");
                                break;
                        }
                        return;
                    }
                } else
                    System.out.println("Protocolo invalido ou CRM invalido");
                    
        }
    }

    public void excluir(){
        int pos, resp, id;
        
        System.out.println("--==[Exclusão de Atendimentos]==--");
        System.out.println("Informe o id do atendimento: ");
        id = leitor.nextInt();
        leitor.skip("\n");
        
        for(int i=0; i<atendimentos.length; i++){
            if(atendimentos[i] != null)
                if(atendimentos[i].getProtocolo() == id){
                    System.out.println("-=[Dados do Atendimento]=-");
                    atendimentos[i].imprimir();
                    System.out.println("\nConfirma exclusão? (1-sim/2-não)");
                    resp = leitor.nextInt();
                    leitor.skip("\n");

                    if(resp == 1){
                        atendimentos[i] = null;
                        System.out.println("Exclusão efetuada com sucesso.");
                        return;
                    }
                    else{
                        System.out.println("Exclusão não efetuada.");
                    }
                }
        }
    }
    
    public void consultar(){
        int pos;
        
        System.out.println("--==[Consultar Atendimento]==--");
        System.out.println("Qual posição deseja consultar? ");
        pos = leitor.nextInt();
        leitor.skip("\n");
        
        if(atendimentos[pos] != null){
            System.out.println("-=[Dados Atendimentos]=-");
            atendimentos[pos].imprimir();
        }
        else{
            System.out.println("Atendimento não encontrado.");
        }
    }
    
    public void relatorio(){
        int pos = 0;
        
        System.out.println("--==[Relatorio de Atendimentos]==--");
        
        while(pos < atendimentos.length){
            if(atendimentos[pos] != null){
                atendimentos[pos].imprimir();
                System.out.println("\n-----------------------------------\n");
            }
            pos++;
        }
    }
}
