package medicheck.backend.APIs;

import medicheck.backend.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public String AddPatient(@RequestBody PatientModel patient){
        try
        {
            patienten.SavePatient(new Patient(patient));
            return "Patient is toegevoegd!";
        }
        catch(Exception e){
            return "Oops! Er is iets foutgegaan!";
        }

    }

    @PutMapping(value="/update", consumes="application/json")
    public String UpdatePatient(@RequestBody PatientModel patient){
        try{
            patienten.updatePatient(new Patient(patient));
            return "Patient is toegevoegd!";
        }
        catch(Exception e){
            return "Oops! Er is iets foutgegaan!";
        }
    }
    /*public void AddPatiënt(Integer id){
        patiënten.SavePatiënt(new Patiënt(id));
    }*/

    /*@GetMapping("/get")
    public List<Patient> GetPatient(){
        return patienten.GetPatienten();
    }*/
    @GetMapping("/get")
    public Patient GetPatiënt(){
        LocalDate date = LocalDate.of(2001,6,11);
        return  Patient.builder().id(1).name("Daan").weight(10).length(10).build();


    }
    
    @GetMapping("/getAll")
    public PatientContainer GetPatients(){
        return patienten;
    }

}
