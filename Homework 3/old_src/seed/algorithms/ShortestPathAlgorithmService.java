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
	
	
}
