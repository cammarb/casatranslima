package pe.com.casatranslima.service.crud;

import java.util.List;

import pe.com.casatranslima.model.entity.House;

public interface HouseService extends CrudService<House, Long> {

    // public List<House> findByName(String name) throws Exception;
    
    public List<House> findByKeyword(String keyword) throws Exception;
}
