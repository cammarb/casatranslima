package pe.com.casatranslima.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.casatranslima.model.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{
    @Query(value = "SELECT * FROM applications WHERE house_name ILIKE %:keyword% OR status ILIKE %:keyword%", nativeQuery = true)
    List<Application> findByKeyword(@Param("keyword") String keyword);
}
