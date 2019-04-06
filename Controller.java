package TwoThousandFortyEight;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    private GameWindow gameWindow;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            moveToLeft();
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            moveToRight();
        } else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            moveToTop();
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            moveToBot();
        }
        gameWindow.drawWindow();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        gameWindow.addKeyListener(this);
    }

    private void moveToLeft(){
        for(int i = 0; i < Game.getSize(); i++) {
            for (int j = 1; j < Game.getSize(); j++) {
                if(Game.getCells()[i][j].getNumber() == 0)
                    continue;
                if(Game.getCells()[i][j].connect(Game.getCells()[i][j-1]) == 0){
                    Game.getCells()[i][j-1] = new Cell(Game.getCells()[i][j].getNumber());
                    Game.getCells()[i][j] = new Cell(0);
                } else if(Game.getCells()[i][j].connect(Game.getCells()[i][j-1]) == 1){
                    Game.getCells()[i][j-1].upNumber();
                    Game.getCells()[i][j] = new Cell(0);
                }
            }
        }
    }

    private void moveToRight(){
        for(int i = 0; i < Game.getSize(); i++) {
            for (int j = 0; j < Game.getSize()-1; j++) {
                if(Game.getCells()[i][j].getNumber() == 0)
                    continue;
                Game.getCells()[i][j].connect(Game.getCells()[i][j-1]);
            }
        }
    }

    private void moveToTop(){
        for(int j = 0; j < Game.getSize(); j++) {
            for (int i = 0; i < Game.getSize(); i++) {
                if(Game.getCells()[i][j].getNumber() == 0)
                    continue;
            }
        }
    }

    private void moveToBot(){
        for(int j = 0; j < Game.getSize(); j++) {
            for (int i = 0; i < Game.getSize(); i++) {
                if(Game.getCells()[i][j].getNumber() == 0)
                    continue;
            }
        }
    }
}
