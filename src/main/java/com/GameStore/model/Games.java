package com.GameStore.model;

public class Games {
    private String Name;
    private Double Price;
    private String Barcode;
    private Integer Id;

    public Games() {
        this.Name = Name;
        this.Price = Price;
        this.Barcode = Barcode;
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        this.Price = price;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        this.Barcode = barcode;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }
}
