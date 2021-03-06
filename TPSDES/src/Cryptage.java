import java.util.Vector;

public class Cryptage {
	GenerateKey key;
	private Vector<Integer> binaryCharToCrypt;
	private Vector<Integer> resultat;
	private int[][] s0;
	private int[][] s1;
	
	public Vector<Integer> getBinaryCharToCrypt() {
		return binaryCharToCrypt;
	}

	public void setBinaryCharToCrypt(Vector<Integer> binaryCharToCrypt) {
		this.binaryCharToCrypt = binaryCharToCrypt;
	}

	public Cryptage(String key, char c) {
		System.out.println("Cryptage de la lettre '" + c +"' avec la cle: " + key);
		System.out.println("-------------------------------------------------");
		this.key = new GenerateKey(key);
		this.initS0();
		this.initS1();
		String str = Convert.charToBinaryString(c);
		this.binaryCharToCrypt = new Vector<Integer>();
		this.resultat = new Vector<Integer>();
		
		this.binaryCharToCrypt = Convert.stringToVectorInteger(str);
		
		System.out.println("Transformation en binaire:" + this.getBinaryCharToCrypt());
		
		this.IP();
		// System.out.println(this.getBinaryCharToCrypt());
		
		// System.out.println("fk first time");
		this.resultat = this.fonctionFK(this.get4BitsGauche(this.binaryCharToCrypt), 
				this.get4BitsDroits(this.binaryCharToCrypt), this.key.getCle1());
		// System.out.println(this.resultat);
		
		// System.out.println("SW");
		this.resultat = this.SW(this.resultat);
		// System.out.println(this.resultat);
		
		// System.out.println("fk second time");
		this.resultat = this.fonctionFK(this.get4BitsGauche(this.resultat),
				this.get4BitsDroits(this.resultat),
				this.key.getCle2());
		// System.out.println(this.resultat);
		
		// System.out.println("IP-1");
		this.IPEnd();
		System.out.println("resultat: " + this.resultat);
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println();
	}
	
	public void initS0() {
		s0 = new int[4][4];
		s0[0][0] = 1;
		s0[0][1] = 0;
		s0[0][2] = 3;
		s0[0][3] = 2;
		
		s0[1][0] = 3;
		s0[1][1] = 2;
		s0[1][2] = 1;
		s0[1][3] = 0;
		
		s0[2][0] = 0;
		s0[2][1] = 2;
		s0[2][2] = 1;
		s0[2][3] = 3;
		
		s0[3][0] = 3;
		s0[3][1] = 1;
		s0[3][2] = 3;
		s0[3][3] = 2;
	}
	
	public void initS1() {
		s1 = new int[4][4];
		s1[0][0] = 0;
		s1[0][1] = 1;
		s1[0][2] = 2;
		s1[0][3] = 3;
		
		s1[1][0] = 2;
		s1[1][1] = 0;
		s1[1][2] = 1;
		s1[1][3] = 3;
		
		s1[2][0] = 3;
		s1[2][1] = 0;
		s1[2][2] = 1;
		s1[2][3] = 0;
		
		s1[3][0] = 2;
		s1[3][1] = 1;
		s1[3][2] = 0;
		s1[3][3] = 3;
	}

	public void IP(){
		Vector<Integer> copie = (Vector<Integer>)binaryCharToCrypt.clone();
		this.binaryCharToCrypt.set(0, copie.elementAt(1));
		this.binaryCharToCrypt.set(1, copie.elementAt(5));
		this.binaryCharToCrypt.set(2, copie.elementAt(2));
		this.binaryCharToCrypt.set(3, copie.elementAt(0));
		this.binaryCharToCrypt.set(4, copie.elementAt(3));
		this.binaryCharToCrypt.set(5, copie.elementAt(7));
		this.binaryCharToCrypt.set(6, copie.elementAt(4));
		this.binaryCharToCrypt.set(7, copie.elementAt(6));
	}
	
	public Vector<Integer> EP(int a, int b, int c, int d) {
		Vector<Integer> res = new Vector<Integer>();
		res.addElement(d);
		res.addElement(a);
		res.addElement(b);
		res.addElement(c);
		res.addElement(b);
		res.addElement(c);
		res.addElement(d);
		res.addElement(a);
		return res;
	}
	
	public Vector<Integer> ouExclusif(Vector<Integer> vec1, Vector<Integer> vec2) {
		Vector<Integer> res = new Vector<Integer>();
		for( int a = 0; a < vec1.size(); a++) {
			if ((vec1.elementAt(a) == 1 && vec2.elementAt(a) == 0) || 
					(vec1.elementAt(a) == 0 && vec2.elementAt(a) == 1)) {
				res.addElement(1);
			} else {
				res.addElement(0);
			}
		}
		return res;
	}
	
