# Weather Forecast & Notification Application

## Executive Summary
Are you someone that never watches tv or the news at night and the following day have no idea on how to dress for the weather? The weather app has got your back. Just open it up and it will give you an up to date temperature reading and forecast for the day. You can also look ahead and see what they week will be like as well. The applciation grabs the user location to always give the most accurate results at the time. You will always be dressed properly for the day.

## Project Goals
* Use GPS to give accurate results to the user 
* Uses OpenWeather API to gather weather data for the user
* Allows for real time weather updates
* Allow for Weather Alerts to notify user
* Provide user with weather maps
* Notify user through email notification of weather forecast reminders
* Privide user temperature data of the android device being used

## User Stories
As a **standard user**, I want to **view current temperature and condition** so I can **see what appearal is required for the day**.  
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
* App is able to correctly render the sensers data to the user

## Misuser stories
As a **weather forecast app misuser**, I want to **exploit the email notification feature** so I can **notify unauthorized individuals of the forecast**.
**Mitigations:**

* Using the If This Then That (IFTTT) WebHook and Email Notification engines the app can securely connect to the IFTTT service to ensure notifications cannot be redirected.

As a **weather forecast app misuser**, I want to **exploit the OpenWeather API request** so I can **misrepresent the users location (long/lat)**.
**Mitigations:**

* Using the OpenWeather API the app can securely connect to the API service with a key ensuring that the connection is secure and validated.

## Design
![High_Level_Diagram](https://user-images.githubusercontent.com/25576618/66276595-66265680-e85a-11e9-97b8-acc22039a30e.png)

```markdown
## High Level Design
![Tooltip for visually disabled](./path-to-image-file.imgextension)

## Component List
### Component 1 Name here
Component description here

#### Sub-component 1.1 name here
Sub component description here

#### Sub-component 1.2 name here
Sub component description here

### Component 2 Name here
Component 2 description here

#### Sub-component 2.1 name here
Sub component description here

#### Sub-component 2.2 name here
Sub component description here
```

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
