import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Trajectoire extends Frame implements ActionListener{
	
	private Dessin zone_dessin;
	
	public Trajectoire() {
		setSize(600, 600);
		setTitle("Trajectoire");
		
		zone_dessin = new Dessin();
		add(zone_dessin);
		
		Button boutton_tracer = new Button("Tracer");
		boutton_tracer.addActionListener(this);
		zone_dessin.add(boutton_tracer);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		List<String> lines = new ArrayList<String>();
		if (e.getActionCommand().equals("Tracer"))
		{
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
		Trajectoire traj = new Trajectoire();
		traj.setVisible(true);
	}

}
