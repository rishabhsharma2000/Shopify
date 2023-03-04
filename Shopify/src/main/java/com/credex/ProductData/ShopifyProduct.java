package com.credex.ProductData;

import java.util.Arrays;

public class ShopifyProduct {

  private long id;
  private String title;
  private String body_html;
  private String vendor;
  private String product_type;
  private String handle;
  private ShopifyProductImage[] images;
  private ShopifyProductVariant[] variants;
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
  public String getBody_html() {
    return body_html;
  }
  public void setBody_html(String body_html) {
    this.body_html = body_html;
  }
  public String getVendor() {
    return vendor;
  }
  public void setVendor(String vendor) {
    this.vendor = vendor;
  }
  public String getProduct_type() {
    return product_type;
  }
  public void setProduct_type(String product_type) {
    this.product_type = product_type;
  }
  public String getHandle() {
    return handle;
  }
  public void setHandle(String handle) {
    this.handle = handle;
  }
  public ShopifyProductImage[] getImages() {
    return images;
  }
  public void setImages(ShopifyProductImage[] images) {
    this.images = images;
  }
  public ShopifyProductVariant[] getVariants() {
    return variants;
  }
  public void setVariants(ShopifyProductVariant[] variants) {
    this.variants = variants;
  }
  @Override
  public String toString() {
    return "ShopifyProduct [id=" + id + ", title=" + title + ", body_html=" + body_html + ", vendor=" + vendor
        + ", product_type=" + product_type + ", handle=" + handle + ", images=" + Arrays.toString(images)
        + ", variants=" + Arrays.toString(variants) + "]";
  }

}
