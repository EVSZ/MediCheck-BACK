package medicheck.backend.patient;

import lombok.Builder;
import lombok.Getter;
import medicheck.backend.Prescription.Prescription;

import java.time.LocalDate;
import java.util.List;

@Builder @Getter
public class PatientModel
{

    private final Integer id;

    private final String name;

    private final Integer weight;

    private final Integer length;

    private final Boolean pregnant;

    private final LocalDate birthDate;

    private final Gender gender;

    private final List<Prescription> UserPrescriptions;

}