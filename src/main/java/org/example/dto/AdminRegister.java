package org.example.dto;

import lombok.*;
import org.example.util.Register;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class AdminRegister {
    private Long id;
    private String name;
    private String adress;
    private String email;
    private String password;
    private Register register;

}
