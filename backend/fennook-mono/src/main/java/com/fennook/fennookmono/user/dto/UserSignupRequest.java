package com.fennook.fennookmono.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
