package be.ucll.da.hospitalmonolith.persistence;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {}
