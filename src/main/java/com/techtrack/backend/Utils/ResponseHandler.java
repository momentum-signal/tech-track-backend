package com.techtrack.backend.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseHandler {
    public static <T> ResponseEntity<Object> sendResponse(ResponseProps<T> data) {
        // Create the response body as a map
        var response = new HashMap<String, Object>();
        response.put("success", data.isSuccess());
        response.put("message", data.getMessage());
        response.put("data", data.getData());
        response.put("statusCode", data.getStatusCode());

        // Return the response with the appropriate HTTP status code
        return new ResponseEntity<>(response, HttpStatus.valueOf(data.getStatusCode()));
    }
}
