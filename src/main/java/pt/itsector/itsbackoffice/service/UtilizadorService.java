package pt.itsector.itsbackoffice.service;

import pt.itsector.itsbackoffice.model.Utilizador;

public interface UtilizadorService {

	public Utilizador getUtilizadorById(Integer id);
	
	public Utilizador createUtilizador(Utilizador utilizador);
	
	public Iterable<Utilizador> listUtilizador();
	
	public void removeUtilizador(Integer userId);
	
	public Utilizador updateUtilizador(Integer userId, Utilizador utilizador);

}
