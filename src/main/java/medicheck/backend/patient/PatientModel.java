package medicheck.backend.patient;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class PatientModel {

    private Integer id;

    private String name;

    private Integer weight;

    private Integer length;

    private Boolean pregnant;

    private LocalDate birthDate;

    private Gender gender;

    /*public PatientModel(String naam, Double weight, Double length) {
        this.name = naam;
        this.weight = weight;
        this.length = length;
    }*/


}
