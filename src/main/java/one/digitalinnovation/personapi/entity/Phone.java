package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //anotação para informar que essa classe é uma entidade. Tem que colocar uma chave primária, que no caso será o id.
@Data //com essa anotação, insere automaticamete getter e setter
@Builder
@AllArgsConstructor //anotação para gerar construtor com argumentos
@NoArgsConstructor //anotação para gerar construtor sem argumentos
public class Phone {

    @Id //informando a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //a geração do id será de forma automática
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) //anotação para informar que o campo dessa coluna deve ser obrigatório. É not null
    private PhoneType type;

    @Column(nullable = false) ////anotação para informar que o campo dessa coluna deve ser obrigatório. É not null
    private String number;


}
