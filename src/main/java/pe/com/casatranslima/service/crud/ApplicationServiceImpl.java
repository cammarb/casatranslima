package pe.com.casatranslima.service.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.com.casatranslima.model.entity.Application;
import pe.com.casatranslima.model.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService{
    
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public JpaRepository<Application, Long> getRepository(){
        return applicationRepository;
    }

    public List<Application> findByKeyword(String keyword){
        return applicationRepository.findByKeyword(keyword);
    }
}
