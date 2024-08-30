package be.ucll.da.hospitalmonolith.domain.hospital;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "hospital")
    private List<Room> rooms;

    @ElementCollection
    private List<Long> doctors;

    @ElementCollection
    private List<Long> patients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms == null ? new ArrayList<>() : rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Long> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Long> doctors) {
        this.doctors = doctors;
    }

    public List<Long> getPatients() {
        return patients;
    }

    public void setPatients(List<Long> patients) {
        this.patients = patients;
    }

    public void addDoctor(Long id) {
        if (getDoctors().stream().anyMatch(dId -> Objects.equals(dId, id))) {
            throw new RuntimeException("Doctor already works here");
        }

        this.getDoctors().add(id);
    }

    public void addPatient(Long id) {
        this.getPatients().add(id);
    }

    public void addRoom(Room room) {
        this.getRooms().add(room);
    }
}
