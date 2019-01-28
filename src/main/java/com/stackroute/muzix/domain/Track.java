package com.stackroute.muzix.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;


//@Document(collection = "Tracks")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Track {
    @Id


    private int trackId;
    private String trackName;
    private String comments;

}
