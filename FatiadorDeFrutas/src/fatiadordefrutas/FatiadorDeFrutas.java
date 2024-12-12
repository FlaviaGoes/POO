
package fatiadordefrutas;

public class FatiadorDeFrutas {


    public static void main(String[] args) {
        Maca maca=new Maca();
        Acerola acerola = new Acerola();
        
        Fatiador fatiador = new Fatiador(maca);
        
        System.out.println(fatiador.efetuarCorte(4));
    }
  
}
