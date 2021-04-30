package medicheck.backend.Algoritmiek;

<<<<<<< Updated upstream
import medicheck.backend.medicine.Medicine;
import medicheck.backend.patient.Patient;
import medicheck.backend.patient.PatientModel;
=======
import medicheck.backend.APIs.RequestModels.PatientModel;
import medicheck.backend.Logic.Models.Algorithm.AlgorithmCommand;
>>>>>>> Stashed changes

import java.util.ArrayList;
import java.util.List;

public class AdviceGenerator
{
    private Patient patient;
    public boolean GenerateAdvice(Patient patientInput)
    {
        /*setPatient(patientInput);
        List<Integer> rulesToCheck = CheckIfMedicationContainsRisks(patient.getMedication());
        RuleSelector selector = new RuleSelector();
        for (Integer integer : rulesToCheck)
        {
            if (selector.SelectRule(integer,patient))
            {
                return true;
            }


        }*/
        return false;

    }

    List<Integer> CheckIfMedicationContainsRules(List<Medicine> medication)
    {
        List<Integer>RulesToCheck = new ArrayList<>();
        for (Medicine medicine: medication)
        {
            if (medicine.getName().equals("nitrofurantoïne")||medicine.getName().equals("norfloxacine")||medicine.getName().equals("cotrimoxazol")){
                RulesToCheck.add(1);
            }

        }
        return RulesToCheck;
    }

    public String GetAdvice(PatientModel patient)
    {
        String advice = "";

        return advice;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }



}

