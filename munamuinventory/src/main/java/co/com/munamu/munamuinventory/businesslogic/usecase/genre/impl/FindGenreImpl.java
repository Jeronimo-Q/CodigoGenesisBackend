package co.com.munamu.munamuinventory.businesslogic.usecase.genre.impl;

import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.entity.GenreEntityAdapter;
import co.com.munamu.munamuinventory.businesslogic.usecase.genre.FindGenre;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.domain.GenreDomain;


public final class FindGenreImpl implements FindGenre{
	
	private DAOFactory daoFactory;
	
	public FindGenreImpl(DAOFactory daoFactory){
		setDaoFactory(daoFactory);
	}

	@Override
	public List<GenreDomain> execute() {
		
		var result = daoFactory.getGenreDAO().findAll();	
		
		return GenreEntityAdapter.getGenreEntityAdapter().adaptTarjet(result);
	}

	public void setDaoFactory(final DAOFactory daoFactory) {
		if(ObjectHelper.isNull(daoFactory)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la busqueda de los generos existentes. Por favor intente de nuevo y si el problema persiste, llame a los tecnicos";
			var technicalMessage = "El dao factory requerido para buscar la clase que busca los generos llego nula.";
			throw BusinessLogicMunamuInventoryException.create(userMessage,technicalMessage,new Exception());
		}
		this.daoFactory = daoFactory;
	}


}
