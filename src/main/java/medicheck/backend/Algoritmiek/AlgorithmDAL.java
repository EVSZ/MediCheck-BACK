package medicheck.backend.Algoritmiek;

import medicheck.backend.Algoritmiek.Entities.SubRuleEntity;
import medicheck.backend.Algoritmiek.Interface.SubRuleContainerInterface;
import medicheck.backend.DAL.ListConverters.SubRuleEntityListTOSubRuleDTOList;
import medicheck.backend.DTO.SubRuleDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class AlgorithmDAL implements SubRuleContainerInterface
{
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("MediCheck-BACK");
    EntityTransaction transaction;
    EntityManager manager  = factory.createEntityManager();

    public List<SubRuleDTO> GetAllSubRules(Long parentRule)
    {
        manager = factory.createEntityManager();
        String query = "SELECT subrule FROM SubRuleEntity subrule WHERE subrule.parentRule = :id";
        SubRuleEntityListTOSubRuleDTOList ListConverter = new SubRuleEntityListTOSubRuleDTOList();

        TypedQuery<SubRuleEntity> tq = manager.createQuery(query, SubRuleEntity.class);
        tq.setParameter("id",parentRule.intValue());
        try
        {
            return ListConverter.ConvertListSubRuleToListSubRuleDTO(tq.getResultList());
        }
        catch (NoResultException ex)
        {
            System.out.println("ex");
            return null;
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
        }
    }

}
