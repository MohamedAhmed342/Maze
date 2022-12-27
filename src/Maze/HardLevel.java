/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maze;

/**
 *
 * @author Delta Store
 */

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
    double px = -146, py = 104;
   public double buffer_px = px;
    public double buffer_py = py;
    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;
    private int n;                 // dimension of maze
    int angle = -10;
    int counter=0;                                                                      
 boolean a=true , b=true , c=true , d =true, e=true ,f=true ,g=true ,k=true ,l=true ,m= true ;   // take coins or not
 String filepath="D:\\Projects\\graphics\\Maze\\src\\Maze\\music\\Arcade-background-music-retro-style.wav";

 
 
    static Sounds pla = Sounds.getInstance();
    static long clpos;
    static boolean isp = true;
    static boolean isL = false;

    

    String name = JOptionPane.showInputDialog(null, "Enter Name");

    //  int maze_level = 2;
    // is there a wall to north of cell i, j

    
    
        private boolean[][] north = {{
        true, true, true, true, true, true, true,  true, true ,true ,true ,true ,true ,true ,true},
    {
        true, true, false,false,true, false,false, false,false,true, false,false,false, false, true},
    {
        true, false,true, true, true, true, false, false,true, false,false,false,false, false, true},
    {
        true, false,true, false,true, true, true,  true, false,true, false,false,false, false, true},
    {
        true, false,true, false,true, false,true,  false,true, true, false,true, true, false, true},
    {
        true, false,true, true, false,true, false, true, false,false,true, false,true, false, true},
    {
        true, false,true, false,true, false,false, true, false,true, false,true, true, false, true},
    {
        true, false,false,true, false,false,false, false,true, true, false,true, false, true, false},
    {
        true, false,false,false,true, true, false, false,true, true, true, true, false, true, true},
            {
        true, false,false,true, true, false,true,  false,true, false,true, true, true, false, true},
    {
        true, false,true, false,true, false,false, false,false,true, false,true, false,false, true},
    {
        true, true, true, false,true, false,true,  false,true, false,true, false,false,true, true},
    {
        true, true, false,true, false,true, false, true, true, true, false,true, false,true, true},
    {
        true, false,false,true,false, false, false, true,false, true,true, false,true, true, true},
    {
        true, false,false,false,false,false, false, false,true, false,true,false,false,false, true},};

    private boolean[][] south = {{
        true, true, true,  true,  true,  true,  true,  true, true, true, true,  true, true, true, true},
    {
        true, true, true,  false, false, false, false, false,false,false,false, false, false, false, false},
    {
        true, true, false, false, false, true,  true,  false,false,true, false, false, false, false, false},
    {
        true, true, false, true,  false, true,  true,  true, true, false,false, false, false, false, false},
    {
        true, true, false, false, false, true,  false, false,false,true, true,  false, true, true, false},
    {
        true, true, false, false, false, false, true,  false,true, false,false, true, false, true, false},
    {
        true, true, false, false, false, false, false, false,true, false,true,  false, true, true, false},
    {
        true, true, false, false, false, false, false, false,false,true, true,  false, true, false, true},
    {
        true, false,false, false, false, true,  true,  false,false,true, true,  true, true, false, true},
            {
        true, true, false, false, false, true,  false, true, false,true, false, true, true, true, false},
    {
        true, true, false, false, false, true,  false, false,false,false,true,  false, true, false, false},
    {
        true, true, true,  false, false, false, false, true, false,true, false, true, false, false, true},
    {
        true, true, false, false, true,  false, true,  false,true, true, true,  false, true, false, true},
    {
        true, true, false, false, false, false, false, false,true, false,true,  true, false, true, true},
    {
        true, true, false, false, false, false, false, false,false, true, false,true, false, false, false},};

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
 { 4.0 , 99.0} ,  { 4.0 , 104.0} ,  { 4.0 , 104.0} ,  { 9.0 , 104.0} ,  { 14.0 , 104.0} ,  { 19.0 , 104.0} ,  { 24.0 , 104.0} ,  { 29.0 , 104.0} ,  { 34.0 , 104.0} ,  { 39.0 , 104.0} ,  { 44.0 , 104.0} ,  { 49.0 , 104.0} ,  { 54.0 , 104.0} ,  { 59.0 , 104.0} ,  { 64.0 , 104.0} ,  { 69.0 , 104.0} ,  { 74.0 , 104.0} ,  { 79.0 , 104.0} ,  { 84.0 , 104.0} ,  { 89.0 , 104.0} ,  { 94.0 , 104.0} ,  { 99.0 , 104.0} ,  { 104.0 , 104.0} ,  { 109.0 , 104.0} ,  { 114.0 , 104.0} ,  { 119.0 , 104.0} ,  { 124.0 , 104.0} ,  { 129.0 , 104.0} ,  { 134.0 , 104.0} ,  { 139.0 , 104.0} ,  { 144.0 , 104.0} ,  { 149.0 , 104.0} ,  { 154.0 , 104.0} ,  { 159.0 , 104.0} ,  { 164.0 , 104.0} ,  { 169.0 , 104.0} ,  { 174.0 , 104.0} ,  { 174.0 , 99.0} ,  { 174.0 , 94.0} ,  { 174.0 , 89.0} ,  { 174.0 , 84.0} ,  { 174.0 , 79.0} ,  { 174.0 , 74.0} ,  { 174.0 , 69.0} ,  { 174.0 , 64.0} ,  { 174.0 , 59.0} ,  { 174.0 , 54.0} ,  { 174.0 , 49.0} ,  { 174.0 , 44.0} ,  { 174.0 , 39.0} ,  { 174.0 , 34.0} ,  { 174.0 , 29.0} ,  { 174.0 , 24.0} ,  { 174.0 , 19.0} ,  { 174.0 , 14.0} ,  { 174.0 , 9.0} ,  { 174.0 , 4.0} ,  { 174.0 , -1.0} ,  { 174.0 , -6.0} ,  { 174.0 , -11.0} ,  { 174.0 , -16.0} ,  { 174.0 , -26.0} ,  { 174.0 , -31.0} ,  { 174.0 , -36.0} ,  { 174.0 , -41.0} ,  { 174.0 , -46.0} ,  { 174.0 , -51.0} ,  { 174.0 , -56.0} ,  { 174.0 , -61.0} ,  { 174.0 , -66.0} ,  { 174.0 , -71.0} ,  { 174.0 , -76.0} ,  { 174.0 , -81.0} ,  { 174.0 , -86.0} ,  { 174.0 , -91.0} ,  { 174.0 , -96.0} ,  { 174.0 , -101.0} ,  { 174.0 , -106.0} ,  { 169.0 , -106.0} ,  { 164.0 , -106.0} ,  { 159.0 , -106.0} ,  { 154.0 , -106.0} ,  { 149.0 , -106.0} ,  { 144.0 , -106.0} ,  { 139.0 , -106.0} ,  { 134.0 , -106.0} ,  { 129.0 , -106.0} ,  { 124.0 , -106.0} ,  { 119.0 , -106.0} ,  { 114.0 , -106.0} ,  { 109.0 , -106.0} ,  { 104.0 , -106.0} ,  { 99.0 , -106.0} ,  { 94.0 , -106.0} ,  { 89.0 , -106.0} ,  { 84.0 , -106.0} ,  { 79.0 , -106.0} ,  { 74.0 , -106.0} ,  { 69.0 , -106.0} ,  { 64.0 , -106.0} ,  { 59.0 , -106.0} ,  { 54.0 , -106.0} ,  { 49.0 , -106.0} ,  { 44.0 , -106.0} ,  { 39.0 , -106.0} ,  { 34.0 , -106.0} ,  { 29.0 , -106.0} ,  { 24.0 , -106.0} ,  { 24.0 , -101.0} ,  { 24.0 , -96.0} ,  { 24.0 , -91.0} ,  { 24.0 , -86.0} ,  { 24.0 , -81.0} ,  { 24.0 , -76.0} ,  { 24.0 , -71.0} ,  { 24.0 , -66.0} ,  { 24.0 , -61.0} ,  { 29.0 , -61.0} ,  { 34.0 , -61.0} ,  { 39.0 , -61.0} ,  { 44.0 , -61.0} ,  { 49.0 , -61.0} ,
  { 154.0 , 89.0} ,  { 149.0 , 89.0} ,  { 144.0 , 89.0} ,  { 139.0 , 89.0} ,  { 134.0 , 89.0} ,  { 129.0 , 89.0} ,  { 124.0 , 89.0} ,  { 119.0 , 89.0} ,  { 114.0 , 89.0} ,  { 109.0 , 89.0} ,  { 104.0 , 89.0} ,  { 99.0 , 89.0} ,  { 94.0 , 89.0} ,  { 89.0 , 89.0} ,  { 84.0 , 89.0} ,  { 79.0 , 89.0} ,  { 74.0 , 89.0} ,  { 74.0 , 84.0} ,  { 74.0 , 79.0} ,  { 74.0 , 74.0} ,  { 74.0 , 69.0} ,  { 74.0 , 64.0} ,  { 74.0 , 59.0} ,  { 74.0 , 54.0} ,  { 74.0 , 49.0} ,  { 74.0 , 44.0} ,  { 79.0 , 44.0} ,  { 84.0 , 44.0} ,  { 89.0 , 44.0} ,  { 94.0 , 44.0} ,  { 99.0 , 44.0} ,  { 99.0 , 39.0} ,  { 99.0 , 34.0} ,  { 99.0 , 29.0} ,  { 104.0 , 29.0} ,  { 109.0 , 29.0} ,  { 114.0 , 29.0} ,  { 119.0 , 29.0} ,  { 124.0 , 29.0} ,  { 129.0 , 29.0} ,  { 134.0 , 29.0} ,  { 139.0 , 29.0} ,  { 144.0 , 29.0} ,  { 149.0 , 29.0} ,  { 149.0 , 24.0} ,  { 149.0 , 19.0} ,  { 149.0 , 14.0} ,  { 154.0 , 14.0} ,  { 159.0 , 14.0} ,  { 164.0 , 14.0} ,  { 169.0 , 14.0} ,  { 174.0 , 14.0} ,  { 174.0 , 14.0} , 
   { 179.0 , 44.0} ,  { 174.0 , 44.0} ,  { 169.0 , 44.0} ,  { 164.0 , 44.0} ,  { 159.0 , 44.0} ,  { 154.0 , 44.0} ,  { 149.0 , 44.0} ,  { 144.0 , 44.0} ,  { 139.0 , 44.0} ,  { 134.0 , 44.0} ,  { 129.0 , 44.0} ,  { 124.0 , 44.0} ,  { 124.0 , 49.0} ,  { 124.0 , 54.0} ,  { 124.0 , 59.0} ,  { 119.0 , 59.0} ,  { 114.0 , 59.0} ,  { 109.0 , 59.0} ,  { 104.0 , 59.0} ,  { 99.0 , 59.0} ,  { 99.0 , 64.0} ,  { 99.0 , 69.0} ,  { 99.0 , 74.0} ,   
  { 124.0 , 89.0} ,  { 124.0 , 84.0} ,  { 124.0 , 79.0} ,  { 124.0 , 74.0} ,  { 129.0 , 74.0} ,  { 134.0 , 74.0} ,  { 139.0 , 74.0} ,  { 144.0 , 74.0} ,  { 149.0 , 74.0} ,  { 149.0 , 69.0} ,  { 149.0 , 64.0} ,  { 149.0 , 59.0} ,   
  { -6.0 , 44.0} ,  { -1.0 , 44.0} ,  { 4.0 , 44.0} ,  { 9.0 , 44.0} ,  { 14.0 , 44.0} ,  { 19.0 , 44.0} ,  { 24.0 , 44.0} ,  { 29.0 , 44.0} ,  { 34.0 , 44.0} ,  { 39.0 , 44.0} ,  { 44.0 , 44.0} ,  { 49.0 , 44.0} ,  { 49.0 , 39.0} ,  { 49.0 , 34.0} ,  { 49.0 , 29.0} ,  { 54.0 , 29.0} ,  { 59.0 , 29.0} ,  { 64.0 , 29.0} ,  { 69.0 , 29.0} ,  { 74.0 , 29.0} ,  { 74.0 , 24.0} ,  { 74.0 , 19.0} ,  { 74.0 , 14.0} ,  { 79.0 , 14.0} ,  { 84.0 , 14.0} ,  { 89.0 , 14.0} ,  { 94.0 , 14.0} ,  { 99.0 , 14.0} ,  { 104.0 , 14.0} ,  { 109.0 , 14.0} ,  { 114.0 , 14.0} ,  { 119.0 , 14.0} ,  { 124.0 , 14.0} ,  { 124.0 , 9.0} ,  { 124.0 , 4.0} ,  { 124.0 , -1.0} ,  { 124.0 , -6.0} ,  { 124.0 , -11.0} ,  { 124.0 , -16.0} , 
  { 124.0 , -46.0} ,  { 124.0 , -41.0} ,  { 124.0 , -36.0} ,  { 124.0 , -31.0} ,  { 119.0 , -31.0} ,  { 114.0 , -31.0} ,  { 109.0 , -31.0} ,  { 104.0 , -31.0} ,  { 99.0 , -31.0} ,  { 99.0 , -26.0} ,  { 99.0 , -21.0} ,  { 99.0 , -16.0} ,  { 94.0 , -16.0} ,  { 89.0 , -16.0} ,  { 84.0 , -16.0} ,  { 79.0 , -16.0} ,  { 74.0 , -16.0} ,  { 74.0 , -11.0} ,  { 74.0 , -6.0} ,  { 74.0 , -1.0} ,  { 74.0 , 4.0} ,  { 74.0 , 9.0} ,  { 74.0 , 14.0} ,   
  { 94.0 , -1.0} ,  { 99.0 , -1.0} ,  { 104.0 , -1.0} ,  { 109.0 , -1.0} ,  { 114.0 , -1.0} ,  { 119.0 , -1.0} ,  { 124.0 , -1.0} ,  { 129.0 , -1.0} ,  { 134.0 , -1.0} ,  { 139.0 , -1.0} ,  { 144.0 , -1.0} ,  { 149.0 , -1.0} ,  { 149.0 , -6.0} ,  { 149.0 , -11.0} ,  { 149.0 , -16.0} ,  { 149.0 , -21.0} ,  { 149.0 , -26.0} ,  { 149.0 , -31.0} ,  { 149.0 , -36.0} ,  { 149.0 , -41.0} ,  { 149.0 , -46.0} ,  { 149.0 , -51.0} ,  { 149.0 , -56.0} ,  { 149.0 , -61.0} ,  { 149.0 , -66.0} ,  { 149.0 , -71.0} ,  { 149.0 , -76.0} ,  { 149.0 , -81.0} ,  { 149.0 , -86.0} ,  { 149.0 , -91.0} ,  { 149.0 , -96.0} , 
  { -1.0 , -31.0} ,  { 4.0 , -31.0} ,  { 9.0 , -31.0} ,  { 14.0 , -31.0} ,  { 19.0 , -31.0} ,  { 24.0 , -31.0} ,  { 24.0 , -36.0} ,  { 24.0 , -41.0} ,  { 24.0 , -46.0} ,  { 29.0 , -46.0} ,  { 34.0 , -46.0} ,  { 39.0 , -46.0} ,  { 44.0 , -46.0} ,  { 49.0 , -46.0} ,  { 54.0 , -46.0} ,  { 59.0 , -46.0} ,  { 64.0 , -46.0} ,  { 69.0 , -46.0} ,  { 74.0 , -46.0} ,  { 79.0 , -46.0} ,  { 84.0 , -46.0} ,  { 89.0 , -46.0} ,  { 94.0 , -46.0} ,  { 99.0 , -46.0} ,  { 104.0 , -46.0},  { 74.0 , -31.0} ,  { 74.0 , -36.0} ,  { 74.0 , -41.0} ,  { 74.0 , -46.0} ,  { 74.0 , -51.0} ,  { 74.0 , -56.0} ,  { 74.0 , -61.0} ,  { 74.0 , -66.0} ,  { 74.0 , -71.0} ,  { 74.0 , -76.0} , { 44.0 , 99.0} ,  { 49.0 , 99.0} ,  { 49.0 , 94.0} ,  { 49.0 , 89.0} ,  { 49.0 , 84.0} ,  { 49.0 , 79.0} ,  { 49.0 , 74.0} ,  { 44.0 , 74.0} ,  { 39.0 , 74.0} ,  { 34.0 , 74.0} ,  { 29.0 , 74.0} ,  { 24.0 , 74.0} ,   
   { -76.0 , 44.0} ,  { -71.0 , 44.0} ,  { -66.0 , 44.0} ,  { -61.0 , 44.0} ,  { -56.0 , 44.0} ,  { -51.0 , 44.0} ,  { -51.0 , 49.0} ,  { -51.0 , 54.0} ,  { -51.0 , 59.0} ,  { -46.0 , 59.0} ,  { -41.0 , 59.0} ,  { -36.0 , 59.0} ,  { -31.0 , 59.0} ,  { -26.0 , 59.0} ,  { -21.0 , 59.0} ,  { -16.0 , 59.0} ,  { -11.0 , 59.0} ,  { -6.0 , 59.0} ,  { -1.0 , 59.0} ,  { 4.0 , 59.0} ,  { 9.0 , 59.0} ,  { 14.0 , 59.0} ,  { 19.0 , 59.0} ,  { 24.0 , 59.0} ,  { 29.0 , 59.0} ,  { 34.0 , 59.0} ,  { 39.0 , 59.0} ,  { 44.0 , 59.0} ,  { 49.0 , 59.0} ,  { 54.0 , 59.0} ,  { 59.0 , 59.0} ,  { 64.0 , 59.0} ,  { 69.0 , 59.0} ,  { 74.0 , 59.0} ,  { 74.0 , 59.0} , 
   { -26.0 , 14.0} ,  { -21.0 , 14.0} ,  { -16.0 , 14.0} ,  { -11.0 , 14.0} ,  { -6.0 , 14.0} ,  { -1.0 , 14.0} ,  { 4.0 , 14.0} ,  { 9.0 , 14.0} ,  { 14.0 , 14.0} ,  { 19.0 , 14.0} ,  { 24.0 , 14.0} ,  { 29.0 , 14.0} ,  { 34.0 , 14.0} ,  { 39.0 , 14.0} ,  { 44.0 , 14.0} ,  { 49.0 , 14.0} ,  { 49.0 , 19.0} ,  { 49.0 , 24.0} ,  { 49.0 , 29.0} , { 49.0 , 24.0} ,  { 49.0 , 19.0} ,  { 49.0 , 14.0} ,  { 49.0 , 9.0} ,  { 49.0 , 4.0} ,  { 49.0 , -1.0} , { -1.0 , 19.0} ,  { -1.0 , 14.0} ,  { -1.0 , 9.0} ,  { -1.0 , 4.0} ,  { -1.0 , -1.0} ,  { -1.0 , -6.0} ,  { -1.0 , -11.0} ,  { -1.0 , -16.0} ,   
   { -31.0 , 54.0} ,  { -26.0 , 54.0} ,  { -21.0 , 54.0} ,  { -21.0 , 49.0} ,  { -21.0 , 44.0} ,  { -21.0 , 39.0} ,  { -21.0 , 34.0} ,  { -26.0 , 34.0} ,  { -26.0 , 39.0} ,  { -26.0 , 44.0} ,  { -26.0 , 49.0} ,  { -26.0 , 54.0} ,  { -26.0 , 59.0} ,  { -1.0 , -41.0} ,  { -1.0 , -46.0} ,  { -1.0 , -51.0} ,  { -1.0 , -56.0} ,  { -1.0 , -61.0} ,  { -1.0 , -66.0} ,  { -1.0 , -71.0} ,  { -1.0 , -76.0} ,  { -1.0 , -81.0} ,  { -1.0 , -86.0} ,  { -1.0 , -91.0} ,  { -1.0 , -96.0} ,  { -1.0 , -101.0} ,  { -1.0 , -106.0} , 
 { 69.0 , -71.0} ,  { 74.0 , -71.0} ,  { 69.0 , -76.0} ,  { 64.0 , -76.0} ,  { 59.0 , -76.0} ,  { 54.0 , -76.0} ,  { 49.0 , -76.0} ,  { 49.0 , -81.0} ,  { 49.0 , -86.0} ,  { 49.0 , -91.0} ,   { 24.0 , -1.0} ,  { 24.0 , -6.0} ,  { 24.0 , -11.0} ,  { 24.0 , -16.0} ,  { 24.0 , -21.0} ,  { 24.0 , -26.0} ,  { 24.0 , -31.0} ,   { 49.0 , -31.0} ,  { 49.0 , -26.0} ,  { 49.0 , -21.0} ,  { 49.0 , -16.0} ,  { 44.0 , -16.0} ,  { 39.0 , -16.0} ,  { 34.0 , -16.0} ,  { 29.0 , -16.0} ,  { 24.0 , -16.0} , 
  { 24.0 , 29.0} ,  { 19.0 , 29.0} ,  { 14.0 , 29.0} ,  { 9.0 , 29.0} ,  { 4.0 , 29.0} ,  { -1.0 , 29.0} ,  { -6.0 , 29.0} ,  { -11.0 , 29.0} ,  { -16.0 , 29.0} ,  { -21.0 , 29.0} ,  { -26.0 , 29.0} ,  { -31.0 , 29.0} ,  { -36.0 , 29.0} ,  { -41.0 , 29.0} ,  { -46.0 , 29.0} ,  { -51.0 , 29.0} ,  { -51.0 , 24.0} ,  { -51.0 , 19.0} ,  { -51.0 , 14.0} ,  { -51.0 , 9.0} ,  { -51.0 , 4.0} ,  { -51.0 , -1.0}  ,  { 19.0 , -46.0} ,  { 14.0 , -46.0} ,  { 9.0 , -46.0} ,  { 4.0 , -46.0} ,  { -1.0 , -46.0} , 
   { 144.0 , -61.0} ,  { 144.0 , -66.0} ,  { 144.0 , -61.0} ,  { 139.0 , -61.0} ,  { 134.0 , -61.0} ,  { 129.0 , -61.0} ,  { 124.0 , -61.0} ,  { 119.0 , -61.0} ,  { 114.0 , -61.0} ,  { 109.0 , -61.0} ,  { 104.0 , -61.0} ,  { 99.0 , -61.0} ,  { 99.0 , -66.0} ,  { 99.0 , -71.0} ,  { 99.0 , -76.0} ,  { 94.0 , -76.0} ,  { 89.0 , -76.0} ,  { 84.0 , -76.0} ,  { 79.0 , -76.0} ,  { 74.0 , -76.0} ,  { 74.0 , -76.0} , { -1.0 , 89.0} ,  { -6.0 , 89.0} ,  { -11.0 , 89.0} ,  { -16.0 , 89.0} ,  { -21.0 , 89.0} ,  { -26.0 , 89.0} ,  { -26.0 , 84.0} ,  { -26.0 , 79.0} ,  { -26.0 , 74.0} ,  { -31.0 , 74.0} ,  { -36.0 , 74.0} ,  { -41.0 , 74.0} ,  { -46.0 , 74.0} ,  { -51.0 , 74.0} ,  { -56.0 , 74.0} ,  { -61.0 , 74.0} ,  { -66.0 , 74.0} ,  { -71.0 , 74.0} ,  { -76.0 , 74.0} ,  { -81.0 , 74.0} ,  { -86.0 , 74.0} ,  { -91.0 , 74.0} ,  { -96.0 , 74.0} ,  { -101.0 , 74.0} ,  { -101.0 , 79.0} ,  { -101.0 , 84.0} ,  { -101.0 , 89.0},
 { 29.0 , 89.0}  ,  { 19.0 , 89.0} ,  { 14.0 , 89.0} ,  { 9.0 , 89.0} ,  { 4.0 , 89.0} ,  { -1.0 , 89.0} ,  { -1.0 , 84.0} ,  { -1.0 , 79.0} ,  { -1.0 , 84.0} ,  { -1.0 , 89.0} ,     };

    
    ;
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

        gl.glColor3f(1.0f, 0.7f, 0.75f);
