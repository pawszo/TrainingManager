package window;

import screens.ComposerPanel;
import screens.NotePanel;
import screens.TrainingPanel;
import screens.UserPanel;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private JPanel mainPanel;
    private UserPanel userPanel;
    private ComposerPanel composerPanel;
    private TrainingPanel trainingPanel;
    private NotePanel notePanel;

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
        createUserPanel(dim, this);
        createComposerPanel(dim, this);
        createTrainingPanel(dim, this);
        createNotePanel(dim, this);

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

    private void createUserPanel(Dimension dim, Frame frame) {
        userPanel = new UserPanel(dim, frame);
        mainPanel.add(userPanel, USERPANEL);
    }
    private void createComposerPanel(Dimension dim, Frame frame) {
        composerPanel = new ComposerPanel(dim, frame);
        mainPanel.add(composerPanel, COMPOSERPANEL);

    }
    private void createTrainingPanel(Dimension dim, Frame frame) {
        trainingPanel = new TrainingPanel(dim, frame);
        mainPanel.add(trainingPanel, TRAININGPANEL);

    }
    private void createNotePanel(Dimension dim, Frame frame) {
        notePanel = new NotePanel(dim, frame);
        mainPanel.add(notePanel, NOTEPANEL);
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }
    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public UserPanel getUserPanel() {
        return userPanel;
    }
    public void setUserPanel(UserPanel userPanel) {
        this.userPanel = userPanel;
    }

    public ComposerPanel getComposerPanel() {
        return composerPanel;
    }
    public void setComposerPanel(ComposerPanel composerPanel) {
        this.composerPanel = composerPanel;
    }

    public TrainingPanel getTrainingPanel() {
        return trainingPanel;
    }
    public void setTrainingPanel(TrainingPanel trainingPanel) {
        this.trainingPanel = trainingPanel;
    }

    public NotePanel getNotePanel() {
        return notePanel;
    }
    public void setNotePanel(NotePanel notePanel) {
        this.notePanel = notePanel;
    }

    public CardLayout getCl() {
        return cl;
    }
    public void setCl(CardLayout cl) {
        this.cl = cl;
    }
}
