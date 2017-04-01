package com.onrkrdmn.repository.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer entity
 * <p>
 * Customer has a unique numeric id, full name and email as fields.
 * </p>
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Entity
@Getter
@Setter
public class Customer extends AbstractEntity {

    private String fullName;

    @Email
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer", targetEntity = Contract.class)
    private List<Contract> contracts;

    @Transient
    public void addContract(Contract contract) {
        if (this.contracts == null) {
            this.contracts = new ArrayList<>();
        }
        this.contracts.add(contract);
    }
}
