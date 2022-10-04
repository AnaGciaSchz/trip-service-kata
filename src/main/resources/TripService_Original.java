
/**
package org.craftedsw.tripservicekata;

import java.util.ArrayList;
import java.util.List;
import tripservicekata.exception.UserNotLoggedInException;
import tripservicekata.trip.Trip;
import tripservicekata.trip.TripDAO;
import tripservicekata.user.User;
import tripservicekata.user.UserSession;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService_Original {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = UserSession.getInstance().getLoggedUser();
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
	
}
 */
