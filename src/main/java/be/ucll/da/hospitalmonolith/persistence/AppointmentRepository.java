package be.ucll.da.hospitalmonolith.persistence;

import be.ucll.da.hospitalmonolith.business.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {}
