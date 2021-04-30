package medicheck.backend.Logic.Models.Algorithm;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DTO.AlgorithmCommandDTO;

@Getter @Setter
public class AlgorithmCommand
{
    public long ID;
    public String variableToCheck;
    public String constraint;
    public String commandType;
    public int valueToCompare;

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
    public AlgorithmCommand(AlgorithmCommandDTO command)
    {
        this.variableToCheck = command.getVariableToCheck();
        this.constraint = command.getConstraint();
        this.commandType = command.getCommandType();
        this.valueToCompare = command.getValueToCompare();
    }
}
