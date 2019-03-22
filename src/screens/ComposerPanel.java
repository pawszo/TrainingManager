package screens;

import exercise.DetailPanel;
import exercise.Exercise;
import exercise.MuscleScoreLabel;
import exercise.TrainingList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Panel where you compose a traning plan from
 */
public class ComposerPanel extends JPanel implements ActionListener, FocusListener {

    private JComboBox bodypartBox, excBox;
    private JTextField weight, repetitions;
    private int[] ABSexc, ARMexc, BACKexc, SHOULDERexc, LEGexc, BUTTOCKexc, HIPexc, CHESTexc, currMuscle;
    private String[] bodyparts, currBodypartString;
    private String currExc;
    private Exercise currExcDet;
    private LinkedList<Exercise> list;
    public static LinkedHashMap<Integer, String> muscleMap;
    public ArrayList<String> excMap;
    private JPanel detailPanel1, detailPanel2, detailPanel3;
    private DetailPanel detailPanel4;

    private JTextArea textField1;
    private JTextArea textField2;
    private JButton addToList, removeFromList, save;
    private JList trainingList;
    private DefaultListModel listmodel;

    public ComposerPanel(Dimension dim) {
        setSize(dim);
        setBackground(Color.yellow);
        setLayout(new GridLayout(2, 2));
        createMuscleMap();
        createExcMap();
        createMuscleArr();
        createTextFields();
        createButtons();
        createCBoxes();
        createTrainingList();
        createDetailPanels();

        addComponentsToPanels();

        list = new LinkedList<Exercise>();
    }
    private void createTrainingList() {
        trainingList = new TrainingList();
        trainingList.setVisibleRowCount(5);
        trainingList.setLayoutOrientation((int) JList.LEFT_ALIGNMENT);
        listmodel = new DefaultListModel();
    }
    private void createCBoxes() {
        bodyparts = new String[] {"Choose muscle group","abs","arms","shoulders","back","legs","buttocks","hips","chest"};
        currBodypartString = new String[] {"Choose exercise"};
        bodypartBox = new JComboBox(bodyparts);
        excBox = new JComboBox((String[]) (currBodypartString));
        bodypartBox.addActionListener(this);
        excBox.addActionListener(this);
    }
    private void createButtons() {
        addToList = new JButton("Add to your list");
        addToList.addActionListener(this);
        removeFromList = new JButton("Remove from your list");
        removeFromList.addActionListener(this);
        save = new JButton("SAVE PLAN FOR PRINTOUT");
        save.addActionListener(this);
    }

    private void addComponentsToPanels() {
        detailPanel3.add(trainingList);
        detailPanel2.add(textField1);
        detailPanel2.add(textField2);
        add(detailPanel1);
        add(detailPanel2);
        add(detailPanel3);
        add(detailPanel4);
    }
    private void createTextFields() {
        weight = new JTextField(10);
        weight.setText("Weight in KGs");
        weight.setToolTipText("Enter weight in KGs here");
        weight.addFocusListener(this);
        repetitions = new JTextField(10);
        repetitions.setText("Enter total number of repetitions here");
        repetitions.setToolTipText("Enter total number of repetitions here");
        repetitions.addFocusListener(this);
        textField1 = new JTextArea("PRIMARY MUSCLES:");
        textField1.setPreferredSize(new Dimension(220, 200));
        textField1.setLayout(new GridLayout(3, 1, 60, 60));
        textField1.setEditable(false);
        textField2 = new JTextArea("SECONDARY MUSCLES:");
        textField2.setPreferredSize(new Dimension(220, 200));
        textField2.setLayout(new GridLayout(2, 1, 60, 60));
        textField2.setEditable(false);
    }
    private void createDetailPanels() {
        detailPanel1 = new DetailPanel(new Color(144, 200, 159));
        detailPanel1.setLayout(new GridLayout(10, 1));
        detailPanel1.add(new JLabel("User the dropdown to select preferred exercise"));
        detailPanel1.add(bodypartBox);
        detailPanel1.add(excBox);
        detailPanel1.add(new JLabel("Enter weight: "));
        detailPanel1.add(weight);
        detailPanel1.add(new JLabel("Enter repetitions: "));
        detailPanel1.add(repetitions);
        detailPanel1.add(addToList);
        detailPanel1.add(removeFromList);
        detailPanel1.add(save);
        detailPanel2 = new DetailPanel(Color.yellow);
        detailPanel3 = new DetailPanel(Color.white);
        detailPanel4 = new DetailPanel(new Color(193, 200, 167), true);
    }

