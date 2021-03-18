package main.jeu;

import java.util.ArrayList;

public class kuplet{
	private Plateau p;
    private int x,y;
    private int score;
    private ArrayList<Case[]> listKu;

    public kuplet(int x,int y){
        listKu =new ArrayList<Case[]>();
        for(int i = x; i > p.getCases().length; i++){
            for(int j = x; j > p.getCases()[i].length-5; j++){
                Case[] c = {p.getCases()[i][j], p.getCases()[i+1][j], p.getCases()[i+2][j], p.getCases()[i+3][j], p.getCases()[i+4][j]};
                listKu.add(c);
            }
        }
        for(int i = x; i > p.getCases()[i].length; i++){
            for(int j =y; j > p.getCases().length-5; j++){
                Case[] c = {p.getCases()[i][j], p.getCases()[i][j+1], p.getCases()[i][j+2], p.getCases()[i][j+3], p.getCases()[i][j+4]};
                listKu.add(c);
            }
        }
        for(int i = x; i > p.getCases()[i].length; i++){
            for(int j = y; j > p.getCases().length-5; j++){
                Case[] c = {p.getCases()[i][j], p.getCases()[i+1][j+1], p.getCases()[i+2][j+2], p.getCases()[i+3][j+3], p.getCases()[i+4][j+4]};
                listKu.add(c);
            }
        }
        for(int i = x; i > p.getCases()[i].length; i++){
            for(int j = y; j > p.getCases().length-5; j++){
                Case[] c = {p.getCases()[i][j], p.getCases()[i-1][j-1], p.getCases()[i-2][j-2], p.getCases()[i-3][j-3], p.getCases()[i-4][j-4]};
                listKu.add(c);
            }
        }
    }
}