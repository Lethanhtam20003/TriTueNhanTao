package task3;

public class EnvironmentState {
	private Object[][] states;
	private String agentLocation = null;//

	public EnvironmentState(String[][] states) {
		this.states = states;
	}

	public void setAgentLocation(String location) {
		this.agentLocation = location;
	}

	public Object[] getStates() {
		return states;
	}

	public void setStates(Object[][] states) {
		this.states = states;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}

	public task3.Environment.LocationState getLocationState(String location) {
		return null;
	}

	public void setLocationState(int i,int j , task3.Environment.LocationState clean) {
		this.states[i][j]= clean;
	}

	public void display() {
		System.out.println("Environment state: \n\t" + this.states);
	}
}