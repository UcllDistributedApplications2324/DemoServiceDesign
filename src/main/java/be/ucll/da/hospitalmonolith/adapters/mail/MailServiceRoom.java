package be.ucll.da.hospitalmonolith.adapters.mail;

import be.ucll.da.hospitalmonolith.domain.hospital.RoomNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MailServiceRoom implements RoomNotificationService {

    private final static Logger LOGGER = LoggerFactory.getLogger(MailServiceRoom.class);

    @Override
    public void sendRoomBuiltNotification(String to, String subject, String text) {
        // Code to actually send an email...
        LOGGER.info("Sending mail with subject {} and text {} to {}", subject, text, to);
    }
}
