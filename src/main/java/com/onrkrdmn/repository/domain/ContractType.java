package com.onrkrdmn.repository.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Contract type entity
 * This class is created, in case of defining new contract on database
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Entity
@Getter
@Setter
public class ContractType extends AbstractEntity {
    private String name;
    private String definition;
}
