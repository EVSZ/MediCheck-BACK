package medicheck.backend.medicine;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.Repos.MedicineRepo;
import medicheck.backend.Converters.MedicineConverter;
import medicheck.backend.DataModels.MedicineDataModel;

@Getter @Setter
public class Medicine
{
    private Long id;
    private boolean hasRule;
    private Long ruleID;
    private String name;
    private String Discription;
    private MedicineType medicineType;
    private MedicineConverter converter = new MedicineConverter();

    public Medicine(Long id, String discription, String name, MedicineType medicineType)
    {
        this.id = id;
        this.name = name;
        Discription = discription;
        this.medicineType = medicineType;
    }
    public Medicine(String discription, String name, MedicineType medicineType)
    {
        this.name = name;
        Discription = discription;
        this.medicineType = medicineType;
    }

    public Medicine(MedicineDataModel medicinedto)
    {
        this.id = medicinedto.getId();
        this.name = medicinedto.getName();
        Discription = medicinedto.getDiscription();
        this.medicineType = medicinedto.getMedicineType();
    }

    public Medicine(MedicineModel medicine)
    {
        this.id = medicine.getId();
        this.name = medicine.getName();
        Discription = medicine.getDiscription();
        this.medicineType = medicine.getMedicineType();
    }

    public void Save(MedicineRepo repo)
    {
        repo.save(converter.convertToDataModel(this));
    }
    public void Delete(MedicineRepo repo)
    {
        repo.delete(converter.convertToDataModel(this));
    }
    public void Update(MedicineRepo repo)
    {
        repo.findById(this.id);
        repo.save(converter.convertToDataModel(this));
    }
}
