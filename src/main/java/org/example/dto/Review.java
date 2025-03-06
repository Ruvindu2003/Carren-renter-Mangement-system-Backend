package org.example.dto;

import lombok.*;
import org.example.util.Rating;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    private Long id;
    private String reviewerName;
    private String comment;
    private Rating rating;
    private String date;

}
