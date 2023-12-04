import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int score = 0;

        // Read input.txt and seperate into Lines in an Array
        List<String> lines = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileReader("/home/lily/AdventOfCode2023/AdventOfCode2023-Day4.1/src/input.txt"));
            while (in.hasNext()) {
                lines.add(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Separate Lines into individual lists for the scratchers & winning numbers
        List<List<Integer>> winningNumbersList = new ArrayList<>();
        List<List<Integer>> scratchersList = new ArrayList<>();
        for (String line : lines) {
            List<Integer> winningNumbers = new ArrayList<>();
            List<Integer> scratcherNumbers = new ArrayList<>();
            String cutLine = line.replaceAll(".+: ", "");
            Matcher winningMatcher = Pattern.compile("\\d+").matcher(cutLine.substring(0, cutLine.indexOf("|")).trim());
            Matcher scratcherMatcher = Pattern.compile("\\d+").matcher(cutLine.substring(0, cutLine.indexOf("|")).trim());
            while (scratcherMatcher.find()) {
                scratcherNumbers.add(Integer.valueOf(scratcherMatcher.group()));
            }
            while (winningMatcher.find()) {
                winningNumbers.add(Integer.valueOf(winningMatcher.group()));
            }
            winningNumbersList.add(winningNumbers);
            scratchersList.add(scratcherNumbers);
        }

        for (List<Integer> integers : winningNumbersList) {
            for (Integer integer : integers) {
                System.out.println(integer);
            }
            System.out.println("-");
        }

        // Code to scan one scratcher & its score
/*      int localScore = 0;
        int[] exampleCardWinning = new int[10];
        int[] exampleCard = new int[25];

        for (int i : exampleCardWinning) {
            for (int j : exampleCard) {
                if (i == j) {
                    localScore = (localScore < 1) ? 1 : localScore * 2;
                }
            }
        }
        score += localScore;
        System.out.println(localScore);*/

    }
}