package idat.edu.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.repository.ClienteRepository;

import idat.edu.pe.dto.ClienteRequestDTO;
import idat.edu.pe.dto.ClienteResponseDTO;
import idat.edu.pe.model.Cliente;

@Service
public class ClienteServiceImplement implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public void guardarCliente(ClienteRequestDTO cliente) {
		Cliente c = new Cliente();
		c.setNombre(cliente.getNombreCliente());
		c.setDireccion(cliente.getDireccionCliente());
		c.setDni(cliente.getDniCliente());
		repository.save(c);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarCliente(ClienteRequestDTO cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClienteResponseDTO> listarCliente() {
		List<Cliente> cliente = repository.findAll();
		List<ClienteResponseDTO> dto = new ArrayList<ClienteResponseDTO>();
		ClienteResponseDTO clienteDTO = null;
		
		for (Cliente c : cliente) {
			clienteDTO = new ClienteResponseDTO();
			clienteDTO.setIdCliente(c.getIdCliente());
			clienteDTO.setNombreCliente(c.getNombre());
			clienteDTO.setDireccionCliente(c.getDireccion());
			clienteDTO.setDniCliente(c.getDni());
			dto.add(clienteDTO);
		}
		
		return dto;
	}

	@Override
	public ClienteResponseDTO clienteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
