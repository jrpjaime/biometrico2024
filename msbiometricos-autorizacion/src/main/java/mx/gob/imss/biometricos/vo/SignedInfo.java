package mx.gob.imss.biometricos.vo;

public class SignedInfo {
	
	CanonicalizationMethod canonicalizationMethod;
	
	SignatureMethod signatureMethod;
	Reference reference;
	
	
	public CanonicalizationMethod getCanonicalizationMethod() {
		return canonicalizationMethod;
	}
	public void setCanonicalizationMethod(CanonicalizationMethod canonicalizationMethod) {
		this.canonicalizationMethod = canonicalizationMethod;
	}
	public SignatureMethod getSignatureMethod() {
		return signatureMethod;
	}
	public void setSignatureMethod(SignatureMethod signatureMethod) {
		this.signatureMethod = signatureMethod;
	}
	public Reference getReference() {
		return reference;
	}
	public void setReference(Reference reference) {
		this.reference = reference;
	}

}
