package pt.itsector.itsbackoffice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pt.itsector.itsbackoffice.model.Utilizador;
import pt.itsector.itsbackoffice.service.UtilizadorService;

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
	public ResponseEntity<Utilizador> saveNewUtilizador(@RequestBody Utilizador utilizador) {
		return new ResponseEntity<>(utilizadorService.createUtilizador(utilizador), HttpStatus.CREATED);
	}
	
	@GetMapping("/user/createuser")
	public ResponseEntity<Utilizador> createUtilizador() {
		return new ResponseEntity<>(utilizadorService.createUtilizador(Utilizador.builder().nome("Renato").password("123").build()), HttpStatus.OK);
	}
	
	@PutMapping("user/{userId}")
    public ResponseEntity<Utilizador> updateUtilizadorById(@PathVariable("userId") Integer userId, @RequestBody Utilizador utilizador){
        return new ResponseEntity<>(utilizadorService.updateUtilizador(userId, utilizador), HttpStatus.NO_CONTENT);
    }
	
	@DeleteMapping("user/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUtilizador(@PathVariable("userId") Integer userId) {
		utilizadorService.removeUtilizador(userId);
	}
//	{
//	    "id": 1,
//	    "username": null,
//	    "password": null,
//	    "nome": "Viviane",
//	    "createTimestamp": "2019-11-16T18:30:08.274983Z",
//	    "updateTimestamp": "2019-11-16T18:30:08.275063Z"
//	}
}
