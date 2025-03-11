package no.ntnu.stud.entity;

public class SimulationResult {
    private int averageWaitingTime;
    private int averageTurnAroundTime;

    public SimulationResult(int averageWaitingTime, int averageTurnAroundTime) {
        this.averageWaitingTime = averageWaitingTime;
        this.averageTurnAroundTime = averageTurnAroundTime;
    }

	public int getAverageWaitingTime() {
		return averageWaitingTime;
	}

	public int getAverageTurnAroundTime() {
		return averageTurnAroundTime;
	}


}
