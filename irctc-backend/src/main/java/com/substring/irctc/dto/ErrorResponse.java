package com.substring.irctc.dto;

public record ErrorResponse(String message, String code, boolean success) {
    //record can be use as data holder class

}
