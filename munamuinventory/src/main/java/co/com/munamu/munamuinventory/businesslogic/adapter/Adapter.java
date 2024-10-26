package co.com.munamu.munamuinventory.businesslogic.adapter;

public interface Adapter<D,T> {
	
	D adaptSource (T data);
	
	T adaptTarget (D data);

}
