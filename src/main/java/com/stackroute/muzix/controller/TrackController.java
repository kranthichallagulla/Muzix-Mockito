package com.stackroute.muzix.controller;
import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackAlreadyUpdatedException;
import com.stackroute.muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.muzix.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1")
@Api(value="this is controller",description = "this is track controller")
public class TrackController {
    private TrackService trackService;
    ResponseEntity responseEntity;
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    @ApiOperation(value="return savetrack")
    @ApiResponses(value={@ApiResponse(code=100,message=" hello")})
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException{


            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Created Successfully", HttpStatus.CREATED);


        return responseEntity;

    }

    @ApiOperation(value="return updatetrack")
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackAlreadyUpdatedException {


            trackService.updateTrack(track);
            responseEntity=new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);

        return responseEntity;

    }
    @ApiOperation(value="return deleteTrack")
    @DeleteMapping("track/{id}")

    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id) throws TrackIdNotFoundException
    {

            trackService.deleteTrack(id);
            responseEntity = new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);


        return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }
}
