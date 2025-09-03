import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Максимальна висота тіла");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        JLabel velocityLabel = new JLabel("Початкова швидкість (м/с):");
        velocityLabel.setBounds(50, 30, 200, 30);
        frame.add(velocityLabel);

        JTextField velocityField = new JTextField();
        velocityField.setBounds(250, 30, 100, 30);
        frame.add(velocityField);

        JLabel angleLabel = new JLabel("Кут (градуси):");
        angleLabel.setBounds(50, 70, 200, 30);
        frame.add(angleLabel);

        JTextField angleField = new JTextField();
        angleField.setBounds(250, 70, 100, 30);
        frame.add(angleField);

        JButton calculateButton = new JButton("Обчислити");
        calculateButton.setBounds(50, 110, 300, 30);
        frame.add(calculateButton);
        
        JLabel resultLabel = new JLabel("Максимальна висота:");
        resultLabel.setBounds(50, 150, 300, 30);
        frame.add(resultLabel);

        calculateButton.addActionListener(e -> {
            try {

                double velocity = Double.parseDouble(velocityField.getText());
                double angle = Double.parseDouble(angleField.getText());

                double angleRadians = Math.toRadians(angle);

                double g = 9.81; 
                double maxHeight = (Math.pow(velocity * Math.sin(angleRadians), 2)) / (2 * g);

                resultLabel.setText(String.format("Максимальна висота: %.2f м", maxHeight));
            } catch (NumberFormatException ex) {

                resultLabel.setText("Будь ласка, введіть коректні значення.");
            }
        });
        frame.setVisible(true);
    }
}
