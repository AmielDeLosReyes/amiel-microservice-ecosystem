package com.user_service.rest.response;

import lombok.Data;

@Data
public class ResponseDefault {
    private String code;
    private String codeDesc;
    private String status;
    private String message;
}
