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
    public String AddPatient(@RequestBody PatientModel patient){
        patienten.SavePatient(new Patient(patient));
        return "YOlo";
    }

    @GetMapping("/get")
    public Patient GetPatiënt()
    {
        LocalDate date = LocalDate.of(2001,6,11);
        return  Patient.builder().id(1).name("Daan").weight(10).length(10).build();
    }
    
    @GetMapping("/getAll")
    public PatientContainer GetPatients(){
        return patienten;
    }
}
