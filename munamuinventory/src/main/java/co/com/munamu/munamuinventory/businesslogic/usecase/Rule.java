package co.com.munamu.munamuinventory.businesslogic.usecase;

public interface Rule<T> {
	
	void execute(T data);

}
