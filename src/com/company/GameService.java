package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameService {
    private HashMap< Integer, Integer> snakes;
    private HashMap< Integer, Integer> ladders;
    private List<String> players;
    private int number_of_players;
    private HashMap<Integer, Integer> positions;
    public GameService(HashMap<Integer, Integer> snakes, HashMap<Integer, Integer> ladders, List<String> players, int no_of_players, HashMap<Integer, Integer> positions) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        this.number_of_players = no_of_players;
        this.positions = positions;
    }
    public int nextNumber(){
        return new Random().nextInt(6) + 1;
    }
    public int play(){
        for(int i = 0; i < number_of_players; i++){
            int move = nextNumber();
            int prev_position = positions.get(i);
            int next_position = prev_position + move;
            while(true){
                int final_next_position = next_position;
                if(snakes.containsKey(next_position)){
                    final_next_position = snakes.get(next_position);
                }
                else if(ladders.containsKey( next_position)){
                    final_next_position = ladders.get( next_position);
                }
                if(final_next_position==next_position){
                    break;
                }
                next_position = final_next_position;
            }
            if(next_position == 100){
                return i;
            }
            System.out.println(players.get(i) + " rolled a " + move + " and moved from " + prev_position + " to " + next_position);
            positions.replace( i, next_position);
        }
        return -1;
    }
    public String start(){
        while(true){
            int ans = play();
            if(ans!=-1){
                System.out.println(players.get(ans) + " wins the game");
                return players.get(ans);
            }
        }
    }

}
