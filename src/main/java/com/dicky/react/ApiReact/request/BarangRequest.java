/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author dickyadriansyah
 */
@Data
@AllArgsConstructor
public class BarangRequest {
    
    @NotBlank(message = "ID Barang Tidak Boleh Kosong")
    private String idBarang;
    @NotBlank(message = "Nama Barang Tidak Boleh Kosong")
    private String nama;
    
    @JsonProperty
    @Max(message = "Jumlah Barang Maximum Harus 1", value = 1)
    @Min(message = "Jumlah Barang Minimum Harus 1", value = 1)
    private int jumlah;
    @NotBlank(message = "ID Kategori Tidak Boleh Kosong")
    private String kategori;
    
}
