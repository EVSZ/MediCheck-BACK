package medicheck.backend.APIs;

import medicheck.backend.DAL.MedicineDAL;
import medicheck.backend.DAL.Repos.MedicineRepo;
import medicheck.backend.Logic.Models.medicine.Medicine;
import medicheck.backend.Logic.Models.medicine.MedicineContainer;
import medicheck.backend.APIs.RequestModels.MedicineModel;
import medicheck.backend.Logic.Models.medicine.MedicineType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medication")
@CrossOrigin
public class MedicationAPI
{
    private final MedicineContainer Medicines;

    public MedicationAPI()
    {
        Medicines = new MedicineContainer(new MedicineDAL());
    }

    @PostMapping(value= "/PostMedicine", consumes = "application/json")
    public void AddMedicine(@RequestBody MedicineModel medicineModel)
    {
        Medicine medicine = new Medicine(
                medicineModel.getId(),
                medicineModel.isHasRule(),
                medicineModel.getRuleID(),
                medicineModel.getDiscription(),
                medicineModel.getName(),
                medicineModel.getMedicineType()
        );

        Medicines.AddMedicine(medicine);
    }

    @DeleteMapping(value= "/DeleteMedicine", consumes = "application/json", produces = "application/json")
    public void DeleteMedicine(@RequestBody MedicineModel medicine)
    {
        //new Medicine(medicine).Delete(Medicinerepo);
    }

    @PutMapping(value="/PutMedicine", consumes="application/json",produces = "application/json")
    public String UpdateMedicine(@RequestBody MedicineModel medicinemodel)
    {
        try{
            //new Medicine(medicinemodel).Update(Medicinerepo);
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
