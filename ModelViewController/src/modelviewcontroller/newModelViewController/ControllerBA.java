
package modelviewcontroller.newModelViewController;

public class ControllerBA {
    ViewBA view;
    ModelBA model;
    
    public void liga(ViewBA vb, ModelBA md){
        view = vb;
        model = md;
        view.setController(this);
        model.setController(this);
    }
    
    public void sendMessageToModel(String data){
        model.update(data);
    }
    
    public void sendMessageToView(String data){
        view.update(data);
    }
}
