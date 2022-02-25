package controller;

import java.util.List;

public interface IDAO<T> {

	public boolean create (T Object);
	public List <T> read();
	public boolean delete (T Object);
	public T findById(int id);
}
