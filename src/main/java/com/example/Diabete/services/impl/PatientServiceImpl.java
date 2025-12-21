package com.example.Diabete.services.impl;

import com.example.Diabete.DTO.PatientDTO;
import com.example.Diabete.models.Patient;
import com.example.Diabete.repositories.PatientRepository;
import com.example.Diabete.services.interfaces.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository repository;
    private final ModelMapper mapper;

    public PatientServiceImpl(PatientRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public PatientDTO addPatient(Patient patient) {
        PatientDTO patientDTO=mapper.map((repository.save(patient)), PatientDTO.class) ;
        return patientDTO;
    }

    @Override
    public List<PatientDTO> getAllPatient() {
       List<Patient> patientList= repository.findAll();
       List<PatientDTO> patientDTOList=patientList.stream().map(patient -> mapper.map(patient, PatientDTO.class)).collect(Collectors.toList());
        return patientDTOList;
    }

    @Override
    public PatientDTO getPatientById(long id) {
       PatientDTO patientDTO=mapper.map((repository.findById(id)), PatientDTO.class) ;
        return patientDTO;
    }

    @Override
    public PatientDTO updatePatient(long id, Patient patient) {
        Optional<Patient> checkPatient=repository.findById(id);
        Patient updatedPatient = new Patient();
        if(checkPatient.isPresent()){
            Patient oldPatient=checkPatient.get();
            oldPatient.setAge(patient.getAge());
            oldPatient.setWeight(patient.getWeight());
            oldPatient.setTreatment(patient.getTreatment());
            oldPatient.setDiabetesType(patient.getDiabetesType());
            oldPatient.setTargetMax(patient.getTargetMax());
            oldPatient.setTargetMin(patient.getTargetMin());
            oldPatient.setGlycemieList(patient.getGlycemieList());
             updatedPatient =repository.save(oldPatient);
        }
        PatientDTO patientDTO=mapper.map(updatedPatient,PatientDTO.class);
        return patientDTO;
    }

    @Override
    public void deletePatient(long id) {
        repository.deleteById(id);
    }
}
