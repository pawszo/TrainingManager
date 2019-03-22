package window;

import screens.ComposerPanel;
import screens.NotePanel;
import screens.TrainingPanel;
import screens.UserPanel;

import javax.swing.*;
import java.awt.*;

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
        createUserPanel(dim);
        createComposerPanel(dim);
        createTrainingPanel(dim);
        createNotePanel(dim);

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
        mainPanel.setBackground(new Color(115, 180, 179));
    }

    private void createUserPanel(Dimension dim) {
        userPanel = new UserPanel(dim);
        mainPanel.add(userPanel, USERPANEL);
    }
    private void createComposerPanel(Dimension dim) {
        composerPanel = new ComposerPanel(dim);
        mainPanel.add(composerPanel, COMPOSERPANEL);

    }
    private void createTrainingPanel(Dimension dim) {
        trainingPanel = new TrainingPanel(dim);
        mainPanel.add(trainingPanel, TRAININGPANEL);

    }
    private void createNotePanel(Dimension dim) {
        notePanel = new NotePanel(dim);
        mainPanel.add(notePanel, NOTEPANEL);
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
