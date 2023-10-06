package task3;

import java.util.HashMap;
import java.util.Map;

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
//		Environment env = new Environment(Environment.LocationState.CLEAN, Environment.LocationState.DIRTY,
//				Environment.LocationState.CLEAN, Environment.LocationState.DIRTY);
		String[] states = {"DIRTY", "CLEAN"};
		Environment env = new Environment(states);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATION_A);

//		env.step(4);
		env.stepUntilDone();

	}
}
 