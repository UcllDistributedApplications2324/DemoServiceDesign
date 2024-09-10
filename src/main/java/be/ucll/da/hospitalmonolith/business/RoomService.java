package be.ucll.da.hospitalmonolith.business;

import be.ucll.da.hospitalmonolith.persistence.DoctorRepository;
import be.ucll.da.hospitalmonolith.persistence.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoomService {

    private RoomRepository roomRepository;
    private DoctorRepository doctorRepository;
    private MailService mailService;

    @Autowired
    public RoomService(RoomRepository roomRepository, DoctorRepository doctorRepository, MailService mailService) {
        this.roomRepository = roomRepository;
        this.doctorRepository = doctorRepository;
        this.mailService = mailService;
    }

    public void createNewRoom(Long hospitalId) {
        roomRepository.createNewRoom(hospitalId); // bypasses domain logic

        for (Doctor doctor : doctorRepository.findAll()) {
            mailService.sendMail(doctor.getEmail(), "New room to work in!", "...");
        }
    }
}
