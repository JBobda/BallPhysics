package ballphysics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Display extends Canvas{
    
    public JFrame frame;
    public Dimension dimension;
    public int width;
    public int height;
    public BufferStrategy bufferStrategy;
    public Graphics graphics;
    public Ball ball;
    
    public Display(String title, int width, int height){
        frame = new JFrame(title);
        this.width = width;
        this.height = height;
        dimension = new Dimension(height, width);
        setup();
        
        
        
    }
    
    public void setup(){
        this.setMinimumSize(dimension);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
}
