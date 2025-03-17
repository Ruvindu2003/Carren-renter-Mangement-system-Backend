package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Car")

public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private String tramsmisson;
    private String brand;
    private String type;
    private Date  moddleDate;
    private String description;
    private Double price;
    @Column(columnDefinition = "longblob")
    private  byte[] image;



}
