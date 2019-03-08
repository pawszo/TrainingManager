package Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {

    public JMenu userMenu;
    public JMenuItem userMenuItem;

    public JMenu composerMenu;
    public JMenuItem composerMenuItem;

    public JMenu trainingMenu;
    public JMenuItem trainingMenuItem;

    public JMenu noteMenu;
    public JMenuItem noteMenuItem;


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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
