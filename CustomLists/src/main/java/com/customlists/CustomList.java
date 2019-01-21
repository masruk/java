package com.customlists;

@SuppressWarnings("unchecked")
public class CustomList<T>{
	private Object[] list; 
	private int top;
	private int listCapacity = 100;
	
	CustomList(){
		list = new Object[listCapacity];
		top = -1;
	}
	
	public CustomList<T> add(T obj) {
		list[++top] = obj;
		return this;
	}
	
	public boolean addAt(int i, T obj) {
		int index = ++top;
		while(index>=i) {
			list[index+1] = list[index];
			index--;
		}
		list[i] = obj;
		return true;
	}
	
	/*
	public T[] addAll(T[] objList) {
		if((objList.length + this.top) < this.listCapacity) {
			for(T obj : objList) {
				if(obj != null)
					this.add(obj);
			}
		}
		return (T[])list;
	}*/
	
	public CustomList<T> addAll(CustomList<T> objList) {
		if((objList.size() + this.top) < this.listCapacity) {
			for(int i = 0; i<objList.size(); i++) {
					this.add(objList.get(i));
			}
		}
		return this;
	}
	
	public boolean removeAt(int i) {
		if(isAvailable(i)) {
			while(i<this.top) {
				list[i]=list[i+1];
				i++;
			}
			list[top] = null;
			this.top--;
			return true;
		}
		return false;
	}
	
	public boolean remove(T obj) {
		for(int i = 0; i <= top; i++){
			if(obj.equals( (T)list[i]) ) {
				return removeAt(i);
			}
		}
		return false;
	}
	
	public CustomList<T> removeAll(CustomList<T> objList) {
		for(int i = 0; i<objList.size(); i++) {
				remove(objList.get(i));
		}
		return this;
	}
	
	public boolean replace(T toBeReplaced, T replaceWith) {
		int position = find(toBeReplaced);
		if(position != -1) {
			list[position] = replaceWith;
			return true;
		}
		return false;
	}
	
	public int find(T obj) {
		for(int i = 0; i <= top; i++)
		{
			if(obj.equals( (T)list[i]) ) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(T obj){
		if(find(obj) != -1)
			return true;
		return false;
	}
	
	public Object[] toArray() {
		return list;
	}
	
	
	public T get(int i) {
		return (T)list[i];
	}
	
	public int size() {
		return this.top+1;
	}
	
	private boolean isAvailable(int i) {
		if(list[i] != null)
			return true;
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		CustomList<T> customList = (CustomList<T>) obj;

		for(int i = 0; i < this.size(); i++) {
			if(!this.get(i).equals(customList.get(i)))
				return false;
		}
		return true;
	}
	
}
