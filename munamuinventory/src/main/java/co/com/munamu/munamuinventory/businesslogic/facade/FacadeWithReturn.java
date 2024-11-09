package co.com.munamu.munamuinventory.businesslogic.facade;

public interface FacadeWithReturn <T,R> {

	R execute (T data);
}
