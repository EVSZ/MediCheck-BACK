package medicheck.backend.Algoritmiek.Entities;

import lombok.Getter;
import medicheck.backend.Algoritmiek.AlgorithmCommand;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

@Entity @Getter
@NamedNativeQuery(
        name="SubRuleEntity.FindByParentRule",
        query = "SELECT * FROM sub_rule_entity WHERE parentRule = ?",
        resultClass = SubRuleEntity.class
)
public class SubRuleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long ID;

    @Column(nullable = false)
    int parentRule;

    @Column(nullable = false)
    int ruleNumber;

    @Column
    int ifTrue;

    @Column
    int ifFalse;

    @Column(nullable = false)
    boolean isResult;

    @Column
    boolean result;

    @ManyToOne
    @JoinColumn
    AlgorithmCommandEntity Command;
}
