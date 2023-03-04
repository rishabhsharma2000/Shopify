package com.credify.RestControllers;

import com.credex.ProductData.ShopifyProduct;
import com.credex.ProductData.ShopifyProductsResponse;
//import com.credex.ProductData.ShopifyProduct;
import com.credex.client.ApiCalls;
import com.google.gson.Gson;

import javax.servlet.http.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")

public class RestControllers {

  @RequestMapping("/home")
  public String HomePage() throws Exception {
    return "home";
  }

  @RequestMapping(path = "/adminLogin", method = RequestMethod.GET)
  public String AdminLogin() throws Exception{

    return "adminLogin";
  }

  @PostMapping("/adminDashboard")
  public String doLogin(HttpServletRequest request, @RequestParam String storeName, @RequestParam String password,
      Model model) throws Exception {
    
      ApiCalls apiCall = new ApiCalls();
      apiCall.setSHOPIFY_STORE_DOMAIN(storeName);
      apiCall.setSHOPIFY_TOKKEN(password);
   
      ShopifyProduct[] products = apiCall.loginAndGetApiCalls("products");
      if (products.length != 0) {
        HttpSession newSessionGenerator = request.getSession();
        newSessionGenerator.setAttribute("storeName", storeName);
        newSessionGenerator.setAttribute("password", password);
        newSessionGenerator.setAttribute("productLength", products.length);
//        for (int i = 0; i < products.length; i++) {
//          System.out.println("Product is" + products[i]);
//        }
        model.addAttribute("productLength", products.length);
        return "adminDashboard";
      } else {

        return "adminLogin";
      }

    

  }

  @GetMapping("/adminDashboard")
  public String showDashboardPage(HttpServletRequest request, Model model) throws Exception{

    HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute("storeName") != null) {
      return "adminDashboard";
    } else {

      return "redirect:/api/adminLogin";
    }
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpServletRequest request) throws Exception{

    HttpSession session = request.getSession(false);

    if (session != null) {
      session.invalidate();
      System.out.println("Hogya delete");
      return "redirect:/api/adminLogin";
    }

    return null;
  }

}
