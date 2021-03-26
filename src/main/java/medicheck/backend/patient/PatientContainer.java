package medicheck.backend.patient;
import medicheck.backend.DTO.PatientDTO;
import medicheck.backend.DataModels.PatientDataModel;
import medicheck.backend.Repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PatientContainer {

    private List<Patient> patienten = new ArrayList<>();


    @Autowired
    private PatientRepo repo;


    public PatientContainer() {
    }

    public PatientContainer(PatientRepo repo) {
        this.repo = repo;
    }

    public Patient GetPatientByNaam(String name){
        PatientDataModel patient = new PatientDataModel();
        patient.setName(name);
        Example<PatientDataModel> example = Example.of(patient);
        List<PatientDataModel> output = repo.findAll(example);
        return new Patient(output.get(0));
        //throw new ArithmeticException("De patient is niet gevonden!");
    }

    public Patient GetPatientByID(Long id){
        return new Patient(repo.getOne(id));
    }

    public void SavePatient(PatientModel _patient){
        Patient patient = new Patient(_patient);
        patient.Save(repo);
    }

    public void AddPatient(Patient patient){
        patienten.add(patient);
    }

    public void updatePatient(Patient patient){
        for (Patient element:
             patienten) {
            if(patient.getId() == element.getId()){
                element.Update(patient);

            }
        }
    }

    public void deletePatient(Patient patient){
        for (Patient element:
             patienten) {
            if(patient.getId() == element.getId()){
                element.Delete();
            }
        }
    }

    public List<Patient> GetPatienten(){
        return patienten;
    }
}
