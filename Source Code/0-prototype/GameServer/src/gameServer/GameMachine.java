package gameServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class GameMachine {
	private static GameMachine theMachine;

	HashMap<String, String> playerNameLevel; // <playerName, playerLevel>
	HashMap<String, String> playerNameScore; // <playername, score>
	TreeMap<String, String> highScore; // act as database for high score
										// TreeMap for sorting
	String ack = "false";

	public HashMap<String, String> getPlayerNameLevel() {
		return playerNameLevel;
	}

	public void setPlayerNameLevel(HashMap<String, String> playerNameLevel) {
		this.playerNameLevel = playerNameLevel;
	}

	public HashMap<String, String> getPlayerNameScore() {
		return playerNameScore;
	}

	public void setPlayerNameScore(HashMap<String, String> playerNameScore) {
		this.playerNameScore = playerNameScore;
	}

	public TreeMap<String, String> getHigScore() {
		for(Entry<String, String> entry : highScore.entrySet()) {
			System.out.println(entry.getValue() + "|" + entry.getKey());
		}
		return highScore;
	}

	public void setHighScore(TreeMap<String, String> highScore) {
		this.highScore = highScore;
	}

	public String getAck() {
		return ack;
	}

	public void setAck(String ack) {
		this.ack = ack;
	}

	public static GameMachine getInstance() {
		if (theMachine == null) {
			theMachine = new GameMachine();
			theMachine.init();
			return theMachine;
		} else {
			return theMachine;
		}
	}

	private void init() {
		playerNameLevel = new HashMap<>();
		playerNameScore = new HashMap<>();
		highScore = new TreeMap<>();

		FileReader in = null;

		try {
			File yourFile = new File("highScore.txt");
			yourFile.createNewFile();
			in = new FileReader(yourFile);
			BufferedReader br = new BufferedReader(in);
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split("|");

				String playerName = tokens[0];
				String score = tokens[1];
				String level = tokens[2];

				this.playerNameLevel.put(playerName, level);
				this.playerNameScore.put(playerName, score);
				this.highScore.put(score, playerName);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("init: FileNotFoundException");
		} catch (IOException e) {
			System.out.println("init: IOException");
		}
	}

	public void registerPlayer(String playerName) {
		if (this.playerNameLevel.get(playerName) != null) {
			this.ack = "false";
		} else {
			this.playerNameLevel.put(playerName, "0");
			this.playerNameScore.put(playerName, "0");
			this.ack = "true";
		}

	}

	public void setLevel(String playerName, String level) {
		if (this.playerNameLevel.get(playerName) == null) {
			this.ack = "false";
		} else {
			this.playerNameLevel.put(playerName, level);
			this.ack = "true";
		}

	}

	public void setScore(String playerName, String score) {
		if (this.playerNameScore.get(playerName) == null) {
			this.ack = "false";
		} else {
			this.playerNameScore.put(playerName, score);
			try {
				FileWriter fw = new FileWriter("highScore.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw);

				out.println(playerName + "|" + score + "|" + this.playerNameLevel.get(playerName));
				
				out.close();
				
				highScore.put(score, playerName);

			} catch (IOException e) {
				System.out.println("setScore: IOExecption");
				this.ack = "false";
				return;
			}
			this.ack = "true";
		}
	}

	public String calculateScore(int correctScore, int time) {
		return Integer.toString(correctScore + time);
	}

}
