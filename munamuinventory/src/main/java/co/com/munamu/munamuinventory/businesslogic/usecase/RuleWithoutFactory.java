package co.com.munamu.munamuinventory.businesslogic.usecase;


public interface RuleWithoutFactory<T> {
	void execute(T data);

}
