package tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;
import tripservicekata.exception.UserNotLoggedInException;
import tripservicekata.user.User;
import tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		if(getLoggedInUser() == null){
			throw new UserNotLoggedInException();
		}

		return user.isFriendsWith(getLoggedInUser())
						? tripsBy(user)
						: noTrips();
	}

	private ArrayList<Trip> noTrips() {
		return new ArrayList<>();
	}

	protected List<Trip> tripsBy(User user) {
		return TripDAO.findTripsByUser(user);
	}

	protected User getLoggedInUser() {
		return UserSession.getInstance().getLoggedUser();
	}

}
