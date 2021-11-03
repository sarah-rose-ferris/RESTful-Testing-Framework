package com.example.restfultestingframework

import com.example.restfultestingframework.controller.rest.WebController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpMethod
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
        ResponseEntity<String> result = helperFunctions.chooseFunction(HttpMethod.GET);
        //ResponseEntity<String> result = webController.getTest();

        expect:
        helperFunctions.testIfResponseBodyContains(result,"Michael");
       // result.getBody().contains("Michael");
        and:
        assert helperFunctions.checkStatusCode(result,HttpStatus.OK);
        //assert result.getStatusCode() == HttpStatus.OK;


    }
    def 'accessing external api with custom param' () {


        given:
        ResponseEntity<String> result = helperFunctions.chooseFunctionWithParam(HttpMethod.GET,3);
        //ResponseEntity<String> result = webController.getTest();

        expect:
        helperFunctions.testIfResponseBodyContains(result,"Emma");
        // result.getBody().contains("Michael");
        and:
        assert helperFunctions.checkStatusCode(result,HttpStatus.OK);
        //assert result.getStatusCode() == HttpStatus.OK;


    }

    def 'post request test' () {
        given:
        ResponseEntity<String> result = helperFunctions.chooseFunction(HttpMethod.POST)
        //ResponseEntity<String> result = webController.createUser();

        expect:
        result != null;

        and:
        assert helperFunctions.checkStatusCode(result,HttpStatus.CREATED)
        //assert result.getStatusCode() == HttpStatus.CREATED;


    }

    def 'put request test' () {
        given:
        ResponseEntity<String> result = helperFunctions.chooseFunction(HttpMethod.PUT)
        //ResponseEntity<String> result = webController.updateUser();

        expect:
        result.body

        and:
        assert helperFunctions.checkStatusCode(result,HttpStatus.OK)
        //assert result.getStatusCode() == HttpStatus.OK;


    }
}
