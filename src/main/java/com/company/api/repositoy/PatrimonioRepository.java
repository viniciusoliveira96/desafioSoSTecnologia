package com.company.api.repositoy;

import com.company.api.model.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {
    @Query(value = "SELECT * FROM patrimonios WHERE marca_id = ?" ,nativeQuery = true)
    public List<Patrimonio> findByMarcaId(Long marcaId);
}
