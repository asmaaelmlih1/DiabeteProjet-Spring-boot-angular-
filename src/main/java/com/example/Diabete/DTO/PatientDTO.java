package com.example.Diabete.DTO;

import com.example.Diabete.models.DiabetesType;
import com.example.Diabete.models.Glycemie;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    private Long age;
    private Double weight;
    private DiabetesType diabetesType;
    private String treatment;
    private Double targetMin;
    private Double targetMax;
    private List<GlycemieDTO> glycemieList;
}
