package ballphysics;

public class BallPhysics implements Runnable{
    public static final int WIDTH = 350;
    public static final int HEIGHT = WIDTH * 16 / 9;
    
    private Thread thread;
    private Display display;
    private boolean running;
    
    public BallPhysics(){
        this.thread = new Thread(this);
        display = new Display("Ball Physics Simulation", WIDTH , HEIGHT );
    }
    
    public synchronized void start(){
        running = true;
        run();
    }
    
    public synchronized void stop(){
        
    }
    
    public void render(){
        display.render();
    }
    
    @Override
    public void run(){
        while(running){
            render();
        }
        stop();
    }
}
