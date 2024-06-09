package com.summerinternship.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OfficeID;
    private String OfficeName;
    private String Location;

    // Getters and setters
    public Long getOfficeId() {
        return OfficeID;
    }

    public void setId(Long OfficeID) {
        this.OfficeID = OfficeID;
    }

    public String getOfficeName() {
        return OfficeName;
    }

    public void setOfficeName(String OfficeName) {
        this.OfficeName = OfficeName;
    }

    public String getLocation() {
        return Location;
    }

    public void setAddress(String Location) {
        this.Location = Location;
    }
}
