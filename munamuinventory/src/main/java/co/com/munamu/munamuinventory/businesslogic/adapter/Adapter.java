package co.com.munamu.munamuinventory.businesslogic.adapter;

public interface Adapter<D,T> {
	
	D adaptTarjet (T data);
	
	T adaptSource (D data);

}
