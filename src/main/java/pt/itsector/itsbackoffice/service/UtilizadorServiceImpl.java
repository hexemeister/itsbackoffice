package pt.itsector.itsbackoffice.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import pt.itsector.itsbackoffice.model.Utilizador;
import pt.itsector.itsbackoffice.repository.UtilizadorRepository;

@Service
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
	public List<Utilizador> listUtilizador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilizador removeUtilizador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilizador updateUtilizador(Integer userId, Utilizador user) {
		Utilizador utilizador = utilizadorRepository.findById(userId).get();
		
		return utilizador.builder()
				.nome(user.getNome())
				.password(user.getPassword())
				.username(user.getPassword())
				.build();
	}

}
