package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Scanner sc = new Scanner(System.in);
        int number_of_snakes = sc.nextInt();
        HashMap<Integer, Integer> snakes = new HashMap<>();
        for(int i = 0; i < number_of_snakes; i++){
            Snake snake = new Snake( sc.nextInt(), sc.nextInt());
            snakes.put(snake.getStart(), snake.getEnd());
        }
        int number_of_ladders = sc.nextInt();
        HashMap<Integer, Integer> ladders = new HashMap<>();
        for (int i = 0; i < number_of_ladders; i++){
            Ladder ladder = new Ladder( sc.nextInt(), sc.nextInt());
            ladders.put( ladder.getStart(), ladder.getEnd());
        }
        int no_of_players = sc.nextInt();
        HashMap<Integer, Integer> positions = new HashMap<>();
        List<String> players = new ArrayList<>();
        for (int i = 0; i < no_of_players; i++){
            String player = sc.next();
            players.add(player);
            positions.put( i, 0);
        }
        GameService gameService = new GameService( snakes, ladders, players, no_of_players, positions);
        gameService.start();
    }
}
