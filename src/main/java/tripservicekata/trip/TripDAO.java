package tripservicekata.trip;

import java.util.List;
import tripservicekata.exception.CollaboratorCallException;
import tripservicekata.user.User;

public class TripDAO {

	public static List<Trip> findTripsByUser(User user) {
		throw new CollaboratorCallException(
				"TripDAO should not be invoked on an unit test.");
	}
	
}