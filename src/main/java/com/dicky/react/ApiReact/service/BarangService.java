/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.service;

import com.dicky.react.ApiReact.exception.ResourceIsExistingException;
import com.dicky.react.ApiReact.exception.ResourceNotFoundException;
import com.dicky.react.ApiReact.model.Barang;
import com.dicky.react.ApiReact.model.Kategori;
import com.dicky.react.ApiReact.repository.BarangRepository;
import com.dicky.react.ApiReact.request.BarangRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dickyadriansyah
 */
@Service
public class BarangService implements IBarangService{

    @Autowired
    public BarangRepository barangRepository;
    
    public BarangService(BarangRepository barangRepository){
        this.barangRepository = barangRepository;
    }
    
    @Override
    public List<Barang> getBarangs() {
        List<Barang> barangs = barangRepository.findAll();
        return barangs;
    }

    @Override
    public Barang getByIdBarang(String id) {
        return barangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id barang "+id+" not found !"));
    }

    @Override
    public Barang SaveBarang(BarangRequest request) {
        Optional<Barang> barangByNama = barangRepository.findBarangByNama(request.getNama());
        if (barangByNama.isPresent()){
            throw new ResourceIsExistingException("sorry "+request.getNama()+" " +
                    "barang is existing in our database !");
        }
        Kategori kategori = new Kategori();
        kategori.setIdKategori(request.getKategori());
        Barang barang = 
                 Barang.builder()
                .idBarang(request.getIdBarang())
                .nama(request.getNama())
                .jumlah(request.getJumlah())
                .kategori(kategori)
                .build();
        return barangRepository.save(barang);
    }

    @Override
    public Barang UpdateBarang(String idBarang, BarangRequest request) {
        Barang barang =  barangRepository.findById(idBarang)
                .orElseThrow(() -> new ResourceNotFoundException("Data Barang Tidak Ditemukan"));

//        Optional<Barang> barangByName = barangRepository.findBarangByNama(request.getNama());
//
//        if (barangByName.isPresent()){
//            throw new ResourceIsExistingException("sorry "+request.getNama()+" is existing in our database !");
//        }

        Kategori kategori = new Kategori();
        kategori.setIdKategori(request.getKategori());
        
        barang.setNama(request.getNama());
        barang.setJumlah(request.getJumlah());
        barang.setKategori(kategori);
        return barangRepository.save(barang);
    }

    @Override
    public boolean DeleteBarang(String idBarang) {
        boolean valid = false;
        
        Barang barang =  barangRepository.findById(idBarang)
                .orElseThrow(() -> new ResourceNotFoundException("Data Barang Tidak Ditemukan"));
        
        if(barang != null){
             barangRepository.delete(barang);
             valid = true;
        }
        
        return valid;
    }
    
}
