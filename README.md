# StudentData

⦁	Create a class StudentData that saves data entered by the user in a text file. Use 4 JPanels in the JFrame using layout GridLayout (with 4 rows and 1 column). This layout assures that each panel (with default layout FlowLayout) will be rendered cleanly if the GUI is resized.
⦁	First panel: contains 2 JTextFields labelled Name and ID;
⦁	Second panel: contains 4 JCheckBoxes labelled Traditional, 1st Generation, Adult Student, and Veteran;
⦁	Third panel: contains 2 JRadioButtons labelled Female and Male; and
⦁	Fourth panel: contains 3 JButtons labelled New, Save, and Exit.

 

The New button clears the form and allows the user to enter more data, which does NOT have to be validated (i.e., assume the user fills the form out correctly). The Save button saves the data entered in a text file whose name is the Student ID field (in the example the name would be 987654321); the contents of the 987654321 file in the example would contain the strings:


   John Smith
   987654321
   first
   adult
   male


Use the Formatter class to populate the text file (and be sure to close it after writing it!). The Exit button exits the program AFTER warning the user using a JOptionPane modal window:

 

Ensure this window appears OVER the StudentData window by declaring and initializing:

   private Component parent = this;

in your program, and then pass the parent variable as the first parameter to the JOptionPane.showMessageDialog() method. If the user selects Yes, then exit the program.
