
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


// Create class that records student name, id, and other attributes, storing information into external file

public class StudentData extends JFrame {

    private JLabel messageLabel;
    private JLabel messageLabel2;
    private JTextField name;
    private JTextField id;
    private JCheckBox traditional;
    private JCheckBox firstGeneration;
    private JCheckBox adultStudent;
    private JCheckBox veteran;
    private JRadioButton female;
    private JRadioButton male;
    private JButton newButton;
    private JButton saveButton;
    private JButton exitButton;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    private String userCheckboxInput;
    private String userRadioInput;
    private ButtonGroup buttonGroup;

    private Component parent;


    // Create constructor for frame

    public StudentData() {

        // Create a title for the frame
        super("Student Data");

        // Designate the StudentData frame as the parent
        parent = this;

        // Set the border layout to GridLayout with 4 rows and 1 column
        setLayout(new GridLayout(4, 1));

        // Set the width (250) and height (400) of frame
        setSize(250, 400);
        // Set the windows to close when the close button is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Call the createPanel1, 2, 3, and 4 method
        createPanel1();
        createPanel2();
        createPanel3();
        createPanel4();

        // Add panel1, 2, 3, and 4 to the frame
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);


        // Make the window visible to the user
        setVisible(true);

    }


    // Create method to make panel1

    private void createPanel1() {


        // Create a new label, prompting the user to input the student name
        messageLabel = new JLabel("Name:");

        // Create a new text field, measured at 10 characters long to input name
        name = new JTextField(10);

        // Create a new panel, using the panel reference
        panel1 = new JPanel();

        // Add label, text field, to panel
        panel1.add(messageLabel);
        panel1.add(name);
    }


    // Create method to make panel2

    private void createPanel2() {


        // Create a new label, prompting the user to input student id
        messageLabel2 = new JLabel("Student ID:");

        // Create a new text field, measured at 10 characters long to input id
        id = new JTextField(10);

        // Create new checkbox handler object to give checkboxes functions
        CheckboxHandler checkboxHandler = new CheckboxHandler();

        // Create new checkbox labeled for traditional students
        traditional = new JCheckBox("Traditional");
        // Give traditional an item listener, allows it to add "traditional" to student qualities string when selected
        traditional.addItemListener(checkboxHandler);

        // Create new checkbox labeled for 1st generation college students
        firstGeneration = new JCheckBox("1st Generation");
        // Give firstGeneration an item listener, allows it to add "1st generation" to student qualities string when selected
        firstGeneration.addItemListener(checkboxHandler);

        // Create new checkbox labeled for adult college students
        adultStudent = new JCheckBox("Adult Student");
        // Give adultStudent an item listener, allows it to add "adult student" to student qualities string when selected
        adultStudent.addItemListener(checkboxHandler);

        // Create new checkbox labeled for veteran college students
        veteran = new JCheckBox("Veteran");
        // Give veteran an item listener, allows it to add "veteran" to student qualities string when selected
        veteran.addItemListener(checkboxHandler);

        // Create a new panel, using the panel reference
        panel2 = new JPanel();

        // Add label, text field, and four checkboxes to panel
        panel2.add(messageLabel2);
        panel2.add(id);
        panel2.add(traditional);
        panel2.add(firstGeneration);
        panel2.add(adultStudent);
        panel2.add(veteran);


    }


    // Create method to make panel3

    private void createPanel3() {

        // Create button new button group
        buttonGroup = new ButtonGroup();

        // Create new radio button handler to give buttons functions
        RadioHandler radioHandler = new RadioHandler();

        // Create a new label, labeled for female students
        female = new JRadioButton("Female");
        // Give female an item listener, allows it to add "female" to student qualities string when selected
        female.addItemListener(radioHandler);


        // Create a new label, labeled for male students
        male = new JRadioButton("Male");
        // Give male an item listener, allows it tp add "male" to student qualities string when selected
        male.addItemListener(radioHandler);

        // Add female to item group
        buttonGroup.add(female);
        // Add male to item group
        buttonGroup.add(male);

        // Create a new panel, using the panel reference
        panel3 = new JPanel();

        // Add 2 buttons to panel
        panel3.add(female);
        panel3.add(male);


    }


    private void createPanel4() {


        // Create a new button to reset user inputs
        newButton = new JButton("New");
        // Create a new action listener, allows program to reset
        newButton.addActionListener(new NewHandler());

        // Create a new button to save the user inputs
        saveButton = new JButton("Save");
        // Create a new action listener, allows program to save user inputs
        saveButton.addActionListener(new SaveHandler());

        // Create a new button to exit the program
        exitButton = new JButton("Exit");
        // Create a new action listener, allows program to prompt user with exit window
        exitButton.addActionListener(new ExitHandler());

        // Create a new panel, using the panel reference
        panel4 = new JPanel();

        // Add 3 buttons to panel
        panel4.add(newButton);
        panel4.add(saveButton);
        panel4.add(exitButton);
    }


    // Create item listener to give checkboxes personal information storage function

    private class CheckboxHandler implements ItemListener {

        public void itemStateChanged(ItemEvent e) {

            // Initialize user input as nothing for checkboxes
            userCheckboxInput = "";

            // When the user clicks on traditional...
            if (traditional.isSelected()) {
                // ...the label is added to the total student attributes
                userCheckboxInput = String.format("%s\ntraditional", userCheckboxInput);
            }
            // When the user clicks on firstGeneration...
            if (firstGeneration.isSelected()) {
                // ...the label is added to the total student attributes
                userCheckboxInput = String.format("%s\nfirst", userCheckboxInput);
            }
            // When the user clicks on adultStudent...
            if (adultStudent.isSelected()) {
                // ...the label is added to the total student attributes
                userCheckboxInput = String.format("%s\nadult", userCheckboxInput);
            }
            // When the user clicks on veteran...
            if (veteran.isSelected()) {
                // ...the label is added to the total student attributes
                userCheckboxInput = String.format("%s\nveteran", userCheckboxInput);
            }


        }
    }


    // Create item listener to give radio buttons personal information storage function

    private class RadioHandler implements ItemListener {

        public void itemStateChanged(ItemEvent e) {

            // When the female radio button is clicked on...
            if (female.isSelected()) {
                // ...the label is added to the student attribute
                userRadioInput = "female";
            }
            // When the male radio button is clicked on...
            if (male.isSelected()) {
                // ...the label is added to the student attribute
                userRadioInput = "male";
            }

        }
    }


    // Create action listener to clear user inputs

    private class NewHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // When an action is performed...

            // ...set name text box to nothing
            name.setText("");
            // ...set id text box to nothing
            id.setText("");
            // ...set traditional checkbox to unchecked
            traditional.setSelected(false);
            // ...set firstGeneration checkbox to unchecked
            firstGeneration.setSelected(false);
            // ...set adultStudent checkbox to unchecked
            adultStudent.setSelected(false);
            // ...set veteran checkbox to unchecked
            veteran.setSelected(false);

            // Call clearRadioGroup method
            clearRadioGroup();
        }
    }

    // Create method to clear radio group for male/female selection

    private void clearRadioGroup() {
        // Make buttons unchecked
        buttonGroup.clearSelection();
    }


    // Create action handler to save student information to external text file

    private class SaveHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Place id textbox information into .txt file name string variable
            String studentID = String.format("%s.txt", id.getText());

            // Place name, id, checkbox info, and radio info into string variable
            String userInput = String.format("%s\n%s\n%s\n%s", name.getText(), id.getText(),
                    userCheckboxInput, userRadioInput);

            try {

                // Create new file using studentID as the .txt file name
                File filename = new File(studentID);
                // Create file writer
                FileWriter fw = new FileWriter(filename);
                // Create buffered writer
                BufferedWriter bw = new BufferedWriter(fw);
                // Have buffered writer input student informatio into file
                bw.write(userInput);
                // Create new line
                bw.newLine();
                // Close buffered writer
                bw.close();
                // Close file writer
                fw.close();

            }
            // When the user-inputted file cannot be found...
            catch (IOException ioException) {
                // ...report to the user the error
                ioException.printStackTrace();
            }

        }
    }


    // Create action listener method that prompts the user to exit the program

    private class ExitHandler extends Component implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Place result of confirm dialogue into integer variable
            // Make dialogue window the child of parent window
            int result = JOptionPane.showConfirmDialog(this,
                    "Are you sure?","Exit Selected", JOptionPane.YES_NO_OPTION);

            // If the result of the confirm dialogue window was yes...
            if (result == JOptionPane.YES_OPTION) {

                // ...exits program with status code 0
                System.exit(0);
            }
        }
    }



}
