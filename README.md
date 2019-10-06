# Weather Forecast & Notification Application

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
As you know, there are many problems that can arise in the design and implementation of an app. You should analyze your design, while considering your misuse cases, to identify problem points where security challenges might exist.

### Submission materials
Using your high level architecture diagram and component list, identify potential problem areas and how they might be mitigated. Draw arrows, circle areas, or use other callout methods to show how the security problems you identify connect to your systems architecture.

You can make use of the following markdown syntax to embed your security analysis information in your README.md file:

```markdown
## Security analysis
Text describing high level diagram with red or other callouts identifying problem points or attacks.
![Tooltip for visually disabled](./path-to-image-file.imgextension)

| Component name | Category of vulnerability | Issue Description | Mitigation |
|----------------|---------------------------|-------------------|------------|
| Component 1 name | Privilege Escalation | This component exposes an interface to integrated webviews that might allow malicious javascript to read and modify protected data on the component that it shouldn't have access it. | Sandboxing techniques should encapsulate access permissions and capabilities for webviews individually to prevent privilege escalation.|
```
