package com.experis.test.util;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(IllegalArgumentException.class)
	 public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request) {
		    Map<String, Object> errorResponse = new LinkedHashMap<>();
		    errorResponse.put("timestamp", LocalDateTime.now());
		    errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		    errorResponse.put("error", "Bad Request");
		    errorResponse.put("message", ex.getMessage());
		    errorResponse.put("path", request.getRequestURI());
		    return ResponseEntity.badRequest().body(errorResponse);
		}

}
