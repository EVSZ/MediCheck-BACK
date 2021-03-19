package medicheck.backend.Algoritmiek;

import medicheck.backend.medicine.Medicine;
import medicheck.backend.medicine.MedicineContainer;
import medicheck.backend.medicine.MedicineType;
import medicheck.backend.patient.HealthInformation;
import medicheck.backend.patient.HealthInformation;
import medicheck.backend.patient.Patient;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;

public class AdviceGenerator
{
    public boolean advice = false;
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


    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }



}

