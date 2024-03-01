package mx.gob.imss.biometricos.vo;

public class Response {
	
	String fechaHoraPeticion;
	String indiceSolicitud;
	DataResponse dataResponse;
	String minutiaeResponse;
	
	
	FacialResponse facialResponse;
	Integer tiempoProcesamiento;
	Integer codigoRespuesta;
	
	
	
	
	public FacialResponse getFacialResponse() {
		return facialResponse;
	}
	public void setFacialResponse(FacialResponse facialResponse) {
		this.facialResponse = facialResponse;
	}
	public Integer getTiempoProcesamiento() {
		return tiempoProcesamiento;
	}
	public void setTiempoProcesamiento(Integer tiempoProcesamiento) {
		this.tiempoProcesamiento = tiempoProcesamiento;
	}
	public Integer getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(Integer codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getFechaHoraPeticion() {
		return fechaHoraPeticion;
	}
	public void setFechaHoraPeticion(String fechaHoraPeticion) {
		this.fechaHoraPeticion = fechaHoraPeticion;
	}
	public String getIndiceSolicitud() {
		return indiceSolicitud;
	}
	public void setIndiceSolicitud(String indiceSolicitud) {
		this.indiceSolicitud = indiceSolicitud;
	}
	public DataResponse getDataResponse() {
		return dataResponse;
	}
	public void setDataResponse(DataResponse dataResponse) {
		this.dataResponse = dataResponse;
	}
	public String getMinutiaeResponse() {
		return minutiaeResponse;
	}
	public void setMinutiaeResponse(String minutiaeResponse) {
		this.minutiaeResponse = minutiaeResponse;
	}
	
	
	
	
	
}
