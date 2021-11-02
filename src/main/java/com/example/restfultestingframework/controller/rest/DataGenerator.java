package com.example.restfultestingframework.controller.rest;

import java.util.HashMap;
import java.util.Map;

public class DataGenerator {
    public Map<String, Object> dataforuser() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "Edward");
        params.put("job","Postman");
        return params;
    }
}
