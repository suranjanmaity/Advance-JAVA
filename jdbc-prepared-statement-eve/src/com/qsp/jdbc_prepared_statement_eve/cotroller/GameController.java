package com.qsp.jdbc_prepared_statement_eve.cotroller;

import java.util.LinkedList;
import java.util.Scanner;

import com.qsp.jdbc_prepared_statement_eve.dto.Game;
import com.qsp.jdbc_prepared_statement_eve.service.GameService;

public class GameController {
    public static void main(String[] args) {
        Game game = new Game();
        GameService gameService = new GameService();
        String choiceS="";
        int choice=-79828720;
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("\n-------------------------------------------------\n\tGAME MENU :\n1.Insert\n2.Update\n3.Delete\n4.Delete all\n5.Display\n6.Add in Batch\nAny other no. to exit\nEnter your choice : ");

                if(choiceS.getClass().getSimpleName()!="Integer") {
                    System.out.println("\n\t!!!\tEnter only numbers\t!!!");
                    choiceS =sc.next();
                }
                
                try {
                    choice =Integer.parseInt(choiceS);
                } catch (Exception e) {
                    e.getStackTrace();
                }

                switch (choice) {
                    // nothing case for repetetion
                    case -79828720:{
                        break;
                    }
                    // insert
                    case 1:{
                        System.out.print("Enter the id :");
                        game.setId(sc.nextInt());
                        System.out.print("Enter the name :");
                        game.setName(sc.next());
                        System.out.print("Enter the player count :");
                        game.setTeamPlayer(sc.nextInt());
                        System.out.print("Enter the expense|cost :");
                        game.setExpense(sc.nextDouble());
                        gameService.insertGame(game);
                        break;
                    }
                    // update
                    case 2:{
                        System.out.print("Enter the id :");
                        game.setId(sc.nextInt());
                        if (gameService.getById(game.getId())==game.getId()) {
                            System.out.print("Enter the new name :");
                            game.setName(sc.next());
                            System.out.print("Enter the new player count :");
                            game.setTeamPlayer(sc.nextInt());
                            System.out.print("Enter the new expense|cost :");
                            game.setExpense(sc.nextDouble());
                            gameService.updateGame(game);   
                        } else {
                            System.out.println("Id not present");
                        }
                        break;
                    }
                    // delete
                    case 3:{
                        System.out.print("Enter the id :");
                        game.setId(sc.nextInt());
                        if (gameService.getById(game.getId())==game.getId()) {
                            gameService.deleteGame(game);
                        } else {
                            System.out.println("Id not present");
                        }
                        break;
                    }
                    // delete all game
                    case 4:{
                        gameService.deleteAllGame();
                        break;
                    }
                    // display
                    case 5:{
                        LinkedList<Game> linkedList = gameService.displayAllGame();
                        if (!linkedList.isEmpty()) {
                            // checked in case of empty linked list
                            for (Game game2 : linkedList) {
                                game2.toStrin();
                            }
                        }
                        else{
                            System.out.println("No data present yet.");
                        }
                        break;
                    }
                    // add in bacth
                    case 6:{
                        LinkedList<Game> linkedList = new LinkedList<Game>();
                        System.out.print("\nhow much entries you want to add : ");
                        int size = sc.nextInt();
                        for (int i = 0; i < size; i++) {
                            Game game2 = new Game();
                            System.out.println("for element "+i+" : ");
                            System.out.print("Enter the id :");
                            game2.setId(sc.nextInt());
                            System.out.print("Enter the name :");
                            game2.setName(sc.next());
                            System.out.print("Enter the player count :");
                            game2.setTeamPlayer(sc.nextInt());
                            System.out.print("Enter the expense|cost :");
                            game2.setExpense(sc.nextDouble());
                            linkedList.add(game2);
                        }
                        gameService.insertAddBatch(linkedList);
                    }
                    // to exit
                    default:{
                        System.exit(0);
                    }
                }
                
            }
        }
    }
}
