Feature: Pago de pasaje

  Scenario: Pago exitoso
    Given un pasajero con saldo 10
    And un viaje con precio 5
    When el pasajero paga el viaje
    Then el pago se realiza correctamente