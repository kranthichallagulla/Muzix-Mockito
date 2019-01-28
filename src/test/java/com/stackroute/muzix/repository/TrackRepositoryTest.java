package com.stackroute.muzix.repository;
import com.stackroute.muzix.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackId(1112);
        track.setTrackName("name");
        track.setComments("comment");
    }
    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }



    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(1112,fetchUser.getTrackId());

    }



    @Test
    public void testSaveTrackFailure(){
        Track testUser = new Track(34,"Hello","Adele");
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getTrackId()).get();
        Assert.assertNotSame(testUser,track);
    }

    @Test
    public void testGetAllTrack(){
        Track u = new Track(1112,"name","XXtentacion");
        Track u1 = new Track(34,"Hello","Adele");
        trackRepository.save(u);
        trackRepository.save(u1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("name",list.get(1).getTrackName());




    }
}
