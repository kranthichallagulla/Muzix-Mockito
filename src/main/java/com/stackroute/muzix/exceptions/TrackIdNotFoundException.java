package com.stackroute.muzix.exceptions;

public class TrackIdNotFoundException extends Exception{
    private String message;

    public TrackIdNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public TrackIdNotFoundException() {

    }
}

