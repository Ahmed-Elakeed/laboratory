package com.alshorouk.laboratory.Service;

import com.alshorouk.laboratory.model.ArabPatient;
import com.alshorouk.laboratory.repository.ArabPatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArabPatientService {
    @Autowired
    private ArabPatientDAO arabPatientDAO;

    public ArabPatient findById(String id){
        return arabPatientDAO.findById(id).get();
    }
    public List<ArabPatient> findAll(){
        return arabPatientDAO.findAll();
    }

    public void deleteByPassportNumber(String passportNumber){
        arabPatientDAO.deletePatientByPassportNumber(passportNumber);
    }
    public ArabPatient findPatientByPassportNumber(String passportNumber){
        return arabPatientDAO.findArabPatientByPassportNumber(passportNumber);
    }
    public void save(ArabPatient patient){
        arabPatientDAO.save(patient);
    }
    public List<ArabPatient> findByAny(String searchText){
        return arabPatientDAO.findByAny(searchText,searchText,searchText,searchText,searchText,searchText,searchText);
    }
    public boolean constraintCheck(String passportNumber){
        for(ArabPatient arabPatient: arabPatientDAO.findAll()){
            if(arabPatient.getPassportNumber().equals(passportNumber))
                return false;
        }
        return true;
    }
}
