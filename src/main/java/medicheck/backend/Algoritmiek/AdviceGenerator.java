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




    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    boolean MedicationCheckRule1(){
        HealthInformation healthInformation = patient.getHealthInfo();
        if (healthInformation.clcr != 0){
            if (healthInformation.monthsSinceLastclcr > 13){
                return true;
            }
            else if (healthInformation.clcr > 30){
                return false;
            }
            else return true;
        }
        else if (patient.CalculateAge() >= 70)
        {
            return true;
        }
        return false;
    }
    boolean MedicationCheckRule2(){
        HealthInformation healthInformation = patient.getHealthInfo();
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