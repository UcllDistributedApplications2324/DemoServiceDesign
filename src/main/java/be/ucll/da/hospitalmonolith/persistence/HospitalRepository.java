package be.ucll.da.hospitalmonolith.persistence;

import be.ucll.da.hospitalmonolith.business.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Long> {}
