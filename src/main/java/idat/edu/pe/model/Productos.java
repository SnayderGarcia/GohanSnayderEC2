package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Table(name="Productos")
@Entity
public class Productos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8904371674927728778L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String producto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="producto_cliente",
	joinColumns = @JoinColumn(name="id_producto", nullable = false, unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references Productos (id_producto)")),
	inverseJoinColumns =  @JoinColumn(name="id_cliente", nullable = false, unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references Cliente (id_cliente)"))
	)
	private List<Cliente> Cliente = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "Productos")
	private List<Bodega> items = new ArrayList<>();


	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public List<Cliente> getCliente() {
		return Cliente;
	}


	public void setCliente(List<Cliente> cliente) {
		Cliente = cliente;
	}


	public List<Bodega> getItems() {
		return items;
	}


	public void setItems(List<Bodega> items) {
		this.items = items;
	}
	
	
	
}
