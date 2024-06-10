package homework.buy.controller;

import homework.buy.model.Person;
import homework.buy.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    private PersonService service;

    @GetMapping("/persons")
    private List<Person> getAllPersons(){
        return service.getAllPersons();
    }

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        service.addPerson(person);
    }
}
