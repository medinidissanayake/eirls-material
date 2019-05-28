package com.example.projectm;

import java.text.ParseException;
import java.util.List;

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
public class itemcontroller{

    @Autowired
    itemrepo itemr;

    @RequestMapping("/home")
    public String index(){
        return "index";
    }


    @ResponseBody
    @RequestMapping(value = "/showItems", method = RequestMethod.GET)
    public List<items> getItems(){
        return itemr.findAll(); 
    }




    @RequestMapping(value = "/addItem", method = RequestMethod.GET)
    public ModelAndView showForm2() {
        return new ModelAndView("addItem", "itemmodel", new itemModel());
    }

    @RequestMapping(value = "/placeItem", method = RequestMethod.POST)
    public String submitdetails(@Valid @ModelAttribute("itemmodel") itemModel itemmodel, 
      BindingResult result, ModelMap model) {
        
   

        items itms = new items();

        itms.setItem_name(itemmodel.getItemname());
        itms.setItem_price(itemmodel.getPrice());
        itms.setItem_description(itemmodel.getDescription());
        itms.setItem_quantity(itemmodel.getQuantity());
        itms.setReorder_level(itemmodel.getReorderlevel());
        itms.setItem_type(itemmodel.getItemtype());

        itemr.save(itms);
        

        return "index";
    }


}