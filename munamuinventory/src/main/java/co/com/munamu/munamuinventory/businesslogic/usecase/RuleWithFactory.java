package co.com.munamu.munamuinventory.businesslogic.usecase;

import co.com.munamu.munamuinventory.data.dao.DAOFactory;

public interface RuleWithFactory<T> {
	
	void execute(T data, DAOFactory factory);

}
