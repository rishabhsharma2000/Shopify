package com.credex.ProductData;

public class ShopifyProductVariant {

  private long id;
  private String title;
  private String sku;

  @Override
  public String toString() {
    return "ShopifyProductVariant [id=" + id + ", title=" + title + ", sku=" + sku + ", price=" + price + ", barcode="
        + barcode + ", inventory_quantity=" + inventory_quantity + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public int getInventory_quantity() {
    return inventory_quantity;
  }

  public void setInventory_quantity(int inventory_quantity) {
    this.inventory_quantity = inventory_quantity;
  }

  private double price;
  private String barcode;
  private int inventory_quantity;
}
