package idat.edu.pe.service;

import java.util.List;

import idat.edu.pe.dto.ProductoRequestDTO;
import idat.edu.pe.dto.ProductoResponseDTO;

public interface ProductoService {
	
	public void guardarProducto(ProductoRequestDTO p);
	public void eliminarProducto(Integer id);
	public void editarProducto(ProductoRequestDTO p);
	public List<ProductoResponseDTO> listarProductos();
	public ProductoResponseDTO productById(Integer id);


}
