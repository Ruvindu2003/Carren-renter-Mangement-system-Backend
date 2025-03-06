package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.util.Register;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CustomerRegister")

public class CustomerRegisterEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String password;
    private Register register;
}
