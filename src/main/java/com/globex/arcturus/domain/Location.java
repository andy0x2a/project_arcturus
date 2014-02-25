package com.globex.arcturus.domain;

import com.globex.arcturus.domain.helper.Linkable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "location")
public class Location extends Linkable {


    public static final String TYPE = "vnd.globex.arcturus.LOCATION";

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "LATITUDE")
    private String latitude;
    @Column(name = "LONGITUDE")
    private String longitude;


    @Column(name = "city_id")
    private Integer cityId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String getType() {
        return Location.TYPE;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
