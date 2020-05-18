package seed.algorithms;

public class ShortestPathAlgorithmService {

	static ShortestPathAlgorithmService instance;
	
	private ShortestPathAlgorithmService() {
		
	}
	
	public static ShortestPathAlgorithmService getInstance() {
		if(instance == null) {
			return new ShortestPathAlgorithmService();
		}else {
			return instance;
		}
	}
	
	//I added this for Task 4 to demo how this would work with the adapter
	//We would have a list of algorithms to run through if this was correctly implemted
	public long findShortestPath(String[] inGraph, String startNode) {
		long startTime = System.nanoTime();
		ShortestPathAdapter adapter = new ShortestPathAdapter();
		adapter.constructShortestPath(inGraph, startNode);
		long endTime = System.nanoTime();
		long difference = endTime - startTime;
		// find the fastest algorithm
		/* long shortestTime = 1000L;
		 * for(int i = 0; i < algorithms.length; i++){
		 * 	if(difference < time){
		 *    time = difference;
		 *  }
		 * }
		 */
		return difference;
	}
	
}
