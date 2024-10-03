# travel-mobile-application-in-android-studio
The Fege Travel Mobile App is a Java-based Android application developed in Android Studio. It features user authentication, journey tracking (steps, distance, calories), and real-time location using Google Maps API. The app ensures seamless data exchange between activities like login, maps, and tracking, providing an intuitive user experience.

# Fege Travel Mobile App

The **Fege Travel App** is a comprehensive travel management Android application developed using **Java** and **Android Studio**. The app provides an intuitive platform for users to track their journeys, stay informed about their location, and manage their travel activities through seamless interactions.

## Features

- **User Authentication**: Secure user registration and login with email, username, and password. The app performs comprehensive validation checks to ensure data integrity.
- **Journey Tracking**: Tracks physical activities, including steps taken, distance traveled, and calories burned, using the device’s accelerometer sensor.
- **Real-Time Location Services**: Integrated with **Google Maps API** to display the user's current location using GPS, with features like zoom and location markers for easy navigation.
- **Seamless Data Exchange**: Ensures smooth transitions and data flow between multiple activities such as login, registration, map view, and journey tracking.

## App Flow

1. **Login Page**: Users log in with their credentials. They can navigate to the registration page if they don’t have an account.
2. **Registration Page**: Users register with an email, username, and password.
3. **Welcome Page**: After logging in, users are presented with options to start tracking their journey, view the map, or log out.
4. **Journey Page**: Displays the user’s physical activity data (steps, distance, and calories). Users can start or stop tracking their journey.
5. **Map Page**: Displays the user's current location and provides an interactive map view with zoom controls.

## Special Features

- **Validation Checks**: Ensures all required fields are filled during registration and login with error messages for empty fields.
- **Database Integration**: Stores registered users' data securely for smooth login and registration processes.
- **Enhanced User Experience**: Clean and intuitive UI design with seamless navigation between activities.

## Challenges Faced

- Ensuring smooth data exchange between multiple activities.
- Accurate integration of **Google Maps API** and GPS functionality.
- Providing a user-friendly experience with comprehensive validation checks and error handling.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
