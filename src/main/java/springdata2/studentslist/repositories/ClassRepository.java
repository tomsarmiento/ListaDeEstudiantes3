package springdata2.studentslist.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springdata2.studentslist.models.Class;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long> {
	
}
