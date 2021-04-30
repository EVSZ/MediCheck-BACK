package medicheck.backend.Algoritmiek.Algorithm;

import medicheck.backend.Algoritmiek.Interface.SubRuleContainerInterface;
import medicheck.backend.DTO.SubRuleDTO;

import java.util.ArrayList;
import java.util.List;

public class SubRuleContainer
{
    List<SubRule> SubRules = new ArrayList<>();
    SubRuleContainerInterface Interface;

    public SubRuleContainer(SubRuleContainerInterface Inter)
    {
        Interface = Inter;
    }

    public List<SubRule> GetSubRulesByParentRule(long parentRule)
    {
        List<SubRuleDTO> SubRuleDTO = Interface.GetAllSubRules(parentRule);
        List<SubRule> SubRules = new ArrayList<SubRule>();
        for (SubRuleDTO SubRule: SubRuleDTO)
        {
            SubRules.add(new SubRule(SubRule));
        }
        return SubRules;
    }
}
