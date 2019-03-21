package com.araltiparmak.springbootjunitmockito.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class VetController {

    @Autowired
    ClinicService clinicService;

    @RequestMapping(value = {"/vets.html"})
    public String showVets(Map<String, Object> model) {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet objects
        // so it is simpler for Object-Xml mapping
        Vets vets = new Vets();
        vets.getVetList().add(clinicService.findById(1));
        model.put("vets", vets);
        return "vets/vetList";
    }

}