package pt.itsector.itsbackoffice.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pt.itsector.itsbackoffice.model.Utilizador;
import pt.itsector.itsbackoffice.repository.UtilizadorRepository;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UtilizadorServiceImpl implements UtilizadorService {

	private final UtilizadorRepository utilizadorRepository;
	
	@Override
	public Utilizador getUtilizadorById(Integer id) {
		
		return utilizadorRepository.findById(id).get();
	}

	@Override
	public Utilizador createUtilizador(Utilizador utilizador) {
		Utilizador u = Utilizador.builder()
				.nome(utilizador.getNome())
				.password(utilizador.getPassword())
				.username(utilizador.getUsername())
				.createTimestamp(OffsetDateTime.now())
				.updateTimestamp(OffsetDateTime.now())
				.build();
		return utilizadorRepository.save(u);
	}

	@Override
	public Iterable<Utilizador> listUtilizador() {
		return null;
	}

	@Override
	public Utilizador updateUtilizador(Integer userId, Utilizador user) {
		Utilizador utilizador = utilizadorRepository.findById(userId).get();
		
		log.info("Updating user: " + utilizador.toString());
		utilizador.setNome(user.getNome());
		utilizador.setPassword(user.getPassword());
		utilizador.setUsername(user.getUsername());
		
		return utilizadorRepository.save(utilizador);
	}

	@Override
	public void removeUtilizador(Integer userId) {
		log.info("Deleting user: " + userId);
		utilizadorRepository.deleteById(userId);
	}

}
