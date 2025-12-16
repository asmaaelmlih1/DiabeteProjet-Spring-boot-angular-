package com.example.Diabete.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Glycemie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unit;
    private Double value;
    @Enumerated(EnumType.STRING)
    private GlycemieType glycemieType;
    @DateTimeFormat
    private DateTime dateTime;
    private String note;
    @ManyToOne
    @JsonIgnore
    private Patient patient;

}
