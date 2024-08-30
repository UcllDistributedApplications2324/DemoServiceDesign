package be.ucll.da.hospitalmonolith.persistence;

import be.ucll.da.hospitalmonolith.business.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {}
