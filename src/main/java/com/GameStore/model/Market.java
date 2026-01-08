package com.GameStore.model;

public class Market {

    private Integer id;
    private String titulo;
    private String nameEmpresa;
    private String email;
    private String address;
    private String phone;
    private String cnpj;

    public Market() {
    }

    public Market(Integer id, String titulo, String nameEmpresa,
                  String email, String address, String phone, String cnpj) {
        this.id = id;
        this.titulo = titulo;
        this.nameEmpresa = nameEmpresa;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNameEmpresa() {
        return nameEmpresa;
    }

    public void setNameEmpresa(String nameEmpresa) {
        this.nameEmpresa = nameEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
