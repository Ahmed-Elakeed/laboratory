package com.alshorouk.laboratory.repository;

import com.alshorouk.laboratory.model.ArabPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArabPatientDAO extends JpaRepository<ArabPatient,String> {

    @Query("select p from ArabPatient p where p.passportNumber=:passportNumber")
    ArabPatient findArabPatientByPassportNumber(@Param("passportNumber") String passportNumber);

    @Modifying
    @Query("delete from ArabPatient where passportNumber=:passportNumber")
    void deletePatientByPassportNumber(@Param("passportNumber") String passportNumber);

    @Query("select p from ArabPatient p where p.passportNumber=:passportNumber or p.national_id=:national_id or p.nationality=:nationality or p.patientName like %:patientName% or p.test=:test or p.sex=:sex or p.result=:result")
    List<ArabPatient> findByAny(@Param("passportNumber") String passportNumber, @Param("national_id") String national_id, @Param("nationality") String nationality, @Param("patientName") String patientName, @Param("test") String test, @Param("sex") String sex, @Param("result") String result);

}
