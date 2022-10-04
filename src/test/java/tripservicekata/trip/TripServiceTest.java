package tripservicekata.trip;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import tripservicekata.exception.UserNotLoggedInException;
import tripservicekata.user.User;
import tripservicekata.user.UserBuilder;

public class TripServiceTest {


    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip TO_BRAZIL = new Trip();
    private static final Trip TO_LONDON = new Trip();
    private TripService tripService;

    @Before
    public void initialise(){
        tripService = new TestableTripService();
    }

    @Test(expected = UserNotLoggedInException.class) public void
    should_throw_an_exception_when_user_is_not_logged_in(){
        tripService.getTripsByUser(UNUSED_USER, GUEST);
    }

    @Test
    public void
    should_not_return_any_trips_when_users_are_not_friends(){
        User friend = UserBuilder.aUser()
            .friendsWith(ANOTHER_USER)
            .withTrips(TO_BRAZIL)
            .build();

        List<Trip> friendTrips = tripService.getTripsByUser(friend, REGISTERED_USER);

        assertThat(friendTrips.size(), is(0));
    }

    @Test public void
    should_return_friend_trips_when_users_are_friends(){
        User friend = UserBuilder.aUser()
            .friendsWith(ANOTHER_USER, REGISTERED_USER)
            .withTrips(TO_BRAZIL, TO_LONDON)
            .build();

        List<Trip> friendTrips = tripService.getTripsByUser(friend, REGISTERED_USER);

        assertThat(friendTrips.size(), is(2));
    }

    private class TestableTripService extends TripService {
        @Override
        protected List<Trip> tripsBy(User user) {
            return user.trips();
        }

    }

}