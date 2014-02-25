package com.globex.arcturus.domain;


import com.globex.arcturus.domain.helper.Linkable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Entity
@Table(name = "city")
@JsonIgnoreProperties(ignoreUnknown = true)
public class City extends Linkable {

    private static final String TYPE = "vnd.globex.arcturus.CITY";

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "andy", strategy = "increment")
    @GeneratedValue(generator = "andy")
    private Integer id;

    @Column(name="name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return City.TYPE;
    }
}
