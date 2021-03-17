package medicheck.backend.patient;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DTO.PatientDTO;
import medicheck.backend.medicine.Medicine;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
@Builder
@Getter
@Setter
public class Patient {
    private Integer id;
    private String name;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;
    private LocalDate birthDate;
    private Gender gender;

    public Patient(PatientDTO patient) {
        this.name = patient.getName();
        this.weight = patient.getWeight();
        this.length = patient.getLength();
        this.pregnant = patient.getPregnant();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
    }

    public Patient(PatientModel patient) {
        this.name = patient.getName();
        this.weight = patient.getWeight();
        this.length = patient.getLength();

    }


    public Integer CalculateAge() {
        LocalDate currentDate = LocalDate.now();
        if (birthDate != null) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
