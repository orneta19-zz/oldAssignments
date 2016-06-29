/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.oldAssignments;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Shay
 */
public class DiscoPanel extends JPanel implements ActionListener{
    private Disco disc;
    
    private JButton cmdAllOff, cmdSwitchBulb, cmdAllOn;
    public DiscoPanel(Disco d)
    {
        disc = d;

        cmdAllOff = new JButton("Switch All Off");
        cmdSwitchBulb = new JButton("Switch Bulb");
        cmdAllOn = new JButton("Switch All On");
        cmdAllOff.addActionListener(this);
        cmdSwitchBulb.addActionListener(this);
        cmdAllOn.addActionListener(this);
        add(cmdAllOff);
        add(cmdSwitchBulb);
        add(cmdAllOn);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        LightBulb[] bulbs = new LightBulb[4];
        bulbs[0] = disc.getFirstBulb();
        bulbs[1] = disc.getSecondBulb();
        bulbs[2] = disc.getThirdBulb();
        bulbs[3] = disc.getFourthBulb();
        int w = getWidth();
        int h = getHeight();
        int jump = 20;
        for(int i = 0; i < 4; i++)
        {
            RGBColorOld rgb = bulbs[i].getColor();
            Color c = new Color(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
            if(bulbs[i].isSwitchedOn())
                g.setColor(c);
            else
                g.setColor(Color.BLACK);
            g.fillOval(jump, h/10, 60, 60);
            jump += w/4;
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == cmdAllOff)
            disc.turnAllOff();
        else if(e.getSource() == cmdSwitchBulb)
        {
            String res = JOptionPane.showInputDialog(this, "Enter bulb number to switch");
            int num;
            try {
                num = Integer.parseInt(res);
                disc.switchBulb(num);
            }
            catch(NumberFormatException ex){}   
        }
        else if(e.getSource() == cmdAllOn)
            disc.turnAllOn();
        
        repaint();
    }

}
