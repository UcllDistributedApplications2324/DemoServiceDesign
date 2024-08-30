package be.ucll.da.hospitalmonolith.business;

import be.ucll.da.hospitalmonolith.persistence.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void createNewRoom(Long hospitalId) {
        roomRepository.createNewRoom(hospitalId); // bypasses domain logic
    }
}
