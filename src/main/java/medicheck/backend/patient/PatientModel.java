package medicheck.backend.patient;

import lombok.Builder;
import lombok.Getter;
import medicheck.backend.Prescription.Prescription;

import java.time.LocalDate;
import java.util.List;

@Builder @Getter
public class PatientModel
{
    private Long id;
    private String name;
    private Integer weight;
    private Integer height;
    private Integer Length;
    private Boolean pregnant;
    private LocalDate birthDate;
    private Gender gender;
    private List<Prescription> UserPrescriptions;
}
