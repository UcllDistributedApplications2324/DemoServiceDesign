package be.ucll.da.hospitalmonolith.domain.appointment;

import be.ucll.da.hospitalmonolith.domain.doctor.Doctor;
import be.ucll.da.hospitalmonolith.domain.hospital.Room;
import be.ucll.da.hospitalmonolith.domain.patient.Patient;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate preferredDay;

    private String neededExpertise;

    private LocalDateTime scheduledTime;

    private Long roomId;

    private Long doctor;

    private Long patient;

    @Embedded
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPreferredDay() {
        return preferredDay;
    }

    public void setPreferredDay(LocalDate preferredDay) {
        this.preferredDay = preferredDay;
    }

    public String getNeededExpertise() {
        return neededExpertise;
    }

    public void setNeededExpertise(String neededExpertise) {
        this.neededExpertise = neededExpertise;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getDoctor() {
        return doctor;
    }

    public void setDoctor(Long doctor) {
        this.doctor = doctor;
    }

    public Long getPatient() {
        return patient;
    }

    public void setPatient(Long patient) {
        this.patient = patient;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
