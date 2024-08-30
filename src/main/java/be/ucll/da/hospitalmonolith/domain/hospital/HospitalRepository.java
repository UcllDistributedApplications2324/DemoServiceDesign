package be.ucll.da.hospitalmonolith.domain.hospital;

import be.ucll.da.hospitalmonolith.domain.hospital.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Long> {}
