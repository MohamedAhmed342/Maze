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
public class TwoPlayer implements GLEventListener {

    GLCanvas gl;
    double px = -146, py = 104;
    public double buffer_px = px;
    public double buffer_py = py;
    
    
    double px2 = -146, py2 = 104;
    public double buffer_px2 = px2;
    public double buffer_py2 = py2;
    
    final double one = (Math.PI / 180);
    final double three = 2 * Math.PI;
    private int n;                 // dimension of maze
    int angle = -10;
    int counter = 0;
    int counter2=0;
    boolean a = true, b = true, c = true, d = true, e = true, f = true, g = true, k = true, l = true, m = true;   // take coins or not
     String coins = "E:\\New folder\\Maze2\\Maze\\src\\Maze\\music\\src_Maze_music_coins.wav";
    String gameover = "E:\\New folder\\Maze2\\Maze\\src\\Maze\\music\\src_Maze_music_gameover.wav";
    String Winning = "E:\\New folder\\Maze2\\Maze\\src\\Maze\\music\\src_Maze_music_Winning.wav";
    String TakeDamage = "E:\\New folder\\Maze2\\Maze\\src\\Maze\\music\\src_Maze_music_TakeDamage.wav";

//
//  String filepath2="D:\\Projects\\graphics\\Maze\\src\\Maze\\music\\wak.wav";
// String coins="D:\\Projects\\graphics\\Maze\\src\\Maze\\music\\coins.wav";
    static Sounds pla = Sounds.getInstance();
//    static Sounds pla2 = Sounds.getInstance2();

    static long clpos;
    static boolean isp = true;
    static boolean isL = false;

    String name = JOptionPane.showInputDialog(null, "Enter First Player Name");
    String name2 = JOptionPane.showInputDialog(null, "Enter Second Player Name");

    //  int maze_level = 2;
    // is there a wall to north of cell i, j
    private boolean[][] north = {{
        true, true, true, true, true, true, true, true, true},
    {
        true, false, true, false, true, false, true, false, true},
    {
        true, false, true, false, false, true, false, false, true},
    {
        true, false, false, true, false, true, false, true, true},
    {
        true, true, false, false, false, true, false, false, true},
    {
        true, true, true, false, false, false, false, true, true},
    {
        true, true, false, false, true, false, true, false, true},
    {
        true, true, false, false, false, false, false, false, true},
    {
        true, false, false, true, false, true, true, false, true},};

    private boolean[][] south = {{
        true, true, true, true, true, true, true, true, true},
    {
        true, true, false, false, false, false, false, false, false},
    {
        true, true, false, false, false, false, false, false, false},
    {
        true, true, false, false, false, false, false, false, false},
    {
        true, true, false, false, false, false, false, false, false},
    {
        true, true, false, false, false, false, false, false, false},
    {
        true, true, false, false, false, false, false, false, false},
    {
        true, true, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false},};

    private boolean[][] east = {{
        true, false, true, true, true, true, true, true, true},
    {
        true, false, false, false, true, false, false, true, false},
    {
        true, false, false, false, true, false, false, false, true},
    {
        true, false, false, true, false, false, false, false, false},
    {
        true, false, false, true, true, true, false, false, false},
    {
        true, false, false, false, true, false, false, true, true},
    {
        true, false, false, false, false, false, true, false, true},
    {
        true, true, false, true, false, true, false, true, false},
    {
        true, true, true, true, true, true, true, true, true},};

    private boolean[][] west = {{
        true, true, true, true, true, true, true, true, true},
    {
        true, true, true, true, true, true, true, true, true},
    {
        true, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false},};

