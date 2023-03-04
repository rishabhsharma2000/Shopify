package com.credex.ProductData;

public class ShopifyProductImage {
  private long id;

  @Override
  public String toString() {
    return "ShopifyProductImage [id=" + id + ", src=" + src + ", width=" + width + ", height=" + height + "]";
  }

  private String src;
  private int width;
  private int height;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
