package be.ucll.da.hospitalmonolith.api;

import be.ucll.da.hospitalmonolith.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    private HospitalService hospitalService;
    private RoomService roomService;

    @Autowired
    public HospitalController(HospitalService hospitalService, RoomService roomService) {
        this.hospitalService = hospitalService;
        this.roomService = roomService;
    }

    @PostMapping
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return hospitalService.createHospital(hospital);
    }

    @PostMapping("/{id}/doctor")
    public Hospital addDoctorToHospital(
            @PathVariable Long id,
            @RequestBody Doctor doctor) {

        return hospitalService.addDoctorToHospital(id, doctor);
    }

    @PostMapping("/{id}/patient")
    public Hospital addPatientToHospital(
            @PathVariable Long id,
            @RequestBody Patient patient) {

        return hospitalService.addPatientToHospital(id, patient);
    }

    @PostMapping("/{id}/room")
    public void addRoomToHospital(
            @PathVariable Long id,
            @RequestBody Room room) {

        roomService.createNewRoom(id);
    }
}
