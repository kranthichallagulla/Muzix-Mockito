package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackAlreadyUpdatedException;
import com.stackroute.muzix.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class TrackServiceTest {
    Track track;

    //Create a mock for UserRepository
    @Mock
    TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track=new Track();
       track.setTrackId(120);
       track.setTrackName("nbjsdh");
       track.setComments("bestttt");
        list = new ArrayList<>();
        list.add(track);


    }

    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }
    @Test(expected = TrackAlreadyExistsException.class)
    public void saveUserTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track)any())).thenReturn(null);
        Track savedTrack = trackService.saveTrack(track);
        System.out.println("savedtrack" + savedTrack);
        Assert.assertEquals(track,savedTrack);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

//    @Test
//    public void updateTrackTestSuccess() throws TrackAlreadyUpdatedException {
//
//        when(trackRepository.save((Track)any())).thenReturn(track);
//        Track updatedTrack = trackService.updateTrack(track);
//        Assert.assertEquals(track,updatedTrack);
//
//        //verify here verifies that userRepository save method is only called once
//        verify(trackRepository,times(1)).save(track);

//    }

    @Test
    public void updateTrackTest() throws TrackAlreadyUpdatedException
    {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track updateTrack = null;
        try {
            updateTrack = trackService.saveTrack(track);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(track,updateTrack);
    }



    @Test
    public void getAllUser(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        Assert.assertEquals(list,tracklist);
    }




}
