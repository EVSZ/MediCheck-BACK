package medicheck.backend.APIs;

import medicheck.backend.patient.Patient;
import medicheck.backend.patient.PatientContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import medicheck.backend.patient.PatientModel;


import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("api/patienten")
@CrossOrigin
public class PatientAPI {

    private PatientContainer patienten;

    @Autowired
    public PatientAPI(PatientContainer container){
        this.patienten = container;
    }

    @PostMapping(value= "/post", consumes = "application/json", produces = "application/json")
    public String AddPatient(@RequestBody PatientModel patient) {
            patienten.SavePatient(patient);
            return "Patient is toegevoegd!";
    }

    @PutMapping(value="/update", consumes="application/json")
    public String UpdatePatient(@RequestBody PatientModel patient){
        try{
            patienten.updatePatient(patient);
            return "Patient is toegevoegd!";
        }
        catch(Exception e){
            return "Oops! Er is iets foutgegaan!";
        }
    }
    
    @GetMapping("/get/{id}")
    public Patient GetPatiëntById(@PathVariable long id)
    {
        return patienten.GetPatientByID(id);
    }

    @GetMapping("/get/{name}")
    public Patient GetPatientByName(@PathVariable String name){
        return patienten.GetPatientByNaam(name);
    }
    @GetMapping("/getAll")
    public PatientContainer GetPatients(){
        return patienten;
    }
}
