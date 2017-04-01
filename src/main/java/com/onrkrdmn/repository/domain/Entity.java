package com.onrkrdmn.repository.domain;

import java.io.Serializable;

/**
 * Persistent data interface
 *
 * @author Onur Karaduman
 * @since 01.04.17.
 */
public interface Entity extends Serializable, Cloneable {

    /**
     * The unique id for persistent object
     *
     * @return
     */
    public Long getId();

}
