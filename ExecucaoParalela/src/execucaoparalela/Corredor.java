
package execucaoparalela;

public class Corredor implements Runnable {

    @Override
    public void run() {
        while(true){
            System.out.println("Corredor");
        }
    }
    
}
