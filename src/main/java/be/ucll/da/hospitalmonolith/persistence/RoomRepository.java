package be.ucll.da.hospitalmonolith.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends CrudRepository<Room, Long> {

    @Modifying
    @Query(value = "INSERT INTO ROOM(HOSPITAL_ID) VALUES(:hospitalId)", nativeQuery = true)
    public void createNewRoom(@Param("hospitalId") Long hospitalId);
}
