package problemRancaVerzija1;

public class Polje
{
	private boolean postojiResenje;
	private boolean uzetPredmet;
	
	public Polje(){}
	public Polje(boolean postojiResenje, boolean uzetPredmet)
	{
		this.postojiResenje = postojiResenje;
		this.uzetPredmet = uzetPredmet;
	}
	
	/**
	 * @return vraca true ukoliko na datom polju postoji resenje problema, inace vraca false
	 */
	public boolean jelPostojiResenje()
	{
		if(postojiResenje)
			return true;
		else
			return false;
	}
	
	/**
	 * @return vraca true ukoliko je predmet koji dato polje obelezava uzet, inace vraca false
	 */
	public boolean jelUzetPredmet()
	{
		if(uzetPredmet)
			return true;
		else
			return false;
	}
	
	/**
	 * Postavlja status resenje
	 * @param resenje status koji je potrebno postaviti
	 */
	public void postaviStatusResenja(boolean resenje)
	{
		this.postojiResenje = resenje;
	}
	
	/**
	 * Postavlja status o tome da li predmet ulazi u resenje
	 * @param predmet status koji je potrebno postaviti
	 */
	public void postaviStatusPredmeta(boolean predmet)
	{
		this.uzetPredmet = predmet;
	}
	
	public String toString()
	{
		int a, b;
		if(postojiResenje)
			a = 1;
		else
			a = 0;
		
		if(uzetPredmet)
			b = 1;
		else
			b = 0;
		return " " + a + "/" + b + " ";
	}
}
