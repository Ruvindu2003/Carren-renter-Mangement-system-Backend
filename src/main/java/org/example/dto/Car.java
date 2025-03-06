package org.example.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    private Long id;
    private String moddle;
    private Double price;
    private Date date;
    private String image;
}
