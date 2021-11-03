package com.example.restfultestingframework;

import com.example.restfultestingframework.controller.rest.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.MediaType;

import java.util.Locale;


@SpringBootTest
public class helperFunctions {

    @Autowired
    private WebController controller = new WebController();


    public helperFunctions() {
    }



    public ResponseEntity<String> chooseFunction(HttpMethod type){

        switch (type) {
            case GET:
                return this.getExecute();
            case PUT:
                return this.putExecute();
            case POST:
                return this.postExecute();
            default :
                System.out.println("invalid choice of method type");
                return null;
        }

    }

    public ResponseEntity<String> chooseFunctionWithParam(HttpMethod type,int param){

        switch (type) {
            case GET:
                return this.getExecuteCustom(param);
            case PUT:
                return this.putExecute();
            case POST:
                return this.postExecute();
            default :
                System.out.println("invalid choice of method type");
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

    public ResponseEntity<String> getExecuteCustom(int param){
        return this.controller.getTestCustom(param);
    }

    public boolean testIfResponseBodyContains(ResponseEntity<String> input,String contains){
        return input.getBody().contains(contains);
    }

    public boolean testResponseBodyType(ResponseEntity<String> input,MediaType type){

        return input.getHeaders().getContentType().isCompatibleWith(type);
        //slight hack - the format of the content type from the header was different to that of the MediaType;
        // ie the header contained the charset as well
    }

    public boolean checkStatusCode(ResponseEntity<String> input, HttpStatus code){
        return input.getStatusCode() == code;
    }
}
