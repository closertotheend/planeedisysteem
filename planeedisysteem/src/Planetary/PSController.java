package Planetary;






/**
 * Kontroller klass (vt GRASP muster), mis toimib fassaadina kogu planeedisüsteemi simulatsiooni 
 * rakendusele.
 * 
 * @author Priit Reiser - 2009
 * lihtsustused A. Torim
 */
public class PSController {

	// T määrab, mitu atomaarset tick sammu on Maa aastas
	private final static double T = 4; 

	// Planeedisüsteem, millel simulatsioon toimub
	private PlanetarySystem<PointSimulationElement> planetarySystem = null;	

		
	/**	 * Fassaadmeetod, mis loob uue planeedisüsteemi
	 */
	public void makeSolarSystem() {
		
		if(getPlanetarySystem() == null) {
						
			this.planetarySystem = new PlanetarySystem<PointSimulationElement>();
			getPlanetarySystem().append(new Planet(0.39, 0.0, (2.0 * Math.PI) /  (87.97/365.26) * T));
			getPlanetarySystem().append(new Planet(0.72, 0.0, (2.0 * Math.PI) /  (227.7/365.26) * T));
			getPlanetarySystem().append(new Planet(1.0, 0.0, (2.0 * Math.PI) /  (1.0) * T));
			getPlanetarySystem().append(new Planet(1.52, 0.0, (2.0 * Math.PI) /  (686.98/365.26) * T));
			getPlanetarySystem().append(new Planet(5.2, 0.0, (2.0 * Math.PI) /  (11.86) * T));
			getPlanetarySystem().append(new Planet(9.54, 0.0, (2.0 * Math.PI) /  (29.46) * T));
			getPlanetarySystem().append(new Planet(19.18, 0.0, (2.0 * Math.PI) /  (84.01) * T));
			getPlanetarySystem().append(new Planet(30.06, 0.0, (2.0 * Math.PI) /  (164.81) * T));
			getPlanetarySystem().append(new Planet(39.75, 0.0, (2.0 * Math.PI) /  (247.7) * T));
					
		}	
	}
	


	/**
	 * Fassaadmeetod, mis liigutab planeedisüsteemi objekte ühe atomaarse sammu võrra
	 */
	public synchronized void tick() {	
		
		getPlanetarySystem().tick();		
	}
	
	
	
	
	public PlanetarySystem<PointSimulationElement> getPlanetarySystem() {
		
		return planetarySystem;
	}

}
