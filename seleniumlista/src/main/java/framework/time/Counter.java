package framework.time;

import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;

public class Counter {
	private HashMap<String, Date> counters;
	
	public Counter() {
		this.counters = new HashMap<>();
	}
	
	public void startCounting(String identifier) throws Exception {
		this.preventCounterDuplication(identifier);		
		this.counters.put(identifier, new Date(System.currentTimeMillis()));
	}
	
	private void preventCounterDuplication(String identifier) throws Exception {
		if (this.counters.containsKey(identifier))
			throw new Exception("Contador '" + identifier + "' já foi iniciado");
	}
	
	public void stopCounting(String identifier) throws Exception {
		this.preventUninitiatedCounterUsage(identifier);
		this.calculateDifference(identifier);
	}
	
	private void preventUninitiatedCounterUsage(String identifier) throws Exception {
		if (!this.counters.containsKey(identifier))
			throw new Exception("Contador '" + identifier + "' não foi iniciado");
	}
	
	private void calculateDifference(String identifier) {		
		Date start = this.counters.get(identifier);
		long difference = System.currentTimeMillis() - start.getTime();
		this.counters.replace(identifier, new Date(difference));
	}
	
	public String getFormattedDuration(String identifier) {
		return new SimpleDateFormat("mm:ss.SSS").format(this.counters.remove(identifier).getTime());
	}	
}