    double[][] unAllowed_points = {
        {-156.0, 119.0}, {-151.0, 119.0}, {-146.0, 119.0}, {-141.0, 119.0}, {-136.0, 119.0}, {-131.0, 119.0}, {-126.0, 119.0}, {-121.0, 119.0}, {-116.0, 119.0}, {-111.0, 119.0}, {-106.0, 119.0}, {-101.0, 119.0}, {-96.0, 119.0}, {-91.0, 119.0}, {-86.0, 119.0}, {-81.0, 119.0}, {-76.0, 119.0}, {-71.0, 119.0}, {-66.0, 119.0}, {-61.0, 119.0}, {-56.0, 119.0}, {-51.0, 119.0}, {-46.0, 119.0}, {-41.0, 119.0}, {-36.0, 119.0}, {-31.0, 119.0}, {-26.0, 119.0}, {-21.0, 119.0}, {-16.0, 119.0}, {-11.0, 119.0}, {-6.0, 119.0}, {-1.0, 119.0}, {4.0, 119.0}, {9.0, 119.0}, {14.0, 119.0}, {19.0, 119.0}, {24.0, 119.0}, {29.0, 119.0}, {34.0, 119.0}, {39.0, 119.0}, {44.0, 119.0}, {49.0, 119.0}, {54.0, 119.0}, {59.0, 119.0}, {64.0, 119.0}, {69.0, 119.0}, {74.0, 119.0}, {79.0, 119.0}, {84.0, 119.0}, {89.0, 119.0}, {94.0, 119.0}, {99.0, 119.0}, {104.0, 119.0}, {109.0, 119.0}, {114.0, 119.0}, {119.0, 119.0}, {124.0, 119.0}, {129.0, 119.0}, {134.0, 119.0}, {139.0, 119.0}, {144.0, 119.0}, {149.0, 119.0}, {154.0, 119.0}, {159.0, 119.0}, {164.0, 119.0}, {159.0, 114.0}, {159.0, 109.0}, {159.0, 104.0}, {159.0, 99.0}, {159.0, 94.0}, {159.0, 89.0}, {159.0, 84.0}, {159.0, 79.0}, {159.0, 74.0}, {159.0, 69.0}, {159.0, 64.0}, {159.0, 59.0}, {159.0, 54.0}, {159.0, 49.0}, {159.0, 44.0}, {159.0, 39.0}, {159.0, 34.0}, {159.0, 29.0}, {159.0, 24.0}, {159.0, 19.0}, {159.0, 14.0}, {159.0, 9.0}, {159.0, 4.0}, {159.0, -1.0}, {159.0, -6.0}, {159.0, -11.0}, {159.0, -16.0}, {159.0, -21.0}, {159.0, -26.0}, {159.0, -31.0}, {159.0, -36.0}, {159.0, -41.0}, {159.0, -46.0}, {159.0, -51.0}, {159.0, -56.0}, {159.0, -61.0}, {159.0, -66.0}, {159.0, -71.0}, {159.0, -76.0}, {159.0, -81.0}, {159.0, -86.0}, {159.0, -91.0}, {159.0, -96.0}, {159.0, -101.0}, {159.0, -106.0}, {159.0, -111.0}, {159.0, -116.0}, {159.0, -121.0}, {154.0, -121.0}, {149.0, -121.0}, {144.0, -121.0}, {139.0, -121.0}, {134.0, -121.0}, {129.0, -121.0}, {124.0, -121.0}, {119.0, -121.0}, {114.0, -121.0}, {109.0, -121.0}, {104.0, -121.0}, {99.0, -121.0}, {94.0, -121.0}, {89.0, -121.0}, {84.0, -121.0}, {79.0, -121.0}, {74.0, -121.0}, {69.0, -121.0}, {64.0, -121.0}, {59.0, -121.0}, {54.0, -121.0}, {49.0, -121.0}, {44.0, -121.0}, {39.0, -121.0}, {34.0, -121.0}, {29.0, -121.0}, {24.0, -121.0}, {19.0, -121.0}, {14.0, -121.0}, {9.0, -121.0}, {4.0, -121.0}, {-1.0, -121.0}, {-6.0, -121.0}, {-11.0, -121.0}, {-16.0, -121.0}, {-21.0, -121.0}, {-26.0, -121.0}, {-31.0, -121.0}, {-36.0, -121.0}, {-41.0, -121.0}, {-46.0, -121.0}, {-51.0, -121.0}, {-56.0, -121.0}, {-61.0, -121.0}, {-66.0, -121.0}, {-71.0, -121.0}, {-76.0, -121.0}, {-81.0, -121.0}, {-86.0, -121.0}, {-91.0, -121.0}, {-96.0, -121.0}, {-101.0, -121.0}, {-106.0, -121.0}, {-111.0, -121.0}, {-116.0, -121.0}, {-121.0, -121.0}, {-126.0, -121.0}, {-131.0, -121.0}, {-136.0, -121.0}, {-141.0, -121.0}, {-146.0, -121.0}, {-151.0, -121.0}, {-156.0, -121.0}, {-161.0, -121.0}, {-161.0, 114.0}, {-161.0, 109.0}, {-161.0, 104.0}, {-161.0, 99.0}, {-161.0, 94.0}, {-161.0, 89.0}, {-161.0, 84.0}, {-161.0, 79.0}, {-161.0, 74.0}, {-161.0, 69.0}, {-161.0, 64.0}, {-161.0, 59.0}, {-161.0, 54.0}, {-161.0, 49.0}, {-161.0, 44.0}, {-161.0, 39.0}, {-161.0, 34.0}, {-161.0, 29.0}, {-161.0, 24.0}, {-161.0, 19.0}, {-161.0, 14.0}, {-161.0, 9.0}, {-161.0, 4.0}, {-161.0, -1.0}, {-161.0, -6.0}, {-161.0, -11.0}, {-161.0, -16.0}, {-161.0, -21.0}, {-161.0, -26.0}, {-161.0, -31.0}, {-161.0, -36.0}, {-161.0, -41.0}, {-161.0, -46.0}, {-161.0, -51.0}, {-161.0, -56.0}, {-161.0, -61.0}, {-161.0, -66.0}, {-161.0, -71.0}, {-161.0, -76.0}, {-161.0, -81.0}, {-161.0, -86.0}, {-161.0, -91.0}, {-161.0, -96.0}, {-161.0, -101.0}, {-161.0, -106.0}, {-161.0, -111.0}, {-161.0, -116.0}, {-161.0, -121.0}, {-81.0, 114.0}, {-81.0, 109.0}, {-81.0, 104.0}, {-81.0, 99.0}, {-81.0, 94.0}, {-81.0, 89.0}, {-76.0, 89.0}, {-71.0, 89.0}, {-66.0, 89.0}, {-61.0, 89.0}, {-56.0, 89.0}, {-51.0, 89.0}, {-46.0, 89.0}, {-41.0, 89.0},
        {39.0, 114.0}, {39.0, 109.0}, {39.0, 104.0}, {39.0, 99.0}, {39.0, 94.0}, {39.0, 89.0}, {34.0, 89.0}, {29.0, 89.0}, {24.0, 89.0}, {19.0, 89.0}, {14.0, 89.0}, {9.0, 89.0}, {4.0, 89.0}, {39.0, 84.0}, {39.0, 79.0}, {39.0, 74.0}, {39.0, 69.0}, {39.0, 64.0}, {39.0, 59.0}, {44.0, 59.0}, {49.0, 59.0}, {54.0, 59.0}, {59.0, 59.0}, {64.0, 59.0}, {69.0, 59.0}, {74.0, 59.0}, {79.0, 59.0}, {79.0, 54.0}, {79.0, 49.0}, {79.0, 44.0}, {79.0, 39.0}, {79.0, 34.0}, {79.0, 29.0}, {79.0, 114.0}, {79.0, 109.0}, {79.0, 104.0}, {79.0, 99.0}, {79.0, 94.0}, {79.0, 89.0}, {154.0, 59.0}, {149.0, 59.0}, {144.0, 59.0}, {139.0, 59.0}, {134.0, 59.0}, {129.0, 59.0}, {124.0, 59.0}, {119.0, 59.0}, {119.0, 64.0}, {119.0, 69.0}, {119.0, 74.0}, {119.0, 79.0}, {119.0, 84.0}, {119.0, 89.0},
        {154.0, 29.0}, {149.0, 29.0}, {144.0, 29.0}, {139.0, 29.0}, {134.0, 29.0}, {129.0, 29.0}, {124.0, 29.0}, {119.0, 29.0}, {119.0, 24.0}, {119.0, 19.0}, {119.0, 14.0}, {119.0, 9.0}, {119.0, 4.0}, {119.0, -1.0}, {79.0, -1.0}, {74.0, -1.0}, {69.0, -1.0}, {64.0, -1.0}, {59.0, -1.0}, {54.0, -1.0}, {49.0, -1.0}, {44.0, -1.0}, {39.0, -1.0}, {39.0, -6.0}, {39.0, -11.0}, {39.0, -16.0}, {39.0, -21.0}, {39.0, -26.0}, {39.0, -31.0},
        {154.0, -31.0}, {149.0, -31.0}, {144.0, -31.0}, {139.0, -31.0}, {134.0, -31.0}, {129.0, -31.0}, {124.0, -31.0}, {119.0, -31.0}, {119.0, -36.0}, {119.0, -41.0}, {119.0, -46.0}, {119.0, -51.0}, {119.0, -56.0}, {119.0, -61.0}, {-121.0, 29.0}, {-116.0, 29.0}, {-111.0, 29.0}, {-106.0, 29.0}, {-101.0, 29.0}, {-96.0, 29.0}, {-91.0, 29.0}, {-86.0, 29.0}, {-81.0, 29.0}, {-76.0, 29.0}, {-71.0, 29.0}, {-66.0, 29.0}, {-61.0, 29.0}, {-56.0, 29.0}, {-51.0, 29.0}, {-46.0, 29.0}, {-41.0, 29.0}, {-36.0, 29.0}, {-31.0, 29.0}, {-26.0, 29.0}, {-21.0, 29.0}, {-16.0, 29.0}, {-11.0, 29.0}, {-6.0, 29.0}, {-1.0, 29.0}, {-1.0, 24.0}, {-1.0, 19.0}, {-1.0, 14.0}, {-1.0, 9.0}, {-1.0, 4.0}, {-1.0, -1.0}, {-1.0, -6.0}, {-1.0, -11.0}, {-1.0, -16.0}, {-1.0, -21.0}, {-1.0, -26.0}, {-1.0, -31.0}, {-1.0, -36.0}, {-1.0, -41.0}, {-1.0, -46.0}, {-1.0, -51.0}, {-1.0, -56.0}, {-1.0, -61.0}, {4.0, -61.0}, {9.0, -61.0}, {14.0, -61.0}, {19.0, -61.0}, {24.0, -61.0}, {29.0, -61.0}, {34.0, -61.0}, {39.0, -61.0}, {-156.0, -1.0}, {-151.0, -1.0}, {-146.0, -1.0}, {-141.0, -1.0}, {-136.0, -1.0}, {-131.0, -1.0}, {-126.0, -1.0}, {-121.0, -1.0}, {-121.0, -6.0}, {-121.0, -11.0}, {-121.0, -16.0}, {-121.0, -21.0}, {-121.0, -26.0}, {-121.0, -31.0}, {-81.0, -1.0}, {-81.0, -6.0}, {-81.0, -11.0}, {-81.0, -16.0}, {-81.0, -21.0}, {-81.0, -26.0}, {-81.0, -31.0}, {-76.0, -31.0}, {-71.0, -31.0}, {-66.0, -31.0}, {-61.0, -31.0}, {-56.0, -31.0}, {-51.0, -31.0}, {-46.0, -31.0}, {-41.0, -31.0}, {-41.0, -36.0}, {-41.0, -41.0}, {-41.0, -46.0}, {-41.0, -51.0}, {-41.0, -56.0}, {-41.0, -61.0}, {-81.0, -61.0}, {-86.0, -61.0}, {-91.0, -61.0}, {-96.0, -61.0}, {-101.0, -61.0}, {-106.0, -61.0}, {-111.0, -61.0}, {-116.0, -61.0}, {-121.0, -61.0}, {-126.0, -61.0}, {-131.0, -61.0}, {-136.0, -61.0}, {-141.0, -61.0}, {-146.0, -61.0}, {-151.0, -61.0}, {-156.0, -61.0}, {-41.0, -91.0}, {-36.0, -91.0}, {-31.0, -91.0}, {-26.0, -91.0}, {-21.0, -91.0}, {-16.0, -91.0}, {-11.0, -91.0}, {-6.0, -91.0}, {-1.0, -91.0}, {4.0, -91.0}, {9.0, -91.0}, {14.0, -91.0}, {19.0, -91.0}, {24.0, -91.0}, {29.0, -91.0}, {34.0, -91.0}, {39.0, -91.0}, {44.0, -91.0}, {49.0, -91.0}, {54.0, -91.0}, {59.0, -91.0}, {64.0, -91.0}, {69.0, -91.0}, {74.0, -91.0}, {79.0, -91.0}, {84.0, -91.0}, {89.0, -91.0}, {94.0, -91.0}, {99.0, -91.0}, {104.0, -91.0}, {109.0, -91.0}, {114.0, -91.0}, {119.0, -91.0}, {119.0, -96.0}, {119.0, -101.0}, {119.0, -106.0}, {119.0, -111.0}, {119.0, -116.0}, {-156.0, 59.0}, {-151.0, 59.0}, {-146.0, 59.0}, {-141.0, 59.0}, {-136.0, 59.0}, {-131.0, 59.0}, {-126.0, 59.0}, {-121.0, 59.0}, {-121.0, 64.0}, {-121.0, 69.0}, {-121.0, 74.0}, {-121.0, 79.0}, {-121.0, 84.0}, {-121.0, 89.0},};

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
        maze(8);
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
        gl.glScaled(40, 30, 0);

