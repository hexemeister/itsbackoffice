package pt.itsector.itsbackoffice.service;

import java.util.List;

import pt.itsector.itsbackoffice.model.Utilizador;

public interface UtilizadorService {

	public Utilizador getUtilizadorById(Integer id);
	
	public Utilizador createUtilizador(Utilizador utilizador);
	
	public List<Utilizador> listUtilizador();
	
	public Utilizador removeUtilizador();
	
	public Utilizador updateUtilizador(Integer userId, Utilizador utilizador);

}
