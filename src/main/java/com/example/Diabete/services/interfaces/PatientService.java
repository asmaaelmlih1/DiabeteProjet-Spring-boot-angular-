package com.example.Diabete.services.interfaces;

import com.example.Diabete.DTO.PatientDTO;
import com.example.Diabete.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    PatientDTO addPatient(Patient patient);
    List<PatientDTO> getAllPatient();

    PatientDTO getPatientById(long id);
    PatientDTO updatePatient(long id,Patient patient);
    void deletePatient(long id);
}
