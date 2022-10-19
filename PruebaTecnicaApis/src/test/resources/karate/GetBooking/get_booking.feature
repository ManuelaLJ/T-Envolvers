Feature: yo como ingeniera requiero realizar la peticion de GetBooking

  Background:
    * url api.baseUrl
    * def pathGetBooking = path.getBooking
    * def headerGetbooking = read("../../jsonbase/header/header_get_booking.json")

  @getBooking
  Scenario Outline: consulta exitosa obtener
    Given path pathGetBooking+'/<id>'
    And headers headerGetbooking
    When method GET
    Then status 200
    And match $.firstname == "#string"
    Examples:
      | id   |
      | 2060 |
      | 1211 |
      | 2021 |


    
    