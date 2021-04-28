package medicheck.backend.Algoritmiek.Entities;

import lombok.Getter;
import medicheck.backend.Algoritmiek.AlgorithmCommand;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

@Entity @Getter
public class SubRuleEntity
{
    @Id
    @GeneratedValue
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    AlgorithmCommandEntity command;
}
