package games;
import  java.util.*;


public class Main{

    


	public static void main(String[] args) {
        int profondeurBleu=0;
        int profondeurRouge=0;
        int ElagageBleu=0;
        int ElagageRouge=0;
        State s = new State();
        float alpha=-50000,beta=500000;
        TestListe t = new TestListe();
        s.Initialisation();
        System.out.println("\n ****************************************\n          ***** BIENVENUE ***** \n ****************************************\n");

        Scanner scanner=new Scanner(System.in);
        System.out.println("Saisir le profondeur du joueur Bleu : ");
        profondeurBleu=scanner.nextInt();
        while(profondeurBleu<=0)
        {
            System.out.println(" Erreur nombre postif ! Saisir la profondeur du joueur Bleu : ");
            profondeurBleu=scanner.nextInt();
        }

        System.out.println("Voulez vous utiliser un élagage pour le joueur Bleu (1 = oui  / 0 = non): ");
        ElagageBleu=scanner.nextInt();

        while( ElagageBleu < 0 || ElagageBleu >1)
        {
        System.out.println("Erreur de saisie ! Voulez vous utiliser un élagage pour le joueur Bleu (1 = oui  / 0 = non): ");
        ElagageBleu=scanner.nextInt();
        }



        System.out.println("Saisir le profondeur du joueur Rouge : ");
        profondeurRouge=scanner.nextInt();

        while(profondeurRouge<=0)
        {
            System.out.println(" Erreur nombre postif ! Saisir la profondeur du joueur Rouge : ");
            profondeurRouge=scanner.nextInt();
        }

        
        System.out.println("Voulez vous utiliser un élagage pour le joueur Rouge (1 = oui  / 0 = non): ");
        ElagageRouge=scanner.nextInt();
        while(ElagageRouge < 0 || ElagageRouge > 1)
        {
        System.out.println("Erreur de saisie ! Voulez vous utiliser un élagage pour le joueur Rouge (1 = oui  / 0 = non): ");
        ElagageRouge=scanner.nextInt();
        }

        
        MinimaxPlayer mini = new MinimaxPlayer(s.pionBleu,profondeurBleu);
        MinimaxPlayer mini1 = new MinimaxPlayer(s.pionRouge,profondeurRouge);
        AlphaBetaPlayer A = new AlphaBetaPlayer(s.pionBleu,profondeurBleu);
        AlphaBetaPlayer A2 = new AlphaBetaPlayer(s.pionRouge,profondeurRouge);
        

      

        while(!s.isOver())
        {

            
            

            // Stoque l'etat actuelle 
            t.ListeState(s.grille);

            // Tester la liste des pions de bleu avant d'en tirer un 
            if(!s.getMove(s.pionBleu).isEmpty())
            {
                Integer bestMove=0;
                
                if(ElagageBleu==0)
                {
                     bestMove=mini.getBestMove(s,profondeurBleu);
                }
                else if(ElagageBleu==1)
                {
                     bestMove=A.getBestMove(s,alpha,beta,profondeurBleu);
                }
                // Si renvoi un bestMove Null on change le joueur 
                s.TestBestMove(s,bestMove);

            }
            //Changement joueur courant si aucun coup valide
            else if(s.getMove(s.pionBleu).isEmpty())
            {
                s.ChangeJoueurCourant();
            }
            
            // Test de la liste des pion de rouge avant d'en tirer un 
            if(!s.getMove(s.pionRouge).isEmpty())
            {
                Integer bestMove2=0;

                //int bestMove2 = s.randomJoueur(s.pionRouge);
                
                if(ElagageRouge==0)
                {
                    bestMove2=mini1.getBestMove(s,profondeurRouge);
                }
                else if(ElagageRouge==1)
                {
                    bestMove2=A2.getBestMove(s,alpha,beta,profondeurRouge);  
                }
                s.TestBestMove(s,bestMove2);
                
            }
            // Changement du joueur 
            else if(s.getMove(s.pionRouge).isEmpty())
            {
                s.ChangeJoueurCourant();
            }

            // Si l'etat se repete on sort de la boucle 
            if(t.isValidState(s)==true )
            {
                System.out.println("Etat repeter");
                break;
                
            }
            
            
        }
        // Affichage du gagnant 
        System.out.println(s.winner());
       
        // Affichage noeud parcourus 
        if(ElagageBleu==1)
        {
            System.out.println("Pour le joueur bleu " + A.getCompteur());
        }
        if(ElagageRouge==1)
        {
            System.out.println("Pour le joueur rouge " + A2.getCompteur());
        }
        if(ElagageBleu==0)
        {
            System.out.println("Pour le joueur bleu " + mini.getCompteur());
        }
        if(ElagageRouge==0)
        {
            System.out.println("Pour le joueur rouge " + mini1.getCompteur());
        }
        
        
    }
}