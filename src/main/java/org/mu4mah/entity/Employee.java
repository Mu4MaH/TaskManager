package org.mu4mah.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class Employee {


    private String UID = String.valueOf(UUID.randomUUID());
    private String name = "unnamed_employee";
    private String login;
    private String password;
    private String role;

    @Override
    public String toString() {
        return this.UID + " : " + this.name + " : " + this.login;
    }
}
