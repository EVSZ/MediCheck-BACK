package medicheck.backend.DTO;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.Algoritmiek.Entities.SubRuleEntity;
import medicheck.backend.Algoritmiek.Algorithm.SubRule;

@Getter @Setter
public class SubRuleDTO
{
    long ID;
    int parentRule;
    int ruleNumber;
    int ifTrue;
    int ifFalse;
    boolean hasResult;
    boolean result;
    AlgorithmCommandDTO Command;

    public SubRuleDTO(SubRule subRule)
    {
        ID = subRule.getID();
        parentRule = subRule.getParentRule();
        ruleNumber = subRule.getRuleNumber();
        ifTrue = subRule.getIfTrue();
        ifFalse = subRule.getIfFalse();
        hasResult = subRule.isResult();
        result = subRule.isResult();
        Command = new AlgorithmCommandDTO(subRule.getCommand());
    }
    public SubRuleDTO(SubRuleEntity subRuleEntity)
    {
        ID = subRuleEntity.getID();
        parentRule = subRuleEntity.getParentRule();
        ruleNumber = subRuleEntity.getRuleNumber();
        ifTrue = subRuleEntity.getIfTrue();
        ifFalse = subRuleEntity.getIfFalse();
        hasResult = subRuleEntity.isHasResult();
        result = subRuleEntity.isResult();
        Command = new AlgorithmCommandDTO(subRuleEntity.getCommand());
    }
}
