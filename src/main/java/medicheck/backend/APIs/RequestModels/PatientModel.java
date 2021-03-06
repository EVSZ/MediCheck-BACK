package medicheck.backend.APIs.RequestModels;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.Logic.Models.Prescription.Prescription;
import medicheck.backend.Logic.Models.patient.Gender;
import medicheck.backend.Logic.Models.patient.HealthInformation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class PatientModel
{
    private Long userid;
    private String name;
    private Integer weight;
    private Integer height;
    private Integer Length;
    private Boolean pregnant;
    private LocalDate birthDate;
    private Gender gender;
    private HealthInformation healthInformation;
    private List<Prescription> userPrescriptions = new ArrayList<>();

    public PatientModel(){

    }


}
