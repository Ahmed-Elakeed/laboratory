package com.alshorouk.laboratory.repository;

import com.alshorouk.laboratory.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends JpaRepository<Admin,Integer> {

    @Query("select a from Admin a where a.email=:email")
    Admin findAdminByEmail(@Param("email") String email);
}
