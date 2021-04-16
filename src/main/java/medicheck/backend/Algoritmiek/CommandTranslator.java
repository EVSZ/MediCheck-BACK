package medicheck.backend.Algoritmiek;

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

    public int TranslateCommandVariableToInteger(String commandVariable, TestPatient patient)
    {
        switch (commandVariable)
        {
            case "clcr":
                return patient.clcr;
            case "lastclcr":
                return CalculateTimeDifference(patient.lastClcr);
            case "age":
                return patient.age;
        }
        return 0;
    }

    public boolean TranslateLogicalTest(String commandVariable, TestPatient patient){
        switch(commandVariable){
            case "isclcrknown":
                return patient.lastClcr != null;
        }
        return false;
    }

    private int CalculateTimeDifference(LocalDate date)
    {
            LocalDate currentDate = LocalDate.now();
            if (date != null) {
                return Period.between(date, currentDate).getYears();
            } else
            {
                return 0;
            }
    }

}
