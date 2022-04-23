package idat.edu.pe.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name="Bodega")
@Entity
public class Bodega implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6568922302378017008L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBodega;
	private String nombre;
	private String direccion;
	
	
	@ManyToOne
	@JoinColumn(name="id_producto", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references Productos (id_producto)"))
	private Productos Productos;


	public Integer getIdBodega() {
		return idBodega;
	}


	public void setIdBodega(Integer idBodega) {
		this.idBodega = idBodega;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Productos getProductos() {
		return Productos;
	}


	public void setProductos(Productos productos) {
		Productos = productos;
	}
	
	
	

}
