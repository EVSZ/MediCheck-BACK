package medicheck.backend.Algoritmiek;

import com.fasterxml.jackson.core.TSFBuilder;
import jdk.jshell.spi.ExecutionControl;

public class CommandTranslator
{
    private TestPatient patient;
    public CommandTranslator(TestPatient patient)
    {
        this.patient = patient;
    }

    public void TranslateCommand(AlgorithmCommand command){
        if (command.variableType.equals("integer")){
            TranslateVariableInteger(command.variable);
        }
    }

    public int TranslateVariableInteger(String variable)
    {
        switch (variable){
            case "age":
                // code block
                return patient.age;
        }
        return 0;
    }

    public int TranslateConstraint(String constraint){
        switch(constraint){
            case ">":
                return 1;

        }
        return 0;
    }

}
