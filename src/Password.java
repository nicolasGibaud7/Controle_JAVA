import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPasswordField;

public class Password extends Frame implements ActionListener{

	public Password() {
		setTitle("Changer un mot de passe");
		setSize(400, 200);
		Panel global_pannel = new Panel();
		global_pannel.setBackground(Color.WHITE);
		global_pannel.setLayout(new BorderLayout());
		
		Panel fields_pannel = new Panel();
		fields_pannel.setLayout(new GridLayout(4, 2));
		
		Label name = new Label("Nom");
		fields_pannel.add(name);
		TextField field_name = new TextField();
		fields_pannel.add(field_name);
		
		Label password = new Label("Mot de passe");
		fields_pannel.add(password);
		JPasswordField field_password = new JPasswordField();
		fields_pannel.add(field_password);
		
		Label new_password = new Label("Nouveau mot de passe");
		fields_pannel.add(new_password);
		JPasswordField field_new_password = new JPasswordField();
		fields_pannel.add(field_new_password);
		
		Label new_password_again = new Label("Retapez le mot de passe");
		fields_pannel.add(new_password_again);
		JPasswordField field_new_password_again = new JPasswordField();
		fields_pannel.add(field_new_password_again);
		
		global_pannel.add(fields_pannel);
		global_pannel.add(new Button("Lancer la modification"), BorderLayout.SOUTH);
		
		add(global_pannel);
	}
	
	boolean verifier(String nom, String pass) {
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("passwd.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		}
		catch (Exception e)
		{
		    System.err.format("Exception occurred trying to read passwd.txt");
		    e.printStackTrace();
		}
		for (String line : lines) {
			String[] infos = line.split(":");
			if (nom.equals(infos[0])) {
				if (pass.contentEquals(infos[1])) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	
	boolean estIdentique(String str, String str1) {
		return str.equals(str1);
	}
	
	void remplace(File f, String ligne1, String ligne2) {
		String content = "";
		Scanner s;
		try {
			s = new Scanner(f);
			/* On parcourt le fichier */
			while(s.hasNextLine()) {
				String line = s.nextLine();
				/* Si on est sur la ligne que l'on veut changer, on ajoute la nouvelle ligne dans 
				 * content sinon on ajoute la ligne actuelle
				 */
				if(ligne1.contentEquals(line)) {
					content += ligne2;
				}
				else {
					content += line;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			PrintWriter ecrivain = new PrintWriter(new FileOutputStream("password.txt"));
			ecrivain.println(content); /* On reécrit le nouveau contenu dans password.txt */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Password pass = new Password();
		pass.setVisible(true);

	}
	
	
	
}
