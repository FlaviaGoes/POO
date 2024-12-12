
package execucaoparalela;

public class ExecucaoParalela {

    public static void main(String[] args) {
        Trabalhador A = new Trabalhador();
        Trabalhador B = new Trabalhador();
        
        A.setNome("AAA");
        B.setNome("BBB");
        
        A.start();
        B.start();
        
        A.setPriority(9);
        B.setPriority(9);
        
//        while(true){
//            System.out.println("Principal");
//        }

        Corredor corredor = new Corredor();
        Thread t = new Thread(corredor);
        t.start();
        
        Runnable corresim = new Runnable(){
            public void run(){
                while(true){
                    System.out.println("Anonima");
                }
            }
        };
        
        Thread tt= new Thread(corresim);
        tt.start();
        
        Runnable correlambda=()->{
            while(true){
                System.out.println("Lambda");
            }
        };
        Thread ttt= new Thread(correlambda);
        ttt.start();
    }
    
}
