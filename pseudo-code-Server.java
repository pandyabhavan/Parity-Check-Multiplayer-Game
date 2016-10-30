HashMap <String, int> playerNameLevel // <playerName, playerLevel>
HashMap <String, int> playerNameScore // <playername, score>
TreeMap <int, String> highScore // act as database for high score, user TreeMap for sorting
int minScore;

//playerNameLevel and playerNameScore can be stored on RAM at runtime only
//highScore can be stored on RAM only, or can be saved to disk as backup then load to
// RAM on runtime. 


public Object get () {
	get a JSON/Jackson Object in the following format 
	{
		String action; //the action of 
		String playerName; //name of the player
		int level; //current level of the player
		int correctScore; //the score of correct answer
		int time; //the time player spend to submit answer
	}

	switch base on user action {
		choose the right functionCall;
	}
}

// action: register
// when user enter name at welcome page, and click begin
// client will sent a JSON/Jackson Object with
// String action set to register
// String name set to playerName
public void registerPlayer (String name) {
	//Option 1:
	search playerNameLevel to find playerName {
		if (playerName exist) {
			ask player to choose a another name;
		}
		else {
			add playerName to playerNameLevel with level 1;
			notify client to move to playMode;
		}
	}
	// Option 2
	// Change playerNameLevel to LinkedList and allow duplicate playerName
	// This will slow down run time. Recommand option 1
}

// action: setLevel
// assuming cliet will set it level without asking server
// client will notify server its level with setLevel action

public void setLevel (String playerName, int level) {
	search playerNameLevel to find playerName {
		if (playerName exist) {
			set playerName level to level
		}
		else {
			ERROR!
			handleException
		}
	}
}


// action: setScore
// when player submit the result, client will send the correctScore and time to server
// server will calculate the finalScore base on correctScore and time
// client can just send the correctScore and time to server and let server calculate the finalScore
// or client can calculate the score itself and send only the finalScore to server
public void setScore (String playerName, int correctScore, int time) {
	int finalScore = calculateScore(correctScore, time);
	search playerNameScore to find playerName {
		if (playerName exist) {
			set playerName score to finalScore
			if (finalScore >= minScore) {
				add player to highScore TreeMap
			}
		}
		else {
			ERROR!
			handleException
		}
	}
}

// action: getHighScore
// when player end their game, client will ask server for highScore record
// server will send an JSON/Jackson Object back to client in the format
// base of numberOfRecord request, server will send back numberOfRecord records to client
{
	int rank; //the rank of the player
	int score; //the score of the player
	int level; //current level of the player
	String playerName; //name of the player

}

public void getHighScore (int numberOfRecord) {
	// TreeMap is sorted in ascending order
	// use descendingMap() to flip the order
	NavigableMap toReturn = highScore.descendingMap();
	for (int i = 0; i < numberOfRecord) {
		construct JSON/Jackson Object from toReturn.get(i);
	}

	send the JSON/Jackson Object back to client;
}