        gl.glTranslated(-5, -5, 0);
        gl.glBegin(GL.GL_LINES);
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (south[x][y]) {
                    gl.glVertex2d((x), (y));
                    gl.glVertex2d((x + 1), (y));
                }
                if (north[x][y]) {
                    gl.glVertex2d((x), (y + 1));
                    gl.glVertex2d((x + 1), (y + 1));

                }
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
        int honka2 = 1;


        for (int i = 0; i < unAllowed_points.length; i++) {
            if (buffer_px == unAllowed_points[i][0] && buffer_py == unAllowed_points[i][1]) {
                honka = 0;
            }
            
            if (buffer_px2 == unAllowed_points[i][0] && buffer_py2 == unAllowed_points[i][1]) {
                honka2 = 0;
            }
        }
//        for (int i = 0; i < 1; i++) {
//            {
//                System.out.print(" { " + buffer_px + " , " + buffer_py + '}' + " , ");
//            }
//        }
        
//        letinout(gl, honka,  px, py);
if(honka2==0){            
            buffer_px2=px2;
            buffer_py2=py2; 
}
else{
            px2 =buffer_px2;
            py2 = buffer_py2;
        }
        letinout(gl, honka2, Color.green ,buffer_px2,buffer_py2 , px2, py2);
        
            gl.glColor3f(1.0f, 0.7f, 0.75f);
            
