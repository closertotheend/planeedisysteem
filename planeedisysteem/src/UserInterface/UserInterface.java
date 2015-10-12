package UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

import Planetary.PSController;
import Planetary.SpaceShip;


/**
 * Kasutajaliidese klass / kiht
 * 
 * @author Priit Reiser
 * lihtsustused A. Torim
 */
public class UserInterface extends JFrame {

	private static final int SLEEP_BETWEEN_TICKS = 50;

	private static final String LBL_TITLE_INFO_PANEL = "Time";

	private static final String LBL_SINGLE_TICK = "Tick";

	private static final String LBL_STOP_AUTO_TICK = "Stop auto tick";

	private static final String LBL_START_AUTO_TICK = "Start auto tick";
	
	private static final long serialVersionUID = 1L;
	public static final String LAUNCH = "Launch";

	private final PSController controller = new PSController(); 
	
	private final double cx;
	private final double cy;
	private final double zoom;
	private final double planetWidth;

	private static boolean tick = true;
	private static boolean auto = false;	
	
	private JPanel planetsPanel = new JPanel() {

		private static final long serialVersionUID = -4598415608421582065L;

		@Override
		public void paint(Graphics g) {			
			super.paint(g);
		    drawPlanets(g);		
		}
	};

	private JPanel timeBtnPanel = new JPanel();
	private JButton btnTick = new JButton(LBL_SINGLE_TICK);
	private JButton btnAuto = new JButton(LBL_START_AUTO_TICK);
	private JButton btnLaunch = new JButton(LAUNCH);

	public UserInterface() {
			
		// 1. loome uue planeedis�steemi
		this.controller.makeSolarSystem();	
		
		this.planetWidth = 3;
		this.cx = 350.0;
		this.cy = 350.0;
		this.zoom = 7.0;
		

		
		this.timeBtnPanel.add(btnTick);
		this.timeBtnPanel.add(btnAuto);
		this.timeBtnPanel.add(btnLaunch);
		this.timeBtnPanel.setBorder(BorderFactory.createTitledBorder(LBL_TITLE_INFO_PANEL));
								
		this.planetsPanel.setBackground(Color.black);				

		this.btnTick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleBtnClickSingleTick();				
			}
		});
		
		this.btnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleBtnClickAutoTick();				
			}
		});

		this.btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleBtnClickLaunch();
			}
		});
		
			
		this.setLayout(new BorderLayout());		
		this.add(planetsPanel, BorderLayout.CENTER);
		this.add(timeBtnPanel, BorderLayout.NORTH);

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.setVisible(true);
		
	
		
		new Thread(new Runnable() {
	    	public void run() {

	    		while(true) {
	    			
	    			if(tick) {
	    				
	    				
	    				// *** 1. arvutame objektide uued koordinaadid ***
	    				controller.tick();
		    			
		    			// *** 2. joonistame muutunud asukohad kasutajaliideses ***
		    			repaint();
						
		    			// *** 3. kui oleme manuaal reziimis, siis peata liikumine ***
						if(!auto) {
							tick = false;
						}						
	    			}
	    			
	    			try {
						Thread.sleep(SLEEP_BETWEEN_TICKS);						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	    			
	    		}
	    	}
	    }).start();				
	}
	
	public void handleBtnClickSingleTick() {
		
		auto = false;
		tick = true;
	}
	
	public void handleBtnClickAutoTick() {
		
		if(auto) {
			auto = false;
			tick = true;
			this.btnAuto.setText(LBL_START_AUTO_TICK);
		} else {
			auto = true;
			tick = true;
			this.btnAuto.setText(LBL_STOP_AUTO_TICK);
		}				
	}

	public void handleBtnClickLaunch() {
		launch();
	}

	public void launch() {
		controller.launch(7, 0.5, 0.5);
	}

	public void drawPlanets(final Graphics g) {			
		for (int i=0; i<controller.getPlanetarySystem().size(); i++ ){
			drawPlanet(g, i);
		}

	}
	
	
	public void drawPlanet(final Graphics g, int planetID) {		
		
		double x = controller.getPlanetarySystem().getElement(planetID).getx();
		double y = controller.getPlanetarySystem().getElement(planetID).gety();
		double[] newCoordinates = convCoords(x, y);
		g.setColor(Color.RED);
		g.drawOval((int)newCoordinates[0] ,(int)newCoordinates[1], (int)planetWidth, (int)planetWidth);		
	}

	
 
	/**
	 * Simulatsiooni koordinaatide konverteerimine kasutajaliidese jaoks sobivale kujule.
        S�ltub atribuutidest: 
        cx, cy - kuva keskpunkt
        zoom - suurendus
        planet_width - planeedi suurus
        V�ljastab ovaali joonistamiseks vajalikud neli koordinaati
	 */
	public double[] convCoords(double x, double y) {
		
		double x0 = (this.cx + x * this.zoom); 
		double y0 = (this.cy + y * this.zoom);
		double x1 = x0 + this.planetWidth;
		double y1 = y0 + this.planetWidth;
		
		return new double[] {
			x0, y0, x1, y1
		};
	}
	
	public static void main(String[] args) {				
		new UserInterface();
	}

}
