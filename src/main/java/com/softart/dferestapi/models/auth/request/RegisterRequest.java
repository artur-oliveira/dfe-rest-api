package com.softart.dferestapi.models.auth.request;

import com.softart.dferestapi.models.auth.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public final class RegisterRequest {
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String username;
    @Email
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String password;
    @NotEmpty
    private Set<RoleType> roles = new HashSet<>();
}
