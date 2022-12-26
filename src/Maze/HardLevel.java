package Maze;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static Maze.Sounds.playMusic;
import java.awt.Color;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.swing.JOptionPane;
import javax.media.opengl.GLCanvas;

/**
 *
 * @author lenovo
 */
public class HardLevel implements GLEventListener {
    GLCanvas gl;
    double px = -12, py = 104;
   public double buffer_px = px;
    public double buffer_py = py;
    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;
    private int n;                 // dimension of maze
    int angle = -10;
    int counter=0;                                                                      
 boolean aa=true , bb=true , cc=true , dd =true, ee=true ,ff=true ,g=true ,k=true ,l=true ,m= true ;   // take coins or not
 String filepath="D:\\Projects\\graphics\\Maze\\src\\Maze\\music\\Arcade-background-music-retro-style.wav";

 
 
    static Sounds pla = Sounds.getInstance();
    static long clpos;
    static boolean isp = true;
    static boolean isL = false;

    

    String name = JOptionPane.showInputDialog(null, "Enter Name");

    //  int maze_level = 2;
    // is there a wall to north of cell i, j

        //من تحت ل فوق هو من اليمين للشال
    


    private boolean[][] east = {{
        true, true, true, true, true, true, true, true, true,true,true,true,true,true,true},
    {
        true, false, false, true, false, false, true, true, false,false,true,true,true,true,false},
    {
        true, false, true, false, false, false, false, false, false,true,true,true,true,true,true},
    {
        true, true, false, true, false, false, true, false, true,false,true,true,false,true,false},
    {
        true, false, true, false, false, true, false, true, false,true,false,false,true,false,true},
    {
        true, true, false, false, true, false, true, false, true,true,false,true,false,false,true},
    {
        true, false, true, true, false, true, true, true, false,false,true,true,false,true,false},
    {
        true, true, true, true, true, false, false, true, true,false,false,false,false,true,false},
    {
        true, true, true, true, false, true, true, true, false,false,false,false,false,false,false},
    {
        true, false, true, false, false, false, true, false, true,true,true,false,false,true,true},
    {
        true, true, false, true, true, true, false, true, true,true,false,true,true,true,false},
    {
        true, false, false, true, false, false, true, false, false,false,true,false,true,false,false},
    {
        true, false, true, false, false, true, false, true, true,false,false,true,false,true,false},
    {
        true, false, true, true, true, true, true, true, false,true,false,false,true,false,false},
    {
        true, true, true, true, true, true, true, true, true,true,true,true,true,true,true},};

    private boolean[][] west = {{
        true, true, true, true, true, true, true, true, true,true,true,true,true,true,true},
    {
        true, true, true, true, true, true, true, true, true,true,true,true,true,true,true},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
            {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},
    {
        true, false, false, false, false, false, false, false, false,false,false,false,false,false,false},};


    double[][] unAllowed_points = {


  
  
    };


    
    public void maze(int n) {
        this.n = n;

    }
    
    
    
    
    @Override
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        GL glu = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, 500, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.glOrtho(-250.0, 250.0, -150.0, 150.0, -1, 1);
        maze(14);
    }   
    
    
    
     float red = 0.0f;
    float green = 0.5f;
    float blue = 0.0f;

    

    @Override
    public void display(GLAutoDrawable glad) {
        
 

        GL gl = glad.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(red, green, blue);

        
        gl.glPushMatrix();
        gl.glScaled(25, 15, 0);
        
        gl.glTranslated(-8, -8, 0);
        gl.glBegin(GL.GL_LINES);
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {

                if (west[x][y]) {
                    gl.glVertex2d((x), (y));
                    gl.glVertex2d((x), (y + 1));
                }
                if (east[x][y]) {
                    gl.glVertex2d((x + 1), (y));
                    gl.glVertex2d((x + 1), (y + 1));

                }
            }
        }

        gl.glEnd();
        gl.glPopMatrix();
        
        
//////////////////////////////// circle /////////////////
        int honka = 1;

        gl.glColor3f(1.0f, 0.7f, 0.75f);

        for (int i = 0; i < unAllowed_points.length; i++) {
            if (buffer_px == unAllowed_points[i][0] && buffer_py == unAllowed_points[i][1]) {
                honka = 0;
            }
        }     
        //
//        for (int i = 0; i < 1; i++) {
//            {
//                System.out.print(" { " + buffer_px + " , " + buffer_py + '}' + " , ");
//            }
//        }   
        //اول اما يلاقي الحاجز يوقف علطول 
        if (honka == 0) {
            gl.glPushMatrix();
            buffer_px = px;
            buffer_py = py;

            gl.glTranslated(px, py, 0);

            double x, y;
            double radius = 5;
            gl.glBegin(GL.GL_POLYGON);
            for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
                x = radius * (Math.cos(a));
                y = radius * (Math.sin(a));
                gl.glVertex2d(x, y);
            }
            gl.glEnd();
            gl.glPopMatrix();
            green = 0.0f;
            red = 1.0f;
            blue = 0.0f;
            counter-=5;
        }
        else {
            gl.glPushMatrix();
            px = buffer_px;
            py = buffer_py;

            gl.glTranslated(px, py, 0);

            double x, y;
            double radius = 5;
            gl.glBegin(GL.GL_POLYGON);
            for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
                x = radius * (Math.cos(a));
                y = radius * (Math.sin(a));
                gl.glVertex2d(x, y);
            }
            gl.glEnd();
            gl.glPopMatrix();
            green = 0f;
            red = 0f;
            blue = 1f;


        }

        gl.glPushMatrix();
                
                drawCircle(gl, 3, Color.YELLOW, aa, -162.0, 39.0 );
                drawCircle(gl, 3, Color.YELLOW, cc,  -112.0 , 39.0);
                drawCircle(gl, 3, Color.YELLOW, dd, -62.0 , 54.0 );
                drawCircle(gl, 3, Color.YELLOW, ee , -142.0 , -66.0 );
                drawCircle(gl, 3, Color.YELLOW, ff , -12.0 , -71.0 );
                
                drawCircle(gl, 3, Color.YELLOW, bb, -12.0 , 4.0);
