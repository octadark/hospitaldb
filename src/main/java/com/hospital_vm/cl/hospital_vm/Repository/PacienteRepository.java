package com.hospital_vm.cl.hospital_vm.Repository;


import com.hospital_vm.cl.hospital_vm.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    @Query("SELECT p FROM paciente p WHERE p.apellidos = :apellido")
    List<Paciente> buscarPorApellidos(@Param("apellidos") String apellido);

    @Query(value = "SELECT * FROM paciente WHERE correo = :correo", nativeQuery = true)
    Paciente buscarPorCorreo(@Param("correo") String correo);

}
