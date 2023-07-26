package com.company.api.repositoy;

import com.company.api.model.Marca;
import com.company.api.model.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
