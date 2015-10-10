package Planetary;

import java.util.*;


public class PlanetarySystem<T extends SimulationElement> implements SimulationElement{
	
	protected List<T> elemendid;
	
	public PlanetarySystem(){
		elemendid = new ArrayList<T>();
	}
	
	@Override
	public void tick() {
		for (T e : elemendid){
			e.tick();
		}
		
	}

	public void append(T element) {
		elemendid.add(element);
	}
	
	public T getElement(int indeks){
		return elemendid.get(indeks);
	}
	
	public int size(){
		return elemendid.size();
	}
	


}
