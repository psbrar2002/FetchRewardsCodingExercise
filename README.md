# Fetch Rewards Coding Exercise

![Fetch Rewards Logo](app/src/main/res/drawable/fetch.png) 

This is a coding exercise project developed for Fetch Rewards. The application retrieves and displays a list of items from a remote JSON source, grouped by `listId`, and sorts them based on the requirements.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Requirements](#requirements)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [API Details](#api-details)
- [Screenshots](#screenshots)


## Overview

This project is an Android application that demonstrates how to:

- Fetch data from a remote server using Retrofit.
- Display the fetched data in a user-friendly manner using `RecyclerView`.
- Group and sort items based on specific fields (`listId` and `name`).
- Filter out any items where the `name` is blank or null.

The goal of this project is to showcase skills in Android development, including UI/UX design, data handling, and API integration.

## Features

- **Data Fetching**: Uses Retrofit to fetch data from a given endpoint.
- **Data Filtering**: Filters out items with empty or null `name` fields.
- **Data Grouping and Sorting**: Groups items by `listId` and sorts them by `name`.
- **UI Elements**: Uses Material Design components and `CardView` for a clean and modern look.
- **Expandable/Collapsible List**: Users can toggle the visibility of the list items.

## Requirements

- **Android Studio**: Latest stable version.
- **Android SDK**: Version 21 (Lollipop) or higher.
- **Gradle**: Version 7.0 or higher.
- **Kotlin**: Version 1.5 or higher.

## Setup and Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/psbrar2002/FetchRewardsCodingExercise.git
2. **Open the Project**: Launch Android Studio and open the project from the cloned repository.

3. **Build the Project**: Allow Gradle to sync and build the project.

4. **Run the App**: Use an emulator or a physical Android device to run the app.

## Usage
- Launch the app on your Android device or emulator.
- Click on the "Expand" button to display the list of items.
- View items grouped by listId, with headers showing the count of items in each group.
- Each item displays its id, listId, and name.

## Project Structure
```plaintext
FetchRewardsCodingExercise/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/fetchrewardscodingexercise/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── ApiService.kt
│   │   │   │   ├── RetrofitClient.kt
│   │   │   │   ├── ListItem.kt
│   │   │   │   ├── Item.kt
│   │   │   │   ├── ItemAdapter.kt
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── category_header_layout.xml
│   │   │   │   ├── item_layout.xml
│   │   │   ├── drawable/
│   │   │   │   ├── fetch.png
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   ├── colors.xml
│   │   │   │   ├── themes.xml
├── README.md
```
## API Details
- Base URL: https://fetch-hiring.s3.amazonaws.com/
- Endpoint: /hiring.json
- Method: GET
- Response: List of items with fields id, listId, and name.

## Screenshots
- Here's a visual representation of the application:
![Animation4](https://github.com/user-attachments/assets/49df4023-6a7e-4e88-982e-44d2b2d993b7)


