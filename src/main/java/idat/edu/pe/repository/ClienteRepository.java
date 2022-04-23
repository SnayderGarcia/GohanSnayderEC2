package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
