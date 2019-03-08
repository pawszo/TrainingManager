package Window;

import javax.swing.*;
import java.awt.*;
import Window.MenuBar;

public class Frame extends JFrame {

    private JPanel mainPanel;
    private JPanel userPanel;
    private JPanel composerPanel;
    private JPanel trainingPanel;
    private JPanel notePanel;

    private Dimension dim;
    private CardLayout cl;

    public static String USERPANEL = "USERPANEL";
    public static String COMPOSERPANEL = "COMPOSERPANEL";
    public static String TRAININGPANEL = "TRAININGPANEL";
    public static String NOTEPANEL = "NOTEPANEL";


    public Frame(int width, int height, MenuBar menuBar) {
        setJMenuBar(menuBar);
        dim = new Dimension(width, height);
        setFrameProperties();

        createMainPanel();
        createUserPanel();
        createComposerPanel();
        createTrainingPanel();
        createNotePanel();

        cl = (CardLayout) (mainPanel.getLayout());


        add(mainPanel);
        pack();
        setVisible(true);
    }




    private void setFrameProperties() {
        setPreferredSize(dim);
        setLocation(450, 100);
        setDefaultCloseOperation(3);
        setResizable(false);
        requestFocus(true);
    }
    private void createMainPanel(){
        mainPanel = new JPanel(new CardLayout());
        mainPanel.setSize(dim);
        mainPanel.setBackground(Color.red);
    }

    private void createUserPanel() {
        userPanel = new JPanel();
        userPanel.setSize(dim);
        userPanel.setBackground(Color.ORANGE);
        mainPanel.add(userPanel);
    }
    private void createComposerPanel() {
        composerPanel = new JPanel();
        composerPanel.setSize(dim);
        composerPanel.setBackground(Color.yellow);
        mainPanel.add(composerPanel);

    }
    private void createTrainingPanel() {
        trainingPanel = new JPanel();
        trainingPanel.setSize(dim);
        trainingPanel.setBackground(Color.CYAN);
        mainPanel.add(trainingPanel);

    }

    private void createNotePanel() {
        notePanel = new JPanel();
        notePanel.setSize(dim);
        notePanel.setBackground(Color.pink);
        mainPanel.add(notePanel);

    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }


    public JPanel getUserPanel() {
        return userPanel;
    }

    public void setUserPanel(JPanel userPanel) {
        this.userPanel = userPanel;
    }

    public JPanel getComposerPanel() {
        return composerPanel;
    }

    public void setComposerPanel(JPanel composerPanel) {
        this.composerPanel = composerPanel;
    }

    public JPanel getTrainingPanel() {
        return trainingPanel;
    }

    public void setTrainingPanel(JPanel trainingPanel) {
        this.trainingPanel = trainingPanel;
    }

    public JPanel getNotePanel() {
        return notePanel;
    }

    public void setNotePanel(JPanel notePanel) {
        this.notePanel = notePanel;
    }

    public CardLayout getCl() {
        return cl;
    }

    public void setCl(CardLayout cl) {
        this.cl = cl;
    }
}
