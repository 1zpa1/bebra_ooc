package com.bebra_ooc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "workingGroupResult")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkingGroupResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "objectType")
    private String objectType;

    @Column(name = "wording")
    private String wording;

    @Column(name = "term")
    private String term;

    @Column(name = "responsible")
    private String responsible;

    @Column(name = "note")
    private String note;

}
