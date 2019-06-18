package com.example.projectm;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class logincontroller{

    @Autowired
    userrepo urepo;

    @Autowired
    itemrepo irepo;

    @Autowired
    orderitemsRepo ordrepo;

 public void updateStocks(){
     

    String theUrl2 = "https://eirls-sales.herokuapp.com/api/enquiries";
    
    RestTemplate restTemplates = new RestTemplate();

    try {

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
     
      HttpEntity<String> entities = new HttpEntity<String>("parameters", headers);

      ResponseEntity<salesorder[]> respEntity2 = restTemplates.exchange(theUrl2, HttpMethod.GET, entities,
      salesorder[].class);
      
      

      salesorder[] resp = respEntity2.getBody();

      List<items> listItems = irepo.findAll();

    salesorder[] resp2 = resp;

	for (salesorder var : resp2) {

        Set<enquiryItems> ilist = var.getEnquiryItems();
        List<order_items> ordlist = ordrepo.findAll();

        if(ordlist.isEmpty()){
            for (enquiryItems eitem : ilist) {
                order_items oitem = new order_items();
                oitem.setItem_id(eitem.getId());
                oitem.setItem_name(eitem.getItem().getName());
                oitem.setItem_quantity(eitem.getQuantity());
                oitem.setProduct_status("reserved");
                oitem.setSales_order_id(var.getId());
                ordrepo.save(oitem);
                items i = irepo.getitem(eitem.getItem().getId());
                int newquantity = i.getItem_quantity() - eitem.getQuantity();
                irepo.updateQuantity(newquantity, i.getItem_name());
                
            }


        }else{
            boolean x = true;

            for (enquiryItems eitem : ilist) {

            for (order_items ord : ordlist) {

                if(eitem.getId()==ord.getItem_id()){
                        x = true;
                        break;
                }else{
                        x = false;

                }
            }
            if(x==false){
                    order_items oitem = new order_items();
                    oitem.setItem_id(eitem.getId());
                    oitem.setItem_name(eitem.getItem().getName());
                    oitem.setItem_quantity(eitem.getQuantity());
                    oitem.setProduct_status("reserved");
                    oitem.setSales_order_id(var.getId());
                    ordrepo.save(oitem);
                    items i = irepo.getitem(eitem.getItem().getId());
                    int newquantity = i.getItem_quantity() - eitem.getQuantity();
                    irepo.updateQuantity(newquantity, i.getItem_name());
                    
            }
                      
        }
    }
    
       }
  
       
    } 
  
    catch (Exception eek) {
      System.out.println("** Exception: " + eek.getMessage());
    }
 }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showForm3() {

        updateStocks();
    
    return new ModelAndView("login", "usermod", new usermodel());


}

    @RequestMapping(value = "/placelogin", method = RequestMethod.POST)
    public String submitdetails(@Valid @ModelAttribute("usermod") usermodel usermod, 
    BindingResult result, ModelMap model) {

        List<user> ulist = urepo.findAll();

        for (user var : ulist) {

            if(var.getUser_name().equals(usermod.getUsername())){

                user u =  urepo.getUser(usermod.getUsername());

    
                if(u.getUser_type().equals("Material Clerk")){
                    return "index";
        
                }else{
                    return "indexmanager";
                }
        
          
               
            }
           
        }

        return "redirect:/login";
       
    
    
}

@RequestMapping(value = "/signup", method = RequestMethod.GET)
public ModelAndView signupform() {
return new ModelAndView("signup", "usermod", new usermodel());


}

@RequestMapping(value = "/signupsubmit", method = RequestMethod.POST)
    public String signupform2(@Valid @ModelAttribute("usermod") usermodel usermod, 
    BindingResult result, ModelMap model) {
    


    user u = new user();

  u.setUser_name(usermod.getUsername());
  u.setPassword(usermod.getPass());
  u.setUser_type(usermod.getUsertype());


    urepo.save(u);
    
    return "redirect:/login";
}

}