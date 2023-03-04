package com.credex.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.credex.ProductData.ShopifyProduct;
import com.credex.ProductData.ShopifyProductsResponse;
import com.google.gson.Gson;

public class ApiCalls {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApiCalls.class);

//  private static final String SHOPIFY_STORE_DOMAIN = "rishify.myshopify.com";
//  private static final String SHOPIFY_TOKKEN = "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";
  private  String SHOPIFY_STORE_DOMAIN;
  private  String SHOPIFY_TOKKEN;
  

  @Override
  public String toString() {
    return "ApiCalls [SHOPIFY_STORE_DOMAIN=" + SHOPIFY_STORE_DOMAIN + ", SHOPIFY_TOKKEN=" + SHOPIFY_TOKKEN + "]";
  }

  public String getSHOPIFY_STORE_DOMAIN() {
    return SHOPIFY_STORE_DOMAIN;
  }

  public void setSHOPIFY_STORE_DOMAIN(String sHOPIFY_STORE_DOMAIN) {
    SHOPIFY_STORE_DOMAIN = sHOPIFY_STORE_DOMAIN;
  }

  public String getSHOPIFY_TOKKEN() {
    return SHOPIFY_TOKKEN;
  }

  public void setSHOPIFY_TOKKEN(String sHOPIFY_TOKKEN) {
    SHOPIFY_TOKKEN = sHOPIFY_TOKKEN;
  }

  public  ShopifyProduct[]  loginAndGetApiCalls  (String  EndPoint) throws Exception {

    URL url = new URL("https://"+SHOPIFY_STORE_DOMAIN+"/admin/api/2022-10/"+EndPoint+".json");

    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Content-Type", "application/json");
    conn.setRequestProperty("X-Shopify-Access-Token", SHOPIFY_TOKKEN);
    int responseCode = conn.getResponseCode();
    if (responseCode == HttpURLConnection.HTTP_OK) {
      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      JSONObject json = new JSONObject(response.toString());
      
      LOGGER.info(json.toString());
      
      System.out.println(json.toString());

      if (json.length() != 0) {
        Gson gson  = new Gson();
        
        ShopifyProductsResponse responseProduct  = gson.fromJson(json.toString(), ShopifyProductsResponse.class);
        ShopifyProduct[] products = responseProduct.getProducts();
        return products;
      }

    } else {
      System.out.println("GET request failed, response code: " + responseCode);
    }
    return null;
  }
}

//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

