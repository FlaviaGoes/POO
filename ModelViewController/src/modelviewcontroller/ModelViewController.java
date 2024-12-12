
package modelviewcontroller;

public class ModelViewController {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();
        
        controller.Rotear(view, model);
        model.atualizaDados("Olares mundos!");
    }
    
}
