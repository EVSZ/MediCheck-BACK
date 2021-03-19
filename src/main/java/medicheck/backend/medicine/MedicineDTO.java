package medicheck.backend.medicine;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class MedicineDTO
{
    private Integer id;
    private Integer amount;
    private String name;
    private MedicineType medicineType;
    private List<SideEffect> sideEffectList;
    private Integer doses;
    private LocalDate timePeriod;

    public MedicineDTO(Integer id, Integer amount, String name, MedicineType medicineType, List<SideEffect> sideEffectList, Integer doses, LocalDate timePeriod)
    {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.medicineType = medicineType;
        this.sideEffectList = sideEffectList;
        this.doses = doses;
        this.timePeriod = timePeriod;
    }
    public MedicineDTO(Medicine medicine)
    {
        this.id = medicine.getId();
        this.amount = medicine.getAmount();
        this.name = medicine.getName();
        this.medicineType = medicine.getMedicineType();
        this.sideEffectList = medicine.getSideEffectList();
        this.doses = medicine.getDoses();
        this.timePeriod = medicine.getTimePeriod();
    }
}
