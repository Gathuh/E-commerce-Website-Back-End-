package com.gathu.eccomerce.exception.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String,String> errors
){

}
