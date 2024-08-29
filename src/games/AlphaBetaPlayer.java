package games;
import games.*;
import java.util.*;


public class AlphaBetaPlayer {
    int joueur;
    int profondeur;
    int cmpt=0;

    public AlphaBetaPlayer(int joueur,int profondeur)
    {
        this.joueur = joueur;
		this.profondeur = profondeur;
    }

    public float Max(float max1,float max2)
    {
        if (max1>max2)
        {
            return max1;

        }
        return max2;
    }

    public float Min(float min1,float min2)
    {
        if(min1<min2)
        {
            return min1;
        }
        return min2;
    }

    public String getCompteur()
	{
		return " Alphabeta a parcourus "+ cmpt + " noeuds";
	}
    public float alphabeta(State s,float alpha,float beta,int profondeur)
    {
        cmpt++;

        if(profondeur==0 || s.isOver())
        {
            return s.getScore(this.joueur);
        }
        else
        {
            if(s.getJoueurCourant() == joueur)
            {
                ArrayList<Move> Valid = new ArrayList<Move>();
                Valid=s.getMove(s.getJoueurCourant());
                

                
                for (int c=0;c<Valid.size();c++) 
                {
                    State next_state = s.copy();
                    next_state.Play2(c);
            
                    alpha = Max(alpha,alphabeta(next_state,alpha,beta,profondeur-1));
                    if (alpha >= beta) 
                    {
                        return alpha;
                    }
                }
                
                return alpha;

            }

            else 
            {

				ArrayList<Move> Valid = new ArrayList<Move>();
                Valid=s.getMove(s.getJoueurCourant());
                
				for (int c=0;c<Valid.size();c++)  
                {
					State next_state = s.copy();
					next_state.Play2(c);
					beta = Min(beta,alphabeta(next_state,alpha,beta,profondeur-1));
					if (alpha >= beta) 
                    {
						return beta;
					}
				}
                
                return beta;
                
            }
		}
    }


 public int getBestMove(State s, float alpha,float beta, int profondeur) 
    {
		float meilleureValeur = -50000;
		Integer meilleureCoup = null;
		ArrayList<Move> Valid = new ArrayList<Move>();
        Valid=s.getMove(joueur);
         if(!Valid.isEmpty())
        {
            for (int c=0;c<Valid.size();c++)  
            {	
                State next_state = s.copy();
                next_state.Play2(c);
                float value = alphabeta(next_state,alpha,beta,profondeur);  
                if (value > meilleureValeur) 
                {
                    meilleureValeur = value;
                    meilleureCoup = c;
                    
                }	
            }
        }
		return meilleureCoup;
	}

}