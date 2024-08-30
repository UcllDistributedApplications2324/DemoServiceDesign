package be.ucll.da.hospitalmonolith.persistence;

import be.ucll.da.hospitalmonolith.business.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {}
