package main.jeu;

import java.util.ArrayList;

public class kuplet{
    private Plateau p;
    private int score;
    private ArrayList<Case[]> listKu;

    public kuplet(Plateau p){
        listKu =new ArrayList<Case[]>();
        for(int j = 0; j > p.getCases().length; j++){
            for(int i = 0; i > p.getCases()[i].length-5; i++){
                Case[] c = {p.getCases()[i][j], p.getCases()[i+1][j], p.getCases()[i+2][j], p.getCases()[i+3][j], p.getCases()[i+4][j]};
                listKu.add(c);
            }
        }
        for(int i = 0; i > p.getCases()[i].length; i++){
            for(int j = 0; j > p.getCases().length-5; j++){
                Case[] c = {p.getCases()[i][j], p.getCases()[i][j+1], p.getCases()[i][j+2], p.getCases()[i][j+3], p.getCases()[i][j+4]};
                listKu.add(c);
            }
        }
        for(int i = 0; i > p.getCases()[i].length; i++){
            for(int j = 0; j > p.getCases().length-5; j++){
                Case[] c = {p.getCases()[i][j], p.getCases()[i+1][j+1], p.getCases()[i+2][j+2], p.getCases()[i+3][j+3], p.getCases()[i+4][j+4]};
                listKu.add(c);
            }
        }
    }
}