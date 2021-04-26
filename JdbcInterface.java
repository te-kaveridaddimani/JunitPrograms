package com.te.jdbc;

import java.util.ArrayList;
import java.util.List;

public interface Jdbc {

	
	public ArrayList<Object> selectAllEmp();
	public void insertEmp(int id, String name, Double sal);
	public void deleteEmp(int id);
	public void update( double sal, int id);
}
