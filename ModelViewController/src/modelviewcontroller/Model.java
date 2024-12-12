
package modelviewcontroller;

public class Model {
    View view;
    String dados = "";
    
    public void setView(View view){
        this.view = view;
    }
    
    public void atualizaDados(String dados){
        this.dados = dados;
        view.update();
    }
    
    public String getDados(){
        return dados;
    }
}
