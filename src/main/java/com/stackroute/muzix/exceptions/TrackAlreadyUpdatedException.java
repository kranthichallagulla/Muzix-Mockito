package com.stackroute.muzix.exceptions;

public class TrackAlreadyUpdatedException extends Exception {
    private String message;

    public TrackAlreadyUpdatedException(String message) {

        super(message);
        this.message = message;
    }

    public TrackAlreadyUpdatedException() {

    }

}
