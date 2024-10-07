package be.ucll.da.hospitalmonolith.business;

import be.ucll.da.hospitalmonolith.persistence.Doctor;
import be.ucll.da.hospitalmonolith.persistence.HospitalRepository;
import be.ucll.da.hospitalmonolith.persistence.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoomService {

    private HospitalRepository hospitalRepository;
    private RoomRepository roomRepository;
    private MailService mailService;

    @Autowired
    public RoomService(HospitalRepository hospitalRepository, RoomRepository roomRepository, MailService mailService) {
        this.hospitalRepository = hospitalRepository;
        this.roomRepository = roomRepository;
        this.mailService = mailService;
    }

    public void createNewRoom(Long hospitalId) {
        roomRepository.createNewRoom(hospitalId); // bypasses domain logic

        for (Doctor doctor : hospitalRepository.findById(hospitalId).orElseThrow().getDoctors()) {
            mailService.sendMail(doctor.getEmail(), "New room to work in!", "...");
        }
    }
}
