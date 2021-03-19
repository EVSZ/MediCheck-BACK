package medicheck.backend.medicine;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.medicine.MedicineType;
import medicheck.backend.patient.Patient;

import java.util.List;

@Getter @Setter @Builder
public class Medicine {

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private Integer amount;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private MedicineType medicineType;

    @Getter @Setter
    private List<SideEffect> sideEffectList;

    @Getter @Setter
    private Integer doses;

    @Getter @Setter
    private LocalDate timePeriod;


    public Medicine(Integer id, Integer amount, String name, MedicineType medicineType, List<SideEffect> sideEffectList,
                    LocalDate timePeriod) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.medicineType = medicineType;
        this.sideEffectList = sideEffectList;
        this.timePeriod = timePeriod;
    }

    public Medicine(Integer amount, String name, MedicineType medicineType, List<SideEffect> sideEffectList,
                    LocalDate timePeriod) {
        this.amount = amount;
        this.name = name;
        this.medicineType = medicineType;
        this.sideEffectList = sideEffectList;
        this.timePeriod = timePeriod;
    }

    public Medicine(MedicineDTO medicine)
    {
        this.id = medicine.getId();
        this.amount = medicine.getAmount();
        this.name = medicine.getName();
        this.medicineType = medicine.getMedicineType();
        this.sideEffectList = medicine.getSideEffectList();
        this.timePeriod = medicine.getTimePeriod();
    }
    public void SaveMedicine() { }
}
