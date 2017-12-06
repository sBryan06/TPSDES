import java.util.Vector;

public class Convert {
	public static String charToBinaryString(char c) {
		StringBuilder res = new StringBuilder();
		String str = Integer.toBinaryString(c);
		for(int i=0; i<8-str.length(); i++) {
			res.append("0");
		}
		res.append(str);
		return res.toString();
	}
	
	public static Vector<Integer> stringToVectorInteger(String str) {
		Vector<Integer> res = new Vector<Integer>();
		for (int i=0; i < str.length(); i++) {
			res.addElement(Character.getNumericValue(str.charAt(i)));
		}
		return res;
	}
	
	public static int binaryStringToInt(String str) {
		return Integer.parseUnsignedInt(str, 2);
	}
	
	public static String intToBinaryString(int a) {
		return Integer.toBinaryString(a);
	}
}