        if (honka == 0) {
            gl.glPushMatrix();
            buffer_px = px;
            buffer_py = py;
            
            gl.glTranslated(px, py, 0);

            double x, y;
            double radius = 5;
            gl.glBegin(GL.GL_POLYGON);
            for (double a = 0; a < three; a += one) {
                x = radius * (Math.cos(a));
                y = radius * (Math.sin(a));
                gl.glVertex2d(x, y);
            }
            gl.glEnd();
            gl.glPopMatrix();
            green = 0.0f;
            red = 1.0f;
            blue = 0.0f;
            counter -= 5;

            playMusic(TakeDamage);
            pla.clip.start();

        } else if(honka==1) {
            gl.glPushMatrix();
            px = buffer_px;
            py = buffer_py;

            gl.glTranslated(px, py, 0);

            double x, y;
            double radius = 5;
            gl.glBegin(GL.GL_POLYGON);
            for (double a = 0; a < three; a += one) {
                x = radius * (Math.cos(a));
                y = radius * (Math.sin(a));
                gl.glVertex2d(x, y);
            }
            gl.glEnd();
            gl.glPopMatrix();
            if(honka2==1){
            green = 0f;
            red = 0f;
            blue = 1f;
            }
        }
          

        gl.glPushMatrix();

        drawCircle(gl, 3, Color.YELLOW, a, 109.0, -106.0);
        drawCircle(gl, 3, Color.YELLOW, c, 59.0, 104.0);
        drawCircle(gl, 3, Color.YELLOW, d, 59.0, -16.0);
        drawCircle(gl, 3, Color.YELLOW, e, -16.0, 14.0);
        drawCircle(gl, 3, Color.YELLOW, f, 139.0, 14.0);

