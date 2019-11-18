package pt.itsector.itsbackoffice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import pt.itsector.itsbackoffice.model.Utilizador;
import pt.itsector.itsbackoffice.service.UtilizadorService;

@Slf4j
@RestController
@RequestMapping("/v1/")
public class UtilizadorController {

	private final UtilizadorService utilizadorService;
	
	public UtilizadorController(UtilizadorService utilizadorService) {
		this.utilizadorService = utilizadorService;
	}

	@GetMapping("user/{userId}")
	public ResponseEntity<Utilizador> getUtilizador(@PathVariable("userId") Integer userId) {
		return new ResponseEntity<>(utilizadorService.getUtilizadorById(userId), HttpStatus.OK);
	}
	
	@GetMapping("user")
	public ResponseEntity<Iterable<Utilizador>> listUtilizadores() {
		return new ResponseEntity<>(utilizadorService.listUtilizador(), HttpStatus.OK);
	}
	
	@PostMapping(path = "user")
	public ResponseEntity<Utilizador> saveNewUtilizador(@Validated @RequestBody Utilizador utilizador) {
			return new ResponseEntity<>(utilizadorService.createUtilizador(utilizador), HttpStatus.CREATED);
	}
	
	@PutMapping("user/{userId}")
    public ResponseEntity<Utilizador> updateUtilizadorById(@PathVariable("userId") Integer userId, @Validated @RequestBody Utilizador utilizador){
        return new ResponseEntity<>(utilizadorService.updateUtilizador(userId, utilizador), HttpStatus.NO_CONTENT);
    }
	
	@DeleteMapping("user/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUtilizador(@PathVariable("userId") Integer userId) {
		utilizadorService.removeUtilizador(userId);
	}
	
}
