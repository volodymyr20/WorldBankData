Feature: Country Key Figures Test

  Scenario: Country Key Figures Test
    Given On Country Table Page
    When Got Country Key Figures
    Then Validate Country Key Figures
      | Andorra_GDP                    | $3.249 billion |
      | Antigua_and_Barbuda_GDP        | $1.221 billion |
      | Argentina_GDP                  | $537.7 billion |
      | Andorra_Population             |         72,790 |
      | Antigua_and_Barbuda_Population |         90,900 |
      | Argentina_Population           | 42.98 million  |
      | Andorra_CO2                    |            6.0 |
      | Antigua_and_Barbuda_CO2        |            5.8 |
      | Argentina_CO2                  |            4.6 |