    public static void createMuscleMap() {
        muscleMap = new LinkedHashMap<Integer, String>();
        muscleMap.put(1, "Abdominals");
        muscleMap.put(2, "Obliques");
        muscleMap.put(3, "Serratus anterior");
        muscleMap.put(4, "Biceps");
        muscleMap.put(5, "Forearms");
        muscleMap.put(6, "Triceps");
        muscleMap.put(7, "Anterior delts");
        muscleMap.put(8, "Lateral delts");
        muscleMap.put(9, "Posterior delts");
        muscleMap.put(10, "Erector spinae");
        muscleMap.put(11, "Infraspinatus");
        muscleMap.put(12, "Latissimus dorsi (Lats)");
        muscleMap.put(13, "Teres");
        muscleMap.put(14, "Trapezius");
        muscleMap.put(15, "Calves");
        muscleMap.put(16, "Hamstrings");
        muscleMap.put(17, "Quads");
        muscleMap.put(18, "Sartorius");
        muscleMap.put(19, "Tibialis_anterior");
        muscleMap.put(20, "Gluteus maximus");
        muscleMap.put(21, "Gluteus medius");
        muscleMap.put(22, "Hip adductors");
        muscleMap.put(23, "Hip Flexors");
        muscleMap.put(24, "Tensor fasciae latae");
        muscleMap.put(25, "Pectoralis major");
    }
    private void createExcMap() {
        excMap = new ArrayList<String>();
        excMap.add("Choose exercise");
        excMap.add("Cable crunches"); // 2
        excMap.add("Crunches");
        excMap.add("Hanging leg raising");
        excMap.add("Elbows and Toes Isometric Hold");
        excMap.add("Lying Side Leg Raises"); // case 6
        excMap.add("Seated Twists");
        excMap.add("Twisting Crunches"); //8
        excMap.add("Side Plank with Straight Leg");
        excMap.add("Seated Dumbbell Curls"); //10
        excMap.add("Standing Barbell Curl");
        excMap.add("Standing Dumbbell Curls"); //12
        excMap.add("Standing Two Hand Cable Curls");
        excMap.add("Dumbbell Preacher Curls"); //14
        excMap.add("Reverse Barbell Curls");
        excMap.add("Seated Barbell Wrist Curls"); //16
        excMap.add("Seated Reverse Dumbbell Wrist Curls");
        excMap.add("Dumbbell Kickbacks"); //18
        excMap.add("Lying Triceps Extensions");
        excMap.add("Seated Overhead Barbell Extensions"); //20
        excMap.add("Triceps Cable Pushdowns");
        excMap.add("Triceps Cable Pushdowns with Rope"); //22
        excMap.add("Arnold Dumbbell Presses");
        excMap.add("Front Dumbbell Raises"); //24
        excMap.add("Military Presses");
        excMap.add("Barbell Shrugs");        //26
        excMap.add("Bent Over Barbell Rows");
        excMap.add("Deadlifts"); //28
        excMap.add("Dumbbell Shrugs");
        excMap.add("Machine Pulldowns"); //30
        excMap.add("Wide Grip Chins");
        excMap.add("Neutral Grip Chins"); //32
        excMap.add("Seated Cable Rows");
        excMap.add("One Arm Dumbbell Rows"); //34
        excMap.add("Barbell Squats");
        excMap.add("Barbell Straight Leg Deadlift"); //36
        excMap.add("Calf Raises");
        excMap.add("Dumbbell Lunges"); //38
        excMap.add("Machine Hamstring Curls");
        excMap.add("Leg Presses");  //40
        excMap.add("Hamstring Kickback");
        excMap.add("Home Squats");   //42
        excMap.add("Outer Thighs Machine");
        excMap.add("Inner Thighs Machine"); //44
        excMap.add("Barbell Incline Bench Presses");
        excMap.add("Decline Barbell Presses"); //46
        excMap.add("Flat Dumbbell Flyes");
        excMap.add("Dumbbell Flat Bench Presses"); //48
        excMap.add("Push-ups");
        excMap.add("Standing Cable Crossovers"); //50
        excMap.add("Parallel Bar Dips");
    }

