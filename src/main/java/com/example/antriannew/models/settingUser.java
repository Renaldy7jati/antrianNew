package com.example.antriannew;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;

public class settingUser {
    private SimpleStringProperty id_user;
    private SimpleStringProperty user_name;
    private SimpleStringProperty password;
    private SimpleStringProperty nama;

    public LocalDateTime getWaktu_update() {
        return waktu_update;
    }

    public void setWaktu_update(LocalDateTime waktu_update) {
        this.waktu_update = waktu_update;
    }

    private SimpleStringProperty id_role;
    private LocalDateTime waktu_update;

    public settingUser(String id_user, String user_name, String password, String nama, String id_role, LocalDateTime waktu_update) {
        this.id_user = new SimpleStringProperty(id_user);
        this.user_name = new SimpleStringProperty(user_name);
        this.password = new SimpleStringProperty(password);
        this.nama = new SimpleStringProperty(nama);
        this.id_role = new SimpleStringProperty(id_role);
        this.waktu_update = waktu_update;
    }

    public String getId_user() {
        return id_user.get();
    }

    public SimpleStringProperty id_userProperty() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user.set(id_user);
    }

    public String getUser_name() {
        return user_name.get();
    }

    public SimpleStringProperty user_nameProperty() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name.set(user_name);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getNama() {
        return nama.get();
    }

    public SimpleStringProperty namaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getId_role() {
        return id_role.get();
    }

    public SimpleStringProperty id_roleProperty() {
        return id_role;
    }

    public void setId_role(String id_role) {
        this.id_role.set(id_role);
    }
}
