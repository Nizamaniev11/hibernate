package nayzek.hibernate.dao;

import java.util.List;

public interface Dao<T> {

	void create(T object);

	T read(int id);

	void update(T object);

	void delete(T object);

	List<T> findAll();

}