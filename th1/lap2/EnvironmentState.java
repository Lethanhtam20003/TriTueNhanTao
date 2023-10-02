package lap2;

import java.util.HashMap;
import java.util.Map;

import Lap1.Environment.LocationState;

public class EnvironmentState {
	private Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
	private String agentLocation = null;//

	public EnvironmentState(lap2.Environment.LocationState locAState, lap2.Environment.LocationState locBState,
			lap2.Environment.LocationState locCState, lap2.Environment.LocationState locDState) {
		this.state.put(Environment.LOCATION_A, locAState);
		this.state.put(Environment.LOCATION_B, locBState);
	}

	public void setAgentLocation(String location) {
		this.agentLocation = location;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}

	public lap2.Environment.LocationState getLocationState(String location) {
		return this.state.get(location);
	}

	public void setLocationState(String location, lap2.Environment.LocationState clean) {
		this.state.put(location, clean);
	}

	public void display() {
		System.out.println("Environment state: \n\t" + this.state);
	}
}