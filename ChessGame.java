package java8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessGame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final JPanel boardPanel;
    private final JButton[][] squares;
    private final JLabel scoreLabel;
    private int score;
    private int currentPlayer;
    private final boolean isGameOver;

    public ChessGame() {
        setTitle("Chess Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boardPanel = new JPanel(new GridLayout(8, 8));
        squares = new JButton[8][8];
        scoreLabel = new JLabel("Score: 0");
        JLabel timerLabel = new JLabel("Time: 0");
        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(scoreLabel);
        controlPanel.add(timerLabel);

        initializeBoard();
        add(boardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        currentPlayer = 1;
        isGameOver = false;

        setVisible(true);
    }

    private void initializeBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squares[row][col] = new JButton();
                squares[row][col].setBackground(getSquareColor(row, col));
                squares[row][col].addActionListener(new SquareClickListener(row, col));
                boardPanel.add(squares[row][col]);
            }
        }
    }

    private Color getSquareColor(int row, int col) {
        if ((row + col) % 2 == 0) {
            return Color.WHITE;
        } else {
            return Color.GRAY;
        }
    }

    private class SquareClickListener implements ActionListener {
        private final int row;
        private final int col;

        public SquareClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isGameOver) {
                // 处理移动棋子和更新分数的逻辑
                // 基于单击的正方形

                // Example:
                score += 1;
                scoreLabel.setText("Score: " + score);

                // Example: 更改单击的正方形的背景色
                squares[row][col].setBackground(Color.YELLOW);

                // Example: Switch the current player
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }
        }
    }

    public static void main(String[] args) {
        new ChessGame();
    }
}
