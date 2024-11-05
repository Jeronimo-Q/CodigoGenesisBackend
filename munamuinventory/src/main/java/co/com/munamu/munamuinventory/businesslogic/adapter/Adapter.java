package co.com.munamu.munamuinventory.businesslogic.adapter;

import java.util.List;

public interface Adapter<D,T> {
	
	D adaptTarjet (T data);
	
	T adaptSource (D data);
	
	List<T> adaptSource(List<D> data);
	
	List<D> adaptTarjet(List<T> data);

}
