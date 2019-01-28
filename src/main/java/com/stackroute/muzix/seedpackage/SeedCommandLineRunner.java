//package com.stackroute.muzix.seedpackage;
//
//import com.stackroute.muzix.domain.Track;
//import com.stackroute.muzix.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SeedCommandLineRunner implements CommandLineRunner {
//    private TrackRepository trackRepository;
//    @Autowired
//    public SeedCommandLineRunner(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Track track1=Track.builder().trackName("first track").comments("good").build();
//        trackRepository.save(track1);
//        Track track2=Track.builder().trackName("second track").comments("good").build();
//        trackRepository.save(track2);
//        trackRepository.save(new Track(6,"new track","good"));
//    }
//}
package com.stackroute.muzix.seedpackage;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.service.TrackService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("application.properties")
public class SeedCommandLineRunner implements CommandLineRunner {
    private Track feedTrackData = new Track();
    @Value("${song.total}")
    private int totalSongs;
    @Value("${song.1.id}")
    private int id1;
    @Value("${song.1.name}")
    private String name1;
    @Value("${song.1.comment}")
    private String comment1;
    @Value("${song.2.id}")
    private int id2;
    @Value("${song.2.name}")
    private String name2;
    @Value("${song.2.comment}")
    private String comment2;
    @Value("${song.3.id}")
    private int id3;
    @Value("${song.3.name}")
    private String name3;
    @Value("${song.3.comment}")
    private String comment3;
    @Value("${song.4.id}")
    private int id4;
    @Value("${song.4.name}")
    private String name4;
    @Value("${song.4.comment}")
    private String comment4;


    @Autowired
    Environment env;
    @Autowired
    private TrackService trackServices;
    //TODO: Add all feeder data to a file, don't let it be hardcoded
    //TODO: Find a better way to write expressions for @Value tag
    @Override
    public void run(String... args) throws Exception {
        System.out.println(env.getProperty("app.name"));
        System.out.println(env.getProperty("JAVA_HOME"));
        feedTrackData.setTrackId(id1);
        feedTrackData.setTrackName(name1);
        feedTrackData.setComments(comment1);
        trackServices.saveTrack(feedTrackData);

//        feedTrackData.setTrackId(Integer.parseInt(env.getProperty("song.1.id")));
//        feedTrackData.setTrackName(env.getProperty("song.1.name"));
//        feedTrackData.setComments(env.getProperty("song.1.comment"));
//        trackServices.saveTrack(feedTrackData);

        feedTrackData.setTrackId(id2);
        feedTrackData.setTrackName(name2);
        feedTrackData.setComments(comment2);
        trackServices.saveTrack(feedTrackData);

        feedTrackData.setTrackId(id3);
        feedTrackData.setTrackName(name3);
        feedTrackData.setComments(comment3);
        trackServices.saveTrack(feedTrackData);

        feedTrackData.setTrackId(id4);
        feedTrackData.setTrackName(name4);
        feedTrackData.setComments(comment4);
        trackServices.saveTrack(feedTrackData);
    }
}
