package com.user_service.rest.controller;

import com.user_service.rest.response.ResponseDefault;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Operation(summary = "Home endpoint for user-service testing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDefault.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @RequestMapping(value = "/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseDefault hello() {
        ResponseDefault response = new ResponseDefault();
        response.setCode("200");
        response.setStatus("Success");
        response.setMessage("Hello User Service!");
        response.setCodeDesc("Request processed successfully.");
        return response;
    }
}
