import java.awt.Button;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

public class Dessin extends Panel {
	
	private List<Integer> liste_x;
	private List<Integer> liste_y;
	
	public Dessin(){
		setSize(600, 600);
		liste_x = new ArrayList<Integer>();
		liste_y = new ArrayList<Integer>();
    }
	
	public void paint(Graphics g) {
		super.paintComponents(g);
		int cpt = 0;
		while (cpt < liste_x.size() - 2) {
			g.drawLine(liste_x.get(cpt), liste_y.get(cpt), liste_x.get(cpt+1), liste_y.get(cpt+1));
			cpt++;
		}
	}
	
	void addPoint(int x, int y) {
		liste_x.add(x);
		liste_y.add(y);
	}
	
	void clear_points() {
		liste_x.clear();
		liste_y.clear();
	}
}
