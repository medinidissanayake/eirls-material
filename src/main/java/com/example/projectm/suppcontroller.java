package com.example.projectm;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    itemrepo irepo;




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
        suppli.setSupplier_status("Allowed");
       


        sup.save(suppli);
        

        return "indexmanager";
    }


    @RequestMapping(value = "/editSupplier", method = RequestMethod.GET)
    public ModelAndView editSup() {
        return new ModelAndView("editSupplier", "suppliermodel", new suppmodel());
    }

    @RequestMapping(value = "/updateSup", method = RequestMethod.POST)
    public String updatedetails(@Valid @ModelAttribute("suppliermodel") suppmodel suppliermodel, 
      BindingResult result, ModelMap model) {
        
   
       if(suppliermodel.getBrandname().isEmpty()){

       }else{
        sup.updateName(suppliermodel.getBrandname(),Integer.parseInt(suppliermodel.getSupplierID()));
       } 
      

       if(suppliermodel.getEmail().isEmpty()){

       }else{
        sup.updateEMail(suppliermodel.getEmail(),Integer.parseInt(suppliermodel.getSupplierID()));
       }
       
      
       if(suppliermodel.getMainloc().isEmpty()){}
       else{
        sup.updateMain(suppliermodel.getMainloc(),Integer.parseInt(suppliermodel.getSupplierID()));
       }
      
       if(suppliermodel.getDeliveryloc().isEmpty()){}
       else{
        sup.updateDelivery(suppliermodel.getDeliveryloc(),Integer.parseInt(suppliermodel.getSupplierID()));
       }
       
       if(suppliermodel.getCollectionloc().isEmpty()){}
       else{
        sup.updateCollection(suppliermodel.getCollectionloc(),Integer.parseInt(suppliermodel.getSupplierID()));
       }
      
       if(suppliermodel.getContact().isEmpty()){

       }
       else{
        sup.updateContact(suppliermodel.getContact(),Integer.parseInt(suppliermodel.getSupplierID()));
       }
      
       


    
        

        return "indexmanager";
    }





    @RequestMapping(value = "/supStatus", method = RequestMethod.GET)
    public ModelAndView changeStatus() {
        return new ModelAndView("supplierStatus", "suppliermodel", new suppmodel());
    }



    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public String updateStatus(@Valid @ModelAttribute("suppliermodel") suppmodel suppliermodel, 
      BindingResult result, ModelMap model) {
        
        if(suppliermodel.getBrandname().equals("Delete")){
            sup.deleteSupplier(Integer.parseInt(suppliermodel.getSupplierID()));
        }else{
            sup.updateStatus(suppliermodel.getBrandname(), Integer.parseInt(suppliermodel.getSupplierID()));
        }
   
     

        return "indexmanager";
    }



    @RequestMapping(value = "/assignSup", method = RequestMethod.GET)
    public ModelAndView assignSupplier() {
        return new ModelAndView("supplierAnditem", "suppliermodel", new suppmodel());
    }


    @RequestMapping(value = "/assignSupplier", method = RequestMethod.POST)
    public String assignSuppliertoItem(@Valid @ModelAttribute("suppliermodel") suppmodel suppliermodel, 
      BindingResult result, ModelMap model) {
        
        supplier supl = sup.getSupplier(Integer.parseInt(suppliermodel.getSupplierID()));

      irepo.updateCollection(supl,Integer.parseInt(suppliermodel.getBrandname()));
    irepo.updateReorder(suppliermodel.getOrderquantity(), Integer.parseInt(suppliermodel.getBrandname()));
irepo.updateLead(suppliermodel.getLeadtime(), Integer.parseInt(suppliermodel.getBrandname()));


        return "indexmanager";
    }



    @ModelAttribute("supList")
    public Map<String, String> getSupList() {
    
      
      Map<String, String> suppList = new HashMap<String, String>();
     
     List<supplier> ilist = sup.findAll();
    
     for (supplier var : ilist) {
    
        suppList.put(String.valueOf(var.getSupplier_id()), String.valueOf(var.getSupplier_id()));
       
     }
    
    return suppList;
    }

    @ModelAttribute("itemList")
    public Map<String, String> getItemList() {
    
      
      Map<String, String> itemList = new HashMap<String, String>();
     
     List<items> ilist = irepo.findAll();
    
     for (items var : ilist) {
    
        itemList.put(String.valueOf(var.getItem_id()), String.valueOf(var.getItem_id()));
       
     }
    
    return itemList;
    }


    @RequestMapping(value = "/performance", method = RequestMethod.GET)
    public ModelAndView performanceRecord() {
        return new ModelAndView("performance", "suppliermodel", new suppmodel());
    }

    @RequestMapping(value = "/recordPerformance", method = RequestMethod.POST)
    public String recordPerformance(@Valid @ModelAttribute("suppliermodel") suppmodel suppliermodel, 
      BindingResult result, ModelMap model) {
        
    
        sup.updateDeliveryPerformance(suppliermodel.getDeliveryperform(), Integer.parseInt(suppliermodel.getSupplierID()));

        sup.updateQualityPerformance(suppliermodel.getQualityperform(), Integer.parseInt(suppliermodel.getSupplierID()));

        return "indexmanager";
    }


}