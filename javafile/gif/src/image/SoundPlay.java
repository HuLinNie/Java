package image;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;

import java.awt.event.*;

//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.*;
//import java.awt.Image;
//import java.awt.Image.*;
//import java.awt.Color;
//import java.awt.*;
//import java.awt.Graphics;

@SuppressWarnings("serial")
public class SoundPlay  extends Applet implements ItemListener,ActionListener {
	
//		JFrame frm = new JFrame("œ‘ æÕº∆¨");
//		JLabel  helloLabel = new JLabel("New lablel");
//		
//		helloLabel.setBackground(Color.black);
//		helloLabel.setBounds(0, 0, 105, 50);
//		frm.add(helloLabel);
		AudioClip sound;
//		Applet alt=new Applet();
		Choice c = new Choice();
		Button play=new Button("≤•∑≈");
		Button loop=new Button("—≠ª∑≤•∑≈");
		Button stop=new Button("Õ£÷π");
//		frm.setSize(400, 300);
//		frm.setVisible(true);
		public void init() {
		c.add("123.wav");
		c.add("456.wav");
	
		add(c);	
		c.addItemListener(this);
		add(play);
		add(loop);
		add(stop);
		play.addActionListener(this);
		loop.addActionListener(this);
		stop.addActionListener(this);
		sound =getAudioClip(getCodeBase(),"123.wav");
		}
		public void itemStateChanged(ItemEvent e) {
			sound.stop();
			sound =getAudioClip(getCodeBase(),c.getSelectedItem());
			
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==play)sound.play();
			else if(e.getSource()==loop)sound.loop();
			else if(e.getSource()==stop)sound.stop();
		}
}
		
		
		
	