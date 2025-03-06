package org.example.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.example.util.Register;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CustomerRegister {
    private Long id;
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Register register;

}
