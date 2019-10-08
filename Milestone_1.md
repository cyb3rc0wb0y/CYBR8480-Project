# Weather Forecast & Notification Application

**Authors:** Talon Flynn, Jeffrey Smith

## Executive Summary
Are you someone that never watches tv or the news at night and the following day have no idea on how to dress for the weather? The weather app has got your back. Just open it up and it will give you an up to date temperature reading and forecast for the day. You can also look ahead and see what they week will be like as well. The application grabs the user location to always give the most accurate results at the time. You will always be dressed properly for the day.

## Project Goals
* Use GPS to give accurate results to the user 
* Uses OpenWeather API to gather weather data for the user
* Allows for real time weather updates
* Allow for Weather Alerts to notify user
* Provide user with weather maps
* Notify user through email notification of weather forecast reminders
* Provide user temperature data of the android device being used

## User Stories
As a **standard user**, I want to **view current temperature and condition** so I can **see what apparel is required for the day**.  
**Acceptance Criteria:**
* App grabs user location
* App is able to interpret data to send off for correct data
* App displays the current temperature and conditions

As a **standard user**, I want to **receive an email notification** so I can **view the weather forecast outside the application**.  
**Acceptance Criteria:**
* App receives weather forecast from Weather API
* App is able to interpret data to determine the correct forecast
* App is able to send an email notification when the user selects the notification option

As a **standard user**, I want to **view the phones current temperature** so I can **determine if the phone needs to be stored elsewhere**.  
**Acceptance Criteria:**
* App receives data from phone's sensor
* App is able to interpret data to be displayed to screen
* App is able to correctly render the sensors data to the user

## Misuser stories
As a **weather forecast app misuser**, I want to **exploit the email notification feature** so I can **notify unauthorized individuals of the forecast**.
**Mitigations:**

* Using the If This Then That (IFTTT) WebHook and Email Notification engines the app can securely connect to the IFTTT service to ensure notifications cannot be redirected.

As a **weather forecast app misuser**, I want to **exploit the OpenWeather API request** so I can **misrepresent the users location (long/latitude)**.
**Mitigations:**

* Using the OpenWeather API the app can securely connect to the API service with a key ensuring that the connection is secure and validated.

## High Level Design
![High_Level_Diagram2](https://user-images.githubusercontent.com/25576618/66276888-dafa9000-e85c-11e9-8958-7932b1bea130.png)

## Component List

### User [Person]
A standard user that is able to complete the sub-component requirements and configuration settings for the Android device and API accounts.

#### User Settings
This sub-component contains the requirements and configuring for users. Each user must have an OpenWeather and If This Then That API key to interact with the applets to retrieve weather data and create email notification events.

### Mobile Android Device [Hardware]
The mobile android device is used to run the Weather Forecast application and used to determine the users geographical physical location to submit to API service to gather forecast data.

### Temperature Sensor [Hardware]
The temperature sensor is used to retrieve the Android devices physical temperature.

### OpenWeather [Software]
OpenWeather is used to query and retrieve the weather data for the user's physical geographical location.

### If This Then That [Software]
If This Then That is used to send the email message notifications to the user. It is initiated by the application via the user's If This Then That API key.

### Weather Forecast Application [Software]
The Weather Forecast application collects the data from the OpenWeather API, analyzes the data to determine the forecast information, and when selected, initiates the email message notification of forecast information. The application can be run on any Android device that has internet connectivity.

#### Temperature Sensor Connector
The application initiates the activity calls to the devices temperature sensor to determine the current reading of the physical devices temperature.

#### OpenWeather API Connector
The application initiates the API request to connect to OpenWeather's API to POST the user's physical location and then retrieves the weather forecast data to be displayed to the user.

#### If This Then That API Connector
When selected by the user, the Application initiates the email message notification by connecting to the If This Then That API. Via this connector, the WebHook crafts the email message and sends it to the user's email account.

## Security Analysis
The Weather Forecast application interfaces with a variety of other softwares and hardwares which introduces possible areas that can be exploited by a malicious user. In addition, the application requires user configuration of the settings and thrid-party API accounts which could be abused to inject code.

![Security_Analysis2](https://user-images.githubusercontent.com/25576618/66440910-56de0f00-e9fa-11e9-8bd4-423088f149c5.png)

| Component name | Category of vulnerability | Issue Description | Mitigation |
|----------------|---------------------------|-------------------|------------|
| User Configuration and Settings | Code Injection | This component exposes an interface to integrated webviews that might allow malicious javascript to read and modify protected data on the component that it shouldn't have access it. | All user input should be sanitized and validated before stored or submitted to APIs to prevent any malicious code injections.|
| If This Then That API Connector | Unauthorized Access | This component exposes an interface to If This Then That that could be exploited to manipulate the data that is sent to the app. | The If This Then That API key should be securely stored inside the Android application to ensure that the API connector cannot be misused.|
| OpenWeather API Connector | Unauthorized Access | This component exposes an interface to OpenWeather that could be exploited to manipulate the data that is sent to the app. | The OpenWeather API key should be securely stored inside the Android application to ensure that the API connector cannot be misused.|
