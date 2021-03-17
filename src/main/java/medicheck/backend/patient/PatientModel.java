package medicheck.backend.patient;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
public class PatientModel {
    @Getter
    private Integer id;

    @Getter
    private String name;

    @Getter
    private Double weight;

    @Getter
    private Double length;

    @Getter
    private Boolean pregnant;

    @Getter
    private LocalDate birthDate;

    @Getter
    private Gender gender;

    /*public PatientModel(String naam, Double weight, Double length) {
        this.name = naam;
        this.weight = weight;
        this.length = length;
    }*/


}
