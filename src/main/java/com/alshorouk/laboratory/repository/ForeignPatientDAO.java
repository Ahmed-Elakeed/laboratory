package com.alshorouk.laboratory.repository;

import com.alshorouk.laboratory.model.ArabPatient;
import com.alshorouk.laboratory.model.ForeignPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForeignPatientDAO extends JpaRepository<ForeignPatient,String> {
    @Query("select p from ForeignPatient p where p.passportNumber=:passportNumber")
    ForeignPatient findForeignPatientByPassportNumber(@Param("passportNumber") String passportNumber);

    @Modifying
    @Query("delete from ForeignPatient where passportNumber=:passportNumber")
    void deleteForeignPatientByPassportNumber(@Param("passportNumber") String passportNumber);

    @Query("select p from ForeignPatient p where p.passportNumber=:passportNumber or p.given_names like %:given_names% or p.nationality=:nationality or p.surName like %:surName% or p.test=:test or p.sex=:sex or p.result=:result")
    List<ForeignPatient> findByAny(@Param("passportNumber") String passportNumber, @Param("given_names") String given_names, @Param("nationality") String nationality, @Param("surName") String surName, @Param("test") String test, @Param("sex") String sex, @Param("result") String result);
}
