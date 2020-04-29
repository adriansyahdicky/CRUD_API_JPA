/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.repository;

import com.dicky.react.ApiReact.model.Kategori;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dickyadriansyah
 */
@Repository
public interface KategoriRepository extends JpaRepository<Kategori, String>{
    Optional<Kategori> findKategoryByNama(String nama);
}
