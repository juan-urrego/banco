package com.onnovacion.banco.repository;

import com.onnovacion.banco.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    @Procedure(value = "movimientosop.FN_CREAR_MOOVIMIENTO")
    void saveMovimiento(@Param("pvalor") double valor, @Param("pcuenta") int cuenta, @Param("prespuesta") String respuesta, @Param("pmensajeerror") String error );
}
