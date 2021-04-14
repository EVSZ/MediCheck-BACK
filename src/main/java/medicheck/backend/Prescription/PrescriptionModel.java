package medicheck.backend.Prescription;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.medicine.Medicine;

import java.time.LocalDate;

@Getter @Setter
public class PrescriptionModel
{
    private long Id;
    private Medicine medicine;
    private int doses;
    private int receptId;
    private Integer amount;
    private LocalDate TimePeriod;
}
