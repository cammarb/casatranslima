package pe.com.casatranslima.service.crud;

import java.util.List;

import pe.com.casatranslima.model.entity.Application;

public interface ApplicationService extends CrudService<Application, Long>{

    public List<Application> findByKeyword(String keyword) throws Exception;
}
