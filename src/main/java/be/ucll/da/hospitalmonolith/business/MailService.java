package be.ucll.da.hospitalmonolith.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final static Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    public void sendMail(String to, String subject, String text) {
        // Code to actually send an email...
        LOGGER.info("Sending mail with subject {} and text {} to {}", subject, text, to);
    }
}
