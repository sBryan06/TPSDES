import java.util.Vector;

public class Cryptage {
	
	private Vector<Integer> binaryCharToCrypt;
	private int[][] S0;
	private int[][] S1;
	
	public Vector<Integer> getBinaryCharToCrypt() {
		return binaryCharToCrypt;
	}

	public void setBinaryCharToCrypt(Vector<Integer> binaryCharToCrypt) {
		this.binaryCharToCrypt = binaryCharToCrypt;
	}

	public Cryptage(char c) {
		this.initS0();
		this.initS1();
		String str = Convert.charToBinaryString(c);
		this.binaryCharToCrypt = new Vector<Integer>();
		this.binaryCharToCrypt = Convert.stringToVectorInteger(str);
	}
	
	public void initS0() {
		
	}
	
	public void initS1() {
		
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
}
