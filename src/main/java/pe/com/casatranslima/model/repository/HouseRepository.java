package pe.com.casatranslima.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.casatranslima.model.entity.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    public List<House> findByName(String name);

}
