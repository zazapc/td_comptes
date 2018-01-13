package metier;

import java.util.Date;

public class CompteEpargne extends Compte {
    private double taux;
    
	@Override
	public void retirer(double mt) {
		if(mt>solde) throw new RuntimeException("l'operation n'as pas ete effectue solde inssiffisant");
		Retrait r = new Retrait(operations.size()+1, new Date(), mt);
		operations.add(r);
		solde=solde - mt;
	}

	@Override
	public void updateSolde() {
		solde=solde*(1+taux/100);
		
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(int code, double solde, double taux) {
		super(code, solde);
		this.taux = taux;
	}
	
	

}
