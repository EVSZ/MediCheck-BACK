package medicheck.backend.Algoritmiek;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlgorithmCommand
{
    long ID;
    String variableToCheck;
    String constraint;
    String commandType;
    int valueToCompare;

    public AlgorithmCommand(String commandType, String variableToCheck){
        this.variableToCheck = variableToCheck;
        this.commandType = commandType;
    }
    public AlgorithmCommand(String commandType, String variableToCheck, String constraint,  int valueToCompare)
    {

            this.variableToCheck = variableToCheck;
            this.constraint = constraint;
            this.commandType = commandType;
            this.valueToCompare = valueToCompare;



    }
}