    private void createMuscleArr() {
        ABSexc = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        ARMexc = new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        BACKexc = new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33};
        LEGexc = new int[]{34, 35, 36, 37, 38, 39};
        BUTTOCKexc = new int[]{40, 41};
        CHESTexc = new int[]{44, 45, 46, 47, 48, 49, 50};
        SHOULDERexc = new int[]{22, 23, 24};
        HIPexc = new int[]{42, 43};
    }
    private void createExcBox(String bodypart) {
        excBox.removeAllItems();
   //     excBox.addItem("Choose exercise");
        switch(bodypart) {
            case "abs":
                currMuscle = ABSexc;
                break;
            case "chest":
                currMuscle = CHESTexc;
                break;
            case "back":
                currMuscle = BACKexc;
                break;
            case "legs":
                currMuscle = LEGexc;
                break;
            case "buttocks":
                currMuscle = BUTTOCKexc;
                break;
            case "hips":
                currMuscle = HIPexc;
                break;
            default:
                currMuscle = ARMexc;
                break;
        }
        for(int i:currMuscle) {
            excBox.addItem(excMap.get(i));
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == bodypartBox) {
            bodypartBox.removeItem("Choose muscle group");
            for (String s : bodyparts) {
                if (bodypartBox.getSelectedItem().equals(s)) {
               //     System.out.println(s);
                    createExcBox(s);

                }

            }
        }
        if(actionEvent.getSource() == excBox) {
            if(excBox.getSelectedItem() != null && !excBox.getSelectedItem().equals("Choose exercise")) {
                currExc = (String) excBox.getSelectedItem();
         //       System.out.println(currExc);
         //       System.out.println(excMap.indexOf(currExc));
                currExcDet = new Exercise(currExc, this);
                list.add(new Exercise(currExc, this));

                String txtfld1 = "PRIMARY MUSCLES:\n";
                String txtfld2 = "SECONDARY MUSCLES:\n";
               for(String primMuscle: currExcDet.primMuscles) txtfld1 += primMuscle + "\n";
               for(String secMuscle: currExcDet.secMuscles) txtfld2 += secMuscle + "\n";
               textField1.setText(txtfld1);
               textField2.setText(txtfld2);
            }
        }
        if((actionEvent.getSource() == addToList) && currExcDet != null) {
            String wgh = weight.getText();
            String reps = repetitions.getText();

            String name = currExcDet.getCurrExc();
            listmodel.addElement(name + " x " + wgh + " kg x " + reps + " reps.");
            trainingList.setModel(listmodel);
           // System.out.println(currExcDet.getCurrExc());
            for(MuscleScoreLabel m: detailPanel4.getPlanScore()) {
                for(String muscP:currExcDet.primMuscles) {


                    if (m.getMuscle().equals(muscP)) {
                        System.out.println(muscP);
                        m.increase();
                        m.increase();
                        m.setNewText();
                    }
                }
                for(String muscS:currExcDet.secMuscles) {


                    if (m.getMuscle().equals(muscS)) {
                        System.out.println(muscS);
                        m.increase();
                        m.setNewText();
                    }
                }
            }

        }
        if(actionEvent.getSource() == removeFromList) {
            if(!trainingList.isSelectionEmpty()) {
                listmodel.removeElement(trainingList.getSelectedValue());
                System.out.println("TEST");
            }
        }



    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        if(focusEvent.getSource() == weight) {
            if(weight.getText().equals("Weight in KGs")) {
                weight.setText("");
            }
        }
        if(focusEvent.getSource() == repetitions) {
            if(repetitions.getText().equals("Enter total number of repetitions here")) {
                repetitions.setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        if(focusEvent.getSource() == weight) {
            if(weight.getText().equals("")) {
                weight.setText("Weight in KGs");
            }
        }
        if(focusEvent.getSource() == repetitions) {
            if(repetitions.getText().equals("")) {
                repetitions.setText("Enter total number of repetitions here");
            }
        }
    }
}
