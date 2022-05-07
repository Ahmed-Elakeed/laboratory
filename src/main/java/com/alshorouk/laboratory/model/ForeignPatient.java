package com.alshorouk.laboratory.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "foreign_patient")
public class ForeignPatient {

    private String surName;
    private String given_names;
    @Id
    private String passportNumber;
    private String nationality;
    private String sex;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sampleDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date reportingDate;
    private String test;
    private String result;

    public ForeignPatient() {
    }

    public ForeignPatient(String surName, String given_names, String passportNumber, String nationality, String sex, Date birthDate, Date sampleDate, Date reportingDate, String test, String result) {
        this.surName = surName;
        this.given_names = given_names;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.sex = sex;
        this.birthDate = birthDate;
        this.sampleDate = sampleDate;
        this.reportingDate = reportingDate;
        this.test = test;
        this.result = result;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGiven_names() {
        return given_names;
    }

    public void setGiven_names(String given_names) {
        this.given_names = given_names;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getSampleDate() {
        return sampleDate;
    }

    public void setSampleDate(Date sampleDate) {
        this.sampleDate = sampleDate;
    }

    public Date getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(Date reportingDate) {
        this.reportingDate = reportingDate;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ForeignPatient{" +
                "surName='" + surName + '\'' +
                ", given_names='" + given_names + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate=" + birthDate +
                ", sampleDate=" + sampleDate +
                ", reportingDate=" + reportingDate +
                ", test='" + test + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
