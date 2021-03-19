package medicheck.backend.APIs;

import medicheck.backend.medicine.Medicine;
import medicheck.backend.medicine.MedicineContainer;
import medicheck.backend.medicine.MedicineType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/medication")
@CrossOrigin
public class MedicationAPI
{
    private MedicineContainer Medicines;

    @Autowired
    public MedicationAPI(MedicineContainer container) {
        this.Medicines = container;
    }

    @PostMapping(value= "/post", consumes = "application/json", produces = "application/json")
    public String AddPatient(@RequestBody Medicine medicine){
        medicine.SaveMedicine();
        return "Gelukt";
    }

    @GetMapping("/get")
    public Medicine GetMedicine(@RequestBody int MedicineID)
    {
        return  Medicine.builder().id(1).medicineType(MedicineType.Pillen).build();
        //Medicines.GetByID(MedicineID);
    }
    @GetMapping("/getAllByType")
    public List<Medicine> GetMedicinesByType(@RequestBody MedicineType medicineType)
    {
       return  Medicines.GetAllMedicineByType(medicineType);
    }
    @GetMapping("/getAll")
    public MedicineContainer GetMedicines()
    {
        return Medicines;
    }
}
