/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.controller;

import com.dicky.react.ApiReact.configroute.ApiRoute;
import com.dicky.react.ApiReact.model.Kategori;
import com.dicky.react.ApiReact.request.KategoriRequest;
import com.dicky.react.ApiReact.response.GlobalResponse;
import com.dicky.react.ApiReact.service.IKategoriService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dickyadriansyah
 */
@RestController
public class KategoriController {
    
    @Autowired
    public IKategoriService _kategoriService;
    
    private HashMap<String, String> hashMapValidation;
    
    public KategoriController(IKategoriService kategoriService){
        _kategoriService = kategoriService;
    }
    
    @GetMapping(value = ApiRoute.GetAllKategori)
    public ResponseEntity<GlobalResponse<ArrayList<Kategori>>> listKategoris(){
        ArrayList<Kategori> arrayCategory = (ArrayList<Kategori>) _kategoriService.getKategori();
        GlobalResponse restResponse;
        if (arrayCategory.isEmpty()){
            restResponse = GlobalResponse
                    .builder().timestamp(LocalDateTime.now())
                    .message("Data Kategori Not Found")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(arrayCategory).build();
        }else{
            restResponse = GlobalResponse
                    .builder().timestamp(LocalDateTime.now())
                    .message("success")
                    .status(HttpStatus.OK.value())
                    .data(arrayCategory).build();
        }
        return new ResponseEntity<>(restResponse, HttpStatus.OK);
    }
    
    @GetMapping(value = ApiRoute.GetByIdKategori)
    public ResponseEntity<Kategori> getByIdKategori(@PathVariable("idKategori")String idKategori){
        Kategori kategori = _kategoriService.getByIdKategori(idKategori);
        return new ResponseEntity<>(kategori, HttpStatus.OK);
    }
    
    @PostMapping(value = ApiRoute.PostKategori)
    public ResponseEntity<Object> createKategori(@RequestBody @Valid KategoriRequest saveKategoriRequest,
                                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            hashMapValidation = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                hashMapValidation.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(hashMapValidation, HttpStatus.NOT_ACCEPTABLE);
        }

        Kategori kategori = _kategoriService.SaveKategori(saveKategoriRequest);
        return new ResponseEntity<>(kategori, HttpStatus.CREATED);
    }
    
    @PutMapping(value = ApiRoute.PutKategori)
    public ResponseEntity<Object> updateKategori(@PathVariable("idKategori")String idKategori,
                                                   @RequestBody KategoriRequest updateKategoriRequest,
                                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            hashMapValidation = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                hashMapValidation.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(hashMapValidation, HttpStatus.NOT_ACCEPTABLE);
        }

        Kategori kategori = _kategoriService.UpdateKategori(idKategori, updateKategoriRequest);
        return new ResponseEntity<>(kategori, HttpStatus.OK);
    }
    
    @DeleteMapping(value = ApiRoute.DeleteKategori)
    public ResponseEntity<GlobalResponse<String>> deleteKategori(@PathVariable("idKategori")String idKategori){
        boolean valid = _kategoriService.DeleteKategori(idKategori);
        
        GlobalResponse restResponse = null;
        if (valid == true){
            restResponse = GlobalResponse
                    .builder().timestamp(LocalDateTime.now())
                    .message("success")
                    .status(HttpStatus.OK.value())
                    .data("Data Berhasil Di Hapus").build();
        }
        
        return new ResponseEntity<>(restResponse , HttpStatus.OK);
    }

    
}
