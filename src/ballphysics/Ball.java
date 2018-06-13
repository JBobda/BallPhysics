package ballphysics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ball {
    
    private int size;
    private int xPos;
    private int yPos;
    private int xVel;
    private int yVel;
    
    
    public Ball( int size){
        this.size = size;
        this.xPos = 0;
        this.yPos = 0;
        xVel = 1;
        yVel = 1;
    }
    
    public void update(){
        if (inBounds(xPos, xVel, 0, BallPhysics.HEIGHT)) {
            xPos = xPos + xVel;
        }else{
            xVel = xVel * -1;
            xPos = xPos + xVel;
        }
        
        if (inBounds(yPos, yVel, 0, BallPhysics.WIDTH)) {
            yPos = yPos + yVel;
        }else{
            yVel = yVel * -1;
            yPos = yPos + yVel;
        }
        
        
    }
    
    public void render(Graphics graphics){
        graphics.setColor(Color.RED);
        graphics.fillRect(xPos,yPos, size, size);
    }
    
    public boolean inBounds(int start, int addition, int min, int max){
        if (start + addition > max || start + addition < min) {
            return false;
        }
        
        return true;
    }
}
