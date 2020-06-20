package sh.locus.manager.access.dao;

import java.util.List;

public interface BaseDao<K, T> {

	T create(T obj);
	
	T read(K id);
	
	List<T> read(List<K> id);
	
	T update(T obj);
	
	T delete(T obj);
}
