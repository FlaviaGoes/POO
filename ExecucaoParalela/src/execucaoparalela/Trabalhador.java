
package execucaoparalela;

public class Trabalhador extends Thread {
    String nome = "";
    int i=0;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    @Override
    public void run(){
        while(true){
            i++;
            System.out.println(nome+" "+i);
        }
    }
}
