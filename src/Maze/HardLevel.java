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
    final double one = (Math.PI / 180);
    final double three = 2 * Math.PI;
    private int n;                 // dimension of maze
    int angle = -10;
    int counter = 0;
    boolean aa = true, bb = true, cc = true, dd = true, ee = true, ff = true;
    boolean a=true , b=true , c=true , d =true, e=true ,f=true ,g=true ,k=true ,l=true ,m= true ; // take coins or not
    String filepath = "E:\\New folder\\Maze2\\Maze\\src\\Maze\\music\\Arcade-background-music-retro-style.wav";
    String coins = "E:\\New folder\\Maze2\\Maze\\src\\Maze\\music\\src_Maze_music_coins.wav";
    String gameover = "E:\\New folder\\Maze2\\Maze\\src\\Maze\\music\\src_Maze_music_gameover.wav";
    String Winning = "E:\\New folder\\Maze2\\Maze\\src\\Maze\\music\\src_Maze_music_Winning.wav";
    String TakeDamage = "E:\\New folder\\Maze2\\Maze\\src\\Maze\\music\\src_Maze_music_TakeDamage.wav";
    static Sounds pla = Sounds.getInstance();
    static long clpos;
    static boolean isp = true;
    static boolean isL = false;

    String name = JOptionPane.showInputDialog(null, "Enter Name");


    private boolean[][] north = {{
        true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, true, false, false, true, false, false, false, false, true, false, false, false, false, true},
    {
        true, false, true, true, true, true, false, false, true, false, false, false, false, false, true},
    {
        true, false, true, false, true, true, true, true, false, true, false, false, false, false, true},
    {
        true, false, true, false, true, false, true, false, true, true, false, true, true, false, true},
    {
        true, false, true, true, false, true, false, true, false, false, true, false, true, false, true},
    {
        true, false, true, false, true, false, false, true, false, true, false, true, true, false, true},
    {
        true, false, false, true, false, false, false, false, true, true, false, true, false, true, false},
    {
        true, false, false, false, true, true, false, false, true, true, true, true, false, true, true},
    {
        true, false, false, true, true, false, true, false, true, false, true, true, true, false, true},
    {
        true, false, true, false, true, false, false, false, false, true, false, true, false, false, true},
    {
        true, true, true, false, true, false, true, false, true, false, true, false, false, true, true},
    {
        true, true, false, true, false, true, false, true, true, true, false, true, false, true, true},
    {
        true, false, false, true, false, false, false, true, false, true, true, false, true, true, true},
    {
        true, false, false, false, false, false, false, false, true, false, true, false, false, false, true},};

    private boolean[][] south = {{
        true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, true, true, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, true, false, false, false, true, true, false, false, true, false, false, false, false, false},
    {
        true, true, false, true, false, true, true, true, true, false, false, false, false, false, false},
    {
        true, true, false, false, false, true, false, false, false, true, true, false, true, true, false},
    {
        true, true, false, false, false, false, true, false, true, false, false, true, false, true, false},
    {
        true, true, false, false, false, false, false, false, true, false, true, false, true, true, false},
    {
        true, true, false, false, false, false, false, false, false, true, true, false, true, false, true},
    {
        true, false, false, false, false, true, true, false, false, true, true, true, true, false, true},
    {
        true, true, false, false, false, true, false, true, false, true, false, true, true, true, false},
    {
        true, true, false, false, false, true, false, false, false, false, true, false, true, false, false},
    {
        true, true, true, false, false, false, false, true, false, true, false, true, false, false, true},
    {
        true, true, false, false, true, false, true, false, true, true, true, false, true, false, true},
    {
        true, true, false, false, false, false, false, false, true, false, true, true, false, true, true},
    {
        true, true, false, false, false, false, false, false, false, true, false, true, false, false, false},};

    private boolean[][] east = {{
        true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, false, false, true, false, false, true, true, false, false, true, true, true, true, false},
    {
        true, false, true, false, false, false, false, false, false, true, true, true, true, true, true},
    {
        true, true, false, true, false, false, true, false, true, false, true, true, false, true, false},
    {
        true, false, true, false, false, true, false, true, false, true, false, false, true, false, true},
    {
        true, true, false, false, true, false, true, false, true, true, false, true, false, false, true},
    {
        true, false, true, true, false, true, true, true, false, false, true, true, false, true, false},
    {
        true, true, true, true, true, false, false, true, true, false, false, false, false, true, false},
    {
        true, true, true, true, false, true, true, true, false, false, false, false, false, false, false},
    {
        true, false, true, false, false, false, true, false, true, true, true, false, false, true, true},
    {
        true, true, false, true, true, true, false, true, true, true, false, true, true, true, false},
    {
        true, false, false, true, false, false, true, false, false, false, true, false, true, false, false},
    {
        true, false, true, false, false, true, false, true, true, false, false, true, false, true, false},
    {
        true, false, true, true, true, true, true, true, false, true, false, false, true, false, false},
    {
        true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},};

    private boolean[][] west = {{
        true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    {
        true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},};

    double[][] unAllowed_points = {
        {-27.0, 104.0}, {-32.0, 104.0}, {-37.0, 104.0}, {-42.0, 104.0}, {-47.0, 104.0}, {-52.0, 104.0}, {-57.0, 104.0}, {-52.0, 104.0}, {-47.0, 104.0},
        {-52.0, 104.0}, {-52.0, 99.0}, {-52.0, 94.0}, {-52.0, 99.0}, {-52.0, 104.0}, {-57.0, 104.0}, {-62.0, 104.0}, {-67.0, 104.0}, {-72.0, 104.0}, {-77.0, 104.0}, {-77.0, 99.0}, {-77.0, 94.0}, {-77.0, 99.0}, {-77.0, 104.0}, {-82.0, 104.0}, {-87.0, 104.0}, {-92.0, 104.0}, {-97.0, 104.0}, {-102.0, 104.0}, {-107.0, 104.0}, {-112.0, 104.0}, {-117.0, 104.0}, {-122.0, 104.0}, {-127.0, 104.0}, {-132.0, 104.0}, {-137.0, 104.0}, {-142.0, 104.0}, {-147.0, 104.0}, {-152.0, 104.0}, {-157.0, 104.0}, {-162.0, 104.0}, {-167.0, 104.0}, {-172.0, 104.0}, {-177.0, 104.0}, {-177.0, 99.0}, {-177.0, 94.0}, {-177.0, 89.0},
        {-177.0, 89.0}, {-177.0, 84.0}, {-177.0, 79.0}, {-177.0, 74.0}, {-177.0, 69.0}, {-177.0, 64.0}, {-177.0, 59.0}, {-177.0, 54.0}, {-177.0, 49.0}, {-177.0, 44.0}, {-177.0, 39.0}, {-177.0, 34.0}, {-177.0, 29.0}, {-172.0, 29.0}, {-167.0, 29.0}, {-162.0, 29.0}, {-157.0, 29.0}, {-152.0, 29.0}, {-147.0, 29.0}, {-147.0, 34.0}, {-147.0, 39.0}, {-147.0, 44.0}, {-147.0, 49.0}, {-147.0, 54.0}, {-147.0, 59.0}, {-147.0, 64.0}, {-147.0, 69.0}, {-147.0, 74.0}, {-147.0, 79.0}, {-147.0, 84.0}, {-147.0, 89.0},
        {-177.0, 29.0}, {-177.0, 24.0}, {-177.0, 19.0}, {-177.0, 14.0}, {-177.0, 9.0}, {-177.0, 4.0}, {-177.0, -1.0}, {-177.0, -6.0}, {-177.0, -11.0}, {-177.0, -16.0}, {-177.0, -21.0}, {-177.0, -26.0}, {-177.0, -31.0}, {-177.0, -36.0}, {-177.0, -41.0}, {-177.0, -46.0}, {-172.0, -46.0}, {-167.0, -46.0}, {-162.0, -46.0}, {-157.0, -46.0}, {-152.0, -46.0}, {-147.0, -46.0}, {-142.0, -46.0}, {-137.0, -46.0}, {-132.0, -46.0}, {-127.0, -46.0}, {-122.0, -46.0}, {-117.0, -46.0}, {-112.0, -46.0}, {-107.0, -46.0}, {-102.0, -46.0}, {-97.0, -46.0}, {-92.0, -46.0}, {-87.0, -46.0}, {-82.0, -46.0}, {-77.0, -46.0}, {-72.0, -46.0}, {-72.0, -41.0}, {-72.0, -36.0}, {-72.0, -31.0}, {-67.0, -31.0}, {-62.0, -31.0}, {-57.0, -31.0}, {-52.0, -31.0}, {-47.0, -31.0}, {-52.0, -31.0}, {-52.0, -26.0}, {-52.0, -21.0}, {-52.0, -16.0}, {-52.0, -21.0}, {-52.0, -26.0}, {-52.0, -31.0},
        {-177.0, -51.0}, {-177.0, -56.0}, {-177.0, -61.0}, {-177.0, -66.0}, {-177.0, -71.0}, {-177.0, -76.0}, {-177.0, -81.0}, {-177.0, -86.0}, {-177.0, -91.0}, {-172.0, -91.0}, {-167.0, -91.0}, {-162.0, -91.0}, {-157.0, -91.0}, {-152.0, -91.0}, {-157.0, -91.0}, {-162.0, -91.0}, {-167.0, -91.0}, {-172.0, -91.0}, {-177.0, -91.0}, {-177.0, -96.0}, {-177.0, -101.0}, {-177.0, -106.0}, {-172.0, -106.0}, {-167.0, -106.0}, {-162.0, -106.0}, {-157.0, -106.0}, {-152.0, -106.0}, {-147.0, -106.0}, {-142.0, -106.0}, {-137.0, -106.0}, {-132.0, -106.0}, {-127.0, -106.0}, {-122.0, -106.0}, {-117.0, -106.0}, {-112.0, -106.0}, {-107.0, -106.0}, {-102.0, -106.0}, {-97.0, -106.0}, {-97.0, -101.0}, {-97.0, -96.0}, {-97.0, -91.0}, {-97.0, -96.0}, {-97.0, -101.0}, {-97.0, -106.0}, {-92.0, -106.0}, {-87.0, -106.0}, {-82.0, -106.0}, {-77.0, -106.0}, {-72.0, -106.0}, {-67.0, -106.0}, {-62.0, -106.0}, {-57.0, -106.0}, {-52.0, -106.0}, {-47.0, -106.0}, {-47.0, -101.0}, {-47.0, -96.0}, {-47.0, -91.0},
        {-42.0, -106.0}, {-37.0, -106.0}, {-32.0, -106.0}, {-27.0, -106.0}, {-22.0, -106.0}, {-17.0, -106.0}, {-12.0, -106.0}, {-7.0, -106.0}, {-2.0, -106.0}, {-2.0, -101.0}, {-2.0, -96.0}, {-2.0, -91.0}, {-2.0, -86.0}, {-2.0, -81.0}, {-2.0, -76.0}, {-2.0, -71.0}, {-2.0, -66.0}, {-2.0, -61.0}, {-2.0, -56.0}, {-2.0, -51.0}, {-2.0, -46.0}, {3.0, -46.0}, {8.0, -46.0}, {13.0, -46.0}, {18.0, -46.0}, {23.0, -46.0}, {28.0, -46.0},
        {-7.0, -61.0}, {-12.0, -61.0}, {-17.0, -61.0}, {-22.0, -61.0}, {-27.0, -61.0}, {-27.0, -66.0}, {-27.0, -71.0}, {-27.0, -76.0}, {-27.0, -81.0}, {-27.0, -86.0}, {-27.0, -81.0}, {-27.0, -76.0}, {-32.0, -76.0}, {-37.0, -76.0}, {-42.0, -76.0}, {-47.0, -76.0}, {-52.0, -76.0}, {-57.0, -76.0}, {-62.0, -76.0}, {-67.0, -76.0}, {-72.0, -76.0}, {-77.0, -76.0}, {-77.0, -81.0}, {-77.0, -86.0}, {-77.0, -81.0}, {-77.0, -76.0}, {-82.0, -76.0}, {-87.0, -76.0}, {-92.0, -76.0}, {-97.0, -76.0}, {-102.0, -76.0}, {-102.0, -71.0}, {-102.0, -66.0}, {-102.0, -61.0}, {-102.0, -66.0}, {-102.0, -71.0}, {-102.0, -76.0}, {-107.0, -76.0}, {-112.0, -76.0}, {-117.0, -76.0}, {-122.0, -76.0}, {-127.0, -76.0}, {-127.0, -81.0}, {-127.0, -91.0}, {-127.0, -81.0}, {-127.0, -76.0},
        {-132.0, -76.0}, {-137.0, -76.0}, {-142.0, -76.0}, {-147.0, -76.0}, {-152.0, -76.0}, {-152.0, -71.0}, {-152.0, -66.0}, {-152.0, -61.0}, {-147.0, -61.0}, {-142.0, -61.0}, {-137.0, -61.0}, {-132.0, -61.0}, {-127.0, -61.0},
        {-127.0, -86.0}, {-122.0, 104.0}, {-122.0, 99.0}, {-122.0, 94.0}, {-122.0, 89.0}, {-122.0, 84.0}, {-122.0, 79.0}, {-122.0, 74.0}, {-122.0, 69.0}, {-122.0, 64.0}, {-122.0, 59.0}, {-122.0, 54.0}, {-122.0, 49.0}, {-122.0, 44.0}, {-122.0, 39.0}, {-122.0, 34.0}, {-122.0, 29.0}, {-122.0, 24.0}, {-122.0, 19.0}, {-122.0, 14.0}, {-127.0, 14.0}, {-132.0, 14.0}, {-137.0, 14.0}, {-142.0, 14.0}, {-147.0, 14.0},
        {-117.0, 29.0}, {-112.0, 29.0}, {-107.0, 29.0}, {-102.0, 29.0}, {-97.0, 29.0}, {-92.0, 29.0}, {-87.0, 29.0}, {-82.0, 29.0}, {-77.0, 29.0}, {-77.0, 24.0}, {-77.0, 19.0}, {-77.0, 14.0}, {-77.0, 19.0}, {-77.0, 14.0}, {-82.0, 14.0}, {-87.0, 14.0}, {-92.0, 14.0}, {-97.0, 14.0}, {-97.0, 9.0}, {-97.0, 4.0}, {-97.0, -1.0}, {-102.0, -1.0}, {-107.0, -1.0}, {-112.0, -1.0}, {-117.0, -1.0}, {-122.0, -1.0},
        {-97.0, 34.0}, {-97.0, 39.0}, {-97.0, 44.0}, {-97.0, 49.0}, {-97.0, 54.0}, {-97.0, 59.0}, {-92.0, 59.0}, {-87.0, 59.0}, {-82.0, 59.0}, {-77.0, 59.0}, {-77.0, 64.0}, {-77.0, 69.0}, {-77.0, 74.0}, {-82.0, 74.0}, {-87.0, 74.0}, {-92.0, 74.0}, {-97.0, 74.0}, {-102.0, 74.0}, {-102.0, 79.0}, {-102.0, 84.0}, {-102.0, 89.0},
        {-72.0, 74.0}, {-67.0, 74.0}, {-62.0, 74.0}, {-57.0, 74.0}, {-52.0, 74.0}, {-47.0, 74.0}, {-42.0, 74.0}, {-37.0, 74.0}, {-32.0, 74.0}, {-27.0, 74.0}, {-22.0, 74.0}, {-22.0, 79.0}, {-22.0, 84.0}, {-22.0, 89.0}, {-17.0, 89.0}, {-12.0, 89.0}, {-7.0, 89.0}, {-2.0, 89.0}, {-2.0, 84.0}, {-2.0, 79.0}, {-2.0, 74.0}, {-2.0, 79.0}, {-2.0, 84.0}, {-2.0, 89.0}, {3.0, 89.0}, {8.0, 89.0}, {13.0, 89.0}, {18.0, 89.0}, {23.0, 89.0},
        {-152.0, -1.0}, {-152.0, -6.0}, {-152.0, -11.0}, {-152.0, -16.0}, {-152.0, -21.0}, {-152.0, -26.0}, {-152.0, -31.0}, {-147.0, -31.0}, {-142.0, -31.0}, {-137.0, -31.0}, {-132.0, -31.0}, {-127.0, -31.0}, {-122.0, -31.0}, {-117.0, -31.0}, {-112.0, -31.0}, {-107.0, -31.0}, {-102.0, -31.0}, {-102.0, -26.0}, {-102.0, -21.0}, {-102.0, -16.0}, {-107.0, -16.0}, {-112.0, -16.0}, {-117.0, -16.0}, {-122.0, -16.0},
        {-97.0, -16.0}, {-92.0, -16.0}, {-87.0, -16.0}, {-82.0, -16.0}, {-77.0, -16.0}, {-77.0, -11.0}, {-77.0, -6.0}, {-77.0, -1.0}, {-72.0, -1.0}, {-67.0, -1.0}, {-62.0, -1.0}, {-57.0, -1.0}, {-52.0, -1.0}, {-47.0, -1.0}, {-42.0, -1.0}, {-37.0, -1.0}, {-32.0, -1.0}, {-27.0, -1.0}, {-27.0, -6.0}, {-27.0, -11.0}, {-27.0, -16.0}, {-27.0, -21.0}, {-27.0, -26.0}, {-27.0, -31.0}, {-27.0, -36.0}, {-27.0, -41.0}, {-27.0, -46.0}, {-32.0, -46.0}, {-37.0, -46.0}, {-42.0, -46.0}, {-47.0, -46.0}, {-52.0, -46.0}, {-52.0, -51.0}, {-52.0, -56.0}, {-52.0, -61.0}, {-57.0, -61.0}, {-62.0, -61.0}, {-67.0, -61.0}, {-72.0, -61.0},
        {-52.0, 4.0}, {-52.0, 9.0}, {-52.0, 14.0}, {-52.0, 19.0}, {-52.0, 24.0}, {-52.0, 29.0}, {-47.0, 29.0}, {-42.0, 29.0}, {-37.0, 29.0}, {-32.0, 29.0}, {-27.0, 29.0}, {-22.0, 29.0}, {-17.0, 29.0}, {-12.0, 29.0}, {-7.0, 29.0}, {-2.0, 29.0}, {3.0, 29.0}, {8.0, 29.0}, {13.0, 29.0}, {18.0, 29.0}, {23.0, 29.0},
        {-27.0, 34.0}, {-27.0, 39.0}, {-27.0, 44.0}, {-27.0, 49.0}, {-27.0, 54.0}, {-27.0, 59.0}, {-32.0, 59.0}, {-37.0, 59.0}, {-42.0, 59.0}, {-47.0, 59.0}, {-52.0, 59.0}, {-52.0, 54.0}, {-52.0, 49.0}, {-52.0, 44.0}, {-57.0, 44.0}, {-62.0, 44.0}, {-67.0, 44.0}, {-72.0, 44.0},
        {-22.0, 59.0}, {-17.0, 59.0}, {-12.0, 59.0}, {-7.0, 59.0}, {-2.0, 59.0}, {3.0, 59.0}, {8.0, 59.0}, {13.0, 59.0}, {18.0, 59.0}, {23.0, 59.0}, {28.0, 59.0}, {33.0, 59.0}, {38.0, 59.0}, {43.0, 59.0}, {48.0, 59.0}, {53.0, 59.0}, {58.0, 59.0}, {63.0, 59.0}, {68.0, 59.0}, {73.0, 59.0},
        {3.0, 104.0}, {8.0, 104.0}, {13.0, 104.0}, {18.0, 104.0}, {23.0, 104.0}, {28.0, 104.0}, {33.0, 104.0}, {38.0, 104.0}, {43.0, 104.0}, {48.0, 104.0}, {53.0, 104.0}, {53.0, 99.0}, {53.0, 94.0}, {53.0, 89.0}, {53.0, 84.0}, {53.0, 79.0}, {53.0, 74.0}, {48.0, 74.0}, {43.0, 74.0}, {38.0, 74.0}, {33.0, 74.0}, {28.0, 74.0},
        {48.0, 104.0}, {53.0, 104.0}, {58.0, 104.0}, {63.0, 104.0}, {68.0, 104.0}, {73.0, 104.0}, {78.0, 104.0}, {83.0, 104.0}, {88.0, 104.0}, {93.0, 104.0}, {98.0, 104.0}, {103.0, 104.0}, {108.0, 104.0}, {113.0, 104.0}, {118.0, 104.0}, {123.0, 104.0}, {128.0, 104.0}, {133.0, 104.0}, {138.0, 104.0}, {143.0, 104.0}, {148.0, 104.0}, {153.0, 104.0}, {158.0, 104.0}, {163.0, 104.0}, {168.0, 104.0}, {173.0, 104.0}, {178.0, 104.0}, {178.0, 99.0}, {178.0, 94.0}, {178.0, 89.0}, {178.0, 84.0}, {178.0, 79.0}, {178.0, 74.0}, {178.0, 69.0}, {178.0, 64.0}, {178.0, 59.0}, {178.0, 54.0}, {178.0, 49.0}, {178.0, 44.0}, {173.0, 44.0}, {168.0, 44.0}, {163.0, 44.0}, {158.0, 44.0}, {153.0, 44.0}, {148.0, 44.0}, {143.0, 44.0}, {138.0, 44.0}, {133.0, 44.0}, {128.0, 44.0}, {123.0, 44.0}, {123.0, 49.0}, {123.0, 54.0}, {123.0, 59.0}, {118.0, 59.0}, {113.0, 59.0}, {108.0, 59.0}, {103.0, 59.0}, {103.0, 64.0}, {103.0, 69.0}, {103.0, 74.0},
        {178.0, 49.0}, {178.0, 44.0}, {178.0, 39.0}, {178.0, 34.0}, {178.0, 29.0}, {178.0, 24.0}, {178.0, 19.0}, {178.0, 14.0}, {178.0, 9.0}, {178.0, 4.0}, {178.0, -1.0}, {178.0, -6.0}, {178.0, -11.0}, {178.0, -16.0}, {178.0, -21.0}, {178.0, -26.0}, {178.0, -31.0}, {178.0, -36.0}, {178.0, -41.0}, {178.0, -46.0}, {178.0, -51.0}, {178.0, -56.0}, {178.0, -61.0}, {178.0, -66.0}, {178.0, -71.0}, {178.0, -76.0}, {178.0, -81.0}, {178.0, -86.0}, {178.0, -91.0}, {178.0, -96.0}, {178.0, -101.0}, {178.0, -106.0}, {173.0, -106.0}, {168.0, -106.0}, {163.0, -106.0}, {158.0, -106.0}, {153.0, -106.0}, {148.0, -106.0}, {143.0, -106.0}, {138.0, -106.0}, {133.0, -106.0}, {128.0, -106.0}, {123.0, -106.0}, {118.0, -106.0}, {113.0, -106.0}, {108.0, -106.0}, {103.0, -106.0}, {98.0, -106.0}, {93.0, -106.0}, {88.0, -106.0}, {83.0, -106.0}, {78.0, -106.0}, {73.0, -106.0}, {68.0, -106.0}, {63.0, -106.0}, {58.0, -106.0}, {53.0, -106.0}, {48.0, -106.0}, {43.0, -106.0}, {38.0, -106.0}, {33.0, -106.0}, {28.0, -106.0}, {23.0, -106.0}, {23.0, -101.0}, {23.0, -96.0}, {23.0, -91.0}, {23.0, -86.0}, {23.0, -81.0}, {23.0, -76.0}, {23.0, -71.0}, {23.0, -66.0}, {23.0, -61.0}, {28.0, -61.0}, {33.0, -61.0}, {38.0, -61.0}, {43.0, -61.0}, {48.0, -61.0},
        {148.0, 89.0}, {143.0, 89.0}, {138.0, 89.0}, {133.0, 89.0}, {128.0, 89.0}, {123.0, 89.0}, {123.0, 84.0}, {123.0, 79.0}, {123.0, 74.0}, {128.0, 74.0}, {133.0, 74.0}, {138.0, 74.0}, {143.0, 74.0}, {148.0, 74.0}, {148.0, 69.0}, {148.0, 64.0},
        {128.0, 89.0}, {123.0, 89.0}, {118.0, 89.0}, {113.0, 89.0}, {108.0, 89.0}, {103.0, 89.0}, {98.0, 89.0}, {93.0, 89.0}, {88.0, 89.0}, {83.0, 89.0}, {78.0, 89.0}, {73.0, 89.0}, {73.0, 84.0}, {73.0, 79.0}, {73.0, 74.0}, {73.0, 69.0}, {73.0, 64.0}, {73.0, 59.0}, {78.0, 64.0}, {78.0, 59.0}, {78.0, 54.0}, {78.0, 49.0}, {78.0, 44.0}, {83.0, 44.0}, {88.0, 44.0}, {93.0, 44.0}, {98.0, 44.0}, {98.0, 39.0}, {98.0, 34.0}, {98.0, 29.0}, {103.0, 29.0}, {108.0, 29.0}, {113.0, 29.0}, {118.0, 29.0}, {123.0, 29.0}, {128.0, 29.0}, {133.0, 29.0}, {138.0, 29.0}, {143.0, 29.0}, {148.0, 29.0}, {153.0, 29.0}, {153.0, 24.0}, {153.0, 19.0}, {153.0, 14.0}, {158.0, 14.0}, {163.0, 14.0}, {168.0, 14.0}, {173.0, 14.0}, {178.0, 14.0}, {178.0, 14.0}, {178.0, 14.0},
        {73.0, -101.0}, {73.0, -96.0}, {73.0, -91.0}, {78.0, -91.0}, {83.0, -91.0}, {88.0, -91.0}, {93.0, -91.0}, {98.0, -91.0}, {103.0, -91.0}, {108.0, -91.0}, {113.0, -91.0}, {118.0, -91.0}, {123.0, -91.0}, {123.0, -86.0}, {123.0, -81.0}, {123.0, -76.0},
        {73.0, -101.0}, {73.0, -96.0}, {73.0, -91.0}, {78.0, -91.0}, {83.0, -91.0}, {88.0, -91.0}, {93.0, -91.0}, {98.0, -91.0}, {103.0, -91.0}, {108.0, -91.0}, {113.0, -91.0}, {118.0, -91.0}, {123.0, -91.0}, {123.0, -86.0}, {123.0, -81.0}, {123.0, -76.0},
        {148.0, -56.0}, {148.0, -51.0}, {148.0, -46.0}, {148.0, -41.0}, {148.0, -36.0}, {148.0, -31.0}, {148.0, -26.0}, {148.0, -21.0}, {148.0, -16.0}, {148.0, -11.0}, {148.0, -6.0}, {148.0, -1.0}, {143.0, -1.0}, {138.0, -1.0}, {133.0, -1.0}, {128.0, -1.0}, {123.0, -1.0}, {123.0, -6.0}, {123.0, -11.0}, {123.0, -6.0}, {123.0, -1.0}, {118.0, -1.0}, {113.0, -1.0}, {108.0, -1.0}, {103.0, -1.0},
        {123.0, 4.0}, {123.0, 9.0}, {123.0, 14.0}, {118.0, 14.0}, {113.0, 14.0}, {108.0, 14.0}, {103.0, 14.0}, {98.0, 14.0}, {93.0, 14.0}, {88.0, 14.0}, {83.0, 14.0}, {78.0, 14.0}, {73.0, 14.0}, {73.0, 9.0}, {73.0, 4.0}, {73.0, -1.0}, {73.0, -6.0}, {73.0, -11.0}, {73.0, -16.0}, {78.0, -16.0}, {83.0, -16.0}, {88.0, -16.0}, {93.0, -16.0}, {98.0, -16.0}, {98.0, -21.0}, {98.0, -26.0}, {98.0, -31.0}, {103.0, -31.0}, {108.0, -31.0}, {113.0, -31.0}, {118.0, -31.0}, {123.0, -31.0}, {123.0, -36.0}, {123.0, -41.0},
        {73.0, 19.0}, {73.0, 24.0}, {73.0, 29.0}, {68.0, 29.0}, {63.0, 29.0}, {58.0, 29.0}, {53.0, 29.0}, {48.0, 29.0}, {48.0, 24.0}, {48.0, 19.0}, {48.0, 14.0}, {48.0, 9.0}, {48.0, 4.0}, {48.0, 9.0}, {48.0, 14.0}, {43.0, 14.0}, {38.0, 14.0}, {33.0, 14.0}, {28.0, 14.0}, {23.0, 14.0}, {18.0, 14.0}, {13.0, 14.0}, {8.0, 14.0}, {3.0, 14.0}, {-2.0, 14.0}, {-2.0, 9.0}, {-2.0, 4.0}, {-2.0, -1.0}, {-2.0, -6.0}, {-2.0, -11.0},
        {-2.0, -11.0}, {-2.0, -6.0}, {-2.0, -1.0}, {-2.0, 4.0}, {-2.0, 9.0}, {-2.0, 14.0}, {-7.0, 14.0}, {-12.0, 14.0}, {-17.0, 14.0}, {-22.0, 14.0},
        {48.0, 34.0}, {48.0, 39.0}, {48.0, 44.0}, {43.0, 44.0}, {38.0, 44.0}, {33.0, 44.0}, {28.0, 44.0}, {23.0, 44.0}, {18.0, 44.0}, {13.0, 44.0}, {8.0, 44.0}, {3.0, 44.0}, {-2.0, 44.0},
        {23.0, -41.0}, {23.0, -36.0}, {23.0, -31.0}, {18.0, -31.0}, {13.0, -31.0}, {8.0, -31.0}, {3.0, -31.0},
        {23.0, -26.0}, {23.0, -21.0}, {23.0, -16.0}, {23.0, -11.0}, {23.0, -6.0}, {23.0, -1.0}, {23.0, -6.0}, {23.0, -11.0}, {23.0, -16.0}, {28.0, -16.0}, {33.0, -16.0}, {38.0, -16.0}, {43.0, -16.0}, {48.0, -16.0}, {48.0, -21.0}, {48.0, -26.0},
        {33.0, -46.0}, {38.0, -46.0}, {43.0, -46.0}, {48.0, -46.0}, {53.0, -46.0}, {58.0, -46.0}, {63.0, -46.0}, {68.0, -46.0}, {73.0, -46.0}, {73.0, -41.0}, {73.0, -36.0}, {73.0, -31.0}, {73.0, -36.0}, {73.0, -41.0}, {73.0, -46.0}, {73.0, -41.0}, {73.0, -36.0}, {73.0, -31.0}, {68.0, -31.0}, {73.0, -31.0}, {73.0, -36.0}, {73.0, -41.0}, {73.0, -46.0}, {78.0, -46.0}, {83.0, -46.0}, {88.0, -46.0}, {93.0, -46.0}, {98.0, -46.0}, {93.0, -46.0}, {88.0, -46.0}, {83.0, -46.0}, {78.0, -46.0}, {73.0, -46.0}, {73.0, -51.0}, {73.0, -56.0}, {73.0, -61.0}, {73.0, -66.0}, {73.0, -71.0}, {73.0, -76.0}, {68.0, -76.0}, {63.0, -76.0}, {58.0, -76.0}, {53.0, -76.0}, {48.0, -76.0}, {48.0, -81.0}, {48.0, -86.0},
        {78.0, -76.0}, {83.0, -76.0}, {88.0, -76.0}, {93.0, -76.0}, {98.0, -76.0}, {98.0, -71.0}, {98.0, -66.0}, {98.0, -61.0}, {103.0, -61.0}, {108.0, -61.0}, {113.0, -61.0}, {118.0, -61.0}, {123.0, -61.0}, {128.0, -61.0}, {133.0, -61.0}, {138.0, -61.0}, {143.0, -61.0}, {148.0, -61.0}, {153.0, -61.0}, {153.0, -66.0}, {153.0, -71.0}, {153.0, -76.0}, {153.0, -81.0}, {153.0, -86.0}, {153.0, -81.0}, {153.0, -76.0}, {153.0, -71.0}, {153.0, -66.0}, {153.0, -61.0}, {153.0, -56.0}, {153.0, -51.0}, {153.0, -46.0}, {153.0, -41.0}, {153.0, -36.0}, {153.0, -31.0}, {153.0, -26.0}, {153.0, -21.0}, {153.0, -16.0}, {153.0, -11.0}, {153.0, -6.0}, {153.0, -1.0}, {148.0, -1.0}, {148.0, -1.0}, {148.0, -1.0},
     { -2.0 , 104.0} ,  { -2.0 , 109.0} ,  { -2.0 , 114.0} ,  { -7.0 , 114.0} ,  { -12.0 , 114.0} ,  { -17.0 , 114.0} ,  { -22.0 , 114.0} ,  { -22.0 , 109.0} ,  { -22.0 , 104.0} , 
     
        
        
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
        int ball = 1;

        gl.glColor3f(1.0f, 0.7f, 0.75f);

        for (int i = 0; i < unAllowed_points.length; i++) {
            if (buffer_px == unAllowed_points[i][0] && buffer_py == unAllowed_points[i][1]) {
                ball = 0;
            }
        }
        //
        for (int i = 0; i < 1; i++) {
            {
                System.out.print(" { " + buffer_px + " , " + buffer_py + '}' + " , ");
            }
        }
        if (ball == 0) {
            playMusic(TakeDamage);
            pla.clip.start();
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
        } else {
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
            green = 0f;
            red = 0f;
            blue = 1f;

        }

        gl.glPushMatrix();

        drawCircle(gl, 3, Color.YELLOW, aa, -162.0, 39.0);
        drawCircle(gl, 3, Color.YELLOW, cc, -112.0, 39.0);
        drawCircle(gl, 3, Color.YELLOW, dd, -62.0, 54.0);
        drawCircle(gl, 3, Color.YELLOW, ee, -142.0, -66.0);
        drawCircle(gl, 3, Color.YELLOW, ff, -12.0, -71.0);

        drawCircle(gl, 3, Color.YELLOW, bb, -12.0, 4.0);
        drawCircle(gl, 3, Color.YELLOW, a,8.0 , 69.0);
                drawCircle(gl, 3, Color.YELLOW, c,  138.0 , 84.0);
                drawCircle(gl, 3, Color.YELLOW, d, 163.0 , 24.0);
                drawCircle(gl, 3, Color.YELLOW, e , 38.0 , 34.0);
                drawCircle(gl, 3, Color.YELLOW, f , 38.0 , -36.0 );
                drawCircle(gl, 3, Color.YELLOW, b, 113.0 , 9.0);
                drawCircle(gl, 3, Color.YELLOW, k, 138.0 , -81.0 );
//                drawCircle(gl, 3, Color.YELLOW, k, 29.0 , 104.0 );
//                drawCircle(gl, 3, Color.YELLOW, l , -71.0 , 104.0 );
//                drawCircle(gl, 3, Color.YELLOW, m, -66.0 , -16.0);

        gl.glEnd();
        gl.glPopMatrix();

        if (buffer_px == -162.0 && buffer_py == 39.0 && aa == true) {
            aa = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == -112.0 && buffer_py == 39.0 && cc == true) {
            cc = false;
            counter += 10;
playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == -62.0 && buffer_py == 54.0 && dd == true) {
            dd = false;
            counter += 10;
playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == -142.0 && buffer_py == -66.0 && ee == true) {
            ee = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == -12.0 && buffer_py == -71.0 && ff == true) {
            ff = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }

        if (buffer_px == -12.0 && buffer_py == 4.0 && bb == true) {
            bb = false;
            counter += 10;
            playMusic(coins);
            pla.clip.start();
        }
        if (buffer_px == 8.0 && buffer_py ==  69.0 && a==true ) {

                  a= false ;
                  counter+=10;
                  playMusic(coins);
            pla.clip.start();
            }

            if (buffer_px == 113.0 && buffer_py == 9.0 && b==true ) {
                  b=false ;
                  counter+=10;
playMusic(coins);
            pla.clip.start();
            }

            if (buffer_px == 138.0 && buffer_py == 84.0 && c==true ) {
                  c=false ;
                  counter+=10;
playMusic(coins);
            pla.clip.start();
            }

            if (buffer_px == 163.0 && buffer_py == 24.0 && d==true  ) {
                  d=false ;
                  counter+=10;
                  playMusic(coins);
            pla.clip.start();
            }

            if (buffer_px == 38.0 && buffer_py ==  -36.0 && f==true  ) {
                  f=false ;
                  counter+=10;
                  playMusic(coins);
            pla.clip.start();
            }

            if (buffer_px == 38.0&& buffer_py == 34.0 && e==true  ) {
                  e=false ;
                  counter+=10;
                  playMusic(coins);
            pla.clip.start();
            }

            if (buffer_px ==138.0  && buffer_py == -81.0 && k==true  ) {
                  k=false ;
                  counter+=10;
playMusic(coins);
            pla.clip.start();
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
        drawStar(gl, 10, true, 12.0, -100, angle += 9);
        gl.glEnd();
        gl.glPopMatrix();
//

if (px == 18.0 && py == -96.0 || px ==13.0 && py == -96.0 ||  px == 8.0 && py == -96.0 ||  px == 3.0 && py == -96.0 ) 
         {
            blue = 1.0f;
            green = 0.0f;
            red = 0.0f;
            if (counter > 0) {

                playMusic(Winning);
                pla.clip.start();

                JOptionPane.showMessageDialog(null, "Good Job ♥ " + name);
                JOptionPane.showMessageDialog(null, "You Win \n Your Score is ☺ " + counter);
            } else {

                playMusic(gameover);
                pla.clip.start();

                JOptionPane.showMessageDialog(null, name + " You lost  " + -1 * counter);

            }

            System.exit(0);

        }

    }// end display method

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

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
    }

}














