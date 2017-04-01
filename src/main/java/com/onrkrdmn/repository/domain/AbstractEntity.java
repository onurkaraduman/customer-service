package com.onrkrdmn.repository.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Abstract implementation of {@link Entity}
 * All persistent object should be extend from {@link AbstractEntity}
 *
 * @author Onur Karaduman
 * @since 01.04.17.
 */
@MappedSuperclass
@Getter
@Setter
@Log4j
public abstract class AbstractEntity implements Entity {

    @Id
    @GeneratedValue
    private Long id;

    @Transient
    public Object clone() {
        Object clonedObject = null;

        try {
            clonedObject = super.clone();
        } catch (CloneNotSupportedException ex) {
            log.error("Error during cloning the object");
            //swallow
        }
        return clonedObject;
    }
}
