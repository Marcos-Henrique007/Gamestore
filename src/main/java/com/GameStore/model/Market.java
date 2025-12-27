package com.GameStore.model;

public class Market {
    private Games[] games;
    private String Name;
    private String Email;
    private String Adress;
    private String Phone;
    private String Cnpj;

    public Market(Games[] games, String Name, String Email, String Adress, String Phone, String Cnpj) {
        this.games = games;
        this.Name = Name;
        this.Email = Email;
        this.Adress = Adress;
        this.Phone = Phone;
        this.Cnpj = Cnpj;
    }

    public Games[] getGames() {
        return games;
    }

    public void setGames(Games[] games) {
        this.games = games;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String cnpj) {
        this.Cnpj = cnpj;
    }
}
