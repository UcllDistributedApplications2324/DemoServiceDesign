package be.ucll.da.hospitalmonolith.domain.patient;

import be.ucll.da.hospitalmonolith.domain.patient.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {}
