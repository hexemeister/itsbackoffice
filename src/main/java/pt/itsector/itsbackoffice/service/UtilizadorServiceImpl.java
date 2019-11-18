package pt.itsector.itsbackoffice.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pt.itsector.itsbackoffice.controller.ResourceNotFoundException;
import pt.itsector.itsbackoffice.model.Utilizador;
import pt.itsector.itsbackoffice.repository.UtilizadorRepository;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UtilizadorServiceImpl implements UtilizadorService {

	private final UtilizadorRepository utilizadorRepository;
	
	@Override
	public Utilizador getUtilizadorById(Integer userId) {
		log.debug("Fetching user with ID: " + userId);
		return utilizadorRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Resource not found for id: " + userId));
	}

	@Override
	public Utilizador createUtilizador(Utilizador utilizador) {
		log.debug("Creating user...");
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
		log.debug("Listing all users...");
		return utilizadorRepository.findAll();
	}

	@Override
	public Utilizador updateUtilizador(Integer userId, Utilizador user) {
		
		Utilizador utilizador = utilizadorRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Resource not found for id: " + userId));
		
		log.debug("Updating user: " + utilizador.toString() + "\n to user: " + user);
		
		verifyIfUsernameIsTheSameAsProvided(user, utilizador);
		
		utilizador.setNome(user.getNome());
		utilizador.setPassword(user.getPassword());
		utilizador.setUsername(user.getUsername());
		
		return utilizadorRepository.save(utilizador);
	}

	private void verifyIfUsernameIsTheSameAsProvided(Utilizador user, Utilizador utilizador) {
		if (!user.getUsername().equals(utilizador.getUsername())) {
			throw new CannotChangeUsernameException("Username does not match");
		}
	}

	@Override
	public void removeUtilizador(Integer userId) {
		log.debug("Deleting user: " + userId);
		utilizadorRepository.deleteById(userId);
	}

}
