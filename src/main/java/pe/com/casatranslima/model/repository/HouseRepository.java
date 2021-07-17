package pe.com.casatranslima.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.casatranslima.model.entity.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    // public List<House> findByName(String name);

    @Query(value = "SELECT * FROM houses WHERE house_name ILIKE %:keyword% OR district ILIKE %:keyword%", nativeQuery = true)
    List<House> findByKeyword(@Param("keyword") String keyword);

    @Query(value = "SELECT * FROM houses WHERE spaces_available > 0", nativeQuery = true)
    List<House> findBySpaces(Integer spaces);

}
