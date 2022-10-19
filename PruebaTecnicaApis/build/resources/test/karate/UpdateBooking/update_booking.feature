Feature: yo como ingeniera requiero realizar la peticion de UpDateBooking
  Background:
    * url api.baseUrl
    * path path.createToken
    * def headerCreateToken = read("../../jsonbase/header/header_create_token.json")
    * def rqBodyCreateToken = read("../../jsonbase/request/rq_body_create_token.json")
    * def rsCreateToken = read("../../jsonbase/reponse/rs_create_token.json")

    * def pathUpDateBooking = path.updateBooking
    * def headerUpDateBooking = read("../../jsonbase/header/header_up_date_booking.json")
    * def rqBodyUpDateBooking = read("../../jsonbase/request/rq_body_up_date_booking.json")

  @createBooking
  Scenario Outline: consulta exitosa
    Given headers headerCreateToken
    And request rqBodyCreateToken
    When method POST
    * set rsCreateToken.token = response.token
    * set headerUpDateBooking.Cookie = 'token='+rsCreateToken.token
    And path pathUpDateBooking+'/<id>'
    And headers headerUpDateBooking
    When request rqBodyUpDateBooking
    And method PUT
    Then status 200
    * print response
    Examples:
      | id   |
      | 4430 |