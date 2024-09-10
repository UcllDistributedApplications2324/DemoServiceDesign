package be.ucll.da.hospitalmonolith.domain.hospital;

public interface RoomNotificationService {

    void sendRoomBuiltNotification(String to, String subject, String text);
}
