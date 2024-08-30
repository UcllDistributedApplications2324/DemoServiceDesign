package be.ucll.da.hospitalmonolith.adapters.rest;

import be.ucll.da.hospitalmonolith.domain.doctor.Doctor;
import be.ucll.da.hospitalmonolith.domain.doctor.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
@Transactional
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
