package ballphysics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Display extends Canvas{
    
    public Dimension dimension;
    public int width;
    public int height;
    public BufferStrategy bufferStrategy;
    
    public Display(String title, int width, int height){
        JFrame frame = new JFrame(title);
        this.width = width;
        this.height = height;
        dimension = new Dimension(height, width);
        
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
    
    public void render(){
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            bufferStrategy = getBufferStrategy();
            return;
        }
        
        Graphics g = bufferStrategy.getDrawGraphics();
        ///////////////////////////////////
        g.setColor(Color.BLACK);
        g.fillRect(0,0, height, width);
        
        
        
        ///////////////////////////////////
        g.dispose();
        bufferStrategy.show();
    }
}
