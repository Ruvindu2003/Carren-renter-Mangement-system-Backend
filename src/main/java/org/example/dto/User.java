package org.example.dto;

import lombok.*;
import org.example.util.UserRoles;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Setter
@Getter

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRoles userRoles;
}
