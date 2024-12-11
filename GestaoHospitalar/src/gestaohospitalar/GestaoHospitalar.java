
package gestaohospitalar;

import java.util.Scanner;
public class GestaoHospitalar {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        Paciente pacientes[] = new Paciente[100];
        Medico medicos[] = new Medico[100];
        Atendimento atendimentos[] = new Atendimento[100];
        
        GerenciaMedicos gm = new GerenciaMedicos(medicos);
        GerenciaPacientes gp = new GerenciaPacientes(pacientes);
        GerenciaAtendimento ga = new GerenciaAtendimento(atendimentos);
        
        int op, op1;
        
        do{
            System.out.println("--==[Gestao Hospitalar]==--");
            System.out.println("1 - Medicos");
            System.out.println("2 - Pacientes");
            System.out.println("3 - Atendimentos");
            System.out.println("4 - Encerrar");
            System.out.println("Opcao: ");
            op = leitor.nextInt();
            leitor.skip("\n");
            
            switch(op){
                case 1:
                    do{
                        System.out.println("--==[Medicos]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatorio");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.println("Opcao: ");
                        op1 = leitor.nextInt();
                        leitor.skip("\n");

                        switch(op1){
                            case 1:
                                gm.cadastrar();
                                break;
                            case 2:
                                gm.alterar();
                                break;
                            case 3:
                                gm.excluir();
                                break;
                            case 4:
                                gm.consultar();
                                break;
                            case 5:
                                gm.relatorio();
                                break;
                            case 6:
                                System.out.println("Encerrando...");
                                break;
                            default:
                                System.out.println("Opcao Invalida!");
                                break;
                        }
                    }while(op1 != 6);
                    break;
                case 2:
                    do{
                        System.out.println("--==[Pacientes]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatorio");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.println("Opcao: ");
                        op1 = leitor.nextInt();
                        leitor.skip("\n");

                        switch(op1){
                            case 1:
                                gp.cadastrar();
                                break;
                            case 2:
                                gp.alterar();
                                break;
                            case 3:
                                gp.excluir();
                                break;
                            case 4:
                                gp.consultar();
                                break;
                            case 5:
                                gp.relatorio();
                                break;
                            case 6:
                                System.out.println("Encerrando...");
                                break;
                            default:
                                System.out.println("Opcao Invalida!");
                                break;
                        }
                    }while(op1 != 6);
                case 3:
                    do{
                        System.out.println("--==[Atendimentos]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatorio");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.println("Opcao: ");
                        op1 = leitor.nextInt();
                        leitor.skip("\n");

                        switch(op1){
                            case 1:
                                ga.cadastrar(gm, gp);
                                break;
                            case 2:
                                ga.alterar();
                                break;
                            case 3:
                                ga.excluir();
                                break;
                            case 4:
                                ga.consultar();
                                break;
                            case 5:
                                ga.relatorio();
                                break;
                            case 6:
                                System.out.println("Encerrando...");
                                break;
                            default:
                                System.out.println("Opcao Invalida!");
                                break;
                        }
                    }while(op1 != 6);
                    break;
                case 4:
                    System.out.println("Encerrando :)");
                    break;
                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
        }while(op != 4);
    } 
}
