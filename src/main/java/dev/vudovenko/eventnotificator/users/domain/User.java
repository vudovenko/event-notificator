package dev.vudovenko.eventnotificator.users.domain;

import dev.vudovenko.eventnotificator.users.userRoles.UserRole;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String login;
    private UserRole role;
}
