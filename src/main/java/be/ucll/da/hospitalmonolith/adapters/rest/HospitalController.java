package be.ucll.da.hospitalmonolith.adapters.rest;

import be.ucll.da.hospitalmonolith.domain.doctor.Doctor;
import be.ucll.da.hospitalmonolith.domain.hospital.Hospital;
import be.ucll.da.hospitalmonolith.domain.hospital.HospitalRepository;
import be.ucll.da.hospitalmonolith.domain.hospital.Room;
import be.ucll.da.hospitalmonolith.domain.hospital.RoomManagementService;
import be.ucll.da.hospitalmonolith.domain.patient.Patient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
@Transactional
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private RoomManagementService roomManagementService;

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @PostMapping("/{id}/doctor")
    public Hospital addDoctorToHospital(
            @PathVariable Long id,
            @RequestBody Doctor doctorDto) {

        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        hospital.addDoctor(doctorDto.getId());

        return hospital;
    }

    @PostMapping("/{id}/patient")
    public Hospital addPatientToHospital(
            @PathVariable Long id,
            @RequestBody Patient patientDto) {

        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        hospital.addPatient(patientDto.getId());

        return hospital;
    }

    @PostMapping("/{id}/room")
    public void addRoomToHospital(
            @PathVariable Long id,
            @RequestBody Room room) {

        roomManagementService.addRoomToHospital(id);
    }
}
