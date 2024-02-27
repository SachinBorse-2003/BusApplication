package com.example.bus;

public class OutOfCapacityException extends Exception {
    public OutOfCapacityException(String message){
        super(message);
    }
}
