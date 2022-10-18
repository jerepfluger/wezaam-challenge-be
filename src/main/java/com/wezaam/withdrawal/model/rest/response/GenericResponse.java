package com.wezaam.withdrawal.model.rest.response;

import com.wezaam.withdrawal.utils.Jsonizable;


public class GenericResponse extends Jsonizable {
    public Integer code;
    public String message;

    public GenericResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
