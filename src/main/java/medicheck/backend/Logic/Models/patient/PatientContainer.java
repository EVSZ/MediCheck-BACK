package medicheck.backend.Logic.Models.patient;
import medicheck.backend.DAL.Interfaces.IPatientContainer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PatientContainer {

    private List<Patient> patienten = new ArrayList<>();
    IPatientContainer Interface;

    public PatientContainer(IPatientContainer Inter)
    {
        Interface = Inter;
    }

    public Patient GetPatientByUsernameAndPassword(String Username, String Password)
    {
      return new Patient(Interface.GetInlogPatient(Username,Password));
    }

    public Patient GetPatientByNaam(String name){
        for (Patient patient:
             patienten) {
            if(patient.getName().equals(name)) return patient;
        }
        throw new ArithmeticException("De patient is niet gevonden!");
    }
    public Patient GetPatientByID(Long id){
        Patient patient =new Patient(Interface.GetPatient(id));

        if(patient.getHealthInfo().lastclcr!=null)
        {
            return patient;
        }
        return patient;

        //throw new ArithmeticException("De patient is niet gevonden!");

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
            if(patient.getId().equals(element.getId())){
                element.Update();

            }
        }
    }

    public void deletePatient(Patient patient){
        for (Patient element:
             patienten) {
            if(patient.getId().equals(element.getId())){
                element.Delete();
            }
        }
    }

    public List<Patient> GetPatienten(){
        return patienten;
    }
}
