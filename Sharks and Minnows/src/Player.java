import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.*; 
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Player implements Icon
	{
	private Color color;
	private int width;
	private int height;

	public Player(Color color, int width, int height)
		{
		this.color = color;
		this.width = width;
		this.height = height;
		}

	public int getIconWidth()
		{
		return width;
		}

	public int getIconHeight()
		{
		return height;
		}

	public void paintIcon(Component c, Graphics g, int x, int y)
		{
		g.setColor(color);
		g.fillRect(x, y, width, height);
		}
	}
	
