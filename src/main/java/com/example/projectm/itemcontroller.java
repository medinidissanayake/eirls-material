package com.example.projectm;

import java.text.ParseException;
import java.util.List;

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
public class itemcontroller {

  @Autowired
  itemrepo itemr;

  @Autowired
  orderitemsRepo ordrepo;

  @RequestMapping("/home")
  public String index() {
    return "index";
  }

  @RequestMapping("/homemanager")
  public String index2() {
    return "indexmanager";
  }

  @ResponseBody
  @RequestMapping(value = "/showItems", method = RequestMethod.GET)
  public List<items> getItems() {
    return itemr.findAll();
  }

  @RequestMapping(value = "/addItem", method = RequestMethod.GET)
  public ModelAndView showForm2() {
    return new ModelAndView("addItem", "itemmodel", new itemModel());
  }

  @RequestMapping(value = "/placeItem", method = RequestMethod.POST)
  public String submitdetails(@Valid @ModelAttribute("itemmodel") itemModel itemmodel, BindingResult result,
      ModelMap model) {

    items itms = new items();

    itms.setItem_name(itemmodel.getItemname());
    itms.setItem_price(itemmodel.getPrice());
    itms.setItem_description(itemmodel.getDescription());
    itms.setItem_quantity(itemmodel.getQuantity());
    itms.setReorder_level(itemmodel.getReorderlevel());
    itms.setItem_type(itemmodel.getItemtype());

    itemr.save(itms);

    return "indexmanager";
  }

  @RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
  public ModelAndView bomView(ModelAndView model) throws ParseException {

    String theUrl2 = "https://cb006700-warehouse.herokuapp.com/inwards/received-items";

    RestTemplate restTemplates = new RestTemplate();
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      HttpEntity<String> entities = new HttpEntity<String>("parameters", headers);
      ResponseEntity<warehouseItems[]> respEntity2 = restTemplates.exchange(theUrl2, HttpMethod.GET, entities,
          warehouseItems[].class);
      warehouseItems[] resp = respEntity2.getBody();

      List<items> listItems = itemr.findAll();

      for (warehouseItems var : resp) {

        for (items item : listItems) {

          if (var.getItem_id() == item.getItem_id()) {

            if (item.getItem_quantity() < item.getReorder_quantity()) {

              int quantity = item.getItem_quantity() + var.getItem_qty();

              itemr.updateQuantitywithID(quantity, item.getItem_id());
            }
          }

        }

      }

    }

    catch (Exception eek) {
      System.out.println("** Exception: " + eek.getMessage());
    }

    List<items> list = itemr.findAll();

    model.addObject("list", list);
    model.setViewName("viewItems");

    return model;
  }




  @RequestMapping(value = "/reservedStocks", method = RequestMethod.GET)
  public ModelAndView ReservedStocks(ModelAndView model) throws ParseException {

    

    List<order_items> list = ordrepo.findAll();

    model.addObject("list", list);
    model.setViewName("viewReservation");

    return model;
  }

}
