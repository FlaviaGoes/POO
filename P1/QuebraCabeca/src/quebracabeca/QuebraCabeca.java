
package quebracabeca;

import java.util.Scanner;

public class QuebraCabeca {

    public static void main(String[] args) {
        int op;
        Borda completa = new Borda(1);
        Borda metadeEsq = new Borda(10);
        Borda metadeDir = new Borda(01);
        Borda vazia = new Borda(0);
        
        Scanner leitor = new Scanner(System.in);
        
        Peca peca1 = new Peca(completa, metadeEsq, completa, metadeEsq);
        Peca peca2 = new Peca(completa, metadeEsq, metadeEsq, metadeDir);
        Peca peca3 = new Peca(completa, metadeDir, metadeDir, completa);
        Peca peca4 = new Peca(metadeDir, metadeEsq, completa, metadeDir);
        Peca peca5 = new Peca(metadeDir, metadeDir, metadeDir, metadeDir);
        Peca peca6 = new Peca(metadeEsq, metadeDir, metadeDir, completa);
        Peca peca7 = new Peca(metadeDir, completa, completa, metadeDir);
        Peca peca8 = new Peca(metadeEsq, completa, metadeDir, metadeEsq);
        Peca peca9 = new Peca(metadeEsq, completa, metadeDir, completa);
        
        do{
            System.out.println("Insira as pecas no tabuleiro: 1-9 ");
            op = leitor.nextInt();
            switch(op){
                case 1:
                    validator(peca1);
                    break;
                case 2:
                    validator(peca2);
                    break;
                case 3:
                    validator(peca3);
                    break;
                case 4:
                    validator(peca4);
                    break;
                case 5:
                    validator(peca5);
                    break;
                case 6:
                    validator(peca6);
                    break;
                case 7:
                    validator(peca7);
                    break;
                case 8:
                    validator(peca8);
                    break;
                case 9:
                    validator(peca9);
                    break;
               
            }  
        }while(op<10);
    }  
    
    static void validator(Peca peca){
        Peca[] tabuleiro = new Peca[9]; 
        int i=0, j=0;
            for(i=0; i<tabuleiro.length; i++){
                j++;
                 if(tabuleiro[i] == null){
                     j = j-1;
                    if(tabuleiro[j] == null){
                        tabuleiro[i] = peca;
                        return;
                    }
                        
                    else{
                         if(peca.getBordaLeft().getTypeBorda() == 1){
                             System.out.println("Não é possível adicionar a esquerda");
                         if(peca.getBordaRight().getTypeBorda() == 1)
                             System.out.println("Não é possível adicionar a direita");
                         if(peca.getBordaUp().getTypeBorda() == 1)
                             System.out.println("Não é possível adicionar a0 topo");
                         if(peca.getBordaDown().getTypeBorda() == 1)
                             System.out.println("Não é possível adicionar em baixo");
                         if(tabuleiro[j].getBordaLeft().getTypeBorda() != peca.getBordaRight().getTypeBorda()){
                             System.out.println("Inserido a esquerda");
                             tabuleiro[i] = peca;
                             tabuleiro[j].bordaLeft.setTypeBorda(1);
                             tabuleiro[i].bordaLeft.setTypeBorda(1);
                             return;
                        }
                        if(tabuleiro[j].getBordaUp().getTypeBorda() != peca.getBordaDown().getTypeBorda()){
                             System.out.println("Inserido em cima");
                             tabuleiro[i] = peca;
                             tabuleiro[j].bordaUp.setTypeBorda(1);
                             tabuleiro[i].bordaDown.setTypeBorda(1);
                             return;
                        }
                    
                    }
            } 
        }
}
