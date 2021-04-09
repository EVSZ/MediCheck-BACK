package medicheck.backend.patient;

import lombok.Builder;
import lombok.Getter;
import medicheck.backend.Prescription.Prescription;

import java.time.LocalDate;
import java.util.List;

@Builder @Getter
public class PatientModel
{
<<<<<<< Updated upstream

    private final Integer id;

    private final String name;

    private final Integer weight;

    private final Integer length;

    private final Boolean pregnant;

    private final LocalDate birthDate;

    private final Gender gender;

    private final List<Prescription> UserPrescriptions;

=======
    private long id;
    private String name;
    private Integer weight;
    private Integer height;
    private Boolean pregnant;
    private LocalDate birthDate;
    private String gender;
    private List<Prescription> UserPrescriptions;
>>>>>>> Stashed changes
}
