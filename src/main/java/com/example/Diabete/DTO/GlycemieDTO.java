package com.example.Diabete.DTO;

import com.example.Diabete.models.GlycemieType;
import com.example.Diabete.models.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlycemieDTO {
    private Long id;
    private Double value;
    private DateTime dateTime;
}
