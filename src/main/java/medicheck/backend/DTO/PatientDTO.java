package medicheck.backend.DTO;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.patient.Gender;
import medicheck.backend.patient.Patient;

@Getter
@Setter
public class PatientDTO
{
    private long id;
    private String name;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;
    private LocalDate birthDate;
    private Gender gender;

    public PatientDTO(long id, String naam,
                      Integer gewicht, Integer lengte,
                      Boolean zwanger,
                      LocalDate birthDate, Gender gender) {
        this.id = id;
        this.name = naam;
        this.weight = gewicht;
        this.length = lengte;
        this.pregnant = zwanger;
        this.birthDate = birthDate;
        this.gender = gender;
    }


    public PatientDTO(Patient patient)
    {
        this.id = patient.getId();
        this.name = patient.getName();
        this.weight = patient.getWeight();
        this.length = patient.getLength();
        this.pregnant = patient.getPregnant();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
    }
}
