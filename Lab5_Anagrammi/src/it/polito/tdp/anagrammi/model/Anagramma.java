package it.polito.tdp.anagrammi.model;

public class Anagramma {
	
	private String parola;
	private boolean corretto;
	
	public Anagramma(String parola) {
		super();
		this.parola = parola;
		corretto = false;
	}

	/**
	 * @return the parola
	 */
	public String getParola() {
		return parola;
	}

	/**
	 * @param parola the parola to set
	 */
	public void setParola(String parola) {
		this.parola = parola;
	}

	/**
	 * @return the corretto
	 */
	public boolean isCorretto() {
		return corretto;
	}

	/**
	 * @param corretto the corretto to set
	 */
	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anagramma other = (Anagramma) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s", parola);
	}

}
