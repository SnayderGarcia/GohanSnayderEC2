package idat.edu.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import idat.edu.pe.dto.ProductoRequestDTO;
import idat.edu.pe.dto.ProductoResponseDTO;
import idat.edu.pe.model.Productos;
import idat.edu.pe.repository.ProductosRepository;

@Service
public class ProductoServiceImplement implements ProductoService{
	
	@Autowired
	private ProductosRepository  repository;

	@Override
	public void guardarProducto(ProductoRequestDTO p) {
		Productos producto = new Productos();
		producto.setIdProducto(p.getIdRequest());
		producto.setDescripcion(p.getDescripcionProducto());
		producto.setProducto(p.getProducto());
		producto.setDescripcion(p.getDescripcionProducto());
		producto.setPrecio(p.getPrecioProducto());
		producto.setStock(p.getStockProducto());
		repository.save(producto);
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarProducto(ProductoRequestDTO p) {
		Productos producto = new Productos();
		producto.setIdProducto(p.getIdRequest());
		producto.setDescripcion(p.getDescripcionProducto());
		producto.setProducto(p.getProducto());
		producto.setPrecio(p.getPrecioProducto());
		producto.setStock(p.getStockProducto());
		repository.saveAndFlush(producto);
		
	}

	@Override
	public List<ProductoResponseDTO> listarProductos() {
		List<Productos> producto = repository.findAll();
		
		List<ProductoResponseDTO> dto = new ArrayList<ProductoResponseDTO>();
		ProductoResponseDTO productoDto = null;
		
		
		for (Productos products : producto) {
			productoDto = new ProductoResponseDTO();
			productoDto.setIdResponse(products.getIdProducto());
			productoDto.setProducto(products.getProducto());
			productoDto.setDescripcionProducto(products.getDescripcion());
			productoDto.setPrecioProducto(products.getPrecio());
			productoDto.setStockProducto(products.getStock());
			dto.add(productoDto);
		}
		
		return dto;
	}

	@Override
	public ProductoResponseDTO productById(Integer id) {
		Productos products = repository.findById(id).orElse(null);
		ProductoResponseDTO productoDto = new ProductoResponseDTO();
		
		productoDto = new ProductoResponseDTO();
		productoDto.setIdResponse(products.getIdProducto());
		productoDto.setProducto(products.getProducto());
		productoDto.setDescripcionProducto(products.getDescripcion());
		productoDto.setPrecioProducto(products.getPrecio());
		productoDto.setStockProducto(products.getStock());
		
		return productoDto;
	}
	
}
