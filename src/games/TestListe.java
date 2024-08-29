package games;
import games.State;
import java.util.*;



//CLASS QUI STOCK LES ETAT PRECEDENT 
public class TestListe 
{
    protected ArrayList<int [][]> ListeEtatState;


public TestListe()
{
    this.ListeEtatState = new ArrayList<int [][]>();
}


// STOCK LE TABLEAU EN PARAMETRE
public void ListeState(int [][]tab)
{
    // Pour ne pas stocker l'adresse du tableau 
    int [][] grille = new int [7][7];
    for(int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
            {
                grille[i][j]=tab[i][j];
            }
        } 
    
    this.ListeEtatState.add(grille);
}


// Test si le plateau de state est egal au etat precedent 
public boolean isValidState(State s)
{ 
  
    for (int c=0;c<this.ListeEtatState.size();c++)
    {
        int cmpt=0;
        int [][] grille2 = new int [7][7];
        grille2 = this.ListeEtatState.get(c);
    
        for (int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(grille2[i][j]==s.grille[i][j])
                {
                        cmpt++;
                }
            }

        }
            
        if(cmpt==49)
        {
            return true;
        }
            
         
    }
  
  return false;
}

}