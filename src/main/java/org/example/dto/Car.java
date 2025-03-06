package org.example.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    private Long id;
    private String moddle;
    private Double pay;
    private String image;
}
