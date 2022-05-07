package com.alshorouk.laboratory.Service;

import com.alshorouk.laboratory.model.ArabPatient;
import com.alshorouk.laboratory.model.ForeignPatient;
import com.alshorouk.laboratory.repository.ForeignPatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ForeignPatientService {
    @Autowired
    private ForeignPatientDAO foreignPatientDAO;

    public ForeignPatient findById(String id){
        return foreignPatientDAO.findById(id).get();
    }
    public List<ForeignPatient> findAll(){
        return foreignPatientDAO.findAll();
    }

    public void deleteForeignPatientByPassportNumber(String passportNumber){
        foreignPatientDAO.deleteForeignPatientByPassportNumber(passportNumber);
    }
    public ForeignPatient findForeignPatientByPassportNumber(String passportNumber){
        return foreignPatientDAO.findForeignPatientByPassportNumber(passportNumber);
    }
    public void save(ForeignPatient patient){
        foreignPatientDAO.save(patient);
    }


    public List<ForeignPatient> findByAny(String searchText){
        return foreignPatientDAO.findByAny(searchText,searchText,searchText,searchText,searchText,searchText,searchText);
    }
    public boolean constraintCheck(String passportNumber){
        for(ForeignPatient foreignPatient: foreignPatientDAO.findAll()){
            if(foreignPatient.getPassportNumber().equals(passportNumber))
                return false;
        }
        return true;
    }
}
