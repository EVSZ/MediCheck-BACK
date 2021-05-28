package medicheck.backend.APIs;

import medicheck.backend.Converters.PatientConverter;
import medicheck.backend.Logic.Models.patient.Patient;
import medicheck.backend.Logic.Models.patient.PatientContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import medicheck.backend.APIs.RequestModels.PatientModel;


@RestController
@RequestMapping("api/patienten")
@CrossOrigin
public class PatientAPI
{

    private final PatientContainer Patients;
    private PatientConverter converter = new PatientConverter();

    @Autowired
    public PatientAPI(PatientContainer container)
    {
        this.Patients = container;
    }

    @PostMapping(value = "/post", consumes = "application/json", produces = "application/json")
    public String AddPatient(@RequestBody PatientModel patient)
    {
        try
        {
            Patients.SavePatient(new Patient(patient));
            return "Patient is toegevoegd!";
        } catch (Exception e)
        {
            return "Oops! Er is iets foutgegaan!";
        }
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public String UpdatePatient(@RequestBody PatientModel patient)
    {
        try
        {
            Patients.updatePatient(new Patient(patient));
            return "Patient is toegevoegd!";
        } catch (Exception e)
        {
            return "Oops! Er is iets foutgegaan!";
        }
    }


    @GetMapping(value = "/get/{id}", consumes = "application/json", produces = "application/json")
    public PatientModel GetPatiëntById(@PathVariable long id)
    {
        return converter.convertToRequestModel(Patients.GetPatientByID(id));
    }

    @GetMapping(value = "/get/{name}", consumes = "application/json", produces = "application/json")
    public PatientModel GetPatientByName(@PathVariable String name)
    {
        return converter.convertToRequestModel(Patients.GetPatientByNaam(name));
    }

}
