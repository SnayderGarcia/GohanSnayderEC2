package idat.edu.pe.dto;

public class ProductoResponseDTO {
	
	private Integer idResponse;
	private String producto;
	private String nombreProducto;
	private String descripcionProducto;
	private Double precioProducto;
	private Integer stockProducto;
	
	public Integer getIdResponse() {
		return idResponse;
	}
	public void setIdResponse(Integer idResponse) {
		this.idResponse = idResponse;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public Double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}
	public Integer getStockProducto() {
		return stockProducto;
	}
	public void setStockProducto(Integer stockProducto) {
		this.stockProducto = stockProducto;
	}
	
	
	
	
	

}
