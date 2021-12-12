package at.htlklu.mqttColorDisplay.presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import at.htlklu.mqttColorDisplay.domain.MqttColor;
import at.htlklu.mqttColorDisplay.domain.OnColorChanged;

public class MainPanel extends JPanel implements OnColorChanged{

	private Color displayColor = Color.BLACK;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(displayColor);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public void onColorChanged(MqttColor color) {
		switch(color) {
		case BLUE: displayColor = Color.BLUE;
			break;
		case GREEN: displayColor = Color.GREEN;
			break;
		case RED: displayColor = Color.RED;
			break;
		default:
			break;
		}
		
		repaint();
	}

}
