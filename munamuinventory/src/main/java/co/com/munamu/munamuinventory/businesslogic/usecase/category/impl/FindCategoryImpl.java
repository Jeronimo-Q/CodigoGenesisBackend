package co.com.munamu.munamuinventory.businesslogic.usecase.category.impl;

import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.entity.CategoryEntityAdapter;
import co.com.munamu.munamuinventory.businesslogic.usecase.category.FindCategory;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.domain.CategoryDomain;


public final class FindCategoryImpl implements FindCategory{
	
	private DAOFactory daoFactory;
	
	public FindCategoryImpl(DAOFactory daoFactory){
		setDaoFactory(daoFactory);
	}

	@Override
	public List<CategoryDomain> execute() {
		
		var result = daoFactory.getCategoryDAO().findAll();	
		
		return CategoryEntityAdapter.getCategoryEntityAdapter().adaptTarjet(result);
	}

	public void setDaoFactory(final DAOFactory daoFactory) {
		if(ObjectHelper.isNull(daoFactory)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la busqueda de las categorias existentes. Por favor intente de nuevo y si el problema persiste, llame a los tecnicos";
			var technicalMessage = "El dao factory requerido para buscar la clase que busca las categorias llego nula.";
			throw BusinessLogicMunamuInventoryException.create(userMessage,technicalMessage,new Exception());
		}
		this.daoFactory = daoFactory;
	}


}