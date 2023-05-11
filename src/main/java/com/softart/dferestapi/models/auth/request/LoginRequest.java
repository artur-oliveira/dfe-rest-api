package com.softart.dferestapi.models.auth.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public final class LoginRequest {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
