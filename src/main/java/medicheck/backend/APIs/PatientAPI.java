package medicheck.backend.APIs;

import medicheck.backend.Converters.PatientConverter;
import medicheck.backend.Logic.Models.patient.Patient;
import medicheck.backend.Logic.Models.patient.PatientContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import medicheck.backend.APIs.RequestModels.PatientModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
            return "Patient is Geupdated!";
        } catch (Exception e)
        {
            return "Oops! Er is iets foutgegaan!";
        }
    }

//    @GetMapping(value = "/patient", produces = "application/json")
//    public PatientModel GetPatientById(HttpServletRequest request)
//    {
//        return converter.convertToRequestModel(Patients.GetPatientByID((long)request.getSession().getAttribute("patientId")));
//    }
    @GetMapping(value = "/patient", produces = "application/json")
    public PatientModel GetPatientById()
    {
        return converter.convertToRequestModel(Patients.GetPatientByID((long)5));
    }

    @GetMapping(value = "/get/{name}", consumes = "application/json", produces = "application/json")
    public PatientModel GetPatientByName(@PathVariable String name)
    {
        return converter.convertToRequestModel(Patients.GetPatientByNaam(name));
    }

}
