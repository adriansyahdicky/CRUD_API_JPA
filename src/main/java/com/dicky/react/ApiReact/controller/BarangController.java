/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.controller;

import com.dicky.react.ApiReact.configroute.ApiRoute;
import com.dicky.react.ApiReact.model.Barang;
import com.dicky.react.ApiReact.request.BarangRequest;
import com.dicky.react.ApiReact.response.GlobalResponse;
import com.dicky.react.ApiReact.service.IBarangService;
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
public class BarangController {
    
    @Autowired
    public IBarangService _barangService;
    
    private HashMap<String, String> hashMapValidation;
    
    public BarangController(IBarangService barangService){
        _barangService = barangService;
    }
    
    @GetMapping(value = ApiRoute.GetAllBarang)
    public ResponseEntity<GlobalResponse<ArrayList<Barang>>> listBarangs(){
        ArrayList<Barang> dataBarang = (ArrayList<Barang>) _barangService.getBarangs();
        GlobalResponse restResponse;
        if (dataBarang.isEmpty()){
            restResponse = GlobalResponse
                    .builder().timestamp(LocalDateTime.now())
                    .message("Data Kategori Not Found")
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(dataBarang).build();
        }else{
            restResponse = GlobalResponse
                    .builder().timestamp(LocalDateTime.now())
                    .message("success")
                    .status(HttpStatus.OK.value())
                    .data(dataBarang).build();
        }
        return new ResponseEntity<>(restResponse, HttpStatus.OK);
    }
    
    @GetMapping(value = ApiRoute.GetByIdBarang)
    public ResponseEntity<GlobalResponse<Barang>> getByIdBarang(@PathVariable("idBarang")String idBarang){
        Barang barang = _barangService.getByIdBarang(idBarang);
        GlobalResponse restResponse = GlobalResponse
                        .builder().timestamp(LocalDateTime.now())
                        .message("success")
                        .status(HttpStatus.OK.value())
                        .data(barang).build();
        
        return new ResponseEntity<>(restResponse, HttpStatus.OK);
    }
    
    @PostMapping(value = ApiRoute.PostBarang)
    public ResponseEntity<Object> createBarang(@RequestBody @Valid BarangRequest saveBarangRequest,
                                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            hashMapValidation = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                hashMapValidation.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(hashMapValidation, HttpStatus.NOT_ACCEPTABLE);
        }

        Barang barang = _barangService.SaveBarang(saveBarangRequest);
        return new ResponseEntity<>(barang, HttpStatus.CREATED);
    }
    
    @PutMapping(value = ApiRoute.PutBarang)
    public ResponseEntity<Object> updateBarang(@PathVariable("idBarang")String idBarang,
                                                   @RequestBody BarangRequest updateBarangRequest,
                                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            hashMapValidation = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                hashMapValidation.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(hashMapValidation, HttpStatus.NOT_ACCEPTABLE);
        }

        Barang barang = _barangService.UpdateBarang(idBarang, updateBarangRequest);
        return new ResponseEntity<>(barang, HttpStatus.OK);
    }
    
    @DeleteMapping(value = ApiRoute.DeleteBarang)
    public ResponseEntity<GlobalResponse<String>> deleteBarang(@PathVariable("idBarang")String idBarang){
        boolean valid = _barangService.DeleteBarang(idBarang);
        
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