        drawCircle(gl, 3, Color.YELLOW, b, -141.0, -16.0);
        drawCircle(gl, 3, Color.YELLOW, k, 29.0, 104.0);
        drawCircle(gl, 3, Color.YELLOW, l, -71.0, 104.0);
        drawCircle(gl, 3, Color.YELLOW, m, -66.0, -16.0);

        gl.glEnd();
        gl.glPopMatrix();

        if (buffer_px == 109.0 && buffer_py == -106.0 && a == true  ) {

            a = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == -141.0 && buffer_py == -16.0 && b == true) {
            b = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();

        }

        if (buffer_px == 59.0 && buffer_py == 104.0 && c == true) {
            c = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == 59.0 && buffer_py == -16.0 && d == true) {
            d = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == 139.0 && buffer_py == 14.0 && f == true) {
            f = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == -16.0 && buffer_py == 14.0 && e == true) {
            e = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();

        }

        if (buffer_px == 29.0 && buffer_py == 104.0 && k == true) {
            k = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == -71.0 && buffer_py == 104.0 && l == true) {
            l = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == -66.0 && buffer_py == -16.0 && m == true) {
            m = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }
        
        
        
        //*/*/*/*/*/*/*/*/*
        
         if (buffer_px2 == 109.0 && buffer_py2 == -106.0 && a == true  ) {

            a = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px2 == -141.0 && buffer_py2 == -16.0 && b == true) {
            b = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();

        }

