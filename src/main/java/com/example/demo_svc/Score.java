package com.example.demo_svc;

public class Score {
	private String manualScore;
	private String predictedScore;
	
	public String getManualScore() {
		return manualScore;
	}
	public Score(String manualScore, String predictedScore) {
		this.manualScore = manualScore;
		this.predictedScore = predictedScore;
	}
	public void setManualScore(String manualScore) {
		this.manualScore = manualScore;
	}
	public String getPredictedScore() {
		return predictedScore;
	}
	public void setPredictedScore(String predictedScore) {
		this.predictedScore = predictedScore;
	}


}
