package com.cognizant.spring_learn;

import static com.cognizant.spring_learn.SpringLearnApplication.LOGGER;

public class Country {

    private String code;
    
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return """
                Country{
                    code='%s', 
                    name='%s'
                }""".formatted(code, name);
    }
}
