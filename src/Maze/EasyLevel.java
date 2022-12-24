package Maze;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.swing.JOptionPane;
import java.awt.event.KeyListener;
import javax.media.opengl.GLCanvas;

/**
 *
 * @author lenovo
 */
public class EasyLevel implements GLEventListener {
    GLCanvas gl;
    double px = -146, py = 104;
   public double buffer_px = px;
    public double buffer_py = py;
    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;
    private int n;                 // dimension of maze

    

    String name = JOptionPane.showInputDialog(null, "Enter Name");

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
        true, true, true, false, false, false, false, false, true},
    {
        true, false, false, true, false, true, true, false, true},};

    private boolean[][] south = {{
        //false معناها انها فاضيه
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
{ -156.0 , 119.0} ,  { -151.0 , 119.0} ,  { -146.0 , 119.0} ,  { -141.0 , 119.0} ,  { -136.0 , 119.0} ,  { -131.0 , 119.0} ,  { -126.0 , 119.0} ,  { -121.0 , 119.0} ,  { -116.0 , 119.0} ,  { -111.0 , 119.0} ,  { -106.0 , 119.0} ,  { -101.0 , 119.0} ,  { -96.0 , 119.0} ,  { -91.0 , 119.0} ,  { -86.0 , 119.0} ,  { -81.0 , 119.0} ,  { -76.0 , 119.0} ,  { -71.0 , 119.0} ,  { -66.0 , 119.0} ,  { -61.0 , 119.0} ,  { -56.0 , 119.0} ,  { -51.0 , 119.0} ,  { -46.0 , 119.0} ,  { -41.0 , 119.0} ,  { -36.0 , 119.0} ,  { -31.0 , 119.0} ,  { -26.0 , 119.0} ,  { -21.0 , 119.0} ,  { -16.0 , 119.0} ,  { -11.0 , 119.0} ,  { -6.0 , 119.0} ,  { -1.0 , 119.0} ,  { 4.0 , 119.0} ,  { 9.0 , 119.0} ,  { 14.0 , 119.0} ,  { 19.0 , 119.0} ,  { 24.0 , 119.0} ,  { 29.0 , 119.0} ,  { 34.0 , 119.0} ,  { 39.0 , 119.0} ,  { 44.0 , 119.0} ,  { 49.0 , 119.0} ,  { 54.0 , 119.0} ,  { 59.0 , 119.0} ,  { 64.0 , 119.0} ,  { 69.0 , 119.0} ,  { 74.0 , 119.0} ,  { 79.0 , 119.0} ,  { 84.0 , 119.0} ,  { 89.0 , 119.0} ,  { 94.0 , 119.0} ,  { 99.0 , 119.0} ,  { 104.0 , 119.0} ,  { 109.0 , 119.0} ,  { 114.0 , 119.0} ,  { 119.0 , 119.0} ,  { 124.0 , 119.0} ,  { 129.0 , 119.0} ,  { 134.0 , 119.0} ,  { 139.0 , 119.0} ,  { 144.0 , 119.0} ,  { 149.0 , 119.0} ,  { 154.0 , 119.0} ,  { 159.0 , 119.0} ,  { 164.0 , 119.0} ,
{ 159.0 , 114.0} ,  { 159.0 , 109.0} ,  { 159.0 , 104.0} ,  { 159.0 , 99.0} ,  { 159.0 , 94.0} ,  { 159.0 , 89.0} ,  { 159.0 , 84.0} ,  { 159.0 , 79.0} ,  { 159.0 , 74.0} ,  { 159.0 , 69.0} ,  { 159.0 , 64.0} ,  { 159.0 , 59.0} ,  { 159.0 , 54.0} ,  { 159.0 , 49.0} ,  { 159.0 , 44.0} ,  { 159.0 , 39.0} ,  { 159.0 , 34.0} ,  { 159.0 , 29.0} ,  { 159.0 , 24.0} ,  { 159.0 , 19.0} ,  { 159.0 , 14.0} ,  { 159.0 , 9.0} ,  { 159.0 , 4.0} ,  { 159.0 , -1.0} ,  { 159.0 , -6.0} ,  { 159.0 , -11.0} ,  { 159.0 , -16.0} ,  { 159.0 , -21.0} ,  { 159.0 , -26.0} ,  { 159.0 , -31.0} ,  { 159.0 , -36.0} ,  { 159.0 , -41.0} ,  { 159.0 , -46.0} ,  { 159.0 , -51.0} ,  { 159.0 , -56.0} ,  { 159.0 , -61.0} ,  { 159.0 , -66.0} ,  { 159.0 , -71.0} ,  { 159.0 , -76.0} ,  { 159.0 , -81.0} ,  { 159.0 , -86.0} ,  { 159.0 , -91.0} ,  { 159.0 , -96.0} ,  { 159.0 , -101.0} ,  { 159.0 , -106.0} ,  { 159.0 , -111.0} ,  { 159.0 , -116.0} ,  { 159.0 , -121.0} ,  { 154.0 , -121.0} ,  { 149.0 , -121.0} ,  { 144.0 , -121.0} ,  { 139.0 , -121.0} ,  { 134.0 , -121.0} ,  { 129.0 , -121.0} ,  { 124.0 , -121.0} ,  { 119.0 , -121.0} ,  { 114.0 , -121.0} ,  { 109.0 , -121.0} ,  { 104.0 , -121.0} ,  { 99.0 , -121.0} ,  { 94.0 , -121.0} ,  { 89.0 , -121.0} ,  { 84.0 , -121.0} ,  { 79.0 , -121.0} ,  { 74.0 , -121.0} ,  { 69.0 , -121.0} ,  { 64.0 , -121.0} ,  { 59.0 , -121.0} ,  { 54.0 , -121.0} ,  { 49.0 , -121.0} ,  { 44.0 , -121.0} ,  { 39.0 , -121.0} ,  { 34.0 , -121.0} ,  { 29.0 , -121.0} ,  { 24.0 , -121.0} ,  { 19.0 , -121.0} ,  { 14.0 , -121.0} ,  { 9.0 , -121.0} ,  { 4.0 , -121.0} ,  { -1.0 , -121.0} ,  { -6.0 , -121.0} ,  { -11.0 , -121.0} ,  { -16.0 , -121.0} ,  { -21.0 , -121.0} ,  { -26.0 , -121.0} ,  { -31.0 , -121.0} ,  { -36.0 , -121.0} ,  { -41.0 , -121.0} ,  { -46.0 , -121.0} ,  { -51.0 , -121.0} ,  { -56.0 , -121.0} ,  { -61.0 , -121.0} ,  { -66.0 , -121.0} ,  { -71.0 , -121.0} ,  { -76.0 , -121.0} ,  { -81.0 , -121.0} ,  { -86.0 , -121.0} ,  { -91.0 , -121.0} ,  { -96.0 , -121.0} ,  { -101.0 , -121.0} ,  { -106.0 , -121.0} ,  { -111.0 , -121.0} ,  { -116.0 , -121.0} ,  { -121.0 , -121.0} ,  { -126.0 , -121.0} ,  { -131.0 , -121.0} ,  { -136.0 , -121.0} ,  { -141.0 , -121.0} ,  { -146.0 , -121.0} ,  { -151.0 , -121.0} ,  { -156.0 , -121.0} ,  { -161.0 , -121.0} ,
{ -161.0 , 114.0} ,  { -161.0 , 109.0} ,  { -161.0 , 104.0} ,  { -161.0 , 99.0} ,  { -161.0 , 94.0} ,  { -161.0 , 89.0} ,  { -161.0 , 84.0} ,  { -161.0 , 79.0} ,  { -161.0 , 74.0} ,  { -161.0 , 69.0} ,  { -161.0 , 64.0} ,  { -161.0 , 59.0} ,  { -161.0 , 54.0} ,  { -161.0 , 49.0} ,  { -161.0 , 44.0} ,  { -161.0 , 39.0} ,  { -161.0 , 34.0} ,  { -161.0 , 29.0} ,  { -161.0 , 24.0} ,  { -161.0 , 19.0} ,  { -161.0 , 14.0} ,  { -161.0 , 9.0} ,  { -161.0 , 4.0} ,  { -161.0 , -1.0} ,  { -161.0 , -6.0} ,  { -161.0 , -11.0} ,  { -161.0 , -16.0} ,  { -161.0 , -21.0} ,  { -161.0 , -26.0} ,  { -161.0 , -31.0} ,  { -161.0 , -36.0} ,  { -161.0 , -41.0} ,  { -161.0 , -46.0} ,  { -161.0 , -51.0} ,  { -161.0 , -56.0} ,  { -161.0 , -61.0} ,  { -161.0 , -66.0} ,  { -161.0 , -71.0} ,  { -161.0 , -76.0} ,  { -161.0 , -81.0} ,  { -161.0 , -86.0} ,  { -161.0 , -91.0} ,  { -161.0 , -96.0} ,  { -161.0 , -101.0} ,  { -161.0 , -106.0} ,  { -161.0 , -111.0} ,  { -161.0 , -116.0} ,  { -161.0 , -121.0} ,          
{ -81.0 , 114.0} ,  { -81.0 , 109.0} ,  { -81.0 , 104.0} ,  { -81.0 , 99.0} ,  { -81.0 , 94.0} ,  { -81.0 , 89.0} ,  { -76.0 , 89.0} ,  { -71.0 , 89.0} ,  { -66.0 , 89.0} ,  { -61.0 , 89.0} ,  { -56.0 , 89.0} ,  { -51.0 , 89.0} ,  { -46.0 , 89.0} ,  { -41.0 , 89.0} ,
{ 39.0 , 114.0} ,  { 39.0 , 109.0} ,  { 39.0 , 104.0} ,  { 39.0 , 99.0} ,  { 39.0 , 94.0} ,  { 39.0 , 89.0} ,  { 34.0 , 89.0} ,  { 29.0 , 89.0} ,  { 24.0 , 89.0} ,  { 19.0 , 89.0} ,  { 14.0 , 89.0} ,  { 9.0 , 89.0} ,  { 4.0 , 89.0} ,
{ 39.0 , 84.0} ,  { 39.0 , 79.0} ,  { 39.0 , 74.0} ,  { 39.0 , 69.0} ,  { 39.0 , 64.0} ,  { 39.0 , 59.0} ,  { 44.0 , 59.0} ,  { 49.0 , 59.0} ,  { 54.0 , 59.0} ,  { 59.0 , 59.0} ,  { 64.0 , 59.0} ,  { 69.0 , 59.0} ,  { 74.0 , 59.0} ,  { 79.0 , 59.0} ,  { 79.0 , 54.0} ,  { 79.0 , 49.0} ,  { 79.0 , 44.0} ,  { 79.0 , 39.0} ,  { 79.0 , 34.0} ,  { 79.0 , 29.0} , { 79.0 , 114.0} ,  { 79.0 , 109.0} ,  { 79.0 , 104.0} ,  { 79.0 , 99.0} ,  { 79.0 , 94.0} ,  { 79.0 , 89.0} ,   
{ 154.0 , 59.0} ,  { 149.0 , 59.0} ,  { 144.0 , 59.0} ,  { 139.0 , 59.0} ,  { 134.0 , 59.0} ,  { 129.0 , 59.0} ,  { 124.0 , 59.0} ,  { 119.0 , 59.0} ,  { 119.0 , 64.0} ,  { 119.0 , 69.0} ,  { 119.0 , 74.0} ,  { 119.0 , 79.0} ,  { 119.0 , 84.0} ,  { 119.0 , 89.0} ,
{ 154.0 , 29.0} ,  { 149.0 , 29.0} ,  { 144.0 , 29.0} ,  { 139.0 , 29.0} ,  { 134.0 , 29.0} ,  { 129.0 , 29.0} ,  { 124.0 , 29.0} ,  { 119.0 , 29.0} ,  { 119.0 , 24.0} ,  { 119.0 , 19.0} ,  { 119.0 , 14.0} ,  { 119.0 , 9.0} ,  { 119.0 , 4.0} ,  { 119.0 , -1.0} , 
{ 79.0 , -1.0} ,  { 74.0 , -1.0} ,  { 69.0 , -1.0} ,  { 64.0 , -1.0} ,  { 59.0 , -1.0} ,  { 54.0 , -1.0} ,  { 49.0 , -1.0} ,  { 44.0 , -1.0} ,  { 39.0 , -1.0} ,  { 39.0 , -6.0} ,  { 39.0 , -11.0} ,  { 39.0 , -16.0} ,  { 39.0 , -21.0} ,  { 39.0 , -26.0} ,  { 39.0 , -31.0} , 
{ 154.0 , -31.0} ,  { 149.0 , -31.0} ,  { 144.0 , -31.0} ,  { 139.0 , -31.0} ,  { 134.0 , -31.0} ,  { 129.0 , -31.0} ,  { 124.0 , -31.0} ,  { 119.0 , -31.0} ,  { 119.0 , -36.0} ,  { 119.0 , -41.0} ,  { 119.0 , -46.0} ,  { 119.0 , -51.0} ,  { 119.0 , -56.0} ,  { 119.0 , -61.0} ,  { 114.0 , -61.0} ,  { 109.0 , -61.0} ,  { 104.0 , -61.0} ,  { 99.0 , -61.0} ,  { 94.0 , -61.0} ,  { 89.0 , -61.0} ,  { 84.0 , -61.0} ,  { 79.0 , -61.0} ,
{ -121.0 , 29.0} ,  { -116.0 , 29.0} ,  { -111.0 , 29.0} ,  { -106.0 , 29.0} ,  { -101.0 , 29.0} ,  { -96.0 , 29.0} ,  { -91.0 , 29.0} ,  { -86.0 , 29.0} ,  { -81.0 , 29.0} ,  { -76.0 , 29.0} ,  { -71.0 , 29.0} ,  { -66.0 , 29.0} ,  { -61.0 , 29.0} ,  { -56.0 , 29.0} ,  { -51.0 , 29.0} ,  { -46.0 , 29.0} ,  { -41.0 , 29.0} ,  { -36.0 , 29.0} ,  { -31.0 , 29.0} ,  { -26.0 , 29.0} ,  { -21.0 , 29.0} ,  { -16.0 , 29.0} ,  { -11.0 , 29.0} ,  { -6.0 , 29.0} ,  { -1.0 , 29.0} ,  { -1.0 , 24.0} ,  { -1.0 , 19.0} ,  { -1.0 , 14.0} ,  { -1.0 , 9.0} ,  { -1.0 , 4.0} ,  { -1.0 , -1.0} ,  { -1.0 , -6.0} ,  { -1.0 , -11.0} ,  { -1.0 , -16.0} ,  { -1.0 , -21.0} ,  { -1.0 , -26.0} ,  { -1.0 , -31.0} ,  { -1.0 , -36.0} ,  { -1.0 , -41.0} ,  { -1.0 , -46.0} ,  { -1.0 , -51.0} ,  { -1.0 , -56.0} ,  { -1.0 , -61.0} ,  { 4.0 , -61.0} ,  { 9.0 , -61.0} ,  { 14.0 , -61.0} ,  { 19.0 , -61.0} ,  { 24.0 , -61.0} ,  { 29.0 , -61.0} ,  { 34.0 , -61.0} ,  { 39.0 , -61.0} ,     { -156.0 , -1.0} ,  { -151.0 , -1.0} ,  { -146.0 , -1.0} ,  { -141.0 , -1.0} ,  { -136.0 , -1.0} ,  { -131.0 , -1.0} ,  { -126.0 , -1.0} ,  { -121.0 , -1.0} ,  { -121.0 , -6.0} ,  { -121.0 , -11.0} ,  { -121.0 , -16.0} ,  { -121.0 , -21.0} ,  { -121.0 , -26.0} ,  { -121.0 , -31.0} , 
{ -81.0 , -1.0} ,  { -81.0 , -6.0} ,  { -81.0 , -11.0} ,  { -81.0 , -16.0} ,  { -81.0 , -21.0} ,  { -81.0 , -26.0} ,  { -81.0 , -31.0} ,  { -76.0 , -31.0} ,  { -71.0 , -31.0} ,  { -66.0 , -31.0} ,  { -61.0 , -31.0} ,  { -56.0 , -31.0} ,  { -51.0 , -31.0} ,  { -46.0 , -31.0} ,  { -41.0 , -31.0} ,  { -41.0 , -36.0} ,  { -41.0 , -41.0} ,  { -41.0 , -46.0} ,  { -41.0 , -51.0} ,  { -41.0 , -56.0} ,  { -41.0 , -61.0} ,{ -81.0 , -61.0} ,  { -86.0 , -61.0} ,  { -91.0 , -61.0} ,  { -96.0 , -61.0} ,  { -101.0 , -61.0} ,  { -106.0 , -61.0} ,  { -111.0 , -61.0} ,  { -116.0 , -61.0} ,  { -121.0 , -61.0} ,  { -126.0 , -61.0} ,  { -131.0 , -61.0} ,  { -136.0 , -61.0} ,  { -141.0 , -61.0} ,  { -146.0 , -61.0} ,  { -151.0 , -61.0} ,  { -156.0 , -61.0} ,
{ -41.0 , -91.0} ,  { -36.0 , -91.0} ,  { -31.0 , -91.0} ,  { -26.0 , -91.0} ,  { -21.0 , -91.0} ,  { -16.0 , -91.0} ,  { -11.0 , -91.0} ,  { -6.0 , -91.0} ,  { -1.0 , -91.0} ,  { 4.0 , -91.0} ,  { 9.0 , -91.0} ,  { 14.0 , -91.0} ,  { 19.0 , -91.0} ,  { 24.0 , -91.0} ,  { 29.0 , -91.0} ,  { 34.0 , -91.0} ,  { 39.0 , -91.0} ,  { 44.0 , -91.0} ,  { 49.0 , -91.0} ,  { 54.0 , -91.0} ,  { 59.0 , -91.0} ,  { 64.0 , -91.0} ,  { 69.0 , -91.0} ,  { 74.0 , -91.0} ,  { 79.0 , -91.0} ,  { 84.0 , -91.0} ,  { 89.0 , -91.0} ,  { 94.0 , -91.0} ,  { 99.0 , -91.0} ,  { 104.0 , -91.0} ,  { 109.0 , -91.0} ,  { 114.0 , -91.0} ,  { 119.0 , -91.0} ,  { 119.0 , -96.0} ,  { 119.0 , -101.0} ,  { 119.0 , -106.0} ,  { 119.0 , -111.0} ,  { 119.0 , -116.0} ,  
    };


    public void maze(int n) {
        this.n = n;
        // init_maze();
        //generate();
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
//                    arr[ref][0] = (50*x)+3 ;
//                    arr[ref][1] = (40*y)+3;
//                    ref++;
//                    arr[ref][0] = 50*(x+1)+3;
//                    arr[ref][1] = 40*y+3;
//                    ref++;
//
                }
                if (north[x][y]) {
                    gl.glVertex2d((x), (y + 1));
                    gl.glVertex2d((x + 1), (y + 1));
//
//                    arr[ref][0] = (50*x)+3 ;
//                    arr[ref][1] = (40*(y+1))+3;
//                    ref++;
//                    arr[ref][0] = 50*(x+1)+3;
//                    arr[ref][1] = 40*(y+1)+3;
//                    ref++;

                }
                if (west[x][y]) {
                    gl.glVertex2d((x), (y));
                    gl.glVertex2d((x), (y + 1));
//
//                    arr[ref][0] = (50*x)+3 ;
//                    arr[ref][1] = (40*y)+3;
//                    ref++;
//                    arr[ref][0] = 50*(x)+3;
//                    arr[ref][1] = 40*(y+1)+3;
//                    ref++;
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
//
//        gl.glPointSize(13.0f);

        int honka = 1;
//         red = 0.5f;
//         green = 0.0f;
//         blue = 0.5f;
        gl.glColor3f(.9f, .9f, 0.0f);

        for (int i = 0; i < unAllowed_points.length; i++) {
            if (buffer_px == unAllowed_points[i][0] && buffer_py == unAllowed_points[i][1]) {
//                buffer_px = px;
//                buffer_py = py;
                honka = 0;
                
            }

        }
//        for (int i = 0; i < 1; i++) {
//            {
//                System.out.print(" { " + buffer_px + " , " + buffer_py + '}' + " , ");
//
////                buffer_px = px;
////                buffer_py = py;
////                honka = 1;
//            }
//        }
        //اول اما يلاقي الحاجز يوقف علطول 
        if (honka == 0) {

            //System.out.println("honka = 0");
            gl.glPushMatrix();
            buffer_px = px;
            buffer_py = py;

//            System.out.println(" { " + px + "," + py + "},");
            gl.glTranslated(px, py, 0);
            //        gl.glBegin(GL.GL_POINTS);
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

        } else {
            //System.out.println("honka = 1");
            gl.glPushMatrix();
            px = buffer_px;
            py = buffer_py;

//            System.out.println(" { " + px + "," + py + "},");
            gl.glTranslated(px, py, 0);
            //        gl.glBegin(GL.GL_POINTS);

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

            green = 0.5f;
            red = 0.0f;

        }
        honka = 1;

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
//
        if (px == 139.0 && py == -91.0 || px == 139.0 && py == -96.0 ||  px == 129.0 && py == -91.0 ||  px == 134.0 && py == -91.0  || px == 129.0 && py == -91.0 || px == 139.0 && py == -96.0 || px == 144.0 && py == -96.0  || px == 149.0 && py == -96.0 || px == 149.0 && py == -101.0   ) 
    {
            blue = 1.0f;
            green = 0.0f;
            red = 0.0f;
            if (blue == 1.0f) {
                JOptionPane.showMessageDialog(null, "Good Job ♥ " + name);

                System.exit(0);
            }

  }
    }// end display method
    
    
    
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
    }

    
}
