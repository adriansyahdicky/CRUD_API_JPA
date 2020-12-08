package com.dicky.react.ApiReact.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

    private final String token;
    private final String username;
    private final String role;

}
