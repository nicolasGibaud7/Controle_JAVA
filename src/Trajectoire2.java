import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Trajectoire2 extends Frame {
	
	private Dessin zone_dessin;
	
	public Trajectoire2() {
		setSize(600, 600);
		setTitle("Trajectoire");
		
		zone_dessin = new Dessin();
		add(zone_dessin);
		
	}
	
	void loop() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
			List<String> lines = new ArrayList<String>();
			zone_dessin.clear_points();
			try {
				BufferedReader reader = new BufferedReader(new FileReader("positions.txt"));
				String line;
				while ((line = reader.readLine()) != null) {
					lines.add(line);
				}
			}
			catch (Exception exception)
			{
			    System.err.format("Exception occurred trying to read positions.txt");
			    exception.printStackTrace();
			}
			
			for(String line : lines) {
				String[] coor = line.split(":");
				zone_dessin.addPoint(Integer.parseUnsignedInt(coor[0]), Integer.parseUnsignedInt(coor[1]));
			}
			zone_dessin.revalidate();
			zone_dessin.repaint();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trajectoire2 traj = new Trajectoire2();
		traj.setVisible(true);
		traj.loop();
	}

}
