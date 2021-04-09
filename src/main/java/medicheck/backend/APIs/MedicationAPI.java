package medicheck.backend.APIs;

import medicheck.backend.Repos.MedicineRepo;
import medicheck.backend.medicine.Medicine;
import medicheck.backend.medicine.MedicineContainer;
import medicheck.backend.medicine.MedicineModel;
import medicheck.backend.medicine.MedicineType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medication")
@CrossOrigin
public class MedicationAPI
{
    private final MedicineContainer Medicines;
    private MedicineRepo Medicinerepo;

    @Autowired
    public MedicationAPI(MedicineContainer container) {
        this.Medicines = container;
    }

    @PostMapping(value= "/PostMedicine", consumes = "application/json", produces = "application/json")
    public String AddMedicine(@RequestBody MedicineModel medicine){
        new Medicine(medicine).Save(Medicinerepo);
        return "Gelukt";
    }

    @DeleteMapping(value= "/DeleteMedicine", consumes = "application/json", produces = "application/json")
    public String DeleteMedicine(@RequestBody MedicineModel medicine){
        new Medicine(medicine).Save(Medicinerepo);
        return "Gelukt";
    }

    @PutMapping(value="/PutMedicine", consumes="application/json",produces = "application/json")
    public String UpdateMedicine(@RequestBody MedicineModel medicinemodel)
    {
        try{
            new Medicine(medicinemodel).Update(Medicinerepo);
            return "Patient is toegevoegd!";
        }
        catch(Exception e){
            return "Oops! Er is iets foutgegaan!";
        }
    }
    @GetMapping("/getByID")
    public Medicine GetMedicine(@RequestBody long MedicineID)
    {
       return Medicines.GetByID(MedicineID);
    }

    @GetMapping("/getAllByType")
    public List<Medicine> GetMedicinesByType(@RequestBody MedicineType medicineType)
    {
       return Medicines.GetAllMedicineByType(medicineType);
    }

    @GetMapping("/getAll")
    public List<Medicine> GetMedicines()
    {
        return Medicines.GetAllMedicines();
    }

}
