# Fetch Rewards Coding Exercise

![Fetch Rewards Logo](./path/to/logo.png) <!-- Replace with the actual path to the logo -->

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
- [Contributing](#contributing)
- [License](#license)

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
   git clone https://github.com/yourusername/fetch-rewards-coding-exercise.git
