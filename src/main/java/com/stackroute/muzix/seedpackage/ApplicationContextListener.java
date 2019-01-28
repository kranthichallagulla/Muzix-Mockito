//package com.stackroute.muzix.seedpackage;
//
//import com.stackroute.muzix.domain.Track;
//import com.stackroute.muzix.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//@Configuration
//public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {
//    private TrackRepository trackRepository;
//    @Autowired
//
//    public ApplicationContextListener(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        Track track3=Track.builder().trackName("third track").comments("good").build();
//        trackRepository.save(track3);
//        Track track4=Track.builder().trackName("fourth track").comments("good").build();
//        trackRepository.save(track4);
//    }
//}
