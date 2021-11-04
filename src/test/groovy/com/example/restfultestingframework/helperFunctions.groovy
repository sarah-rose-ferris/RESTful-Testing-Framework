package com.example.restfultestingframework;

import com.example.restfultestingframework.controller.rest.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import spock.lang.Specification;

import java.util.Locale;


@SpringBootTest
@Component
class helperFunctions extends Specification {


    @Autowired
    private WebController controller;

//test

    public ResponseEntity<String> chooseFunction(HttpMethod type){

        switch (type) {
            case HttpMethod.GET:
                return getExecute();
            case HttpMethod.PUT:
                return putExecute();
            case HttpMethod.POST:
                return postExecute();
            default :
                System.out.println("invalid choice of method type");
                return null;
        }

    }

    public ResponseEntity<String> chooseFunctionWithParam(HttpMethod type,int param){

        switch (type) {
            case HttpMethod.GET:
                return getExecuteCustom(param);
            case HttpMethod.PUT:
                return putExecute();
            case HttpMethod.POST:
                return postExecute();
            default :
                System.out.println("invalid choice of method type");
                return null;
        }

    }

    public ResponseEntity<String> postExecute(){
        return controller.createUser();
    }

    public ResponseEntity<String> putExecute(){
        return controller.updateUser();
    }

    public ResponseEntity<String> getExecute(){
        return controller.getTest();
    }

    public ResponseEntity<String> getExecuteCustom(int param){
        return controller.getTestCustom(param);
    }

    void testIfResponseBodyContains(ResponseEntity<String> input,String contains){
        assert input.getBody().contains(contains);
    }

    void testResponseBodyType(ResponseEntity<String> input,MediaType type){

        assert input.getHeaders().getContentType().isCompatibleWith(type);
        //slight hack - the format of the content type from the header was different to that of the MediaType;
        // ie the header contained the charset as well
    }

    void checkStatusCode(ResponseEntity<String> input, HttpStatus code){
        assert input.getStatusCode() == code;
    }
}