//بتمنعنا ان امشي ع الاماكن اللي مش مسموحلي بيها
        for (int i = 0; i < unAllowed_points.length; i++) {
            if (buffer_px == unAllowed_points[i][0] && buffer_py == unAllowed_points[i][1]) {
                honka = 0;
            }
        }   

        // هفتحها عشان اطبع الاحداثيات
        for (int i = 0; i < 1; i++) {
            {
                System.out.print(" { " + buffer_px + " , " + buffer_py + '}' + " , ");
            }
        }
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
                
                drawCircle(gl, 3, Color.YELLOW, a,114.0 , 9.0);
                drawCircle(gl, 3, Color.YELLOW, c,  164.0 , 24.0);
                drawCircle(gl, 3, Color.YELLOW, d, 9.0 , 69.0);
                drawCircle(gl, 3, Color.YELLOW, e , 39.0 , -36.0);
                drawCircle(gl, 3, Color.YELLOW, f , 139.0 , -81.0 );
                drawCircle(gl, 3, Color.YELLOW, b, 39.0 , 34.0);
                drawCircle(gl, 3, Color.YELLOW, k, 139.0 , 84.0 );
                
//                drawCircle(gl, 3, Color.YELLOW, l , -71.0 , 104.0 );
//                drawCircle(gl, 3, Color.YELLOW, m, -66.0 , -16.0);



        gl.glEnd();
        gl.glPopMatrix();
        
            if (buffer_px == 114.0 && buffer_py ==  9.0 && a==true ) {
                
                  a= false ;
                  counter+=10;
            }
            
            if (buffer_px == 39.0 && buffer_py == 34.0 && b==true ) {
                  b=false ;
                  counter+=10;

            }
            
            if (buffer_px == 164.0 && buffer_py == 24.0 && c==true ) {
                  c=false ;
                  counter+=10;
                  
            }
            
            if (buffer_px == 9.0 && buffer_py == 69.0 && d==true  ) {
                  d=false ;
                  counter+=10;
            }
            
            if (buffer_px == 139.0 && buffer_py ==  -81.0 && f==true  ) {
                  f=false ;
                  counter+=10;
            }
            
            if (buffer_px == 39.0&& buffer_py == -36.0 && e==true  ) {
                  e=false ;
                  counter+=10;
            }
            
            if (buffer_px ==139.0  && buffer_py == 84.0 && k==true  ) {
                  k=false ;
                  counter+=10;
            }
            
            if (buffer_px == -71.0  && buffer_py == 104.0 && l==true  ) {
                  l=false ;
                  counter+=10;
            }
            
            if (buffer_px == -66.0  && buffer_py == -16.0 && m==true  ) {
                  m=false ;
                  counter+=10;
            }
            

    //النجمة بتاعت النهاية 
        gl.glPushMatrix();
        gl.glColor3f(1.0f, 0.0f, 1.0f);
        // مكان النجمة
        drawStar(gl, 10, true, 13.0 , -97.0, angle+=9);   
        gl.glEnd();
        gl.glPopMatrix();  
//


// احداثيات الفوز
        if (px == 14.0 && py == -91.0 || px ==9.0 && py == -91.0 ||  px == 9.0 && py == -96.0 ||  px == 14.0 && py == -96.0  || px == 14.0 && py == -101.0 || px == 19.0 && py == -101.0 || px == 14.0 && py == -101.0  || px == 9.0 && py == -101.0 || px == 14.0 && py == -86.0   ) 
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
        
//ميثود لو كلت الكورة بتكون فاضية
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

