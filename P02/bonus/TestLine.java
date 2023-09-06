import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestLine {
    public static void main(String[] args) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            double x1, x2, y1, y2;
            Color color;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter starting point(x1) and ending point(x2) for line " + (i + 1) + ":");
            x1 = scanner.nextDouble();
            x2 = scanner.nextDouble();
            System.out.println("Enter starting point(y1) and ending point(y2) for line " + (i + 1) + ":");
            y1 = scanner.nextDouble();
            y2 = scanner.nextDouble();

            System.out.println("Enter color (PURPLE, ORANGE, PINK, BLUE) for line " + (i + 1) + ":");
            String colorInput = scanner.next();
            colorInput = colorInput.toUpperCase();

            try {
                color = Color.valueOf(colorInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid color input. Defaulting to PINK for line " + (i + 1) + ".");
                color = Color.PINK;
            }

            Line line = new Line(x1, y1, x2, y2, color);
            lines.add(line); // Add the line to the list
        }


        // Print the details of all lines
        for (Line line : lines) {
            double length = line.length();
            System.out.println(line + " has length " + length);
        }
    }
}

