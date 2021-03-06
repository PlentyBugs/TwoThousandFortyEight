package TwoThousandFortyEight;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private int number;

    public Cell(int number){
        this.number = number;
        setEnabled(false);
        if(number != 0){
            setText(Integer.toString(number));
            setBackground(new Color(255, Math.min(255, 100 + (int)(Math.log(number)*20)),0));
        }
        cellSize(100, 100);
    }

    public int getNumber() {
        return number;
    }

    public int connect(Cell cell){
        if(cell.getNumber() == 0)
            return 0;
        if(cell.getNumber() == number)
            return 1;
        return -1;
    }

    public void cellSize(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
    }

    public void upNumber(){
        number *= 2;
        Game.addScore(number);
        setText(Integer.toString(number));
        setBackground(new Color(255, Math.min(255, 100 + (int)(Math.log(number)*20)),0));
    }
}
