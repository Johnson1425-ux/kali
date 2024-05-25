import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    // Main frame
    private JFrame frame;
    // Text field to display result
    private JTextField textField;
    // String to store the operator and operands
    private String operator, operand1, operand2;

    // Constructor to initialize the calculator
    public Calculator() {
        operator = "";
        operand1 = "";
        operand2 = "";

        // Create the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        // Create the text field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH);

        // Create the panel to hold buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Array of button texts
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        // Add buttons to the panel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    // Action listener for button clicks
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // Clear the text field
            if (command.equals("C")) {
                textField.setText("");
                operator = "";
                operand1 = "";
                operand2 = "";
                return;
            }

            // If the command is an operator
            if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                if (!operator.isEmpty()) {
                    return;
                }
                operator = command;
                operand1 = textField.getText();
                textField.setText("");
                return;
            }

            // If the command is "="
            if (command.equals("=")) {
                if (operator.isEmpty()) {
                    return;
                }
                operand2 = textField.getText();
                double result = calculate(Double.parseDouble(operand1), Double.parseDouble(operand2), operator);
                textField.setText(String.valueOf(result));
                operator = "";
                operand1 = "";
                operand2 = "";
                return;
            }

            // If the command is a number or decimal point
            textField.setText(textField.getText() + command);
        }
    }

    // Method to perform the calculation
    private double calculate(double op1, double op2, String operator) {
        switch (operator) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                return op1 / op2;
            default:
                return 0;
        }
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}