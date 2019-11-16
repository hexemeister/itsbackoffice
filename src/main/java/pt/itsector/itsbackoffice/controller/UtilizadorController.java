package pt.itsector.itsbackoffice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.itsector.itsbackoffice.model.Utilizador;
import pt.itsector.itsbackoffice.service.UtilizadorService;

@RestController
@RequestMapping
public class UtilizadorController {

	private final UtilizadorService utilizadorService;
	
	public UtilizadorController(UtilizadorService utilizadorService) {
		this.utilizadorService = utilizadorService;
	}



	@GetMapping("/api/v1/user")
	public ResponseEntity<Utilizador> getUtilizador() {
		return new ResponseEntity<>(utilizadorService.getUtilizadorById(), HttpStatus.OK);
	}
}