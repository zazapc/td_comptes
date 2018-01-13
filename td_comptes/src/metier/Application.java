package metier;

import java.util.List;

public class Application {
	public static void main(String[] args){
		try{
		/*creer des comptes*/
		Compte cp1 = new CompteCourant(1, 8000, 5000);
		Compte cp2 = new CompteEpargne (2, 30000, 5.5);

		/*effectuer des versement des retrait et des virement*/
		cp1.verser(50000);
		cp1.retirer(3000);
		cp1.virement(400, cp2);
		
		cp1.verser(4000);
		cp1.retirer(7000);
		
		//cp1.retirer(9098890);
		
		/*consulter solde*/
		System.out.println("Solde du compte cp1 :"+cp1.consulterSolde());
		System.out.println("Solde du compte cp2 :"+cp2.consulterSolde());
		
		/*consulter l'historique des operations*/
		System.out.println("-----------------------------------------------------------");
		List<Operation> listOperations=cp1.getOperations();
		for(Operation o: listOperations){
			System.out.println(o.getClass().getSimpleName()+"--"+o.getNumero()+"--"+o.getDateOperation()+"--"+o.getMontant());
		}
		/*consulter le total des operations*/
		System.out.println("-----------------------------------------------------------");
		System.out.println("Total du versements du compte cp1 :"+cp1.totaleVersements());
		System.out.println("Total du retraits du compte cp1 :"+cp1.totaleRetraits());
		
		System.out.println("--------------------Metre ajour le solde--------------------");
		cp1.updateSolde();
		cp2.updateSolde();
		/*consulter a nouveaux le solde*/
		System.out.println("Solde du compte cp1 :"+cp1.consulterSolde());
		System.out.println("Solde du compte cp2 :"+cp2.consulterSolde());
		
		}catch(Exception e){System.out.println(e.getMessage());}
	}
}
