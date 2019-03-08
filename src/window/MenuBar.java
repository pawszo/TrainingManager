package window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {

    public static String panel;

    public JMenu userMenu;
    public JMenuItem userMenuItem;

    public JMenu composerMenu;
    public JMenuItem composerMenuItem;

    public JMenu trainingMenu;
    public JMenuItem trainingMenuItem;

    public JMenu noteMenu;
    public JMenuItem noteMenuItem;

    public Frame frame;

    public MenuBar() {
        createMenu();
        createMenuItems();
        addItemsToMenu();
        addMenuToBar();
        setVisible(true);

    }

    private void createMenu() {
        userMenu = new JMenu("User");
        composerMenu = new JMenu("Compose plan");
        trainingMenu = new JMenu("Exercise");
        noteMenu = new JMenu("Notes");
    }

    private void createMenuItems() {
        userMenuItem = new JMenuItem("User");
        userMenuItem.addActionListener(this);

        composerMenuItem = new JMenuItem("Composer");
        composerMenuItem.addActionListener(this);

        trainingMenuItem = new JMenuItem("Training");
        trainingMenuItem.addActionListener(this);

        noteMenuItem = new JMenuItem("Note");
        noteMenuItem.addActionListener(this);
    }

    private void addItemsToMenu() {
        userMenu.add(userMenuItem);
        composerMenu.add(composerMenuItem);
        trainingMenu.add(trainingMenuItem);
        noteMenu.add(noteMenuItem);
    }
    private void addMenuToBar() {
        add(userMenu);
        add(composerMenu);
        add(trainingMenu);
        add(noteMenu);
    }
    public void addFrame(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == userMenuItem) {
            frame.getCl().show(frame.getMainPanel(), "USERPANEL");
            System.out.println("USERPANEL");
        }
        if(actionEvent.getSource() == composerMenuItem) {
            frame.getCl().show(frame.getMainPanel(), "COMPOSERPANEL");
            System.out.println("COMPOSERPANEL");
        }
        if(actionEvent.getSource() == trainingMenuItem) {
            frame.getCl().show(frame.getMainPanel(), "TRAININGPANEL");
            System.out.println("TRAININGPANEL");
        }
        if(actionEvent.getSource() == noteMenuItem) {
            frame.getCl().show(frame.getMainPanel(), "NOTEPANEL");
            System.out.println("NOTEPANEL");
        }
    }
}
