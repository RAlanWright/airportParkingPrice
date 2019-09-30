# Airport Parking Price Calculation
Given an amount of time in minutes, calculate the cost for time parked. 24 hours equals 1440 minutes.


## Constraints
* Between 0 and 30 minutes, parking is free.
* Between 31 and 60 minutes, parking costs $2.
* Every 30 minutes beyond 1 hour = $1 added to the price (e.g., at 61 minutes parking = $3).
* The maximum parking price per 24 hour period is $24. 
* The first 30 minutes after a full 24 hour period is not counted in the calculation (e.g., 1470 total minutes is still
 $24 for parking).
* Only increments of 30 minutes are counted for the calculation.
* If the total minutes is above between 1 minute and 29 minutes above the former 30 minute mark, then the total is
 rounded up for the purpose of the calculation (e.g., 90 minutes = $3; 91, 95, 100, 104, 109, 112, 120 minutes all equal
  = $4).


| Time Parked in Minutes | Price for Parking |
| :--------------------: | :---------------: |
| 0                      |        Free       | 
| 31                     | $2                |
| 60                     | $2                |
| 61                     | $3                |
| 90                     | $3                |
| 690                    | $23               |
| 691                    | $24               |
| 1440                   | $24               |
| 1471                   | $26               |
| 22479                  | $384              |

