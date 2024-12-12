
package dependencias;

public class Dependencias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Soma soma=new Soma();
        Subtracao subtracao = new Subtracao();
        
        Calculadora calc = new Calculadora(subtracao);
        
        System.out.println(calc.efetuarCalculo(1, 2));
    }
    
}
