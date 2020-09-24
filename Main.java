package readability;

import java.util.Scanner;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String... args) {
        // Scanner scanner = new Scanner(System.in);
        UserInterface tui = new TextUserInterface(args.clone());
        tui.start();
        
    }
}

class TextUserInterface implements UserInterface {
    
    private RSText rstext;
    
    public TextUserInterface(String... args) {
        rstext = new RSText(args[0]);
    }
    
    @Override
    public void start() {
        
        rstext.displayText();
        System.out.println("");
        int words = rstext.wordsCount();
        System.out.println("Words: " + words);
        int sentences = rstext.sentncesCount();
        System.out.println("Sentences: " + sentences);
        int charaters = rstext.charactersCount();
        System.out.println("Characters: " + charaters);
        int syllables = rstext.syllablesCount();
        System.out.println("Syllables: " + syllables);
        int polysyllables = rstext.polysyllablesCount();
        System.out.println("Polysyllables: " + polysyllables);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("");
        if ("ARI".equals(input)) {
            displayScore(words, sentences, charaters);
        }
        if ("FK".equals(input)) {
            fkrt(words, sentences, syllables);
        }
        if ("SMOG".equals(input)) {
            smog(sentences, polysyllables);
        }
        if ("CL".equals(input)) {
            cl(charaters, words, sentences);
        }
        if ("all".equals(input)) {
            displayScore(words, sentences, charaters);
            fkrt(words, sentences, syllables);
            smog(sentences, polysyllables);
            cl(charaters, words, sentences);
        }
        
    }
    
    private void displayScore(int words, int sentences, int charaters) {
        double score = 4.71 * charaters / words + 0.5 * words / sentences - 21.43;
        // System.out.println("Automated Readability Index: " + score);
        // System.out.printf("The score is: %.2f %n", score);
        System.out.printf("Automated Readability Index: %.2f", score);
        // Math.ceil();
        String years ="";
        if (Math.ceil(score) > 14) {
            years = "24+";
        } else {
            switch ((int)Math.ceil(score)) {
                case 1:
                    years ="5-6";
                    break;
                case 2:
                    years ="6-7";
                    break;
                case 3:
                    years ="7-9";
                    break;
                case 4:
                    years ="9-10";
                    break;
                case 5:
                    years ="10-11";
                    break;
                case 6:
                    years ="11-12";
                    break;
                case 7:
                    years ="12-13";
                    break;
                case 8:
                    years ="13-14";
                    break;
                case 9:
                    years ="14-15";
                    break;
                case 10:
                    years ="15-16";
                    break;
                case 11:
                    years ="16-17";
                    break;
                case 12:
                    years ="17-18";
                    break;
                case 13:
                    years ="18-24";
                    break;
                default:
                    break;
            }
        }
        // System.out.println("This text should be understood by " + years + " year olds");
        System.out.println(" (about " + years + " year olds).");
    }
    
    private void fkrt(int words, int sentences, int syllables) {
        double score = 0.39 * (double) words / (double) sentences + 11.8 * (double) syllables / (double) words - 15.59;
        System.out.printf("Flesch–Kincaid readability tests: %.2f", score);
        String years ="";
        if (Math.ceil(score) > 14) {
            years = "24+";
        } else {
            switch ((int)Math.ceil(score)) {
                case 1:
                    years ="5-6";
                    break;
                case 2:
                    years ="6-7";
                    break;
                case 3:
                    years ="7-9";
                    break;
                case 4:
                    years ="9-10";
                    break;
                case 5:
                    years ="10-11";
                    break;
                case 6:
                    years ="11-12";
                    break;
                case 7:
                    years ="12-13";
                    break;
                case 8:
                    years ="13-14";
                    break;
                case 9:
                    years ="14-15";
                    break;
                case 10:
                    years ="15-16";
                    break;
                case 11:
                    years ="16-17";
                    break;
                case 12:
                    years ="17-18";
                    break;
                case 13:
                    years ="18-24";
                    break;
                default:
                    break;
            }
        }
        System.out.println(" (about " + years + " year olds).");
    }
    
