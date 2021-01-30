# BaseMVVM - Android

BaseMVVM is the Android project that showcases the MVVM architecture in the basic scenario of fetching the list of books data from the mocked REST API service and caching it in the Room database.

### Libraries used

  - Dagger 2.28
  - RxJava 2.2.9
  - Room 2.2.0
  - Retrofit 2.9.0

### Architecture flow
1. **Activity** injects the ViewModel and starts observing ViewModel's LiveData
2. **ViewModel** fetches books from the Repository and observes it by RxJava
3. **Repository** tries to fetch data from the ApiService by RxJava
3.1  **onSuccess** -- Repository caches data into the Database
3.2  **onError** -- Repository loads cached data from the Database
4. **ViewModel** updates LiveData with the response from the Repository
5. **Activity** shows the response by RecyclerViewAdapter
