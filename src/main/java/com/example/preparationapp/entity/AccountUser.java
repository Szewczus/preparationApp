package com.example.preparationapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AccountUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String surname;
    @OneToMany(mappedBy = "accountUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripPlan> tripPlanList;
}