//                drawCircle(gl, 3, Color.YELLOW, k, 29.0 , 104.0 );
//                drawCircle(gl, 3, Color.YELLOW, l , -71.0 , 104.0 );
//                drawCircle(gl, 3, Color.YELLOW, m, -66.0 , -16.0);



        gl.glEnd();
        gl.glPopMatrix();
        
            if (buffer_px == -162.0 && buffer_py == 39.0 && aa==true ) {
                
                  aa= false ;
                  counter+=10;
            }
            
            if (buffer_px ==  -112.0 && buffer_py ==39.0 && cc==true ) {
                  cc=false ;
                  counter+=10;

            }
            
            if (buffer_px == -62.0 && buffer_py ==54.0 && dd==true ) {
                  dd=false ;
                  counter+=10;
                  
            }
            
            if (buffer_px == -142.0 && buffer_py == -66.0 && ee==true  ) {
                  ee=false ;
                  counter+=10;
            }
            
            if (buffer_px == -12.0 && buffer_py == -71.0 && ff==true  ) {
                  ff=false ;
                  counter+=10;
            }
            
            if (buffer_px == -12.0 && buffer_py == 4.0 && bb==true  ) {
                  bb=false ;
                  counter+=10;
            }
            
//            if (buffer_px == 29.0 && buffer_py == 104.0 && k==true  ) {
//                  k=false ;
//                  counter+=10;
//            }
//            
//            if (buffer_px == -71.0  && buffer_py == 104.0 && l==true  ) {
//                  l=false ;
//                  counter+=10;
//            }
//            
//            if (buffer_px == -66.0  && buffer_py == -16.0 && m==true  ) {
//                  m=false ;
//                  counter+=10;
//            }
            

    //الكوره بتاعت النهاية 
        gl.glPushMatrix();
        gl.glColor3f(1.0f, 0.0f, 1.0f);
        drawStar(gl, 10, true, 12.0, -100, angle+=9);   
        gl.glEnd();
        gl.glPopMatrix();  
//



        if (px == 139.0 && py == -91.0 || px == 139.0 && py == -96.0 ||  px == 129.0 && py == -91.0 ||  px == 134.0 && py == -91.0  || px == 129.0 && py == -91.0 || px == 139.0 && py == -96.0 || px == 144.0 && py == -96.0  || px == 149.0 && py == -96.0 || px == 149.0 && py == -101.0   ) 
         {
            blue = 1.0f;
            green = 0.0f;
            red = 0.0f;
            if (blue == 1.0f) {
                JOptionPane.showMessageDialog(null, "Good Job ♥ " + name);
                if(counter>0){
                JOptionPane.showMessageDialog(null, "You Win \n Your Score is ☺ " + counter);
                }
                else  JOptionPane.showMessageDialog(null, "You lost  " + -1*counter);

                System.exit(0);
            }

        }
        
    }// end display method
    
    
    
        void drawStar(GL gl, double r, boolean filled, double x, double y, int angle) {
        gl.glPushMatrix();
        gl.glTranslated(x, y, 0);
        gl.glRotated(angle, 0, 0, 1);
        drawStar(gl, r, r/2 , 5, 90, 2, filled);
        gl.glPopMatrix();
    } 


    void drawStar(GL gl, double r1, double r2, double sides, double startAngle, int step, boolean filled) {
        if (filled) {
            gl.glBegin(GL.GL_TRIANGLE_FAN);
        } else {
            gl.glBegin(GL.GL_LINE_LOOP);
        }

        for (double i = startAngle; i <= 360 + startAngle; i += 360.0 / sides) {
            gl.glVertex2d(r2 * Math.cos(Math.toRadians(i-180.0 / sides)), r2 * Math.sin(Math.toRadians(i-180.0 / sides)));
            gl.glVertex2d(r1 * Math.cos(Math.toRadians(i)), r1 * Math.sin(Math.toRadians(i)));
        }
        gl.glEnd();
    }
    
    
    
        void drawCircle(GL gl, int r, Color c, boolean filled, double x, double y) {
        gl.glPushMatrix();
        gl.glTranslated(x, y, 0);
        drawPolyLines(gl, r, c, 360, 0, 1, filled);
        gl.glPopMatrix();
    }
        

        void drawPolyLines(GL gl, int r, Color c, double sides, double startAngle, double step, boolean filled) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        if (filled) {
            gl.glBegin(GL.GL_POLYGON);
        } else {
            gl.glBegin(GL.GL_LINE_LOOP);
        }

        for (double i = startAngle; i < 360 * step + startAngle; i += step * 360.0 / sides) {
            gl.glVertex2d(r * Math.cos(Math.toRadians(i)), r * Math.sin(Math.toRadians(i)));
        }
        gl.glEnd();
    }
        
        
        
        

    
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
    }

    
}















/*
  //الكوره بتاعت النهاية 
        gl.glPushMatrix();
        gl.glTranslated(139.0, -106, 0);
        gl.glColor3f(0.0f, 0.0f, 1.00f);
        double x2, y2;
        double radius1 = 16;
//        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glBegin(GL.GL_POLYGON);
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x2 = radius1 * (Math.cos(a));
            y2 = radius1 * (Math.sin(a));
            gl.glVertex2d(x2, y2);
        }
        gl.glEnd();
        gl.glPopMatrix();

*/