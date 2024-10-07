package be.ucll.da.hospitalmonolith.persistence;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {}