	public Vector<Integer> get4BitsGauche(Vector<Integer> vec){
		Vector<Integer> res = new Vector<Integer>();
		res.addElement(vec.elementAt(0));
		res.addElement(vec.elementAt(1));
		res.addElement(vec.elementAt(2));
		res.addElement(vec.elementAt(3));
		return res;
	}
	
	public Vector<Integer> get4BitsDroits(Vector<Integer> vec){
		Vector<Integer> res = new Vector<Integer>();
		res.addElement(vec.elementAt(4));
		res.addElement(vec.elementAt(5));
		res.addElement(vec.elementAt(6));
		res.addElement(vec.elementAt(7));
		return res;
	}
	
	public String passerDansS0(String ligne, String colone) {
		StringBuilder temp = new StringBuilder();
		int l = Convert.binaryStringToInt(ligne);
		int c = Convert.binaryStringToInt(colone);
		String str = Convert.intToBinaryString(this.s0[l][c]);
		if (str.length() < 2) {
			temp.append("0");
		}
		temp.append(str);
		return temp.toString();
	}
	
	public String passerDansS1(String ligne, String colone) {
		StringBuilder temp = new StringBuilder();
		int l = Convert.binaryStringToInt(ligne);
		int c = Convert.binaryStringToInt(colone);
		String str = Convert.intToBinaryString(this.s1[l][c]);
		if (str.length() < 2) {
			temp.append("0");
		}
		temp.append(str);
		return temp.toString();
	}
	
	public Vector<Integer> p4(Vector<Integer> vect){
		Vector<Integer> res = new Vector<Integer>();
		res.addElement(vect.elementAt(1));
		res.addElement(vect.elementAt(3));
		res.addElement(vect.elementAt(2));
		res.addElement(vect.elementAt(0));
		return res;
	}
	
	public Vector<Integer> fonctionF(Vector<Integer> vect, Vector<Integer> cle) {
		// System.out.println(vect);
		int bit0 = vect.elementAt(0);
		int bit1 = vect.elementAt(1);
		int bit2 = vect.elementAt(2);
		int bit3 = vect.elementAt(3);
		Vector<Integer> v = new Vector<Integer>();
		v = this.EP(bit0, bit1, bit2, bit3);
		// System.out.println(v);
		v = this.ouExclusif(v, cle);
		// System.out.println(v);
		
		// On passe les 4 bits a gauche dans s0
		StringBuilder lig = new StringBuilder();
		StringBuilder col = new StringBuilder();
		lig.append(v.elementAt(0));
		lig.append(v.elementAt(3));
		col.append(v.elementAt(1));
		col.append(v.elementAt(2));
		StringBuilder temp = new StringBuilder();
		temp.append(this.passerDansS0(lig.toString(), col.toString()));
		// On passe les 4 bits a droite dans s1
		lig = new StringBuilder();
		col = new StringBuilder();
		lig.append(v.elementAt(4));
		lig.append(v.elementAt(7));
		col.append(v.elementAt(5));
		col.append(v.elementAt(6));
		temp.append(this.passerDansS1(lig.toString(), col.toString()));
		// v = new Vector<Integer>();
		// on reconstruit le resultat des SBox
		v = Convert.stringToVectorInteger(temp.toString());
		// System.out.println(v);
		v = this.p4(v);
		// System.out.println(v);
		
		return v;
	}
	
	public Vector<Integer> fonctionFK(Vector<Integer> g, Vector<Integer> d, Vector<Integer> key) {
		// System.out.println("gauche: " + g);
		// System.out.println("droite: " + d);
		Vector<Integer> res = new Vector<Integer>();
		res = this.ouExclusif(g, this.fonctionF(d, key));
		// System.out.println("res: " + res);
		
		for (int i=0; i < d.size(); i++) {
			res.addElement(d.elementAt(i));
		}
		
		return res;
	}
	
	/**
	 * Inverse les 4 bits de droits avec les 4 bits de gauche
	 */
	public Vector<Integer> SW(Vector<Integer> vect){
		Vector<Integer> res = new Vector<Integer>();
		Vector<Integer> temp = new Vector<Integer>();
		res = this.get4BitsDroits(vect);
		
		for (int i=0; i < this.get4BitsGauche(vect).size(); i++) {
			res.addElement(this.get4BitsGauche(vect).elementAt(i));
		}
		return res;
	}
	
	public void IPEnd() {
		Vector<Integer> copie = (Vector<Integer>)this.resultat.clone();
		this.resultat.set(0, copie.elementAt(3));
		this.resultat.set(1, copie.elementAt(0));
		this.resultat.set(2, copie.elementAt(2));
		this.resultat.set(3, copie.elementAt(4));
		this.resultat.set(4, copie.elementAt(6));
		this.resultat.set(5, copie.elementAt(1));
		this.resultat.set(6, copie.elementAt(7));
		this.resultat.set(7, copie.elementAt(5));
	}
}
