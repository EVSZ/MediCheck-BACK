package medicheck.backend.APIs;

import medicheck.backend.Logic.Models.Prescription.Prescription;
import medicheck.backend.Logic.Models.Prescription.PrescriptionContainer;
import medicheck.backend.APIs.RequestModels.PrescriptionModel;
import medicheck.backend.DAL.Repos.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prescription")
@CrossOrigin
public class PrescriptionAPI
{
    private PrescriptionContainer Prescriptions = new PrescriptionContainer();
    private PrescriptionRepo Repo;

    @Autowired
    public PrescriptionAPI() { this.Prescriptions = new PrescriptionContainer(); }

//    @PostMapping(value= "/PostPrescription", consumes = "application/json", produces = "application/json")
//    public void AddMedicine(@RequestBody PrescriptionModel prescription)
//    {
//        new Prescription(prescription).Save(Repo);
//    }
//
//    @DeleteMapping(value= "/DeletePrescription", consumes = "application/json", produces = "application/json")
//    public void DeleteMedicine(@RequestBody PrescriptionModel prescription)
//    {
//        new Prescription(prescription).Delete(Repo);
//    }
//
//    @PutMapping(value="/PutPrescription", consumes="application/json",produces = "application/json")
//    public void UpdateMedicine(@RequestBody PrescriptionModel prescription)
//    {
//        new Prescription(prescription).Update(Repo);
//    }
    @GetMapping("/getByID")
    public Prescription GetPrescription(@RequestBody long ID)
    {
        return Prescriptions.GetPrescriptionById(ID);
    }

    @GetMapping("/getByPatientID")
    public List<Prescription> GetPrescriptionByPatientID(@RequestBody long PatientID)
    {
        return Prescriptions.GetPrescriptionByPatientID(PatientID);
    }

    @GetMapping("/getByMedicineID")
    public List<Prescription> GetPrescriptionByMedicineID(@RequestBody long MedicineID)
    {
        return Prescriptions.GetPrescriptionByMedicineID(MedicineID);
    }

    @GetMapping("/getAll")
    public List<Prescription> GetPrescriptions()
    {
        return Prescriptions.GetPrescriptions();
    }

}
