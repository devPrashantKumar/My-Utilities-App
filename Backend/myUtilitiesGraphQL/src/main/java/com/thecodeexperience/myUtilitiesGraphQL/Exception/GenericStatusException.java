package com.thecodeexperience.myUtilitiesGraphQL.Exception;

import lombok.Data;

@Data
public class GenericStatusException extends RuntimeException {

    private final int status;

    public GenericStatusException(String msg, int status){
        super(msg);
        this.status=status;
    }
}
