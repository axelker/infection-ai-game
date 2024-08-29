package games;
import games.State;
import java.util.*;


public class Move {
    int departCoup;
    boolean TypeCoup;
    int arriverCoup;

public Move(int depart,int arriver)
{
    this.departCoup=depart;
    this.arriverCoup=arriver;
    this.TypeCoup=false; 

}
@Override
    public String toString() { 
        return String.format("pion : " + this.departCoup + " coup : " + this.arriverCoup + " Type : " + this.TypeCoup); 
    } 
}