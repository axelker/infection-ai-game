package games;
import games.*;
import java.util.*;

public class MinimaxPlayer {
	
	protected int cmpt=0;
	protected int joueur;
	protected int profondeur;
	
	public MinimaxPlayer(int joueur, int profondeur) 
    {
		this.joueur = joueur;
		this.profondeur = profondeur;
	}
		
	public String getCompteur()
	{
		return " Minimax a parcourus "+ cmpt + " noeuds";
	}


	public float minimax(State s, int profondeur) 
    {
		cmpt++;
		float res = 0;
		if(profondeur==0 || s.isOver())
        {
			return s.getScore(this.joueur);
        }
		else 
        {
			// SI C'EST UN NOEUD DE MAX
			if(s.getJoueurCourant() == joueur)
            {
				res =-5000000;
                ArrayList<Move> Valid = new ArrayList<Move>();
                Valid=s.getMove(s.getJoueurCourant());


				for (int c=0;c<Valid.size();c++) 
                {	
					State next_state = s.copy();
					next_state.Play2(c);
					
					float value = minimax(next_state, profondeur-1);


					if (value > res) 
                    {
						res = value;
						
					}
				}
			}
			else{
				res =500000;
				ArrayList<Move> Valid = new ArrayList<Move>();
                Valid=s.getMove(s.getJoueurCourant());


				for (int c=0;c<Valid.size();c++)  
                {
					State next_state = s.copy();
					next_state.Play2(c);
					float value = minimax(next_state, profondeur-1);
					if (value < res) 
                    {
						res = value;
					}
				}
			}
		}
		return res;
	}
	
	public int getBestMove(State s, int profondeur) 
    {
		float meilleureValeur = -50000;
		Integer meilleureCoup = null;
		ArrayList<Move> Valid = new ArrayList<Move>();
        Valid=s.getMove(joueur);

		for (int c=0;c<Valid.size();c++)  
        {	
			State next_state = s.copy();
			next_state.Play2(c);
			float value = minimax(next_state, profondeur);  
			if (value > meilleureValeur) 
            {
				meilleureValeur = value;
				meilleureCoup = c;
				
			}	
		}
		return meilleureCoup;
	}
}
