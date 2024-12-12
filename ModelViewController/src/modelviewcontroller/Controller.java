
package modelviewcontroller;

public class Controller {
    public void Rotear(View view, Model model){
        view.setModel(model);
        model.setView(view);
    }
}
