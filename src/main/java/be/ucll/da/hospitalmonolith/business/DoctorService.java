package be.ucll.da.hospitalmonolith.business;

import be.ucll.da.hospitalmonolith.persistence.AddressRepository;
import be.ucll.da.hospitalmonolith.persistence.Doctor;
import be.ucll.da.hospitalmonolith.persistence.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DoctorService {

    private DoctorRepository doctorRepository;
    private AddressRepository addressRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, AddressRepository addressRepository) {
        this.doctorRepository = doctorRepository;
        this.addressRepository = addressRepository;
    }

    public Doctor createDoctor(Doctor doctor) {
        doctor.setAddress(addressRepository.save(doctor.getAddress()));
        return doctorRepository.save(doctor);
    }
}