        if (buffer_px2 == 59.0 && buffer_py2 == 104.0 && c == true) {
            c = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px2 == 59.0 && buffer_py2 == -16.0 && d == true) {
            d = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px2 == 139.0 && buffer_py2 == 14.0 && f == true) {
            f = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px2 == -16.0 && buffer_py2 == 14.0 && e == true) {
            e = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();

        }

        if (buffer_px2 == 29.0 && buffer_py2 == 104.0 && k == true) {
            k = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px2 == -71.0 && buffer_py2 == 104.0 && l == true) {
            l = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px2 == -66.0 && buffer_py2 == -16.0 && m == true) {
            m = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }
        
        
        
        
        

        //الكوره بتاعت النهاية 
        gl.glPushMatrix();
        gl.glColor3f(1.0f, 0.0f, 1.0f);
        drawStar(gl, 15, true, 139.0, -106, angle += 9);
        gl.glEnd();
        gl.glPopMatrix();
//

        if (buffer_px == 139.0 && buffer_py == -91.0 || buffer_px == 139.0 && buffer_py == -96.0 || buffer_px == 129.0 && buffer_py == -91.0 || buffer_px == 134.0 && buffer_py == -91.0 || buffer_px == 129.0 && buffer_py == -91.0 || buffer_px == 139.0 && buffer_py == -96.0 || buffer_px == 144.0 && buffer_py == -96.0 || buffer_px == 149.0 && buffer_py == -96.0 || buffer_px == 149.0 && buffer_py == -101.0) {

            turnoff();
            //clpos = pla.clip.getMicrosecondPosition();
//            clpos = pla2.clip.getMicrosecondPosition();
            // pla2.clip.stop();           
//            pla.clip.stop();

            if (counter > counter2) {                
                balance();
                playMusic(Winning);
                pla.clip.start();
                JOptionPane.showMessageDialog(null, name + " Is The Winner \n Score is ☺ " + counter + "\n" + name2 + " Losese \n Score is ☺ " + counter2  );
                
            } else {
                balance();
                playMusic(gameover);
                pla.clip.start();

                JOptionPane.showMessageDialog(null, name2 + " Is The Winner \n Score is ☺ " + counter2 + "\n" + name + " Losese \n Score is ☺ " + counter  );

            }

            System.exit(0);

        }
        
        
        if (buffer_px2 == 139.0 && buffer_py2 == -91.0 || buffer_px2 == 139.0 && buffer_py2 == -96.0 || buffer_px2 == 129.0 && buffer_py2 == -91.0 || buffer_px2 == 134.0 && buffer_py2 == -91.0 || buffer_px2 == 129.0 && buffer_py2== -91.0 || buffer_px2 == 139.0 && buffer_py2 == -96.0 || buffer_px2 == 144.0 && buffer_py2 == -96.0 || buffer_px2 == 149.0 && buffer_py2 == -96.0 || buffer_px2 == 149.0 && buffer_py2 == -101.0) {

            turnoff();
            //clpos = pla.clip.getMicrosecondPosition();
//            clpos = pla2.clip.getMicrosecondPosition();
            // pla2.clip.stop();           
//            pla.clip.stop();
            
            if (counter2 > counter) {
                balance();
                playMusic(Winning);
                pla.clip.start();

                JOptionPane.showMessageDialog(null, name2 + " Is The Winner \n Score is ☺ " + counter2 + "\n" + name + " Losese \n Score is ☺ " + counter  );
            } else {
                balance();
                playMusic(gameover);
                pla.clip.start();

                JOptionPane.showMessageDialog(null, name + " Is The Winner \n Score is ☺ " + counter + "\n" + name2 + " Losese \n Score is ☺ " + counter2  );

            }

            System.exit(0);


        }
        

    }// end display method

    void turnoff() {
        clpos = pla.clip.getMicrosecondPosition();
//        clpos = pla2.clip.getMicrosecondPosition();
//        pla2.clip.stop();
        pla.clip.stop();
    }

    void drawStar(GL gl, double r, boolean filled, double x, double y, int angle) {
        gl.glPushMatrix();
        gl.glTranslated(x, y, 0);
        gl.glRotated(angle, 0, 0, 1);
        drawStar(gl, r, r / 2, 5, 90, 2, filled);
        gl.glPopMatrix();
    }

    void drawStar(GL gl, double r1, double r2, double sides, double startAngle, int step, boolean filled) {
        if (filled) {
            gl.glBegin(GL.GL_TRIANGLE_FAN);
        } else {
            gl.glBegin(GL.GL_LINE_LOOP);
        }

        for (double i = startAngle; i <= 360 + startAngle; i += 360.0 / sides) {
            gl.glVertex2d(r2 * Math.cos(Math.toRadians(i - 180.0 / sides)), r2 * Math.sin(Math.toRadians(i - 180.0 / sides)));
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
    
    void letinout (GL gl  ,int ball ,Color c ,double  bffx  , double bffy  ,double posx , double posy ){
        gl.glColor3fv(c.getColorComponents(null), 0);
          if (ball == 0) {
            gl.glPushMatrix();
            bffx = posx;
            bffy = posy;

            gl.glTranslated(posx, posy, 0);

            double x, y;
            double radius = 5;
            gl.glBegin(GL.GL_POLYGON);
            for (double a = 0; a < three; a += one) {
                x = radius * (Math.cos(a));
                y = radius * (Math.sin(a));
                gl.glVertex2d(x, y);
            }
            gl.glEnd();
            gl.glPopMatrix();
            
            green = 0.0f;
            red = 1.0f;
            blue = 0.0f;
            counter2 -= 5;

            playMusic(TakeDamage);
            pla.clip.start();

        }
          else if (ball==1) {
            gl.glPushMatrix();
            posx = bffx;
            posy = bffy;

            gl.glTranslated(posx, posy, 0);

            double x, y;
            double radius = 5;
            gl.glBegin(GL.GL_POLYGON);
            for (double a = 0; a < three; a += one) {
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

    
    }
    
    
    void balance () {
        if(counter<0)
        {
            counter=0;
        
       }
        if(counter2<0)
        {
            counter2=0;
        }
}

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
    }

}
