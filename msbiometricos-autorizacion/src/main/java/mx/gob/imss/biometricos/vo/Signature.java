package mx.gob.imss.biometricos.vo;

public class Signature {
	SignedInfo signedInfo;
	String signatureValue;
	KeyInfo keyInfo;
	public SignedInfo getSignedInfo() {
		return signedInfo;
	}
	public void setSignedInfo(SignedInfo signedInfo) {
		this.signedInfo = signedInfo;
	}
	public String getSignatureValue() {
		return signatureValue;
	}
	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
	}
	public KeyInfo getKeyInfo() {
		return keyInfo;
	}
	public void setKeyInfo(KeyInfo keyInfo) {
		this.keyInfo = keyInfo;
	}

	
	
	
	
}
