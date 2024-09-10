package be.ucll.da.hospitalmonolith.domain.hospital;

import be.ucll.da.hospitalmonolith.domain.doctor.Doctor;
import be.ucll.da.hospitalmonolith.domain.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomManagementService {

    private HospitalRepository hospitalRepository;
    private DoctorRepository doctorRepository;
    private RoomNotificationService roomNotificationService;

    @Autowired
    public RoomManagementService(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, RoomNotificationService roomNotificationService) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.roomNotificationService = roomNotificationService;
    }

    public void addRoomToHospital(Long id) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        hospital.addRoom(new Room());

        for (Doctor doctor : doctorRepository.findAllById(hospital.getDoctors())) {
            roomNotificationService.sendRoomBuiltNotification(doctor.getEmail(), "New room to work in!", "...");
        }
    }
}
