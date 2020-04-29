/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.service;

import com.dicky.react.ApiReact.model.Kategori;
import com.dicky.react.ApiReact.request.KategoriRequest;
import java.util.List;

/**
 *
 * @author dickyadriansyah
 */
public interface IKategoriService {
    public List<Kategori> getKategori();
    public Kategori getByIdKategori(String id);
    public Kategori SaveKategori(KategoriRequest request);
    public Kategori UpdateKategori(String idKategori, KategoriRequest request);
    public boolean DeleteKategori(String idKategori);
}
