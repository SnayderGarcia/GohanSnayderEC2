package idat.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer>{

}
