package tripservicekata.trip;

import org.junit.Test;
import tripservicekata.exception.CollaboratorCallException;
import tripservicekata.user.User;

public class TripDAOTest {

    @Test (expected = CollaboratorCallException.class)
    public void
    should_throw_exception_when_retrieving_user_trips(){
        new TripDAO().tripsBy(new User());
    }

}
