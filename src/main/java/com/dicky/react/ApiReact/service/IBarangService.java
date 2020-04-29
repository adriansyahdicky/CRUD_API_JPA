/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.service;

import com.dicky.react.ApiReact.model.Barang;
import com.dicky.react.ApiReact.request.BarangRequest;
import java.util.List;

/**
 *
 * @author dickyadriansyah
 */
public interface IBarangService {
     public List<Barang> getBarangs();
     public Barang getByIdBarang(String id);
     public Barang SaveBarang(BarangRequest request);
     public Barang UpdateBarang(String idBarang, BarangRequest request);
     public boolean DeleteBarang(String idBarang);
}
