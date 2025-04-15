package com.example.preparationapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tripName;
    private String tripDescription;

    @ManyToOne
    @JoinColumn(name = "account_user_id", nullable = false)
    private AccountUser accountUser;
}
