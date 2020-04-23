import java.util.Scanner;

public class Calculette {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String decision = "";
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("1.	Somme de deux entiers");
			System.out.println("2.	Soustraction de deux entiers");
			System.out.println("3.	Multiplication de deux entiers");
			System.out.println("4.	Division de deux entiers");
			System.out.println("5.	Sortie du programme");
			
			System.out.print("\nVeuillez entrer votre choix : ");
			decision = scan.nextLine();
			if (Integer.parseInt(decision) >= 1 && Integer.parseInt(decision) <=4) {
				System.out.print("\nVeuillez entrer les deux entiers composant l'opération séparé d'un espace : ");
				String entree = scan.nextLine();
				String[] nombres = entree.split(" ");
				int nombre1 = Integer.parseInt(nombres[0]);
				int nombre2 = Integer.parseInt(nombres[1]);
				int resultat = 0;
				switch(decision.charAt(0)) {
				case '1':
					resultat = nombre1 + nombre2;
					break;
				case '2':
					resultat = nombre1 - nombre2;
					break;
				case '3':
					resultat = nombre1 * nombre2;
					break;
				case '4':
					resultat = nombre1 / nombre2;
					break;
				}
				System.out.println("Le resultat est " + resultat + "\n");
			}
		} while(decision.charAt(0) != '5');
		System.out.println("Sortie du programme");
	}

}
