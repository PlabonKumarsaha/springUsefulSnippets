package com.era.onetoone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int iid;

    String name;
    String mailId;
    int salary;
}
