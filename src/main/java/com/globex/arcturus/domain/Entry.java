package com.globex.arcturus.domain;


import com.globex.arcturus.domain.helper.Linkable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Entity
@Table(name = "entry")
//@JsonIgnoreProperties({"user"})
public class Entry extends Linkable {

    private static final String TYPE = "vnd.globex.arcturus.ENTRY";

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "andy", strategy = "increment")
    @GeneratedValue(generator = "andy")
    private Integer id;

    @Column(name = "RATING")
    private Double rating;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "location_id")
    private Integer locationId;


    @Override
    public String getType() {
        return Entry.TYPE;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    /*

//    @JsonIgnore
    @JsonBackReference
    public User getUser() {
        return user;
    }

//    @JsonIgnore
    @JsonBackReference
    public void setUser(User user) {
        this.user = user;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
*/


}