    private void smog(int sentences, int polysyllables) {
        double score = 1.043 * Math.sqrt(polysyllables * (30 / sentences)) + 3.129;
        System.out.printf("Simple Measure of Gobbledygook: %.2f", score);
        String years ="";
        if (Math.ceil(score) > 14) {
            years = "24+";
        } else {
            switch ((int)Math.ceil(score)) {
                case 1:
                    years ="5-6";
                    break;
                case 2:
                    years ="6-7";
                    break;
                case 3:
                    years ="7-9";
                    break;
                case 4:
                    years ="9-10";
                    break;
                case 5:
                    years ="10-11";
                    break;
                case 6:
                    years ="11-12";
                    break;
                case 7:
                    years ="12-13";
                    break;
                case 8:
                    years ="13-14";
                    break;
                case 9:
                    years ="14-15";
                    break;
                case 10:
                    years ="15-16";
                    break;
                case 11:
                    years ="16-17";
                    break;
                case 12:
                    years ="17-18";
                    break;
                case 13:
                    years ="18-24";
                    break;
                default:
                    break;
            }
        }
        System.out.println(" (about " + years + " year olds).");
    }
    
    private void cl(int charaters, int words, int sentences) {
        double score = 5.88 * charaters / words - 26.9 * sentences / words - 15.8;
        System.out.printf("Coleman–Liau index: %.2f", score);
        String years ="";
        if (Math.ceil(score) > 14) {
            years = "24+";
        } else {
            switch ((int)Math.ceil(score)) {
                case 1:
                    years ="5-6";
                    break;
                case 2:
                    years ="6-7";
                    break;
                case 3:
                    years ="7-9";
                    break;
                case 4:
                    years ="9-10";
                    break;
                case 5:
                    years ="10-11";
                    break;
                case 6:
                    years ="11-12";
                    break;
                case 7:
                    years ="12-13";
                    break;
                case 8:
                    years ="13-14";
                    break;
                case 9:
                    years ="14-15";
                    break;
                case 10:
                    years ="15-16";
                    break;
                case 11:
                    years ="16-17";
                    break;
                case 12:
                    years ="17-18";
                    break;
                case 13:
                    years ="18-24";
                    break;
                default:
                    break;
            }
        }
        System.out.println(" (about " + years + " year olds).");
    }
    
    private void commented() {
        // System.out.print("Hello world!");
        
        //String inputs[] = scanner.nextLine().split("[\\.\\!\\?]");
        //int sum = 0;
        //for (String input : inputs) {
        //    sum += input.split(" ").length;
        //}
        //System.out.println(sum/inputs.length > 10 ? "HARD" : "EASY");
        // System.out.println(input.length() > 100 ? "HARD" : "EASY");
    }
}


class RSText {
    
    private List<String> text;
    
    public RSText(String pathToFile) {
        try {
            text = Files.readAllLines(Paths.get(pathToFile)); 
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
    }
    
    public void displayText() {
        System.out.println("The text is:");
        for (String s : text) {
            System.out.println(s);
        }
    }
    
    public int wordsCount() {
        
        int count = 0;
        
        for (String s : text) {
            String[] words = s.split("\\s");
            count += words.length;
        }
        
        return count;
    }
    
    public int sentncesCount() {
        
        int count = 0;
        
        for (String s : text) {
            String[] words = s.split("[!?.:]+");
            count += words.length;
        }
        
        return count;
    }
    
    public int charactersCount() {
        
        int count = 0;
        
        for (String s : text) {
            String[] words = s.split("\\s");
            for (String w : words) {
                count += w.length();
            }
        }
        
        return count;
    }
    
    public int syllablesCount() {
        
        int count = 0;
        
        for (String s : text) {
            String[] words = s.split("\\s");
            for (String w : words) {
                count += vsyllables(w);
            }
        }
        
        return count;
    }
    
    public int polysyllablesCount() {
        
        int count = 0;
        
        for (String s : text) {
            String[] words = s.split("\\s");
            for (String w : words) {
                if (vsyllables(w) > 2)
                count++;
            }
        }
        
        return count;
    }
    
    public int vsyllables(String str) {
        int syll = 0;
        syll += str.toLowerCase().replaceAll("e$","").replaceAll("[aeiouy]{2,}", "a").replaceAll("[^aeiouy]", "").length();
        return syll <= 0 ? 1 : syll;
    }
    
}


interface UserInterface {
    
    void start();

} 
