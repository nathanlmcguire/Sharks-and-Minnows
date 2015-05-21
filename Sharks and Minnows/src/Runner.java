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

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Runner 
	{
	static JComponent component;
	static JComponent object1, object2, object3;
	static boolean ob1 = true, ob2 = true, ob3 = true;
	static int count = 0, moveCount = 0, escapeCount = 0;
	static JPanel content = new JPanel();
	static JFrame frame = new JFrame("SHARKS AND MINNOWS");
	static int speedX1 = 10, speedY1 = 10, speedX2 = 10, speedY2 = 10, speedX3 = 10, speedY3 = 10;

	public Runner(JComponent component, JComponent object1, JComponent object2, JComponent object3)
		{
		this.component = component;
		this.object1 = object1;
		this.object2 = object2;
		this.object3 = object3;
		}
	
	public static void main(String[] args)
		{
		EventQueue.invokeLater(new Runnable()
			{
			public void run()
				{
				int width = chooseWidth();
				int height = chooseHeight();
				
				//  Create a panel with a component to be moved
				JPanel content = new JPanel();
				content = prepareContent(width, height, content);
				prepareFrame(width, height, object1, object2, object3, content);
				}
			});
		}
	
	public static int chooseWidth()
		{
		JFrame frame = new JFrame();
		Object[] chooseSize = {"THIN", "THICK", "VERY THICK"};
		int chosenSize = JOptionPane.showOptionDialog(frame, "How wide do you want the lake to be?",
				"CHARACTER CREATION",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, chooseSize, chooseSize[1]);
		switch(chosenSize)
			{
			case 0:
				{
				return 500;
				}
			case 1:
				{
				return 800;
				}
			case 2:
				{
				return 1200;
				}
			}
		return 700;
		}
	
	public static int chooseHeight()
		{
		JFrame frame = new JFrame();
		Object[] chooseSize = {"SHORT", "TALL", "VERY TALL"};
		int chosenSize = JOptionPane.showOptionDialog(frame, "How tall do you want the lake to be?",
				"CHARACTER CREATION",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, chooseSize, chooseSize[1]);
		switch(chosenSize)
			{
			case 0:
				{
				return 500;
				}
			case 1:
				{
				return 800;
				}
			case 2:
				{
				return 1200;
				}
			}
		return 700;
		}

	public static void prepareFrame(int width, int height, JComponent ob1, JComponent ob2, JComponent ob3, JPanel co)
		{
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(width, height);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		frame.add(ob1);
		frame.add(ob2);
		frame.add(ob3);
		frame.add(co);
		}
	
	public static JPanel prepareContent(int width, int height, JPanel content)
		{
		content.setLayout(null);
		content.setBackground(Color.CYAN);
		JFrame.setDefaultLookAndFeelDecorated(true);
		

		Icon player = new ImageIcon("shark2.jpg");
		JLabel component = new JLabel(player);
		Icon f1 = new ImageIcon("f2.jpg");
		JLabel object1 = new JLabel(f1);
		Icon f2 = new ImageIcon("f2.jpg");
		JLabel object2 = new JLabel(f2);
		Icon f3 = new ImageIcon("f2.jpg");
		JLabel object3 = new JLabel(f3);
		
		component.setSize( component.getPreferredSize() );
		component.setLocation(0, 0);
		content.add(component);
		
		object1.setSize( object1.getPreferredSize() );
		object2.setSize( object2.getPreferredSize() );
		object3.setSize( object3.getPreferredSize() );
		int x = (int) ((Math.random() * width));
		int y = (int) ((Math.random() * height));
		object1.setLocation(x, y);
		content.add(object1);
		x = (int) ((Math.random() * width));
		y = (int) ((Math.random() * height));
		object2.setLocation(x, y);
		content.add(object2);
		x = (int) ((Math.random() * width));
		y = (int) ((Math.random() * height));
		object3.setLocation(x, y);
		content.add(object3);
		addMotionSupport(component, object1, object2, object3);
		return content;
		}
	
	private static void addMotionSupport(JComponent component, JComponent object1, JComponent object2, JComponent object3)//adds movement bindings
		{
		int delta = 20;
		
		Runner move = new Runner(component, object1, object2, object3);
		move.addAction("A", -delta,  0);
		move.addAction("D", delta,  0);
		move.addAction("W",    0, -delta);
		move.addAction("S",  0,  delta);
		move.addAction("WA", -delta,  -delta);
		move.addAction("WD", delta,  -delta);
		move.addAction("SA",   -delta, -delta);
		move.addAction("SD",  delta,  delta);
		move.addAction("LEFT", -delta,  0);
		move.addAction("RIGHT", delta,  0);
		move.addAction("UP",    0, -delta);
		move.addAction("DOWN",  0,  delta);
		}

	public Action addAction(String name, int deltaX, int deltaY)
		{
		Action action = new Action(name, deltaX, deltaY);
		
		KeyStroke pressedKeyStroke = KeyStroke.getKeyStroke(name);
		InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(pressedKeyStroke, name);
		component.getActionMap().put(name, action);
		return action;
		}
	
	public class Action extends AbstractAction implements ActionListener
		{
		private int deltaX;
		private int deltaY;
	
		public Action(String name, int deltaX, int deltaY)
			{
			super(name);
			this.deltaX = deltaX;
			this.deltaY = deltaY;
			}
	
		public void actionPerformed(ActionEvent e)
			{
			move(deltaX, deltaY);
			}
		
		public void move(int deltaX, int deltaY)//  Move the component to its new location. The component will stop moving when it reaches the bounds of its container 
			{
			int componentWidth = component.getSize().width;
			int componentHeight = component.getSize().height;
			Dimension parentSize = component.getParent().getSize();
			int parentWidth  = parentSize.width;
			int parentHeight = parentSize.height;
	
			//  Determine next X position
			int nextX = Math.max(component.getLocation().x + deltaX, 0);
			if ( nextX + componentWidth > parentWidth)
				{
				nextX = parentWidth - componentWidth;
				}
	
			//  Determine next Y position
			int nextY = Math.max(component.getLocation().y + deltaY, 0);
			if ( nextY + componentHeight > parentHeight)
				{
				nextY = parentHeight - componentHeight;
				}
	
			//  Move the component
			component.setLocation(nextX, nextY);
			int width1 = object1.getX() + object1.getWidth();
			int height1 = object1.getY() + object1.getHeight();
			int width2 = object2.getX() + object2.getWidth();
			int height2 = object2.getY() + object2.getHeight();
			int width3 = object3.getX() + object3.getWidth();
			int height3 = object3.getY() + object3.getHeight();
			
			if((component.getX() >= object1.getX() && component.getX() <= width1) && (component.getY() >= object1.getY() && component.getY() <= height1) && ob1 == true)
				{
				count++;
				content.remove(object1);
				frame.remove(object1);
				object1.setEnabled(false);
				ob1 = false;
				if(count >= 3)
					{
					System.out.println("GAME OVER!!!");
					System.exit(0);
					}
				else
					{
					System.out.println("Good job! Keep on munching!  Only " + (3 - count) + " left!");
					}
				}
			if((component.getX() >= object2.getX() && component.getX() <= width2) && (component.getY() >= object2.getY() && component.getY() <= height2) && ob2 == true)
				{
				count++;
				ob2 = false;
				content.remove(object2);
				frame.remove(object2);
				object2.setEnabled(false);
				if(count >= 3)
					{
					System.out.println("GAME OVER!!!");
					System.exit(0);
					}
				else
					{
					System.out.println("Good job! Keep on munching!  Only " + (3 - count) + " left!");
					}
				}
			if((component.getX() >= object3.getX() && component.getX() <= width3) && (component.getY() >= object3.getY() && component.getY() <= height3) && ob3 == true)
				{
				count++;
				content.remove(object3);
				frame.remove(object3);
				object3.setEnabled(false);
				ob3 = false;
				if(count >= 3)
					{
					System.out.println("GAME OVER!!!  YOU WIN!!!!");
					System.exit(0);
					}
				else
					{
					System.out.println("Good job! Keep on munching!  Only " + (3 - count) + " left!");
					}
				}
			moveCount++;
			if(moveCount == 1)
				{
				speedX1 = getDirection(speedX1);
				speedY1 = getDirection(speedY1);
				speedX2 = getDirection(speedX2);
				speedY2 = getDirection(speedY2);
				speedX3 = getDirection(speedX3);
				speedY3 = getDirection(speedY3);
				}
			else if( moveCount == 9)
				{
				moveCount = 0;
				}
			object1.setLocation(object1.getX() + speedX1, object1.getY() + speedY1);
			object2.setLocation(object2.getX() + speedX2, object2.getY() + speedY2);
			object3.setLocation(object3.getX() + speedX3, object3.getY() + speedY3);
			}
		
		public int getDirection(int num)
			{
			int ran = (int) (Math.random() * 2);
			switch(ran)
				{
				case 0:
					{
					return num;
					}
				case 1:
					{
					return num * -1;
					}
				}
			return 0;
			}
		}
	
	}