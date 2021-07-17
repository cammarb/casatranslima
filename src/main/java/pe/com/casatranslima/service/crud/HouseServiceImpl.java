package pe.com.casatranslima.service.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.casatranslima.model.entity.House;
import pe.com.casatranslima.model.repository.HouseRepository;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public JpaRepository<House, Long> getRepository() {
        return houseRepository;
    }

    // @Transactional(readOnly = true)
    // @Override
    // public List<House> findByName(String name) throws Exception {
    //     return houseRepository.findByName(name);
    // }

    public List<House> findByKeyword(String keyword){
        return houseRepository.findByKeyword(keyword);
    }

    public List<House> findBySpaces(Integer spaces){
        return houseRepository.findBySpaces(spaces);
    }    
}
