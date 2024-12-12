
package modelviewcontroller;

public class View {
    Model model;
    String dados = "";
    
    public void setModel(Model model){
        this.model = model;
    }
    
    public void mostrarDados(){
        System.out.println(dados);
    }
    
    public void update(){
        dados = model.getDados();
        mostrarDados();
    }
    
    public void atualizaDados(String dados){
        model.atualizaDados(dados);
    }
}
