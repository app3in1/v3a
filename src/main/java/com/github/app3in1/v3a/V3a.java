package com.github.app3in1.v3a;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V3a extends JFrame {

    private Timer timer;
    private int x, y, xDelta = 2, yDelta = 2;
    private JButton startButton, stopButton;
    private AnimatedPanel animatedPanel;

    public V3a() {
        x = y = 100;
        timer = new Timer(10, e -> {
            x += xDelta;
            y += yDelta;

            if (x + "Hello jDeploy".length() * 7 >= animatedPanel.getWidth() || x < 0) xDelta *= -1;
            if (y + 15 >= animatedPanel.getHeight() || y < 0) yDelta *= -1;

            animatedPanel.repaint();
        });

        startButton = new JButton("Start");
        startButton.addActionListener(e -> timer.start());

        stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> timer.stop());

        animatedPanel = new AnimatedPanel();

        setLayout(new BorderLayout());
        add(animatedPanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.NORTH);
        add(stopButton, BorderLayout.SOUTH);
    }

    class AnimatedPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("Hello jDeploy 8", x, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            V3a frame = new V3a();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }
}
