package com.example.preparationapp;

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
