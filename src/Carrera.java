import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Carrera extends JFrame {
	
	int fila;
	Map<Integer,Integer> mapa = new HashMap<>();
	
	public  Carrera(){
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(520,520));
	}
	
	public void mostrar(){
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public synchronized void avanzar(int f, int c){
		System.out.println("HHHHHHHH: "+f+", KKKKKKKK: "+c);
		if (mapa.containsKey(f)) {
			mapa.remove(f);
			mapa.put(f,c);
		}else {
			mapa.put(f,c);
		}
		this.repaint();
	}
	
	public synchronized void paint(Graphics g) {
		super.paint(g);
		for (Integer act : mapa.keySet()) {
			System.out.println("asdsadsa: "+act);
			g.setColor( Color.RED );
			g.drawLine( 5, (act*30)+5, mapa.get(act), (act*30)+5 );
		}
	}
	
	public static void main(String[] args) {
		final Carrera app = new Carrera();
		app.mostrar();
		int name;
		for(int j=0; j<20; j++){
			name=j;
			new Thread(new Thread() {
				
				private int miDistancia = 0;
				
				@Override
				public void run() {
					while(true){
						//System.out.println("I VALE ESTO: "+i);
						//System.out.println("SOY "+this.getName());
						System.out.println(this.getName().charAt(this.getName().length()-1));
						app.avanzar(Integer.parseInt( this.getName().substring(this.getName().length()-1, this.getName().length() )), miDistancia);
						miDistancia = miDistancia+5;
						try {
							Thread.sleep(Integer.parseInt( this.getName().substring(this.getName().length()-1))+1*(500));
						} catch (InterruptedException e) {
							System.exit(37);
						}
						}
				}
			},""+j).start();	
		}
	}

}

