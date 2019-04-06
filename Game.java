package TwoThousandFortyEight;

import java.util.ArrayList;

public class Game {
    private static int score = 0;
    private static int size = 4;
    private static Cell[][] cells = new Cell[size][size];
    private static ArrayList<String> frees = new ArrayList<>();

    public static void main(String[] args){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                Cell cell = new Cell(0);
                cells[i][j] = cell;
            }
        }
        Game.updateFrees();
        new Controller().setGameWindow(new GameWindow());
    }

    static int getScore(){
        return score;
    }

    static int getSize() {
        return size;
    }

    static Cell[][] getCells() {
        return cells;
    }

    static void updateFrees(){
        frees.clear();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                if(cells[i][j].getNumber() == 0){
                    frees.add(i + " " + j);
                }
            }
        }
        if(frees.size() > 0){
            addRandom();
        } else {
            lose();
        }
    }

    static ArrayList<String> getFrees() {
        return frees;
    }

    private static void addRandom(){
        String[] luckyBoy = frees.get((int)(Math.random()*frees.size())).split(" ");
        int x = Integer.parseInt(luckyBoy[1]);
        int y = Integer.parseInt(luckyBoy[0]);
        if(Math.random()*100 < 10)
            cells[y][x] = new Cell(4);
        else
            cells[y][x] = new Cell(2);
    }

    private static void lose(){
        System.out.println("You lose!");
    }
}
