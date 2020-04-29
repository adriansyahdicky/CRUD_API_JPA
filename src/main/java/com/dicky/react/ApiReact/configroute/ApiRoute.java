/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.configroute;


/**
 *
 * @author dickyadriansyah
 */

public class ApiRoute {
    
   //kategori api route 
   public static final String GetAllKategori = "/api/kategori/listkategori";
   public static final String GetByIdKategori = "/api/kategori/getbyid/{idKategori}";
   public static final String PostKategori = "/api/kategori/createkategori";
   public static final String PutKategori = "/api/kategori/updatekategori/{idKategori}";
   public static final String DeleteKategori = "/api/kategori/deletekategori/{idKategori}";
   
   //barang api route
   public static final String GetAllBarang = "/api/barang/listbarang";
   public static final String GetByIdBarang = "/api/barang/getbyid/{idBarang}";
   public static final String PostBarang = "/api/barang/createbarang";
   public static final String PutBarang = "/api/barang/updatebarang/{idBarang}";
   public static final String DeleteBarang = "/api/barang/deletebarang/{idBarang}";
   
}
