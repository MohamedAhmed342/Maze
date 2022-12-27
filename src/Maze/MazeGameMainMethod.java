package Maze;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static Maze.EasyLevel.pla2;
import static Maze.EasyLevel.pla;
import static Maze.Sounds.playMusic;
import com.sun.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author lenovo
 */
public class MazeGameMainMethod extends JFrame implements KeyListener {

    GLCanvas gl;
//    EasyLevel listner = new EasyLevel();
    HardLevel listner = new HardLevel();


    public static void main(String[] args) {
        final MazeGameMainMethod app = new MazeGameMainMethod();

//         String MazeMusic="D:\\Projects\\graphics\\Maze\\src\\Maze\\music\\FinalBattle.wav";
//         playMusic(MazeMusic);
//         pla2.clip.start();
//         

        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                
                app.setVisible(true);     
                


            }
            
      
        }
        );
    }

    public MazeGameMainMethod() {

        super("Maze");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GLCapabilities glcaps2 = new GLCapabilities();
        gl = new GLCanvas(glcaps2);
        gl.addGLEventListener(
                listner
        );
        gl.addKeyListener(this);
        getContentPane().add(gl, BorderLayout.CENTER);
        setSize(1230, 700);
        centerWindow(this);
    }

    public void centerWindow(Component frame) {
        Dimension screenSize
                = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        frame.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }

    
        @Override
    public void keyTyped(KeyEvent ke) {

    }
    @Override
    public void keyPressed(KeyEvent ke) {
        try {
            switch (ke.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    listner.buffer_py -= 5;
                    //listner.py -= 10;
                    gl.repaint();
                    break;
                case KeyEvent.VK_UP:
                    listner.buffer_py += 5;
                    //listner.py += 10;
                    gl.repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    listner.buffer_px += 5;
                    //listner.px += 10;
                    gl.repaint();
                    break;
                case KeyEvent.VK_LEFT:
                    listner.buffer_px -= 5;
                    //listner.px -= 10;
                    gl.repaint();
                    break;

            }
        }// end switch    
        catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Error: " + ee.getMessage());
        }
    }

    public void keyReleased(KeyEvent ke) {
    }    
    
    
    
}
