package exercise;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import usr.DBcon;
import usr.User;

import java.io.*;
import java.util.ArrayList;

public class Plan {

    private ArrayList<String> exercises = new ArrayList<>();
    private ArrayList<String> muscles = new ArrayList<>();
    private String name;

    public void addMuscle(String scoreLabel) {
        muscles.add(scoreLabel);
    }

    public void addExercise(String exercise) {
        exercises.add(exercise);

    }

    public void setExercises(Object[] jlist) {
        for(Object c:jlist) {
            exercises.add(c.toString());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String planName = "Training plan created on ";
        return planName;
    }

    public void createPDF() throws IOException {
            PDDocument document = new PDDocument();  //CREATE EMPTY DOCUMENT;
            PDPage page1 = new PDPage(); //CREATE PAGE 1
            PDPage page2 = new PDPage(); //CREATE PAGE 2
            document.addPage(page1);
            document.addPage(page2);
            PDPageContentStream contentStream = new PDPageContentStream(document, page1);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 22 );
        contentStream.newLineAtOffset(40, 750);
        contentStream.setLeading(30f);


        contentStream.showText("MY TRAINING PLAN");
        contentStream.newLine(); contentStream.newLine();
        contentStream.showText("OWNER: " + User.currentUser.getUserName());
        contentStream.newLine();contentStream.newLine();

        for(int i = 0; i < exercises.size(); i++) {
            contentStream.showText(exercises.get(i));
            contentStream.newLine();
        }
        contentStream.endText();
        contentStream.close();

        PDPageContentStream contentStream2 = new PDPageContentStream(document, page2);
        contentStream2.beginText();
        contentStream2.setFont(PDType1Font.COURIER, 16);
        contentStream2.newLineAtOffset(40, 700);
        contentStream2.setLeading(25f);
        contentStream2.showText("TRAINED MUSCLES: ");
        contentStream2.newLine();
        contentStream2.showText("(0 = not trained. Score over 5 may overtrain muscles.)");
        contentStream2.newLine();
        contentStream2.newLine();
        for(int i = 0; i < muscles.size(); i++) {
            contentStream2.showText(muscles.get(i));
            contentStream2.newLine();
        }
        contentStream2.endText();
        contentStream2.close();

            File file = File.createTempFile("tempfile", "pdf");
            document.save(file);
            document.save("/home/nitropawel/Documents/test.pdf");

            DBcon.uploadPlanPDF(file, "TEST");
            document.close();
    }

}
