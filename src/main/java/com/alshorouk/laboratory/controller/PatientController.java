package com.alshorouk.laboratory.controller;


import com.alshorouk.laboratory.Service.ArabPatientService;
import com.alshorouk.laboratory.Service.ForeignPatientService;
import com.alshorouk.laboratory.model.ArabPatient;
import com.alshorouk.laboratory.model.ForeignPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(path = "/patients")
public class PatientController {

    @Autowired
    private ForeignPatientService foreignPatientService;
    @Autowired
    private ArabPatientService arabPatientService;

    //Get Mapping ////////////
    @GetMapping(path = "/data")
    public ModelAndView showDataPage(HttpSession session) {
        if (session.getAttribute("logged") != "true") {
            return new ModelAndView("login");
        }
        ModelAndView modelAndView = new ModelAndView("data");
        modelAndView.addObject("arabPatients", arabPatientService.findAll());
        modelAndView.addObject("foreignPatients", foreignPatientService.findAll());
        return modelAndView;
    }

    @GetMapping("/your-details")
    public String showValidationPage() {
        return "validation";
    }

    @GetMapping(path = "/addArabForm")
    public ModelAndView showAddArabPage(HttpSession session) {
        if (session.getAttribute("logged") != "true") {
            return new ModelAndView("login");
        }
        return new ModelAndView("addArab");
    }

    @GetMapping(path = "/addForeignForm")
    public ModelAndView showAddForeignPage(HttpSession session) {
        if (session.getAttribute("logged") != "true") {
            return new ModelAndView("login");
        }
        return new ModelAndView("addForeign");
    }


    //PostMapping ////////////
    @PostMapping(path = "/add-arab")
    public ModelAndView addNewArabPatient(@RequestParam String name, @RequestParam String passportNumber, @RequestParam String IdNumber, @RequestParam String nationality, @RequestParam String gender, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birth_date, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date sampleDate, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date reportingDate, @RequestParam String test, @RequestParam String result, HttpSession session) {
        if (session.getAttribute("logged") != "true") {
            return new ModelAndView("login");
        }
        try {
            if (foreignPatientService.constraintCheck(passportNumber)) {
                arabPatientService.save(new ArabPatient(name, passportNumber, IdNumber, nationality, gender, birth_date, sampleDate, reportingDate, test, result));
                return new ModelAndView("redirect:/patients/data");
            }
            return new ModelAndView("addArab");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("addArab");
        }
    }

    @PostMapping(path = "/add-foreign")
    public ModelAndView addNewForeignPatient(@RequestParam String surname, @RequestParam String givenNames, @RequestParam String passportNumber, @RequestParam String nationality, @RequestParam String gender, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birth_date, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date sampleDate, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date reportingDate, @RequestParam String test, @RequestParam String result, HttpSession session) {
        if (session.getAttribute("logged") != "true") {
            return new ModelAndView("login");
        }
        try {
            if (arabPatientService.constraintCheck(passportNumber)) {
                foreignPatientService.save(new ForeignPatient(surname, givenNames, passportNumber, nationality, gender, birth_date, sampleDate, reportingDate, test, result));
                return new ModelAndView("redirect:/patients/data");
            }
            return new ModelAndView("addForeign");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("addForeign");
        }
    }

    @PostMapping(path = "/yourData")
    public ModelAndView showPatientData(@RequestParam String passportNumber) {
        ArabPatient arabPatient = arabPatientService.findPatientByPassportNumber(passportNumber);
        ForeignPatient foreignPatient = foreignPatientService.findForeignPatientByPassportNumber(passportNumber);
        if (arabPatient != null) {
            ModelAndView modelAndView = new ModelAndView("arabPatient");
            modelAndView.addObject("birthDate",new SimpleDateFormat("MM-dd-yyyy").format(arabPatient.getBirthDate()));
            modelAndView.addObject("sampleDate",new SimpleDateFormat("MM-dd-yyyy").format(arabPatient.getSampleDate()));
            modelAndView.addObject("reportingDate",new SimpleDateFormat("MM-dd-yyyy").format(arabPatient.getReportingDate()));
            modelAndView.addObject("arabPatient", arabPatient);
            return modelAndView;
        }
        if (foreignPatient != null){
            ModelAndView modelAndView = new ModelAndView("foreignPatient");
            modelAndView.addObject("birthDate",new SimpleDateFormat("MM-dd-yyyy").format(foreignPatient.getBirthDate()));
            modelAndView.addObject("sampleDate",new SimpleDateFormat("MM-dd-yyyy").format(foreignPatient.getSampleDate()));
            modelAndView.addObject("reportingDate",new SimpleDateFormat("MM-dd-yyyy").format(foreignPatient.getReportingDate()));
            modelAndView.addObject("foreignPatient", foreignPatient);
            return modelAndView;
        }
        return new ModelAndView("validation");
    }

    @PostMapping(path = "/search")
    public ModelAndView search(@RequestParam String searchText, HttpSession session) {
        if (session.getAttribute("logged") != "true") {
            return new ModelAndView("login");
        }
        ModelAndView modelAndView = new ModelAndView("data");
        modelAndView.addObject("arabPatients", arabPatientService.findByAny(searchText));
        modelAndView.addObject("foreignPatients", foreignPatientService.findByAny(searchText));
        return modelAndView;
    }

    @PostMapping(path = "/delete")
    public ModelAndView delete(@RequestParam String passportNumber, HttpSession session) {
        if (session.getAttribute("logged") != "true") {
            return new ModelAndView("login");
        }
        arabPatientService.deleteByPassportNumber(passportNumber);
        foreignPatientService.deleteForeignPatientByPassportNumber(passportNumber);
        return new ModelAndView("redirect:/patients/data");
    }
}
