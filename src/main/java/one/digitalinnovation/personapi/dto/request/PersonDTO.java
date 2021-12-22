package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty //Anotação que diz que o o campo não pode ser nulo
    @Size(min = 2, max = 100) //anotação para informar o tamanho máximo e mínimo
    private String firstName;

    @NotEmpty //Anotação que diz que o o campo não pode ser nulo
    @Size(min = 2, max = 100) //anotação para informar o tamanho máximo e mínimo
    private String lastName;

    @NotEmpty //Anotação que diz que o o campo não pode ser nulo
    @CPF //Anotação para validar o CPF no formato brasileiro
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty //Anotação que diz que o o campo não pode ser nulo
    private List<PhoneDTO> phones;
}
