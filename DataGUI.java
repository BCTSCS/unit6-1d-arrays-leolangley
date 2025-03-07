import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DataGUI extends JFrame {
    private JTextField inputField;
    private JButton statusButton, percentageButton, saveScreenButton;
    private JTextArea resultsArea;
    private CountryAnalyzer analyzer;
    private int counter;

    public DataGUI() {
        super("Data Analysis Tool");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        counter = 0;

        // Initialize data analyzer with data files.
        analyzer = new CountryAnalyzer("Countries.txt", "Populations.txt",
                                       "Incomes.txt", "Unemployment.txt");

        // Create components.
        inputField = new JTextField(20);
        statusButton = new JButton("Analyze By Status");
        percentageButton = new JButton("Status Percentage");
        saveScreenButton = new JButton("Save Screen");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);

        // Add components to window.
        add(inputField);
        add(statusButton);
        add(percentageButton);
        add(saveScreenButton);
        add(new JScrollPane(resultsArea));

        // Set up button actions.
        statusButton.addActionListener(e -> analyzeStatus());
        percentageButton.addActionListener(e -> showPercentage());
        saveScreenButton.addActionListener(e -> saveScreen());

        setVisible(true);
    }

    private void analyzeStatus() {
        String status = inputField.getText();
        resultsArea.setText("Analyzing Status: " + capitalizeWords(status));
        analyzer.identifyHighRiskCommunities(status, 10);
    }

    private void showPercentage() {
        double average = analyzer.calculateAverageUnemployment();
        resultsArea.setText("Average Unemployment: " + average + "%");
    }

    public void saveScreen() {
        counter++;
        try {
            // Create a BufferedImage to store content.
            int width = resultsArea.getWidth();
            int height = resultsArea.getHeight();
            BufferedImage screenshot = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // Capture the contents of the text area.
            Graphics2D g2d = screenshot.createGraphics();
            resultsArea.paint(g2d);

            // Save the image to a file.
            File outputFile = new File("Search" + counter + ".png");
            ImageIO.write(screenshot, "png", outputFile);

            // Clean up graphics resources.
            g2d.dispose();

            System.out.println("Screenshot Saved: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String capitalizeWords(String input) {
        String[] words = input.split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                           .append(word.substring(1).toLowerCase())
                           .append(" ");
            }
        }
        return capitalized.toString().trim();
    }

    public static void main(String[] args) {
        new DataGUI();
    }
}