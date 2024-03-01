package esselunga.jpa.eccezzioni;

public class EsselungaException extends Exception {

	private static final long serialVersionUID = 2213559952013673394L;
	
	public EsselungaException(String messaggio) {
		this.messaggio = messaggio;
	}
	
	private String messaggio;
		
	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}


}
