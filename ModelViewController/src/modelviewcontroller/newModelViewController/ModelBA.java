
package modelviewcontroller.newModelViewController;

public class ModelBA {
    String dados = "";
    ControllerBA controller;
    
    public void setController(ControllerBA cont){
        this.controller = cont;
        
    }
    
    public void update(String dados){
        this.dados=dados;
        controller.sendMessageToView(dados);
    }
}
