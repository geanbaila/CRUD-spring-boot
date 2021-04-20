package com.geanbaila.parcial.repository;

import com.geanbaila.parcial.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalleEntity,Long>{
    @Transactional
    @Modifying
    @Query(value="DELETE FROM factura_detalle WHERE factura_id=?1", nativeQuery = true)
    void deleteByFactura(Long factura_id);

}
