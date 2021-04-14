package medicheck.backend.APIs;

import medicheck.backend.patient.Patient;
import medicheck.backend.patient.PatientContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import medicheck.backend.patient.PatientModel;

import java.time.LocalDate;


@RestController
@RequestMapping("api/patienten")
@CrossOrigin
public class PatientAPI {

    private final PatientContainer Patients;

    @Autowired
    public PatientAPI(PatientContainer container){
        this.Patients = container;
    }

    @PostMapping(value= "/post", consumes = "application/json", produces = "application/json")
    public String AddPatient(@RequestBody PatientModel patient) {
        try {
            Patients.SavePatient(new Patient(patient));
            return "Patient is toegevoegd!";
        } catch (Exception e) {
            return "Oops! Er is iets foutgegaan!";
        }
    }

    @PutMapping(value="/update", consumes="application/json",produces = "application/json")
    public String UpdatePatient(@RequestBody PatientModel patient){
        try{
            Patients.updatePatient(new Patient(patient));
            return "Patient is toegevoegd!";
        }
        catch(Exception e){
            return "Oops! Er is iets foutgegaan!";
        }
    }

    @GetMapping("/get")
    public Patient GetPatiënt()
    {
        LocalDate date = LocalDate.of(2001,6,11);
        return  Patient.builder().id(1).name("Daan").weight(10).length(10).build();
    }
    
    @GetMapping("/getAll")
    public PatientContainer GetPatients(){

    @GetMapping(value="/get/{id}",consumes = "application/json", produces = "application/json")
    public Patient GetPatiëntById(@PathVariable long id)
    {
        return Patients.GetPatientByID(id);
    }

    @GetMapping(value="/get/{name}",consumes = "application/json", produces = "application/json")
    public Patient GetPatientByName(@PathVariable String name)
    {
        return Patients.GetPatientByNaam(name);
    }

    @GetMapping(value="/getAll",consumes = "application/json", produces = "application/json")
    public PatientContainer GetPatients()
    {
        return Patients;
    }
}
