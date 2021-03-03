package medicheck.backend.Algoritmiek;

import medicheck.backend.Medicine.Medicine;
import medicheck.backend.Medicine.MedicineContainer;
import medicheck.backend.Medicine.MedicineType;
import medicheck.backend.Patiënt.HealthInformation;
import medicheck.backend.Patiënt.Patiënt;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;

public class AdviceGenerator
{
    public boolean advice = false;
    private Patiënt patient;
    public boolean GenerateAdvice(Patiënt patientInput)
    {
        setPatient(patientInput);
        List<Integer> rulesToCheck = CheckIfMedicationContainsRisks(patient.getMedication());
        for (Integer integer : rulesToCheck)
        {
            if (SelectRule(integer))
            {
                return true;
            }

        }
        return false;

    }

    List<Integer> CheckIfMedicationContainsRisks(List<Medicine> medication)
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

    boolean SelectRule(int rulenumber)
    {
        switch (rulenumber)
        {
            case 0:
                return false;
            case 1:
                return MedicationCheckRule1();
            case 2:
                return MedicationCheckRule2();

        }
        return false;
    }




    public Patiënt getPatient() {
        return patient;
    }

    public void setPatient(Patiënt patient) {
        this.patient = patient;
    }
    boolean MedicationCheckRule1(){
        HealthInformation healthInformation = patient.getHealthinfo();
        if (healthInformation.clcr != 0){
            if (healthInformation.monthsSinceLastclcr > 13){
                return true;
            }
            else if (healthInformation.clcr > 30){
                return false;
            }
            else return true;
        }
        else if (patient.CalculcateAge() >= 70)
        {
            return true;
        }
        return false;
    }
    boolean MedicationCheckRule2(){
        HealthInformation healthInformation = patient.getHealthinfo();
        if(LaxansCheck()){
            return false;
        }
        return true;

    }

    boolean LaxansCheck(){
//        if (patient.getMedication().contains("Laxans")){
//            return true;
//        }
        return false;
    }
    boolean LoperamideCheck(){
        //        if (patient.getMedication().contains("Loperamide")){
//            return true;
//        }
        return false;

    }
}