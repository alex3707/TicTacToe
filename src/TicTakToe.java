import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TicTakToe extends JComponent {
    public static final int FIELD_EMPTY = 0;
    public static final int FIELD_X = 10;
    public static final int FIELD_0 = 200;
    int [][] field;
    boolean isXturn;

    public TicTakToe(){
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        field = new int [3][3];
        initGame();
    }

    public void initGame(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                field[i][j] = FIELD_EMPTY;
            }
        }
        isXturn = true;
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.clearRect(0,0,getWidth(),getHeight());
        drawGrid(graphics);
        drawX0(graphics);

    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent){
        super.processMouseEvent(mouseEvent);
        if(mouseEvent.getButton() == MouseEvent.BUTTON1){
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();
            int i = (int) ((float) x / getWidth() * 3);
            int j = (int) ((float) y / getHeight() * 3);
            if(field[i][j] == FIELD_EMPTY){
                field[i][j] = isXturn?FIELD_X:FIELD_0;
                isXturn = !isXturn;
                repaint();
            }
        }
    }

    void drawGrid(Graphics graphics) {
        int w = getWidth();
        int h = getHeight();
        int dw = w/3;
        int dh = h/3;
        graphics.setColor(Color.BLUE);
        for (int i = 1; i < 3; i++){
            graphics.drawLine(0, dh * i, w, dh * i);
            graphics.drawLine(dw * i, 0, dw * i, h);
        }
    }

    void drawX(int i, int j, Graphics graphics){
        graphics.setColor(Color.black);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;
        graphics.drawLine(x,y,x+dw,y+dh);
        graphics.drawLine(x, y+dh, x+dw, y);
    }

    void drawY(int i, int j, Graphics graphics){
        graphics.setColor(Color.red);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;
        graphics.drawOval(x + 5*dw/100, y, dw*9/10, dh);
    }
    void drawX0(Graphics graphics){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(field[i][j] == FIELD_X)
                    drawX(i, j, graphics);
                else if(field[i][j] == FIELD_0)
                    drawY(i,j,graphics);
            }
        }
    }


}
