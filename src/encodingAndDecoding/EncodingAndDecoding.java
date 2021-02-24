package encodingAndDecoding;

import org.apache.commons.net.util.Base64;

public class EncodingAndDecoding {

	public static void main(String[] args) {
		
		
		String str = "admin123"; 
		
		byte[] encodedString = Base64.encodeBase64(str.getBytes());
		
		System.out.println( "encodedString = " + new String( encodedString));
		
		byte[] decodedString = Base64.decodeBase64(encodedString);
		
		System.out.println("decodedString = " + new String(decodedString));

	}

}
