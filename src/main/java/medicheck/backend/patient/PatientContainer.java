package medicheck.backend.patient;
import medicheck.backend.DTO.PatientDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PatientContainer {

    private List<Patient> patienten = new ArrayList<>();

    public PatientContainer() {
    }

    public Patient GetPatientByNaam(String name){
        for (Patient patient:
             patienten) {
            if(patient.getName() == name) return patient;
        }
        throw new ArithmeticException("De patient is niet gevonden!");
    }

    public Patient GetPatientByID(Integer id){
        for (Patient patient:
             patienten) {
            if(patient.getId() == id) return patient;
        }
        throw new ArithmeticException("De patient is niet gevonden!");
    }

    public void SavePatient(Patient patient){
        patienten.add(patient);
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
