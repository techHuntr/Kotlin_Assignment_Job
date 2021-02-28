# Job-MVVM

> An Android application built using Clean + MVVM architecture.

## Components used in the app.
- [Kotlin](https://kotlinlang.org/) - As a programming language.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Lifecycle aware Observable data holder class.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - To manage the UI-related data in a lifecycle conscious way.
- [RxKotlin](https://github.com/ReactiveX/RxKotlin) - Used for data manipulations and to switch between main thread and worker thread.
- [Retrofit](https://square.github.io/retrofit/) - For making network calls.
- [hilt] - For dependency injection.
- [Compose](https://developer.android.com/jetpack/compose?gclid=CjwKCAiAm-2BBhANEiwAe7eyFDXuTK0trRQ9N1-Sb8XA7V3CxdV-YT6x4oGCddvEnjeQQy2-zIuM4RoCNToQAvD_BwE&gclsrc=aw.ds) Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android.
- [Room database](https://developer.android.com/topic/libraries/architecture/room) - To cache the response for offline access.
- [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started) - For Graph based navigation

## Description

This is a android Kotlin application built using latest android best practices to demonstrate MVVM architecture in a optimised manner. FireBase serverless functions are used as a Back-end to the client application in order to consume data. The application's presentation layer demonstrates latest android composer approach in order to demonstrate re-usable views. As a second option traditional XML approach is also demonstrated. View Models are used to create  states and side effect scope to activities and fragments. Android navigation architecture components are used to demonstrate navigation between fragments and highlight single activity based architecture. Mutable live data is used in memory management to make the data life cylce aware and also to prevent memory leaks. 


## Architecture
![Architecture](https://github.com/techHuntr/Kotlin_Assignment_Job/blob/main/Demo/architecture%20Document.png)


## Steps to build the app
- Download Android Studio Cross Platform Canary IDE (ARCTIC FOX) 8 for auto config and build
- Clone
- Build and run the app.

## Demo Artifact 
- Navigate to Demo Folder
- Install the apk in the device
- Run and test :)

Thank you!
