package medicheck.backend.Algoritmiek;

import medicheck.backend.patient.HealthInformation;
import medicheck.backend.Algoritmiek.MedicationRules;
import medicheck.backend.patient.Patient;

public class RuleSelector {

    boolean SelectRule(int rulenumber, Patient patient)
    {
        MedicationRules medicationRules = new MedicationRules();
        switch (rulenumber)
        {
            case 0:
                return false;
            case 1:
                return medicationRules.Rule1(patient.getHealthInfo(), patient.CalculateAge());
            case 2:
                return medicationRules.Rule2(patient.getHealthInfo());

        }
        return false;
    }
}

