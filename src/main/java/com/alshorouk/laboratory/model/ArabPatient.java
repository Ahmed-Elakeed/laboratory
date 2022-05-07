package com.alshorouk.laboratory.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "arab_patient")
public class ArabPatient {

    private String patientName;
    private String passportNumber;
    @Id
    private String national_id;
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

    public ArabPatient() {
    }

    public ArabPatient(String patientName, String passportNumber, String national_id, String nationality, String sex, Date birthDate, Date sampleDate, Date reportingDate, String test, String result) {
        this.patientName = patientName;
        this.passportNumber = passportNumber;
        this.national_id = national_id;
        this.nationality = nationality;
        this.sex = sex;
        this.birthDate = birthDate;
        this.sampleDate = sampleDate;
        this.reportingDate = reportingDate;
        this.test = test;
        this.result = result;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
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
        return "ArabPatient{" +
                "patientName='" + patientName + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", national_id='" + national_id + '\'' +
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
