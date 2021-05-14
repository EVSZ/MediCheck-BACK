package medicheck.backend.DAL.ListConverters;

import medicheck.backend.Algoritmiek.Entities.SubRuleEntity;
import medicheck.backend.DAL.DataModels.MedicineDataModel;
import medicheck.backend.DTO.MedicineDTO;
import medicheck.backend.DTO.SubRuleDTO;

import java.util.ArrayList;
import java.util.List;

public class SubRuleEntityListTOSubRuleDTOList
{
    public List<SubRuleDTO> ConvertListSubRuleToListSubRuleDTO(List<SubRuleEntity> subRuleEntities)
    {
        List<SubRuleDTO> SubRuleDTOs = new ArrayList<SubRuleDTO>();
        for(SubRuleEntity subrule: subRuleEntities)
        {
            SubRuleDTOs.add(new SubRuleDTO(subrule));
        }
        return SubRuleDTOs;
    }
}
