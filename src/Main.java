import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Створюємо нове вікно
        JFrame frame = new JFrame("Максимальна висота тіла");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Створюємо текстові поля для введення початкової швидкості і кута
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

        // Створюємо кнопку для виконання обчислення
        JButton calculateButton = new JButton("Обчислити");
        calculateButton.setBounds(50, 110, 300, 30);
        frame.add(calculateButton);

        // Створюємо мітку для відображення результату
        JLabel resultLabel = new JLabel("Максимальна висота:");
        resultLabel.setBounds(50, 150, 300, 30);
        frame.add(resultLabel);

        // Додаємо обробник подій для кнопки
        calculateButton.addActionListener(e -> {
            try {

                double velocity = Double.parseDouble(velocityField.getText());
                double angle = Double.parseDouble(angleField.getText());

                // Конвертуємо кут у радіани
                double angleRadians = Math.toRadians(angle);

                // Обчислюємо максимальну висоту
                double g = 9.81; // Прискорення вільного падіння
                double maxHeight = (Math.pow(velocity * Math.sin(angleRadians), 2)) / (2 * g);

                // Відображаємо результат
                resultLabel.setText(String.format("Максимальна висота: %.2f м", maxHeight));
            } catch (NumberFormatException ex) {
                // Відображаємо повідомлення про помилку
                resultLabel.setText("Будь ласка, введіть коректні значення.");
            }
        });

        // Відображаємо вікно
        frame.setVisible(true);
    }
}