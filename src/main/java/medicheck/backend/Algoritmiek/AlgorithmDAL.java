package medicheck.backend.Algoritmiek;

import medicheck.backend.Algoritmiek.Entities.SubRuleEntity;
import medicheck.backend.Algoritmiek.Interface.SubRuleContainerInterface;
import medicheck.backend.DTO.SubRuleDTO;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmDAL implements SubRuleContainerInterface
{
    AlgorithmRepo repo;

    public List<SubRuleDTO> GetAllSubRules(long parentRule)
    {
        List<SubRuleEntity> SubRulesEntitys = repo.FindByParentRule(parentRule);
        List<SubRuleDTO> SubRules = new ArrayList<SubRuleDTO>();
        for (SubRuleEntity SubRule: SubRulesEntitys)
        {
            SubRules.add(new SubRuleDTO(SubRule));
        }
        return SubRules;
    }

}
