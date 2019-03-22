package screens;

import usr.DBcon;
import usr.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NotePanel extends JPanel implements ActionListener {

    private JTextField noteField;
    private JTextArea zoomField;
    private JButton addButton, deleteButton, zoomButton, syncButton;
    private JList<String> noteList;
    private JPanel buttonPanel, toolPanel;
    private static DefaultListModel listmodel;
    private JDialog zoomDialog;
    private Frame frame;


    public NotePanel(Dimension dim, Frame frame) {
        this.frame = frame;
        setSize(dim);
        setBackground(Color.pink);
        setLayout(new GridLayout(1, 2));
        createComponents();
        addComponents();

    }

    private void createComponents() {
        noteField = new JTextField();
        noteField.setToolTipText("Enter your training notes here");
        noteField.setHorizontalAlignment(0);

        addButton = new JButton("ADD NOTE");
        addButton.addActionListener(this);

        zoomButton = new JButton("VIEW FULL NOTE");
        zoomButton.addActionListener(this);
        zoomDialog = new JDialog();
        zoomDialog.setVisible(false);
        zoomField = new JTextArea();
        zoomField.setFont(new Font("Serif", Font.PLAIN, 32));
        zoomField.setLineWrap(true);

        syncButton =  new JButton("SYNCHRONIZE");
        syncButton.addActionListener(this);

        deleteButton =  new JButton("DELETE NOTE");
        deleteButton.addActionListener(this);

        noteList = new JList<>();
        noteList.setVisibleRowCount(5);
        noteList.setLayoutOrientation((int) JList.LEFT_ALIGNMENT);
        listmodel = new DefaultListModel();

        buttonPanel = new JPanel();
        toolPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        toolPanel.setLayout(new GridLayout(2, 1));

    }

    private void addComponents() {
        add(noteField);
        toolPanel.add(noteList);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(zoomButton);
        buttonPanel.add(syncButton);
        toolPanel.add(buttonPanel);
        add(toolPanel);
        noteList.setModel(listmodel);
        zoomDialog.add(zoomField);
    }

    public static void syncNoteList() {
        listmodel.removeAllElements();
        ArrayList<String> noteArray = DBcon.getNoteArrayList();
        for(String n:noteArray) {
            listmodel.addElement(n);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton) {
            String note = noteField.getText();
            DBcon.addNotes(note);
            syncNoteList();
            noteField.setText(null);

        }
        if(e.getSource() == deleteButton) {
            if(!noteList.isSelectionEmpty()) {
                DBcon.deleteNote(noteList.getSelectedValue());
                syncNoteList();
            }
        }
        if(e.getSource() == zoomButton) {
            if(!noteList.isSelectionEmpty()) {
                zoomField.setText(noteList.getSelectedValue());
                zoomDialog.setVisible(true);
                zoomDialog.setSize(new Dimension(600, 400));
                zoomDialog.requestFocus();
            }
        }
        if(e.getSource() == syncButton) {
            syncNoteList();
        }

    }
}
