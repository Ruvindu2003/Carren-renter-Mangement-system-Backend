package org.example.dto;

import lombok.*;
import org.example.enums.UserRoles;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthoricationRespones {
    private String jwt;
    private UserRoles userRoles;
    private Long userid;
}
