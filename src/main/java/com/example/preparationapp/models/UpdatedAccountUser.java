package com.example.preparationapp.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdatedAccountUser {
    private String name;
    private String email;
    private String surname;
}
