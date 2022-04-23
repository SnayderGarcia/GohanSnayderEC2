package idat.edu.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.dto.UsuarioRequestDTO;
import idat.edu.pe.dto.UsuarioResponseDTO;
import idat.edu.pe.security.JWTTokenUtil;
import idat.edu.pe.security.JWTUserDetailService;


@RestController
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private JWTUserDetailService jWTUserDetailService;
	
	@Autowired
	private JWTTokenUtil jwtTokenUtil;
	
	@RequestMapping(method = RequestMethod.POST, path = "/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UsuarioRequestDTO request){
		
		UserDetails userDetail = jWTUserDetailService.loadUserByUsername(request.getUsuario());

		return ResponseEntity.ok(new UsuarioResponseDTO(jwtTokenUtil.generateToken(userDetail.getUsername())));
	}

}
