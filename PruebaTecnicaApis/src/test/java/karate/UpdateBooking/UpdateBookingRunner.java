package karate.UpdateBooking;

import com.intuit.karate.junit5.Karate;

import static karate.Infraestructure.util.ConstantsFeature.UPDATE_BOOKING;

public class UpdateBookingRunner {
    @Karate.Test
    Karate testSample(){
        return Karate.run(UPDATE_BOOKING).relativeTo(getClass());
    }
}
