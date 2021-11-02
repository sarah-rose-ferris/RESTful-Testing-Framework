package com.example.restfultestingframework

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class ExampleSpec extends Specification{

    def test = 1;

    def "easy assert"(){
        expect:
        test == 1;

    }
}
