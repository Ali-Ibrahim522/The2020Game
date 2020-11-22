package ibrahim;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author caveb
 */
public class The2020Game {

    /**
     * @param args the command line arguments
     */
    private static JLabel lblBrd;
    private static JLabel lblDice;
    private static JLayeredPane images;
    private static JButton btnRoll;
    private static JTextArea txtDisplay;
    private static JTextField txtHealth;
    private static int health;
    private static gameBoard game;
    private static JFrame gameWindow;
    private static JLabel lblPlyr;
    private static Player plyr;
    private static JTextArea txtInstructions;
    private static JButton btnPlay;
    
    public static void main(String[] args) {
       //part 1
       
       health = 15;
       plyr = new Player();
       game = new gameBoard();
       images = new JLayeredPane();
       btnRoll = new JButton("ROLL");
       btnPlay = new JButton("PLAY!!!");
       txtDisplay = new JTextArea(game.getBoardSlot(0).getEffect());
       txtInstructions = new JTextArea("HOW TO PLAY:\n \nThis is a board game to where the objective is to make it to the end of the\nboard without dying from loss of health or corona. Every turn you roll a dice\nand depending on the the dice number, move up a certain amount of tiles.\nOn the tile you land on there may be a symbol with a '+', '-', '+/-', a skull and\nbones, or nothing."
       + ". If you land on a +, you gain health equal to how many spots\nyou moved, if you landed on a minus you lose health equal to the amount you\nmoved. If you land on a +/-, you could lose or gain health depending on the\ncondition shown in the center text box, lastly landing on a blank tile will do\nnothing to you. If you think you're ready press play to start the game!");
       txtHealth = new JTextField("HEALTH: " + health);
       images.setBounds(0, 0, 600, 600);
       gameWindow = new JFrame();
       gameWindow.add(btnPlay);
       gameWindow.add(btnRoll);
       gameWindow.add(txtHealth);
       gameWindow.add(txtDisplay);
       gameWindow.add(images);
       gameWindow.add(txtInstructions);
       gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       gameWindow.setSize(new Dimension(615, 639));
       gameWindow.setLayout(null);
       lblPlyr = new JLabel();
       lblPlyr.setOpaque(false);
       lblPlyr.setIcon(new ImageIcon(gameWindow.getClass().getResource("/images/player.png")));
       lblPlyr.setBounds(game.getBoardSlot(0).getxPosition(), game.getBoardSlot(0).getyPosition(), 25, 25);
       lblBrd = new JLabel();
       lblBrd.setOpaque(true);
       lblBrd.setIcon(new ImageIcon(gameWindow.getClass().getResource("/images/boardgame.png")));
       lblBrd.setBounds(0, 0, 600, 600);
       lblDice = new JLabel();
       lblDice.setOpaque(true);
       lblDice.setIcon(new ImageIcon(gameWindow.getClass().getResource("/images/d3.png")));
       lblDice.setBounds(95, 380, 125, 125);
       images.add(lblPlyr);
       images.add(lblBrd);
       images.add(lblDice, JLayeredPane.DRAG_LAYER);
       
       
       //part 2
       
       //txtDisplay.setSize(int x, int y);
       //txtDisplay.setText(String txt);
       txtDisplay.setBounds(225, 95, 280, 175);
       txtDisplay.setEditable(false);
       txtDisplay.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
       txtHealth.setBounds(325, 275, 180, 75);
       txtHealth.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 25));
       txtHealth.setOpaque(false);
       txtHealth.setEditable(false);
       btnRoll.setBounds(325, 430, 180, 75);
       //btnRoll.isSelected();
       lblBrd.hide();
       lblDice.hide();
       btnRoll.hide();
       txtDisplay.hide();
       txtHealth.hide();
       lblPlyr.hide();
       txtInstructions.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
       txtInstructions.setBounds(0, 0, 615, 639);
       btnPlay.setBounds(200, 300, 180, 75);
       gameWindow.setVisible(true);
       addEventHandlers();
       
    }
    
    private static void addEventHandlers() {
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtInstructions.hide();
                btnPlay.hide();
                lblBrd.show();
                lblDice.show();
                btnRoll.show();
                txtDisplay.show();
                txtHealth.show();
                lblPlyr.show();
            }
        });
        btnRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int roll = Dice.roll();
                if (plyr.getIndex() + roll <= 23) {
                    int pastIndex = plyr.getIndex() + roll;
                    plyr.setIndex(pastIndex);
                    txtDisplay.setText(game.getBoardSlot(plyr.getIndex()).getEffect());
                    lblDice.setIcon(new ImageIcon(gameWindow.getClass().getResource(Dice.setDiceIcon(roll))));
                    if (game.getBoardSlot(plyr.getIndex()).getPlusOrMinus().equals("DEATH")) {
                        plyr.setIndex(0);
                        lblPlyr.setBounds(game.getBoardSlot(plyr.getIndex()).getxPosition(), game.getBoardSlot(plyr.getIndex()).getyPosition(), 25, 25);
                        health = 15;
                        txtHealth.setText("HEALTH: " + health);
                    } else {
                        if (game.getBoardSlot(plyr.getIndex()).getPlusOrMinus().equals("-")) {
                            if (health - roll <= 0) {
                                txtDisplay.setText("YOU HAVE LOST THE GAME\n \nyou have been sent back to the start");
                                //moved back to back-end start
                                plyr.setIndex(0);
                                //moved back to start
                                lblPlyr.setBounds(game.getBoardSlot(plyr.getIndex()).getxPosition(), game.getBoardSlot(plyr.getIndex()).getyPosition(), 25, 25);
                                //reset health
                                health = 15;
                                txtHealth.setText("HEALTH: " + health);
                            } else {
                                //move player icon
                                lblPlyr.setBounds(game.getBoardSlot(plyr.getIndex()).getxPosition(), game.getBoardSlot(plyr.getIndex()).getyPosition(), 25, 25);
                                //change health accordigly
                                health -= roll;
                                txtHealth.setText("HEALTH: " + health);
                            }

                        } else if (game.getBoardSlot(plyr.getIndex()).getPlusOrMinus().equals("+")) {
                            //move player icon
                                lblPlyr.setBounds(game.getBoardSlot(plyr.getIndex()).getxPosition(), game.getBoardSlot(plyr.getIndex()).getyPosition(), 25, 25);
                                //change health accordigly
                                health += roll;
                                txtHealth.setText("HEALTH: " + health);
                        } else if (game.getBoardSlot(plyr.getIndex()).getPlusOrMinus().equals("+/-")) {
                            lblPlyr.setBounds(game.getBoardSlot(plyr.getIndex()).getxPosition(), game.getBoardSlot(plyr.getIndex()).getyPosition(), 25, 25);
                            if (plyr.getIndex() == 8) {
                                if (roll % 2 == 0) {
                                    health += roll;
                                    txtHealth.setText("HEALTH: " + health);
                                } else {
                                    if (health - roll <= 0) {
                                        txtDisplay.setText("YOU HAVE LOST THE GAME\n \nyou have been sent back to the start");
                                        //moved back to back-end start
                                        plyr.setIndex(0);
                                        //moved back to start
                                        lblPlyr.setBounds(game.getBoardSlot(plyr.getIndex()).getxPosition(), game.getBoardSlot(plyr.getIndex()).getyPosition(), 25, 25);
                                        //reset health
                                        health = 15;
                                        txtHealth.setText("HEALTH: " + health);
                                    } else {
                                        //change health accordigly
                                        health -= roll;
                                        txtHealth.setText("HEALTH: " + health);
                                    }
                                }
                            } else if (plyr.getIndex() == 13) {
                                if (roll == 1 || roll == 2 || roll == 3) {
                                    health += roll;
                                    txtHealth.setText("HEALTH: " + health);
                                } else {
                                    if (health - roll <= 0) {
                                        txtDisplay.setText("YOU HAVE LOST THE GAME\n \nyou have been sent back to the start");
                                        //moved back to back-end start
                                        plyr.setIndex(0);
                                        //moved back to start
                                        lblPlyr.setBounds(game.getBoardSlot(plyr.getIndex()).getxPosition(), game.getBoardSlot(plyr.getIndex()).getyPosition(), 25, 25);
                                        //reset health
                                        health = 15;
                                        txtHealth.setText("HEALTH: " + health);
                                    } else {
                                        //change health accordigly
                                        health -= roll;
                                        txtHealth.setText("HEALTH: " + health);
                                    }
                                }
                            } else if (plyr.getIndex() == 22) {
                                if (!(health % 2 == 0)) {
                                    health += roll;
                                    txtHealth.setText("HEALTH: " + health);
                                } else {
                                    if (health - roll <= 0) {
                                        txtDisplay.setText("YOU HAVE LOST THE GAME\n \nyou have been sent back to the start");
                                        //moved back to back-end start
                                        plyr.setIndex(0);
                                        //moved back to start
                                        lblPlyr.setBounds(game.getBoardSlot(plyr.getIndex()).getxPosition(), game.getBoardSlot(plyr.getIndex()).getyPosition(), 25, 25);
                                        //reset health
                                        health = 15;
                                        txtHealth.setText("HEALTH: " + health);
                                    } else {
                                        //change health accordigly
                                        health -= roll;
                                        txtHealth.setText("HEALTH: " + health);
                                    }
                                }
                            }
                        } else {
                            lblPlyr.setBounds(game.getBoardSlot(plyr.getIndex()).getxPosition(), game.getBoardSlot(plyr.getIndex()).getyPosition(), 25, 25);
                        }
                    }
                } else {
                    txtDisplay.setText("YOU HAVE WON THE GAME!!!!\n \nroll the dice to play again");
                    //moved back to back-end start
                    plyr.setIndex(0);
                    //moved back to start
                    lblPlyr.setBounds(game.getBoardSlot(plyr.getIndex()).getxPosition(), game.getBoardSlot(plyr.getIndex()).getyPosition(), 25, 25);
                    //reset health
                    health = 15;
                    txtHealth.setText("HEALTH: " + health);
                }
            }
        });
    }
}
