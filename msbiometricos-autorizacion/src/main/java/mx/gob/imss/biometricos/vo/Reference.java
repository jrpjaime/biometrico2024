package mx.gob.imss.biometricos.vo;

public class Reference {
	
	DigestMethod digestMethod;
	String digestValue;
	String uri;
	public DigestMethod getDigestMethod() {
		return digestMethod;
	}
	public void setDigestMethod(DigestMethod digestMethod) {
		this.digestMethod = digestMethod;
	}
	public String getDigestValue() {
		return digestValue;
	}
	public void setDigestValue(String digestValue) {
		this.digestValue = digestValue;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

	
	
}
