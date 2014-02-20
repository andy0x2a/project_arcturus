package com.globex.arcturus.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Entity
@Table(name = "entry")
public class Entry {


    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name="RATING")
    private Double rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
