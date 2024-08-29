package games;
import games.*;
import java.util.*;


public class State 
{
    protected int pionBleu;
    protected int pionRouge;
    protected int joueurCourrant;
    protected int[][] grille;


public State()
{   this.pionBleu=1;
    this.pionRouge=2;
    this.joueurCourrant=this.pionBleu;
    this.grille = new int [7][7];


}

// Initialisation des quatres premiers pion 
public void Initialisation()
{

        
    for(int i=0;i<7;i++)
    {
        
        for(int j=0;j<7;j++)
        {
            this.grille[i][j]=0;
            
        }
    }
    this.grille[0][0]=pionRouge;
    this.grille[6][6]=pionRouge;
    this.grille[6][0]=pionBleu;
    this.grille[0][6]=pionBleu;
}

//Retourn le joueur qui ne joue pas 
public int returnJoueur()
{
    if(this.joueurCourrant==pionBleu)
    {
        return this.pionRouge;
    }
    else {
        return this.pionBleu;
    }
}

// Change le joueur courrant 
public void ChangeJoueurCourant()
{
    if(this.joueurCourrant==pionBleu)
    {
        this.joueurCourrant=pionRouge;
    }
    else if(this.joueurCourrant==pionRouge) {
        this.joueurCourrant=pionBleu;
    }
}

// Retourne le joueur courant 
public int getJoueurCourant()
{
    return this.joueurCourrant;
}

// Retourne le joueur qui n'est pas passer en parametre
public int returnOtherJoueur(int joueur)
{
    if(joueur==this.pionBleu)
    {
        return this.pionRouge;
    }
    else {
        return this.pionBleu;
    }
}

// Test si le coup entrée pour le joueur est bien de taille plu petite que la liste des coups possible 
public boolean isValid(int coup,int joueur)
{
    // SI le coup plut petit que la taille de la liste 
    if (coup < getMove(joueur).size()){
      return true;
    }
    
        return false;
    
}

// Convertis un entier en une ligne de la grille 
public int Ligne(int coup)
{
int ligne=0;

    if (coup>=0 && coup<=6){
      ligne = 0;
    }
    if (coup>=7 && coup<=13){
      ligne = 1;
    }
    if (coup>=14 && coup<=20){

      ligne = 2;
    }
   if (coup>=21 && coup<=27){

      ligne = 3;
    }
   if (coup>=28 && coup<=34){

      ligne = 4;
    }
   if (coup>=35 && coup<=41){

      ligne = 5;
    }
   if (coup>=42 && coup<=48){

      ligne = 6;
    }

return ligne;
    
}

         
// Convertis un entier entrée en colonne pour la grille 
public int Colonne(int coup)
{
    int colonne=0;
    
colonne = coup%7;

return colonne;
}

//Test pour le pion choisi si le coup clonne entré est valide
public boolean isValidClonePionCoup(int depart,int arriver,int joueur)
{
    
    int ligne=0;
    int colonne=0;
    int lignePion=0;
    int colonnePion=0;
    lignePion=Ligne(depart);
    colonnePion=Colonne(depart);
    ligne=Ligne(arriver);
    colonne=Colonne(arriver);

//Si la case de depart contient le joueur et la case d'arriver et vide   
    if (grille[lignePion][colonnePion]==joueur && grille[ligne][colonne]==0)
    {
        // TEST DE TOUTE LES CASES AJDACENTE PAR RAPPORT AU PION DE DEPART ET AU PION D'ARRIVER
        if(ligne!=0) 
        {
            if(ligne-1==lignePion && colonne==colonnePion)
            {
                return true;
            }
            if(colonne!=0 && ligne-1==lignePion && colonne-1==colonnePion )
            {
                return true;
            }
            if(colonne!=6 && ligne-1==lignePion && colonne+1==colonnePion)
            {
                return true;
            }
        }

        if(colonne!=0)
        {
            if(ligne==lignePion && colonne-1==colonnePion)
            {
                return true;
            }
        }

        if(colonne!=6)
        {
            if(ligne==lignePion && colonne+1==colonnePion)
            {
                return true;
            }

        }   
        if(ligne!=6)
        {   
            if( colonne!=6 && ligne+1==lignePion && colonne+1==colonnePion )
            {
                return true;
            }
            if(ligne+1==lignePion && colonne==colonnePion)
            {
                return true;
            }
            if(colonne!=0 && ligne+1==lignePion && colonne-1==colonnePion )
            {
                return true;
            }
            
        } 
    }

return false;

}
 
// Test si un pion peux effectuer un saut 
 public boolean isValidSautPionCoup(int depart,int arriver,int joueur)
{
    int ligne=0;
    int colonne=0;
    int lignePion=0;
    int colonnePion=0;
    lignePion=Ligne(depart);
    colonnePion=Colonne(depart);
    ligne=Ligne(arriver);
    colonne=Colonne(arriver);
//Si case autour contient le joueur
    
        if (grille[lignePion][colonnePion]==joueur && grille[ligne][colonne]==0)
{

    if(ligne>=2) 
    {
        if(ligne-2==lignePion && colonne==colonnePion && grille[ligne-1][colonne]!=0)
        {
            return true;
        }
        if(colonne >=2 && ligne-2==lignePion && colonne-2==colonnePion && grille[ligne-1][colonne-1]!=0)
        {
            return true;
        }
        if(colonne <=4 && ligne-2==lignePion && colonne+2==colonnePion && grille[ligne-1][colonne+1]!=0)
        {
            return true;
        }
    }

    if(colonne>=2)
    {
        if(ligne==lignePion && colonne-2==colonnePion && grille[ligne][colonne-1]!=0)
        {
            return true;
        }
    }

    if(colonne<=4)
    {
        if(ligne==lignePion && colonne+2==colonnePion && grille[ligne][colonne+1]!=0)
        {
            return true;
        }

    }   
    if(ligne<=4)
    {   
        if( colonne<=4 && ligne+2==lignePion && colonne+2==colonnePion && grille[ligne+1][colonne+1]!=0)
        {
            return true;
        }
        if(ligne+2==lignePion && colonne==colonnePion && grille[ligne+1][colonne]!=0)
        {
            return true;
        }
        if(colonne>=2 && ligne+2==lignePion && colonne-2==colonnePion && grille[ligne+1][colonne-1]!=0)
        {
            return true;
        }
        
    } 
}

return false;

}



public boolean isOver(){
int cmptBleu=0;
int cmptrouge=0;

// Un des jouerus n'a plu de pion sur le plateau
    cmptBleu=ScoreJoueur(this.pionBleu);
    cmptrouge=ScoreJoueur(this.pionRouge);
    if(cmptrouge==0 || cmptBleu==0)
    {
        return true;
    }
//Les deux joueurs doivent passer leur tours declaration de 2 listes pour stocker les pions valides 
    ArrayList<Move> ValidJ1 = new ArrayList<Move>();
    ArrayList<Move> ValidJ2 = new ArrayList<Move>();
    ValidJ1=getMove(this.pionBleu);
    ValidJ2=getMove(this.pionRouge);
// SI les listes des pions sont vides la partie est finis   
if((ValidJ1.isEmpty() && ValidJ2.isEmpty()))
{
    return true;
}

// Cas ou situation se repete dans la class testliste 

return false;

}

// Score du joueur sous forme de point 
public int ScoreJoueur(int joueur)
{
    int cmpt=0;
    for(int i=0;i<7;i++) {
        for(int j=0;j<7;j++)
        {
            if (this.grille[i][j]==joueur)
            {
                cmpt++;
            }
        }
    }
    
return cmpt;

}

// Score du joueur sous forme d'état 
public float getScore(int joueur)
{
    float cmptJoueurCourant=0;
    float cmptJoueurnonCourant=0;
    float etat=0;
    cmptJoueurCourant=ScoreJoueur(joueur);
    cmptJoueurnonCourant=ScoreJoueur(returnOtherJoueur(joueur));
    etat=cmptJoueurCourant/(cmptJoueurCourant+cmptJoueurnonCourant);
    
    return etat;

}
//Liste des saut et clonnes possibles 
public ArrayList<Move> getMove(int joueur)
{
    ArrayList<Move> Liste= new ArrayList<Move>();
    
    for(int i=0;i<49;i++)
    {
        for(int j=0;j<49;j++)
        {
            // Si cest un clonne pour le depart i et l'arriver j
            if(isValidClonePionCoup(i,j,joueur))
            {
                Move m = new Move(i,j);
                m.departCoup=i;
                m.arriverCoup=j;
                m.TypeCoup=false;
                Liste.add(m);

            }
            // SI c'est un saut pour le depart i et l'arriver j
            if(isValidSautPionCoup(i,j,joueur))
            {
                Move m = new Move(i,j);
                m.departCoup=i;
                m.arriverCoup=j;
                m.TypeCoup=true;
                Liste.add(m);

            }
        }
    }
    return Liste;
}

// Fonction test si le bestmove n'est pas null sinon change le joueur 
    public void TestBestMove(State s,Integer bestMove)
    {
        if(bestMove!=null)
            {
                s.Play(bestMove);
            }
            else
            {
                s.ChangeJoueurCourant();

            }
    }

// Joueur aleatoire 
public int randomJoueur(int joueur)
{
    ArrayList<Move> ValidJoueur = new ArrayList<Move>();
    ValidJoueur=getMove(joueur);
    int nombre=0;
    Random r = new Random();
    if(ValidJoueur.size()!=0)
    {
         nombre=r.nextInt(ValidJoueur.size());
    }
    return nombre;

}

//Fonction Affiche le nom du joueur 
public String AfficheNomJoueur(int joueur)
{
    if(joueur==this.pionBleu)
    {
        return " Pion bleu ";
    }
    
    
        return " Pion rouge ";
        
    
}


//Executer un coup + infection
public void doExecute(int coup,int joueur)
{
    ArrayList<Move> Liste= new ArrayList<Move>();
    Liste=getMove(joueur);
    Move m = new Move(0,0);
    m=Liste.get(coup);
    int ligne,colonne,joueurNoncourant;
    ligne=Ligne(m.arriverCoup);
    colonne=Colonne(m.arriverCoup);
    joueurNoncourant=returnJoueur();
    this.grille[ligne][colonne]=joueur;
        
    // Infection case adjacente 
        if(ligne!=0) 
        {
            if(grille[ligne-1][colonne]==joueurNoncourant)
            {
                this.grille[ligne-1][colonne]=joueur;
            }
            if(colonne!=0 && grille[ligne-1][colonne-1]==joueurNoncourant )
            {
                this.grille[ligne-1][colonne-1]=joueur;
            }
            if(colonne!=6 && grille[ligne-1][colonne+1]==joueurNoncourant)
            {
                this.grille[ligne-1][colonne+1]=joueur;
            }
        }

        if(colonne!=0)
        {
            if(grille[ligne][colonne-1]==joueurNoncourant)
            {
                this.grille[ligne][colonne-1]=joueur;
            }
        }

        if(colonne!=6)
        {
            if(grille[ligne][colonne+1]==joueurNoncourant)
            {
                this.grille[ligne][colonne+1]=joueur;
            }

        }   
        if(ligne!=6)
        {   
            if( colonne!=6 && grille[ligne+1][colonne+1]==joueurNoncourant )
            {
                this.grille[ligne+1][colonne+1]=joueur;
            }
            if(grille[ligne+1][colonne]==joueurNoncourant)
            {
                this.grille[ligne+1][colonne]=joueur;
            }
            if(colonne!=0 && grille[ligne+1][colonne-1]==joueurNoncourant )
            {
                this.grille[ligne+1][colonne-1]=joueur;
            } 
        } 

}

// Fonction qui ecrase le pion qui a sauté 
public void EcraseSaut(int coup,int joueur,Move m)
{
   
    int ligne,colonne;
    ligne=Ligne(m.departCoup);
    colonne=Colonne(m.departCoup);
    // Test le type de coup si true c'est un saut 
    if(m.TypeCoup==true)
    {
        this.grille[ligne][colonne]=0;
    }
}

// Methode play avec affichage 
public void Play(int coup)
{
        // Liste stoque les coup 
        ArrayList<Move> Liste= new ArrayList<Move>();
        Liste=getMove(this.joueurCourrant);
        // Si liste des coup n'est pas vide on peux joueur un coup
        if(isValid(coup,this.joueurCourrant))
        {
            Move m = new Move(0,0);
            m=Liste.get(coup);
            System.out.println(AfficheNomJoueur(this.joueurCourrant) + " prends le coup " + coup +" a été choisi " + m);
            System.out.println(getMove(this.joueurCourrant));
            System.out.println(AffichagePlateau());  
            doExecute(coup,this.joueurCourrant);
            EcraseSaut(coup,this.joueurCourrant,m);
        }
        
        //Changement de joueur dans tous les cas 
        ChangeJoueurCourant();
       
            
    // Affichage plateau et score
    System.out.println(AffichagePlateau());  
    System.out.println("Score du " + AfficheNomJoueur(this.joueurCourrant) + ScoreJoueur(this.joueurCourrant)); 
    int joueurNoncourant=returnJoueur();
    System.out.println("Score du " + AfficheNomJoueur(joueurNoncourant) + ScoreJoueur(joueurNoncourant)); 

}
// Methode play sans affichage pour le negamax
public void Play2(int coup)
{
        // Liste stoque les coup 
        ArrayList<Move> Liste= new ArrayList<Move>();
        Liste=getMove(this.joueurCourrant);
        // Si liste des coup n'est pas vide on peux joueur un coup
        if(isValid(coup,this.joueurCourrant))
        {
            Move m = new Move(0,0);
            m=Liste.get(coup); 
            doExecute(coup,this.joueurCourrant);
            EcraseSaut(coup,this.joueurCourrant,m);
        }
        

        //Changement de joueur dans tous les cas 
        ChangeJoueurCourant();
            
}


//Copie du jeu et de la grille  
public State copy(){

    State res = new State();
    res.joueurCourrant=this.joueurCourrant;
    for(int i=0;i<7;i++)
    {
        for(int j=0;j<7;j++)
        {
        res.grille[i][j]=this.grille[i][j];
        }
    }
  return res;

}

// Gagnant 
public String winner()
{
    int joueur=getJoueurCourant();
    int joueur2=returnOtherJoueur(joueur);
    if(ScoreJoueur(joueur)==ScoreJoueur(joueur2))
    {
        return " Match nul ";
    }
    if(ScoreJoueur(joueur) > ScoreJoueur(joueur2))
    {
        return "Le gagnant est " + AfficheNomJoueur(joueur);
    }
    return "Le gagnant est " + AfficheNomJoueur(joueur2);
}

public String AffichagePlateau(){

    String res =" ";
    int tmp=0;  

   for(int i=0;i<7;i++)
   { 
     res+=" " + i + " ";
   }
   

     for(int i=0;i<7;i++){
        
          res+=System.lineSeparator();
          res+=i;
        
      for(int j=0;j<7;j++){

        
             if(grille[i][j]==this.pionBleu)
             {
               res+=" B ";
             }
             if(grille[i][j]==this.pionRouge){
               res+=" R ";
             }
             if(grille[i][j]==0){
               res+=" . ";
             }
             tmp++;
             

      }
   }
   return res;
 }


}