package medicheck.backend.Algoritmiek;

public class AlgorithmCommand
{
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
