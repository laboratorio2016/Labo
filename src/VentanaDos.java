import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class VentanaDos {

	private JFrame frame = new JFrame("Imagen Intermitente");
	private JPanel sur = new JPanel();
	private JPanel norte = new JPanel();
	private JPanel este = new JPanel();
	private JPanel oeste = new JPanel();
	private JPanel centro = new JPanel();
	
	public  VentanaDos(){
		frame.setLayout(new BorderLayout());
		frame.setSize(new Dimension(640,400));
		sur.setSize(new Dimension(100,100));
		sur.setBackground(Color.BLUE);
		norte.setBackground(Color.RED);
		este.setBackground(Color.YELLOW);
		oeste.setBackground(Color.GREEN);
		centro.setBackground(Color.CYAN);
		frame.add(sur, BorderLayout.SOUTH);
		frame.add(norte, BorderLayout.NORTH);
		frame.add(este, BorderLayout.EAST);
		frame.add(oeste, BorderLayout.WEST);
		frame.add(centro, BorderLayout.CENTER);
	}
	
	public void mostrar(){
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public synchronized void pintar(int p){
		switch (p) {
		case 0:
			sur.setBackground(Color.BLACK);
			try {
				Thread.sleep(500);
				sur.setBackground(Color.BLUE);
			} catch (InterruptedException e) {
				System.exit(25);
			}
			break;
		case 1:
			norte.setBackground(Color.BLACK);
			try {
				Thread.sleep(500);
				norte.setBackground(Color.RED);
			} catch (InterruptedException e) {
				System.exit(25);
			}
			break;
		case 2:
			este.setBackground(Color.BLACK);
			try {
				Thread.sleep(500);
				este.setBackground(Color.GREEN);
			} catch (InterruptedException e) {
				System.exit(25);
			}
			break;
		case 3:
			oeste.setBackground(Color.BLACK);
			try {
				Thread.sleep(500);
				oeste.setBackground(Color.YELLOW);
			} catch (InterruptedException e) {
				System.exit(25);
			}
			break;
		case 4:
			centro.setBackground(Color.BLACK);
			try {
				Thread.sleep(500);
				centro.setBackground(Color.CYAN);
			} catch (InterruptedException e) {
				System.exit(25);
			}
			break;
		}
	}
	
	public static void main(String[] args) {
		final VentanaDos app = new VentanaDos();
		app.mostrar();
		int name;
		for(int j=0; j<9; j++){
			name=j;
			new Thread(new Thread() {
				
				@Override
				public void run() {
					while(true){
						int i = (int) (Math.random() * 100) % 5;
						System.out.println("I VALE ESTO: "+i);
						System.out.println("SOY "+this.getName());
						app.pintar(i);
					}
				}
			},""+j).start();	
		}
	}

}
