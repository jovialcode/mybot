package service.search;

import model.vo.SearchVO;
import org.junit.Assert;
import org.junit.Test;
import service.searching.UserInputService;

public class UserInputServiceTest{

    @Test
    public void userInputTest(){
        UserInputService userInputService = new UserInputService();
        SearchVO userInput = userInputService.getUserInput();
        Assert.assertEquals("사용자입력 : Hello",  "Hello", userInput.getInput());
    }
}
