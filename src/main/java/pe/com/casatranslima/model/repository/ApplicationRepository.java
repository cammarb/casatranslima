package pe.com.casatranslima.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.casatranslima.model.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{
    
}
