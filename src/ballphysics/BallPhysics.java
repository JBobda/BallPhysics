package ballphysics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class BallPhysics implements Runnable{
    public static final int WIDTH = 350;
    public static final int HEIGHT = WIDTH * 16 / 9;
    
    private Thread thread;
    private Display display;
    private Ball ball;
    private boolean running;
    public BufferStrategy bufferStrategy;
    
    public BallPhysics(){
        this.thread = new Thread(this);
        display = new Display("Ball Physics Simulation", WIDTH , HEIGHT );
        
        int xPos =(int)(Math.random() * WIDTH);
        int yPos = (int) (Math.random() * HEIGHT);
        
        ball = new Ball(10, yPos, xPos);
        
    }
    
    public synchronized void start(){
        running = true;
        run();
    }
    
    public synchronized void stop(){
        running = false;
    }
    
    public void update(){
        ball.update();
    }
    
    public void render(){
        if (bufferStrategy == null) {
            display.createBufferStrategy(3);
            bufferStrategy = display.getBufferStrategy();
            return;
        }
        
        Graphics graphics = bufferStrategy.getDrawGraphics();
        //////////////////////////////////////////////
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, HEIGHT, WIDTH);
        ball.render(graphics);
        /////////////////////////////////////////////
        graphics.dispose();
        bufferStrategy.show();
    }
    
    @Override
    public void run(){
        long lastTime = System.nanoTime();
        double unprocessedTime = 0;
        double ns = 1000000000.0/ 60.0;
        
        
        while(running){
            long now = System.nanoTime();
            unprocessedTime = unprocessedTime + (now -lastTime)/ns;
            lastTime = now;
            
            while (unprocessedTime >= 1) {
                update();   
                unprocessedTime--;
            }
            render();
        }
        stop();
    }
}
