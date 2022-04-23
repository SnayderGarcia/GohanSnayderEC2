package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.dto.ClienteRequestDTO;
import idat.edu.pe.dto.ClienteResponseDTO;
import idat.edu.pe.service.ClienteService;

@RestController
@RequestMapping("/cliente/v2")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<ClienteResponseDTO>>listar(){
		
		return new ResponseEntity<List<ClienteResponseDTO>>(service.listarCliente(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ClienteRequestDTO producto){
		service.guardarCliente(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ClienteResponseDTO product = service.clienteById(id);
		if(product != null) {
			service.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

}
