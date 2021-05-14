package medicheck.backend.Algoritmiek;

import medicheck.backend.Logic.Models.patient.Patient;

import java.time.LocalDate;
import java.time.Period;

public class CommandTranslator
{
    public int TranslateCommandType(String commandType)
    {
        switch (commandType)
        {
            case "integer":
                return 1;
            case "boolean":
                return 2;
        }
        return 0;
    }

    public int TranslateConstraint(String commandConstraint){
        switch (commandConstraint){
            case">": return 1;
            case "<": return 2;
        }
        return 0;
    }

    public int TranslateCommandVariableToInteger(String commandVariable, Patient patient)
    {
        switch (commandVariable)
        {
            case "clcr":
                return patient.getHealthInfo().clcr;
            case "lastclcr":
                return CalculateTimeDifference(patient.getHealthInfo().lastclcr);
            case "age":
                return patient.getAge();
        }
        return 0;
    }

    public boolean TranslateLogicalTest(String commandVariable, Patient patient){
        switch(commandVariable)
        {

            case "isclcrknown":
                return patient.getHealthInfo().lastclcr != null;
        }
        return false;
    }

    private int CalculateTimeDifference(LocalDate date)
    {
            LocalDate currentDate = LocalDate.now();
            if (date != null) {
                return (Period.between(date,currentDate).getYears()*12) + Period.between(date, currentDate).getMonths();
            } else
            {
                return 0;
            }
    }

}
