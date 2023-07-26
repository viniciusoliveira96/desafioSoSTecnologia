package com.company.api.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Random;

@Table(name = "patrimonios")
@Entity(name = "patrimonios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patrimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    private String nome;

    private String descricao;

    @NotNull
    private Long marcaId;

    @NotNull(message = "Tombo não deve ser nulo")
    private Long numTombo;

    public Long geradorNumTombo(){
        Random random = new Random();
        return random.nextLong();
    }
}
