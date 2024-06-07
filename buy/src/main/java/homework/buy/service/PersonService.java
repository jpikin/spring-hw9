package homework.buy.service;

import homework.buy.model.Person;
import homework.buy.repository.PersonRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepo personRepo;

    public List<Person> getAllPersons(){
        return personRepo.findAll();
    }
    public void addPerson(Person person){
        personRepo.save(person);
    }

    public Person findPersonById(Long id) {
        Optional<Person> optionalPerson = personRepo.findById(id);
        return optionalPerson.orElse(null);
    }
}
