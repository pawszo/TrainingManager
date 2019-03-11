package screens;

import exercise.Exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Panel where you compose a traning plan from
 */
public class ComposerPanel extends JPanel implements ActionListener {

    private JComboBox bodypartBox, excBox;
    private int[] ABSexc, ARMexc, BACKexc, SHOULDERexc, LEGexc, BUTTOCKexc, HIPexc, CHESTexc, currMuscle;
    private String[] bodyparts, currBodypartString;
    private String currExc;
    private Exercise currExcDet;
    public LinkedHashMap<Integer, String> muscleMap;
    public ArrayList<String> excMap;


    public ComposerPanel(Dimension dim) {
        setSize(dim);
        setBackground(Color.yellow);
        createMuscleMap();
        createExcMap();
        createMuscleArr();
        bodyparts = new String[] {"Choose muscle group","abs","arms","shoulders","back","legs","buttocks","hips","chest"};
        currBodypartString = new String[] {"Choose exercise"};
        bodypartBox = new JComboBox(bodyparts);
        excBox = new JComboBox((String[]) (currBodypartString));
        bodypartBox.addActionListener(this);
        excBox.addActionListener(this);
        add(bodypartBox);
        add(excBox);


    }

    private void createMuscleMap() {
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
               for(String primMuscle: currExcDet.primMuscles) System.out.println(primMuscle);
            }
        }



    }
}
