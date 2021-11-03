package com.example.restfultestingframework;

import com.example.restfultestingframework.controller.rest.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Locale;


@SpringBootTest
public class helperFunctions {

    @Autowired
    private WebController controller = new WebController();


    public helperFunctions() {
    }

    public ResponseEntity<String> chooseFunction(String type){
        switch (type.toLowerCase(Locale.ROOT)) {
            case "get" :
                return this.getExecute();
            case "put" :
                return this.putExecute();
            case "post" :
                return this.postExecute();
            default :
                System.out.println("invalid choice");
                return null;
        }

    }

    public ResponseEntity<String> postExecute(){
        return this.controller.createUser();
    }

    public ResponseEntity<String> putExecute(){
        return this.controller.updateUser();
    }

    public ResponseEntity<String> getExecute(){
        return this.controller.getTest();
    }

    public boolean testIfResponseBodyContains(ResponseEntity<String> input,String contains){
        return input.getBody().contains(contains);
    }

    public boolean checkStatusCode(ResponseEntity<String> input, HttpStatus code){
        return input.getStatusCode() == code;
    }
}
