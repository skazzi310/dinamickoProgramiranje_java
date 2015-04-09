package problemRancaVerzija1;

public class Predmet
{
	private int tezina;
	public Predmet(){}
	public Predmet(int tezina)
	{
		if(tezina < 0)
			tezina *= -1;
		this.tezina = tezina;
	}
	
	/**
	 * @return tezina objekta predmet
	 */
	public int getTezina()
	{
		return tezina;
	}
	
	/**
	 * Postavlja tezinu predmetu
	 * @param tezina Tezina koju je potrebno postaviti, ako je negativna, konvertuje se u pozitivnu
	 */
	public void setTezina(int tezina)
	{
		if (tezina < 0)
			tezina *= -1;
		this.tezina = tezina;
	}
	
	public String toString()
	{
		return "" + tezina;
	}
}
