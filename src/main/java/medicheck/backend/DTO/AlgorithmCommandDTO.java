package medicheck.backend.DTO;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.Algoritmiek.AlgorithmCommand;
import medicheck.backend.Algoritmiek.Entities.AlgorithmCommandEntity;

@Getter @Setter
public class AlgorithmCommandDTO
{
    long ID;
    String variableToCheck;
    String constraint;
    String commandType;
    int valueToCompare;

    public AlgorithmCommandDTO(AlgorithmCommand algorithmCommand)
    {
        ID = algorithmCommand.getID();
        variableToCheck = algorithmCommand.getVariableToCheck();
        constraint = algorithmCommand.getConstraint();
        commandType = algorithmCommand.getCommandType();
        valueToCompare = algorithmCommand.getValueToCompare();
    }
    public AlgorithmCommandDTO(AlgorithmCommandEntity algorithmCommandEntity)
    {
        ID = algorithmCommandEntity.getID();
        variableToCheck = algorithmCommandEntity.getVariableToCheck();
        constraint = algorithmCommandEntity.getRuleConstraint();
        commandType = algorithmCommandEntity.getCommandType();
        valueToCompare = algorithmCommandEntity.getValueToCompare();
    }
}
