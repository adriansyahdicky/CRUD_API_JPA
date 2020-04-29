/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.request;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author dickyadriansyah
 */
@Data
@AllArgsConstructor
public class KategoriRequest {
    @NotBlank(message = "ID Kategori Tidak Boleh Kosong")
    public String idKategori;
    @NotBlank(message = "Nama Kategori Tidak Boleh Kosong")
    public String nama;
}
