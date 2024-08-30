package be.ucll.da.hospitalmonolith.persistence;

import be.ucll.da.hospitalmonolith.business.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {}
