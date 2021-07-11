package pe.com.casatranslima.service.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CrudService<T, ID> {

    JpaRepository<T, ID> getRepository();

    @Transactional(readOnly = true)
    default List<T> getAll() throws Exception { // gets all elements
        return getRepository().findAll();
    }

    @Transactional(readOnly = true)
    default Optional<T> findById(ID id) throws Exception { // search by ID
        return getRepository().findById(id);
    }

    @Transactional
    default T create(T entity) throws Exception { // saves the entity (Repository->Database)
        return getRepository().save(entity);
    }

    @Transactional
    default T update(T entity) throws Exception { // Updates the entity (Repository->Database)
        return getRepository().save(entity);
    }

    @Transactional
    default void deleteById(ID id) throws Exception { // Deletes the entity (Repository->Database)
        getRepository().deleteById(id);
    }
}
