package at.htlklu.fsst.presentation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

import at.htlklu.fsst.Settings;
import at.htlklu.fsst.Shape;
import at.htlklu.fsst.ShapeTool;

public class ShapePanel extends JPanel implements MouseListener {

	private List<Shape> shapes;
	private final List<Settings> settings;

	public ShapePanel() {
		addMouseListener(this);
		this.settings = ShapeTool.readSettings("settings.txt");
	}

	@Override
	protected void paintComponent(Graphics g) {
		final Graphics2D graphics = (Graphics2D) g;
		super.paintComponent(g);
		if (shapes != null) {
			shapes.forEach(e -> e.paint(graphics));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		shapes = ShapeTool.generateRandomShapes(30);
		ShapeTool.setPositionAndColors(settings, shapes, getWidth(), getHeight());
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
