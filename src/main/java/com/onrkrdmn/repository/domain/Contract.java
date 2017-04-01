package com.onrkrdmn.repository.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Contract entity
 * <p>
 * Contract has a unique numeric id,
 * the id of the Customer it belongs to, a start date, a type and a monthly revenue, as
 * </p>
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Entity
@Getter
@Setter
public class Contract extends AbstractEntity {

    private Date startDate;

    private double monthlyRevenue;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ContractType type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
