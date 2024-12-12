
package dependencias;


public class Calculadora {
    Calculo calculo;
    // injecao de dependencia
    public Calculadora(Calculo calculo){
        this.calculo = calculo;
    }
    
    public double efetuarCalculo(double a, double b){
        return calculo.efetuar(a, b);
    }
}
