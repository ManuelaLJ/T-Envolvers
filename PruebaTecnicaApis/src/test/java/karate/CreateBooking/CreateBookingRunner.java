package karate.CreateBooking;

import com.intuit.karate.junit5.Karate;

import static karate.Infraestructure.util.ConstantsFeature.CREATE_BOOKING;

public class CreateBookingRunner {
    @Karate.Test
    Karate testSample(){
        return Karate.run(CREATE_BOOKING).relativeTo(getClass());
    }
}
