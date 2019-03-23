package window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {


    public JMenu userMenu, composerMenu, trainingMenu;
    public JMenuItem userMenuItem, composerMenuItem, trainingMenuItem, noteMenuItem, printoutsItem;
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
        composerMenu = new JMenu("Training plan");
        trainingMenu = new JMenu("Exercise");
    }

    private void createMenuItems() {
        userMenuItem = new JMenuItem("User");
        userMenuItem.addActionListener(this);

        composerMenuItem = new JMenuItem("Composer");
        composerMenuItem.addActionListener(this);

        trainingMenuItem = new JMenuItem("Stopwatch");
        trainingMenuItem.addActionListener(this);

        noteMenuItem = new JMenuItem("Notes");
        noteMenuItem.addActionListener(this);
        printoutsItem = new JMenuItem("Your training plans");
        printoutsItem.addActionListener(this);
    }

    private void addItemsToMenu() {
        userMenu.add(userMenuItem);
        composerMenu.add(composerMenuItem);
        composerMenu.add(printoutsItem);
        trainingMenu.add(trainingMenuItem);
        trainingMenu.add(noteMenuItem);
    }
    private void addMenuToBar() {
        add(userMenu);
        add(composerMenu);
        add(trainingMenu);
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
        if(actionEvent.getSource() == printoutsItem) {
            frame.getCl().show(frame.getMainPanel(), "PLANPANEL");
            System.out.println("PLANPANEL");
        }
    }

}
