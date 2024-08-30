package be.ucll.da.hospitalmonolith.api;

import be.ucll.da.hospitalmonolith.business.Doctor;
import be.ucll.da.hospitalmonolith.business.DoctorService;
import be.ucll.da.hospitalmonolith.business.Patient;
import be.ucll.da.hospitalmonolith.business.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }
}
