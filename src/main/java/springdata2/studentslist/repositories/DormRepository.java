package springdata2.studentslist.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springdata2.studentslist.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {
	Dorm findByid(Long id);
}
