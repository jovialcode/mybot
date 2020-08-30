import model.vo.SearchVO;
import service.searching.UserInputService;

public class Application {
    public static void main(String[] args){
        UserInputService userInputService = new UserInputService();
        SearchVO userInput = userInputService.getUserInput();

        System.out.println(userInput.getInput());
    }
}
