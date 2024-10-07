package be.ucll.da.hospitalmonolith.business;

import be.ucll.da.hospitalmonolith.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalService {

    private HospitalRepository hospitalRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public Hospital createHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public Hospital addDoctorToHospital(Long id, Doctor d) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        Doctor doctor = doctorRepository.findById(d.getId()).orElseThrow(() -> new RuntimeException("Not found"));

        hospital.addDoctor(doctor);
        return hospital;
    }

    public Hospital addPatientToHospital(Long id, Patient p) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        Patient patient = patientRepository.findById(p.getId()).orElseThrow(() -> new RuntimeException("Not found"));

        hospital.addPatient(patient);
        return hospital;
    }
}
