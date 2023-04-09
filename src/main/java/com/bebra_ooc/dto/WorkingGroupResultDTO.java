package com.bebra_ooc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkingGroupResultDTO {

    private Long id;

    private String date;

    private String objectType;

    private String wording;

    private String term;

    private String responsible;

    private String note;
}
