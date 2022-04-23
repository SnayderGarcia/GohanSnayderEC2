package idat.edu.pe.dto;

public class UsuarioRequestDTO {
	
	private String usuario;
	private String contrasenia;
	
	
	public UsuarioRequestDTO() {
		super();
	}
	public UsuarioRequestDTO(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	

}
