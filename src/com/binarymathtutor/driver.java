package com.binarymathtutor;
import javax.swing.JOptionPane;

public class driver {
    /**
     * main runs the program
     * @param args      Command-line arguments
     * @return          Returns void
     */

    public static void main(String[] args) {
        Object [] options = {"OK", "CANCEL"};

        //Below block of code creates initial dialog box for user to interact with. It also creates an instance of the
        //BinaryMathTutor class and an array of ProblemAndAnswer objects. It uses the member of the BinaryMathTutor
        // object to set value for ProblemAndAnswer array.

        int n = JOptionPane.showConfirmDialog(null, "Welcome to Dylan's Binary Math Tutor. \nLet's start " +
                "practicing.", "Dylan's Binary Math Tutor", JOptionPane.DEFAULT_OPTION);
        BinaryMathTutor mycheckedlist = new BinaryMathTutor();
        ProblemAndAnswer[] mylist;
        mylist = mycheckedlist.mylist;

        //Below if-statement handles if user tries exiting out of dialog box.
        if(n == -1) {
            JOptionPane.showMessageDialog(null, "Thanks for playing!", "Dylan's Binary Math Tutor", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }

        //Below while loop runs the program until user reaches end of 15 ProblemAndAnswer array, or quits.
        boolean newbool = true;
        while(newbool) {
            for (int i = 0; i < 15; i++) {
                //Gets problem from array of ProblemAndAnswer and asks user for input.
                String mystring = mylist[i].getProblem();
                String userAnswer = (String) JOptionPane.showInputDialog(null, mystring + " = ?",  "Dylan's Binary Math Tutor", JOptionPane.QUESTION_MESSAGE,null,null,"Your answer?");
                //If user tries quiting out of or cancelling the dialog box, the for-loop is exited.
                if(userAnswer == null)  {
                    i=15;
                }
                //If the user enters a response and continues with the program, the user's response is evaluated.
                else {
                    //Gets rid of any whitespace in useranswer
                    userAnswer = userAnswer.replaceAll("\\s", "");
                    String[] yesno = {"Yes", "No"};
                    //While-loop searches for any leading 0's in answer and discards them
                    while(userAnswer.charAt(0) == '0'){
                        StringBuilder modified = new StringBuilder(userAnswer);
                        modified.deleteCharAt(0);
                        userAnswer = modified.toString();
                    }
                    //If-else statements check answer and displays message accordingly
                    if (mylist[i].checkAnswer(userAnswer)) {
                        JOptionPane.showMessageDialog(null, "You are correct!", "Dylan's Binary Math Tutor", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry, but no. :(", "Dylan's Binary Math Tutor", JOptionPane.PLAIN_MESSAGE);
                    }
                    //Dialog box asks if user wishes to play again.
                    String input = (String) JOptionPane.showInputDialog(null, "Do you want to continue practicing? (Yes/No)",
                            "Dylan's Binary Math Tutor", JOptionPane.QUESTION_MESSAGE, null, yesno, yesno[0]);
                    String compare = null;
                    if (input == null || input.equals(yesno[1])) {
                        i = 15;
                    }
                }
            }
            //newbool is made false and while-loop comes to an end.
            newbool=false;
        }
        //Dialog box appears thanking user for playing before exiting the application.
        JOptionPane.showMessageDialog(null, "Thanks for playing!", "Dylan's Binary Math Tutor", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}
