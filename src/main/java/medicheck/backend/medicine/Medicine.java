package medicheck.backend.medicine;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
<<<<<<< Updated upstream
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
=======
import medicheck.backend.Converters.MedicineConverter;
import medicheck.backend.DataModels.MedicineDataModel;
import medicheck.backend.Repos.MedicineRepo;

@Getter @Setter @Builder
public class Medicine
{
    private Long id;
>>>>>>> Stashed changes
    private String name;
    private String Discription;
    private MedicineType medicineType;
    private MedicineConverter converter = new MedicineConverter();

<<<<<<< Updated upstream
    @Getter @Setter
    private List<SideEffect> sideEffectList;

    @Getter @Setter
    private Integer doses;

    @Getter @Setter
    private LocalDate timePeriod;

=======
    public Medicine(Long id, String discription, String name, MedicineType medicineType)
    {
        this.id = id;
        this.name = name;
        Discription = discription;
        this.medicineType = medicineType;
    }
>>>>>>> Stashed changes

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
