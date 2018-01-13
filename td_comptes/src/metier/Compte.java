package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Compte {

	protected int code;
	protected double solde;
	protected List<Operation> operations=new ArrayList<>();
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(int code, double solde) {
		super();
		this.code = code;
		this.solde = solde;
	}
	
	public void verser(double mt){
		Versement v = new Versement(operations.size()+1, new Date(), mt);
		operations.add(v);
		solde+=mt;
	}
	
	public abstract void retirer(double mt);
	
	public void virement(double mt, Compte cp2){
		retirer(mt);
		cp2.verser(mt);		
	}
	
	public double consulterSolde(){
		return solde;
	}
	
	public abstract void updateSolde();
	
	public List<Operation> getOperations(){
		return operations;
	}
	
	public double totaleVersements(){
		double some=0;
		for(Operation o:operations){
			if(o instanceof Versement)
			some=some+o.getMontant();
		}
		return some;
	}
	
	public double totaleRetraits(){
		double some=0;
		for(Operation o:operations){
			if(o instanceof Retrait)
			some=some+o.getMontant();
		}
		return some;
	}
}
