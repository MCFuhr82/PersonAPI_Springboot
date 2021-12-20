package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    //anotação para injetar o PersonRepository para dentro da classe. Pode ser usado o @Autowired com construtor, atributo ou método setter
    // usando dentro do construtor, facilita para criar testes unitários futuramente
    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping //anotação POST, usado para criar um novo usuário
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person personSaved = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + personSaved.getId())
                .build();
    }
}
