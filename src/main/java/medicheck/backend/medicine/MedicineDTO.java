package medicheck.backend.medicine;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class MedicineDTO
{
    private long id;
    private String name;
    private String Discription;
    private MedicineType medicineType;

    public MedicineDTO(Integer id, String discription, String name, MedicineType medicineType)
    {
        this.id = id;
        this.name = name;
        this.Discription = discription;
        this.medicineType = medicineType;;
    }
    public MedicineDTO(Medicine medicine)
    {
        this.id = medicine.getId();
        this.name = medicine.getName();
        this.Discription = medicine.getDiscription();
        this.medicineType = medicine.getMedicineType();
    }
}
