package pt.itsector.itsbackoffice.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import pt.itsector.itsbackoffice.model.Utilizador;

@Service
public class UtilizadorServiceImpl implements UtilizadorService {

	
	
	@Override
	public Utilizador getUtilizadorById() {
		Utilizador u = Utilizador.builder()
				.nome("Renato")
				.password("123")
				.id(1)
				.username("hexemeister")
				.createTimestamp(OffsetDateTime.now())
				.updateTimestamp(OffsetDateTime.now())
				.build();
		return u;
		
	}

}
