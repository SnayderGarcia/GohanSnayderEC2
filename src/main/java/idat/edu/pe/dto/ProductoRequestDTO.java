package idat.edu.pe.dto;

public class ProductoRequestDTO {

	private Integer idRequest;
	private String producto;
	private String descripcionProducto;
	private Double precioProducto;
	private Integer stockProducto;
	public Integer getIdRequest() {
		return idRequest;
	}
	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
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
