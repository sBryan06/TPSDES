import java.util.Vector;

public class Cryptage {
	GenerateKey key;
	private Vector<Integer> binaryCharToCrypt;
	private int[][] s0;
	private int[][] s1;
	
	public Vector<Integer> getBinaryCharToCrypt() {
		return binaryCharToCrypt;
	}

	public void setBinaryCharToCrypt(Vector<Integer> binaryCharToCrypt) {
		this.binaryCharToCrypt = binaryCharToCrypt;
	}

	public Cryptage(String key, char c) {
		this.key = new GenerateKey(key);
		this.initS0();
		this.initS1();
		String str = Convert.charToBinaryString(c);
		this.binaryCharToCrypt = new Vector<Integer>();
		this.binaryCharToCrypt = Convert.stringToVectorInteger(str);
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
	
	public void fonctionF(Vector<Integer> cle, Vector<Integer> vect) {
		
	}
	
	public Vector<Integer> p4(int a, int b, int c, int d){
		Vector<Integer> res = new Vector<Integer>();
		res.addElement(b);
		res.addElement(d);
		res.addElement(c);
		res.addElement(a);
		return res;
	}
}
