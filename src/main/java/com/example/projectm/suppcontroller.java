package com.example.projectm;

import java.text.ParseException;
import java.util.List;
import java.util.function.Supplier;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class suppcontroller{

    @Autowired
    supprepo sup;




    @ResponseBody
    @RequestMapping(value = "/showSupplier", method = RequestMethod.GET)
    public List<supplier> getSupplier(){
        return sup.findAll(); 
    }




    @RequestMapping(value = "/addSuppplier", method = RequestMethod.GET)
    public ModelAndView showForm2() {
        return new ModelAndView("addSupplier", "suppliermodel", new suppmodel());
    }

    @RequestMapping(value = "/placeSupp", method = RequestMethod.POST)
    public String submitdetails(@Valid @ModelAttribute("suppliermodel") suppmodel suppliermodel, 
      BindingResult result, ModelMap model) {
        
   
        supplier suppli = new supplier();
        
        suppli.setContact_number(suppliermodel.getContact());
        suppli.setEmail_address(suppliermodel.getEmail());
        suppli.setBrand_name(suppliermodel.getBrandname());
        suppli.setDelivery_location(suppliermodel.getDeliveryloc());
        suppli.setCollection_location(suppliermodel.getCollectionloc());
        suppli.setMain_location(suppliermodel.getMainloc());
       


        sup.save(suppli);
        

        return "index";
    }


}