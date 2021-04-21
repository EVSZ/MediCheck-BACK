package medicheck.backend.DataModels;

import lombok.Setter;
import medicheck.backend.medicine.Medicine;
import medicheck.backend.medicine.MedicineType;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;

@Entity  @Getter @Setter
public class MedicineDataModel
{
    @Id
    @GeneratedValue
    private Long id;
    private String Name;
    private String Discription;

    @Enumerated(EnumType.ORDINAL)
    private MedicineType medicineType;

    public MedicineDataModel() { }
    public MedicineDataModel(Medicine medicine)
    {
        this.id = medicine.getId();
        this.Discription = medicine.getDiscription();
        this.Name = medicine.getName();
        this.medicineType = medicine.getMedicineType();
    }
}
