package karate.GetBooking;

import com.intuit.karate.junit5.Karate;

import static karate.Infraestructure.util.ConstantsFeature.GET_BOOKING;

public class GetBookingRunner {
    @Karate.Test
    Karate testSample(){
        return Karate.run(GET_BOOKING).relativeTo(getClass());
    }
}
