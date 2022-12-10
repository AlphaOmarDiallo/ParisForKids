# ParisForKids

#### This app is meant to be published on the PlayStore, even if it's primary goal is meant to be used for learning purposes.

App using the open data API to display all activities available in Paris for kids. 
Goal of the app is to make all the activities available even when the user is online if he previously connected to the app.
Goal is to make the app consume the minimum of Data possible. There is no plan of monetization at the moment.
It should stay advert free for now.

## Competition
[Parissi](https://play.google.com/store/apps/details?id=com.stdm.homefun.parissi&hl=en&gl=US&pli=1) - Events and activities -> Found the idea, then this app and it's well done. We are just going to narrow the target.
https://play.google.com/store/apps/details?id=com.stdm.homefun.parissi&hl=en&gl=US&pli=1

### Architecture
* MVVM structure - all common files are in common, otherwise it's organized by views
* Dependency injection done using Hilt
* Single activity app model, using Jetpack Navigation for navigation

### UI
* No templates have been built so far. Inspiration needed.
* Jetpack compose 
* XML

### Testing
* Unit testing must be done with Junit
* Instrumentation should be implemented, has not been tested yet.

### Convention
* You cannot push on master without a pull request
* You cannot self validate your own pull request
* You must create a new branch from Master whenever developing a new feature or fixing a bug - do not forget to update before creating the branch
* You must bring your own ideas 
* Do not be afraid to break, that is the all purpose

## Ticketing system
A Trello will be set up so anyone can pick up a task to do and work in full autonomy

## Design
... if anyone is up to it

## Backend
Firebase is nice, but it would be awesome to set up a ktor backend for the app. Solutions exists to run it for free.