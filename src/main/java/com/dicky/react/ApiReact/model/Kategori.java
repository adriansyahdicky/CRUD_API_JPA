/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "kategori")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kategori implements Serializable{
    
    @Id
    private String idKategori;
    
    private String nama;
    
    @JsonIgnore
    @OneToMany(mappedBy="kategori", fetch = FetchType.LAZY)
    private Set<Barang> barangs = new HashSet<Barang>(0);
}
