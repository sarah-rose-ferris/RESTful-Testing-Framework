package com.example.restfultestingframework

import com.example.restfultestingframework.controller.rest.WebController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest
class restSPEC extends Specification{

    helperFunctions helperFunctions = new helperFunctions();

//    @Autowired
//    private WebController webController

    def 'accessing external api' () {


        given:
        ResponseEntity<String> result = helperFunctions.chooseFunction("get");
        //ResponseEntity<String> result = webController.getTest();

        expect:
        helperFunctions.testIfResponseBodyContains(result,"Michael");
       // result.getBody().contains("Michael");// hack to get around parsing JSON
       // - would need to create a class to store object returned
        // like https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate?rq=1
        and:
        assert helperFunctions.checkStatusCode(result,HttpStatus.OK);
        //assert result.getStatusCode() == HttpStatus.OK;


    }

    def 'post request test' () {
        given:
        ResponseEntity<String> result = helperFunctions.chooseFunction("post")
        //ResponseEntity<String> result = webController.createUser();

        expect:
        result != null;

        and:
        assert helperFunctions.checkStatusCode(result,HttpStatus.CREATED)
        //assert result.getStatusCode() == HttpStatus.CREATED;


    }

    def 'put request test' () {
        given:
        ResponseEntity<String> result = helperFunctions.chooseFunction("put")
        //ResponseEntity<String> result = webController.updateUser();

        expect:
        result.body

        and:
        assert helperFunctions.checkStatusCode(result,HttpStatus.OK)
        //assert result.getStatusCode() == HttpStatus.OK;


    }
}
