package com.stackroute.muzix.controller;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackAlreadyUpdatedException;
import com.stackroute.muzix.exceptions.TrackIdNotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track already exist")
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public void handleTrackAlreadyExistException(TrackAlreadyExistsException e){
        System.out.println("Track already exist");
    }
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Track not found")
    @ExceptionHandler(TrackIdNotFoundException.class)
    public void handleTrackNotFoundException(TrackIdNotFoundException e){
        System.out.println("Track not found");
    }
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track id not found")
    @ExceptionHandler(TrackAlreadyUpdatedException.class)
    public void handleTrackAlreadyUdatedException(TrackAlreadyUpdatedException e){
        System.out.println("Track not found");
    }
}

