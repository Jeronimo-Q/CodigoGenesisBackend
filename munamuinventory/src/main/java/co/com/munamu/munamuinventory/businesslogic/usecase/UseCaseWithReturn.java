package co.com.munamu.munamuinventory.businesslogic.usecase;

public interface UseCaseWithReturn <D, R>{

	R execute(D data);
	
}
