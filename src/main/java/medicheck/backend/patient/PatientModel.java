package medicheck.backend.patient;

import lombok.Builder;
import lombok.Getter;
import medicheck.backend.Prescription.Prescription;

import java.time.LocalDate;
import java.util.List;

@Builder @Getter
public class PatientModel
{

    private final long id;

    private final String name;

    private final Integer weight;

    private final Integer height;

    private final Boolean pregnant;

    private final LocalDate birthDate;

    private final String gender;

    private final List<Prescription> UserPrescriptions;

}
