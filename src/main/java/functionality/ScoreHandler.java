package functionality;

import java.io.*;

public class ScoreHandler {
    private String scoresFilePath = "./Scores.txt";

    public void saveScore(String boardName, String resultText) {
        File scoreFile = new File(scoresFilePath);
        BufferedWriter writer;

        try {
            if (scoreFile.createNewFile()) {    //true if the named file does not exist and was successfully created; false if the named file already exists
                writer = new BufferedWriter(new FileWriter(scoreFile));
                writer.write("Board Nickname Time\n");

            } else {
                writer = new BufferedWriter(new FileWriter(scoreFile, true));
            }

            writer.write(boardName + " " + resultText + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readScores() {
        File scoreFile = new File(scoresFilePath);
        if (!scoreFile.exists()) return null;
        else {
            try {
                BufferedReader reader = new BufferedReader((new FileReader(scoreFile)));
                String line;
                StringBuilder scoresString = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    scoresString.append(line);
                    scoresString.append("\n");
                }
                return scoresString.toString();
                } catch(Exception e){
                    e.printStackTrace();
                    return null;
                }




        }

    }
}
