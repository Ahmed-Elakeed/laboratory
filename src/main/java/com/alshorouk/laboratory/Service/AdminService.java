package com.alshorouk.laboratory.Service;

import com.alshorouk.laboratory.model.Admin;
import com.alshorouk.laboratory.repository.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Admin findById(Integer id){
        return adminDAO.findById(id).get();
    }
    public Admin findAdminByEmail(String email){
        return adminDAO.findAdminByEmail(email);
    }
    public String hashPassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }
    public boolean login(String email,String password){
        if(adminDAO.findAdminByEmail(email)==null)
            return false;
        if(bCryptPasswordEncoder.matches(password,adminDAO.findAdminByEmail(email).getPassword()))
            return true;
        return false;
    }
    public void updatePassword(String email,String password){
        adminDAO.findAdminByEmail(email).setPassword(bCryptPasswordEncoder.encode(password));
    }
    public void updateEmail(String oldEmail,String newEmail){
        adminDAO.findAdminByEmail(oldEmail).setEmail(newEmail);
    }
}
