package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackAlreadyUpdatedException;
import com.stackroute.muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService{
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {

        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

         if(trackRepository.existsById(track.getTrackId())){
             throw new TrackAlreadyExistsException("Track already exists");
         }
        Track savedTrack=trackRepository.save(track);
         if(savedTrack==null){
             throw new TrackAlreadyExistsException("Track already exist");
         }
        return savedTrack;
    }
    @Override
    public Track updateTrack(Track track) throws TrackAlreadyUpdatedException {

       if(trackRepository.existsById(track.getTrackId())){
            track.setTrackId(track.getTrackId());
            track.setComments(track.getComments());
            track.setTrackName(track.getTrackName());
            return trackRepository.save(track);
       }else
            throw new TrackAlreadyUpdatedException("Track doesn't exists.");


    }


    @Override
    public boolean deleteTrack(int id) throws TrackIdNotFoundException {
            boolean status=false;
           if(trackRepository.existsById(id)){

               trackRepository.deleteById(id);

               status=true;
               return status;
           }
           else{
               throw new TrackIdNotFoundException("Track id not found");
           }



    }


    @Override
    public List<Track> getAllTracks()
    {
        return trackRepository.findAll();
    }


}
