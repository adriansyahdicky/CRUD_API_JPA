package com.dicky.react.ApiReact.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

    private final String jwt;
    private final String username;

}
