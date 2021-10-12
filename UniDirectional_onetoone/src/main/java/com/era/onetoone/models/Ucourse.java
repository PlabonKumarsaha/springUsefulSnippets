package com.era.onetoone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ucourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int uid;

    String instName;
    String courseName;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Instructor instructor;
}
