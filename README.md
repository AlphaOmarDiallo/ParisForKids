# ParisForKids

#### This app is meant to be published on the PlayStore, even if it's primary goal is meant to be used for learning purposes.

App using the open data API to display all activities available in Paris for kids. 
Goal of the app is to make all the activites available even when the user is online if he previously connected to the app.
Goal is to make the app consume the minimum of Data possible. There is no planification of monetisation at the moment.
It should stay advert free for now.

Architecture
* MVVM structure - all common files are in common, otherwise it's organized by views
* Dependency injection done using Hilt
* Single activity app model, using Jetpack Navigation for navigation

UI
* No templates have been built so far. Inspiration needed.
* Jetpack compose 
* XML

Testing
* Unit testing must be done with Junit
* Instrumentation should be implemented, has not neen tested yet.

Convention
* You connot push on master without a pull request
* You cannont self validate your own pull request
* You must create a new branch from Master whenever developing a new feature or fixing a bug
* You must bring your own ideas
