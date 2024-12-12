
package fatiadordefrutas;


public class Fatiador {
    Fatiar fatiar;
    
    public Fatiador(Fatiar fatiar){
        this.fatiar = fatiar;
    }
    
    public double efetuarCorte(double a){
        return fatiar.corta(a);
    }
    
}
