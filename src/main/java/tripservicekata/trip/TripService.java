package tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;
import tripservicekata.exception.UserNotLoggedInException;
import tripservicekata.user.User;

public class TripService {

	public List<Trip> getTripsByUser(User user, User loggedInUser) throws UserNotLoggedInException {
		if(loggedInUser == null){
			throw new UserNotLoggedInException();
		}

		return user.isFriendsWith(loggedInUser)
						? tripsBy(user)
						: noTrips();
	}

	private ArrayList<Trip> noTrips() {
		return new ArrayList<>();
	}

	protected List<Trip> tripsBy(User user) {
		return TripDAO.findTripsByUser(user);
	}

}
