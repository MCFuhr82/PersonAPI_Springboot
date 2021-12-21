package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    //anotação para injetar o PersonRepository para dentro da classe. Pode ser usado o @Autowired com construtor, atributo ou método setter
    // usando dentro do construtor, facilita para criar testes unitários futuramente
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person personSaved = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + personSaved.getId())
                .build();
    }
}
