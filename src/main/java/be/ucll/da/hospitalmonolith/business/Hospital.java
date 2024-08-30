package be.ucll.da.hospitalmonolith.business;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "hospital")
    private List<Room> rooms;

    @ManyToMany
    private List<Doctor> doctors;

    @ManyToMany
    private List<Patient> patients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Doctor> getDoctors() {
        return doctors == null ? new ArrayList<>() :  doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients == null ? new ArrayList<>() :  patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void addDoctor(Doctor doctor) {
        if (getDoctors().stream().anyMatch(d -> d.getName().equals(doctor.getName()))) {
            throw new RuntimeException("Doctor already works here");
        }

        this.getDoctors().add(doctor);
    }

    public void addPatient(Patient patient) {
        this.getPatients().add(patient);
    }
}
