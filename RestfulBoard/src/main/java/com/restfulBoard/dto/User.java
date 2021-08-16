package com.restfulBoard.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    @Size(min = 2, max = 10)
    @Pattern(regexp = "^[0-9a-z]+$*") // only English
    private String id;
    @Size(min = 10, max = 12)
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
