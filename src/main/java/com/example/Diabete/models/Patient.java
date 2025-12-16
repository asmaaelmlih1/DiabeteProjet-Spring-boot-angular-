package com.example.Diabete.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long age;
    private Double weight;
    @Enumerated(EnumType.STRING)
    private DiabetesType diabetesType;
    private String treatment;
    private Double targetMin;
    private Double targetMax;
    @OneToMany(mappedBy = "patient")
    private List<Glycemie> glycemieList;
}
