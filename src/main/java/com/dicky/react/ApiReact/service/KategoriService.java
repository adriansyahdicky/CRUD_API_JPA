/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.service;

import com.dicky.react.ApiReact.exception.ResourceIsExistingException;
import com.dicky.react.ApiReact.exception.ResourceNotFoundException;
import com.dicky.react.ApiReact.model.Kategori;
import com.dicky.react.ApiReact.repository.KategoriRepository;
import com.dicky.react.ApiReact.request.KategoriRequest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dickyadriansyah
 */
@Service
public class KategoriService implements IKategoriService{

    @Autowired
    public KategoriRepository kategoriRepository;
    
    public KategoriService(KategoriRepository kategoriRepository){
        this.kategoriRepository = kategoriRepository;
    }
    
    @Override
    public List<Kategori> getKategori() {
        List<Kategori> kategoris = kategoriRepository.findAll();
        return kategoris;
    }

    @Override
    public Kategori getByIdKategori(String id) {
         return kategoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id kategori "+id+" not found !"));
    }

    @Override
    public Kategori SaveKategori(KategoriRequest request) {
        Optional<Kategori> kategoriByNama = kategoriRepository.findKategoryByNama(request.getNama());
        if (kategoriByNama.isPresent()){
            throw new ResourceIsExistingException("sorry "+request.getNama()+" " +
                    "kategori is existing in our database !");
        }
        
        Kategori kategori = 
                 Kategori.builder()
                .idKategori(request.getIdKategori()).nama(request.getNama())
                .build();
        return kategoriRepository.save(kategori);
        
    }

    @Override
    public Kategori UpdateKategori(String idKategori, KategoriRequest request) {
        Kategori kategori =  kategoriRepository.findById(idKategori)
                .orElseThrow(() -> new ResourceNotFoundException("Data Kategori Tidak Ditemukan"));

        Optional<Kategori> categoryByName = kategoriRepository.findKategoryByNama(request.getNama());

        if (categoryByName.isPresent()){
            throw new ResourceIsExistingException("sorry "+request.getNama()+" is existing in our database !");
        }

        kategori.setNama(request.getNama());
        return kategoriRepository.save(kategori);
    }

    @Override
    public boolean DeleteKategori(String idKategori) {
        
        boolean valid = false;
        
        Kategori kategori =  kategoriRepository.findById(idKategori)
                .orElseThrow(() -> new ResourceNotFoundException("Data Kategori Tidak Ditemukan"));
        
        if(kategori != null){
             kategoriRepository.delete(kategori);
             valid = true;
        }
        
        return valid;
    }
    
}
