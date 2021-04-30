package medicheck.backend.Algoritmiek.Entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity @Getter
public class AlgorithmCommandEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long ID;

    @Column
    String variableToCheck;

    @Column
    String ruleConstraint;

    @Column(nullable = false)
    String commandType;

    @Column
    int valueToCompare;

    @OneToMany(mappedBy = "Command")
    List<SubRuleEntity> subRuleEntityList;
}
