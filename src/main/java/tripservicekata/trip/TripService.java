package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;
import tripservicekata.exception.UserNotLoggedInException;
import tripservicekata.trip.Trip;
import tripservicekata.trip.TripDAO;
import tripservicekata.user.User;
import tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = getLoggedInUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = TripDAO.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}

	protected User getLoggedInUser() {
		return UserSession.getInstance().getLoggedUser();
	}

}
