package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Table(name="Cliente")
@Entity
public class Cliente implements Serializable{
	

	private static final long serialVersionUID = -5345604334372604345L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	private String direccion;
	private String dni;
	

	@ManyToMany(mappedBy = "Cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Productos> Productos = new ArrayList<>();


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public List<Productos> getProductos() {
		return Productos;
	}


	public void setProductos(List<Productos> productos) {
		Productos = productos;
	}
	
	

}
