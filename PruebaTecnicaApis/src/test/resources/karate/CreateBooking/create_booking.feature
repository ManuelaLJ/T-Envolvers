Feature: yo como ingeniera requiero realizar la peticion de CreateBooking

  Background:
    * url api.baseUrl
    * path path.createBooking
    * def headerCreatebooking = read("../../jsonbase/header/header_create_booking.json")
    * def rqBodyCreatebooking = read("../../jsonbase/request/rq_body_create_booking.json")

  @createBooking
  Scenario Outline: consulta exitosa
    * def firstname = firstname
    * def lastname = lastname
    * def totalprice = totalprice
    * def checkin = checkin
    * def checkout = checkout
    * def additionalneeds = additionalneeds
    Given headers headerCreatebooking
    And request rqBodyCreatebooking
    When method POST
    Then status 200
    And match response ==
    """
    {
      "bookingid": "#number",
      "booking": {
          "firstname": "#string",
          "lastname": "#string",
          "totalprice": "#number",
          "depositpaid": true,
          "bookingdates": {
              "checkin": "#string",
              "checkout": "#string"
          },
          "additionalneeds": "#string"
      }
    }
    """
    Examples:
      | firstname | lastname | totalprice | checkin    | checkout   | additionalneeds |
      | Manuela   | Lopez    | 231232     | 2022-10-20 | 2022-11-20 | Breakfast       |
      | Carlos    | Ramirez  | 23112312   | 2022-10-20 | 2022-11-20 | Breakfast       |
