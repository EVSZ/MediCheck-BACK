package medicheck.backend.APIs;

import medicheck.backend.patient.Gender;
import medicheck.backend.patient.Patient;
import medicheck.backend.patient.PatientContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import medicheck.backend.patient.PatientModel;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("api/patienten")
public class PatientController {

    private PatientContainer patienten;

    @Autowired
    public PatientController(PatientContainer container){
        this.patienten = container;
    }

    @PostMapping(value= "/post", consumes = "application/json")
    public void AddPatient(@RequestBody PatientModel patient){
        patienten.SavePatient(new Patient(patient));
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
        return new Patient(1, "Daan", 10.00, 10.00, false, date, Gender.Male);
    }
}
