package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackAlreadyUpdatedException;
import com.stackroute.muzix.exceptions.TrackIdNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public Track updateTrack(Track track) throws TrackAlreadyUpdatedException;
    public boolean deleteTrack(int id) throws TrackIdNotFoundException;
    public List<Track> getAllTracks();

}
