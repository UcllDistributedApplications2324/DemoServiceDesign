package be.ucll.da.hospitalmonolith.domain.appointment;

import be.ucll.da.hospitalmonolith.domain.appointment.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {}
