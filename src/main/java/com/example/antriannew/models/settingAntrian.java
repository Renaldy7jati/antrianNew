package com.example.antriannew.models;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.SimpleTimeZone;

public class settingAntrian {
    private SimpleStringProperty id_antrian;
    private SimpleStringProperty kode_antrian;

    private SimpleStringProperty uraian_antrian;
    private LocalDateTime waktu_update;

    public settingAntrian(String id_antrian, String kode_antrian, String uraian_antrian, LocalDateTime waktu_update) {
        this.id_antrian = new SimpleStringProperty(id_antrian);
        this.kode_antrian = new SimpleStringProperty(kode_antrian);
        this.uraian_antrian = new SimpleStringProperty(uraian_antrian);
        this.waktu_update = waktu_update;
    }

    public String getId_antrian() {
        return id_antrian.get();
    }

    public SimpleStringProperty id_antrianProperty() {
        return id_antrian;
    }

    public void setId_antrian(String id_antrian) {
        this.id_antrian.set(id_antrian);
    }

    public String getKode_antrian() {
        return kode_antrian.get();
    }

    public SimpleStringProperty kode_antrianProperty() {
        return kode_antrian;
    }

    public void setKode_antrian(String kode_antrian) {
        this.kode_antrian.set(kode_antrian);
    }

    public String getUraian_antrian() {
        return uraian_antrian.get();
    }

    public SimpleStringProperty uraian_antrianProperty() {
        return uraian_antrian;
    }

    public void setUraian_antrian(String uraian_antrian) {
        this.uraian_antrian.set(uraian_antrian);
    }

    public LocalDateTime getWaktu_update() {
        return waktu_update;
    }

    public void setWaktu_update(LocalDateTime waktu_update) {
        this.waktu_update = waktu_update;
    }
}
