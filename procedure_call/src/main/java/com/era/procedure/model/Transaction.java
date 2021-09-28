package com.era.procedure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    Customer senderId;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    Customer recieverId;
    float amount;
}
