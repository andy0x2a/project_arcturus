package com.globex.arcturus.domain;

import com.globex.arcturus.domain.helper.Linkable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Entity
@Table(name = "user")
public class User extends Linkable {


    private static final String TYPE = "vnd.globex.arcturus.USER";

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "JOINDATE")
    private Date joinDate;



    @Override
    public String getType() {
        return this.TYPE;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

/*
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Entry> entries = new HashSet<Entry>(0);


    @JsonManagedReference
    public Set<Entry> getEntries() {
        return entries;
    }

    @JsonManagedReference
    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }*/

}
