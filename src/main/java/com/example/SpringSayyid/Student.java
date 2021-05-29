package com.example.SpringSayyid;
public class Student{
	public long id;
	public int age;
	public String name;
	
	@Override
	public String toString() {
		return ("[id:"+id+" , age:"+age+" , name:"+name+"]");
	}
}