package screens;

import exercise.Plan;
import window.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlanPanel extends JPanel implements ActionListener {

    private Dimension dim;
    private Frame frame;
 //   private ArrayList<Plan> plans = new ArrayList<>();
    private JPanel lookupPanel, listPanel, buttonPanel;
    private JButton sendButton, deleteButton;
    private JList<Plan> plans;
    private DefaultListModel listmodel;

    public PlanPanel(Dimension dim, Frame frame) {
        this.dim = dim;
        this.frame = frame;
        setSize(dim);
        setBackground(Color.YELLOW);
        setLayout(new GridLayout(1, 2));
        createComponents();
        addComponents();
    }

    /** ADD PLAN FROM COMPOSERPANEL TO LIST AND CREATE A PDF. THEN SEND THE FILE TO THE DATABASE */
    public void addPlan(Plan plan) {
        listmodel.addElement(plan);
    }

    private void createComponents() {
        lookupPanel = new JPanel();
        listPanel = new JPanel();
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        listPanel.setLayout(new GridLayout(2, 1));
        sendButton = new JButton("Send by email");
        sendButton.addActionListener(this);
        deleteButton = new JButton("Delete plan");
        deleteButton.addActionListener(this);
        plans = new JList<>();
        listmodel = new DefaultListModel();
    }

    private void addComponents() {
        listPanel.add(plans);
        listPanel.add(buttonPanel);
        buttonPanel.add(sendButton);
        buttonPanel.add(deleteButton);
        plans.setModel(listmodel);
        add(lookupPanel);
        add(listPanel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
