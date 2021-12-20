package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity //anotação para informar que essa classe é uma entidade. Tem que colocar uma chave primária, que no caso será o id.
@Data //com essa anotação, insere automaticamete getter e setter
@Builder
@AllArgsConstructor //anotação para gerar construtor com argumentos
@NoArgsConstructor //anotação para gerar construtor sem argumentos
public class Person {

    @Id //informando a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //a geração do id será de forma automática
    private Long id;

    @Column(nullable = false) //anotação para informar que o campo dessa coluna deve ser obrigatório. É not null
    private String firstName;

    @Column(nullable = false) //anotação para informar que o campo dessa coluna deve ser obrigatório. É not null
    private String lastName;

    @Column(nullable = false, unique = true) //unique serve para dizer que o campo é um valor único. Não pode ter CPF repetido.
    private String cpf;

    private LocalDate birthDate;

    /* O JPA também possibilita fazer a anotação de relacionamento entre as tabelas.
    No caso, será o relacionamento de um para muitos, com a anotação @OneToMany
    */
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}
