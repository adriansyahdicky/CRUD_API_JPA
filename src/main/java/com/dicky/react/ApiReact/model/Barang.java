/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dickyadriansyah
 */
@Entity
@Builder
@Table(name = "barang")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Barang implements Serializable{
    
    @Id
    private String idBarang;
    
    private String nama;
    
    private int jumlah;
    
    @ManyToOne
    @JoinColumn(name = "id_kategori", nullable = false)
    private Kategori kategori;
    
}
