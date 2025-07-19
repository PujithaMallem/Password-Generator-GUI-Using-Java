import javax.swing.*;
import java.util.Random;

public class PasswordGeneratorGUI {

    public static void main(String[] args) {
        // Greeting
        JOptionPane.showMessageDialog(null, "🔐 Welcome to the Password Generator!", "Password Generator", JOptionPane.INFORMATION_MESSAGE);

        // Get password length
        String lengthInput = JOptionPane.showInputDialog("Enter desired password length:");
        if (lengthInput == null) return;
        int length = Integer.parseInt(lengthInput);

        if (length <= 0) {
            JOptionPane.showMessageDialog(null, "❌ Password length must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get number of passwords
        String countInput = JOptionPane.showInputDialog("How many passwords do you want to generate?");
        if (countInput == null) return;
        int count = Integer.parseInt(countInput);

        // Character sets
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()-_+=<>?/{}~";
        String allChars = upper + lower + numbers + symbols;

        // Generate passwords
        StringBuilder result = new StringBuilder("Here are your secure passwords:\n\n");
        Random random = new Random();

        for (int i = 1; i <= count; i++) {
            StringBuilder password = new StringBuilder();
            for (int j = 0; j < length; j++) {
                int index = random.nextInt(allChars.length());
                password.append(allChars.charAt(index));
            }
            result.append("🔑 Password ").append(i).append(": ").append(password).append("\n");
        }

        // Show result
        JTextArea textArea = new JTextArea(result.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(350, 200));
        JOptionPane.showMessageDialog(null, scrollPane, "Generated Passwords", JOptionPane.INFORMATION_MESSAGE);
    }
}


