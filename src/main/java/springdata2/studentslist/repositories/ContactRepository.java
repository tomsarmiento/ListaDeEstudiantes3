package springdata2.studentslist.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springdata2.studentslist.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
}
