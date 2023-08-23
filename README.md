# tmdbApp-002

TMDB Movie App is an Android application that allows users to view movies, search for specific movies, and display random movies using the TMDB (The Movie Database) API.

## Features

- View Popular Movies: Display a list of popular movies fetched from the TMDB API.
- Search Movies: Search for specific movies based on keywords.
- Show Random Movie: Show a random movie from the TMDB database.
- Clickable Movies: Movies in the list are clickable, and tapping on them displays more details about the movie.
- Retrofit Integration: Utilize the Retrofit library to make API requests and receive responses.
- Coroutine Support: Use Kotlin coroutines to perform asynchronous tasks.
- RecyclerView: Display movie data in a RecyclerView with a custom adapter.
- MVVM Architecture: Implement the Model-View-ViewModel architecture to separate concerns and improve maintainability.

## Prerequisites

- Android Studio (version X.X.X or higher)
- Kotlin version X.X.X
- TMDB API Key (Get yours at https://www.themoviedb.org/)

## Setup

1. Clone the repository.
2. Open the project in Android Studio.
3. Replace `"YOUR_TMDB_API_KEY"` in `ApiInterface.kt` with your TMDB API key.
4. Build and run the app on an emulator or physical device.

## Usage

1. Launch the app. The popular movies list will be displayed on the main screen.
2. Tap on any movie to view more details about it.
3. Use the search feature to search for movies by entering keywords in the search bar.
4. Click the "Random Movie" button to view a random movie's details.

## Libraries Used

- Retrofit: For making API requests and handling responses.
- Glide: For loading and displaying images efficiently.
- Coroutine: For managing asynchronous operations in a more readable way.

## Acknowledgements

- This app was created for educational purposes and uses the TMDB API to showcase API integration in Android apps.
- Thanks to TMDB for providing the API and documentation.
