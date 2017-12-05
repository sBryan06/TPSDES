import java.util.Vector;


public class GenerateKey {
	Vector<Integer> cle;
	Vector<Integer> cle1;
	Vector<Integer> cle2;

	public GenerateKey(String c) {
		// TODO Auto-generated constructor stub
		cle = new Vector<Integer>();
		cle1 = new Vector<Integer>();
		cle2 = new Vector<Integer>();
		this.initCle(c);
		this.afficheCle("Cle", cle);
		this.IPcle();
		this.afficheCle("Cle", cle);
		this.genererCle1();
		this.genererCle2();
		
		this.afficheCle("Cle 1", cle1);
		
		this.afficheCle("Cle 2", cle2);
	}
	
	
	public void initCle(String c){
		int x = 0;
		for (int i=0; i<c.length(); i++) {
			x = Character.getNumericValue(c.charAt(i));
			if (x == 0 || x == 1) {
				cle.addElement(x);
			}
		}
	}
	
	public void IPcle(){
		Vector<Integer> copie = (Vector<Integer>)cle.clone();
		cle.set(0, copie.elementAt(2));
		cle.set(1, copie.elementAt(4));
		cle.set(2, copie.elementAt(1));
		cle.set(3, copie.elementAt(6));
		cle.set(4, copie.elementAt(3));
		cle.set(5, copie.elementAt(9));
		cle.set(6, copie.elementAt(0));
		cle.set(7, copie.elementAt(8));
		cle.set(8, copie.elementAt(7));
		cle.set(9, copie.elementAt(5));
	}
	
	public void rotationGauche(){
		int temp = cle.elementAt(0);
		for(int i=0; i<4;i++){
			cle.setElementAt(cle.elementAt(i+1), i);
		}
		cle.setElementAt(temp, 4);
		
		temp = cle.elementAt(5);
		for(int i=5; i<9;i++){
			cle.setElementAt(cle.elementAt(i+1), i);
		}
		cle.setElementAt(temp, 9);
	}
	
	public void genererCle1(){
		this.rotationGauche();
		cle1.addElement(cle.elementAt(5));
		cle1.addElement(cle.elementAt(2));
		cle1.addElement(cle.elementAt(6));
		cle1.addElement(cle.elementAt(3));
		cle1.addElement(cle.elementAt(7));
		cle1.addElement(cle.elementAt(4));
		cle1.addElement(cle.elementAt(9));
		cle1.addElement(cle.elementAt(8));
	}
	
	public void genererCle2(){
		this.rotationGauche();
		this.rotationGauche();
		cle2.add(cle.elementAt(5));
		cle2.add(cle.elementAt(2));
		cle2.add(cle.elementAt(6));
		cle2.add(cle.elementAt(3));
		cle2.add(cle.elementAt(7));
		cle2.add(cle.elementAt(4));
		cle2.add(cle.elementAt(9));
		cle2.add(cle.elementAt(8));
	}
	
	public String displayCle(Vector<Integer> vec){
		String str = new String();
		for(int i=0; i<vec.size(); i++){
			str += vec.elementAt(i);
		}
		return str;
	}
	
	public void afficheCle(String nom, Vector<Integer> vec){
		System.out.println(nom + "-> " + this.displayCle(vec));
	}

}
