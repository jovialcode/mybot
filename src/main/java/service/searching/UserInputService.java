package service.searching;

import model.vo.SearchVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserInputService {
    /**
    *
    * */
    public SearchVO getUserInput(){
        SearchVO userInput = new SearchVO();
        System.out.println("사용자 입력");
        try(
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
        ) {
            userInput.setInput(br.readLine());
        }catch (IOException e){
        }
        return userInput;
    }
}
