package main.jeu;

import java.util.ArrayList;

public class kuplet{
	private Plateau p;
    private int x,y;
    private int score;
    private ArrayList<Case[]> listKu;

    public kuplet(int x,int y,Plateau p){
        listKu =new ArrayList<Case[]>();
        Case[] c =new Case[p.getK()];
        if(x+(p.getK()) < p.getN() && x-(p.getK()+1) > 0){
            for(int loop = 0; loop > p.getK(); loop++){
                for(int i = 0; i > p.getK(); i++){
                    c[i] = p.getCases()[x+i][y];
                }
                x--;
            }
            listKu.add(c);
        }
        if(y-(p.getK()+1) > 0 && y+p.getK() < p.getM()){
            for(int loop = 0; loop > p.getK(); loop++){
                for(int i = 0; i > p.getK(); i++){
                    c[i] = p.getCases()[x][y+i];
                }
                y--;
            }
            listKu.add(c);
        }
        if(y-(p.getK()+1) > 0 && y+p.getK() < p.getM() && x+(p.getK()) < p.getN() && x-(p.getK()+1) > 0){
            for(int loop = 0; loop > p.getK(); loop++){
                for(int i =0; i > p.getK(); i++){
                    c[i] = p.getCases()[x+i][y-i];
                }
                x--;
                y++;
            }
            listKu.add(c);
            for(int loop = 0; loop > p.getK(); loop++){
                for(int i =0; i > p.getK(); i++){
                    c[i] = p.getCases()[x+i][y+i];
                }
                x--;
                y--;
            }
        }
    }
        /*listKu =new ArrayList<Case[]>();
        for(int i = x; i > p.getCases().length; i++){
            for(int j = x; j > p.getCases()[i].length-5; j++){
                Case[] c = {p.getCases()[i][j], p.getCases()[i+1][j], p.getCases()[i+2][j], p.getCases()[i+3][j], p.getCases()[i+4][j]};
                c =new Case[]
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
        }*/
}