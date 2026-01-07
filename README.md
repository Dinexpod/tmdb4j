# TMDb4J (The Movie Database API)

[![Maven Central](https://img.shields.io/maven-central/v/io.github.dinexpod/tmdb4j.svg?label=Maven%20Central)](https://search.maven.org/artifact/io.github.dinexpod/tmdb4j)
[![BSD 2 License](http://img.shields.io/badge/license-BSD_2_Clause-green.svg)](https://opensource.org/licenses/BSD-2-Clause)

This library provides a Java-wrapper around
the [JSON API](https://developer.themoviedb.org/docs/getting-started) provided by
[TMDb](https://www.themoviedb.org/), which is an open database for Movie and TV content.

The wrapper implements most, if not all, of the JSON API. However, because the API is subject to
constantly change, new functionality may
not be implemented, or current functionality may break. Please point this out by submitting an
issue, or even better, just send us a pull
request!

It's available via [Maven Central](https://central.sonatype.com/artifact/io.github.dinexpod/tmdb4j).
Just add it as dependency to your
project.

<details open>
<summary>Gradle (Kotlin)</summary>

```kotlin
dependencies {
    implementation("io.github.dinexpod:tmdb4j:{version}")
}
```

</details>

<details open>
<summary>Maven</summary>

```xml

<dependency>
    <groupId>io.github.dinexpod</groupId>
    <artifactId>tmdb4j</artifactId>
    <version>{version}</version>
</dependency>
```

</details>

## Usage

To register for a TMDb API key, click the [TMDb API link](https://www.themoviedb.org/settings/api)
from within your account settings page.
There are two types of API keys currently provided by TMDb, please ensure you are using the
`API Read Access Token` key.

With this you can instantiate `app.moviso.tmdb4j.TmdbApi`, which has getters for all subcategories
of the API, e.g.

```java
TmdbApi tmdbApi = new TmdbApi("<apikey>");
```

### Examples

#### Get movie details

```java
TmdbMovies tmdbMovies = tmdbApi.getMovies();
MovieDb movie = tmdbMovies.getDetails(5353, "en-US");
```

#### Append to response

Some of the API methods support appending additional requests to the response. This concept is part
of the underlying
[TMDb API - Append To Response](https://developer.themoviedb.org/docs/append-to-response), our
wrapper just mimics the scheme.

If you try to call the getter for a model that has fields for appendable responses, without
providing the append to response parameter to
the function, it will return  `null`.

```java
TmdbMovies tmdbMovies = tmdbApi.getMovies();

MovieDb movie = tmdbMovies.getDetails(5353, "en-US");
Images images = movie.getImages();  // this will be null

MovieDb movie = tmdbMovies.getDetails(5353, "en-US", MovieAppendToResponse.IMAGES);
Images images = movie.getImages();  // this will NOT be null
```

You can also append multiple responses to the same request by providing multiple append to response
values.

```java
TmdbMovies tmdbMovies = tmdbApi.getMovies();

MovieDb movie = tmdbMovies.getDetails(5353, "en-US", MovieAppendToResponse.IMAGES, MovieAppendToResponse.VIDEOS);
MovieDb movie = tmdbMovies.getDetails(5353, "en-US", MovieAppendToResponse.values());
```

To find all methods that use append to response, see the
`app.moviso.tmdb4j.tools.appendtoresponse.AppendToResponse` interface
implementations.

### Exception Handling

Every API method can throw a `app.moviso.tmdb4j.tools.TmdbException` if the request fails for any
reason. You should catch this
exception and handle it appropriately.

Some exceptions are caused because the response status provided by the TMDb API is not successful.
To see more details, see the
`app.moviso.tmdb4j.tools.TmdbResponseCode`
and [TMDb Errors](https://developer.themoviedb.org/docs/errors).

In the example below, the response was successful, but response code returned by TMDb API was not
successful due to an authentication
failure.

```java

@RequireArgumentsConstructor
public class MyClass {
    
    private final TmdbApi tmdbApi;

    public void method() {
        TmdbMovies tmdbMovies = tmdbApi.getMovies();
        
        try {
            AccountStates accountStates = tmdbMovies.getAccountStates(-1, "accountId", null);
        } catch (TmdbResponseException exception) {
            TmdbResponseCode responseCode = exception.getResponseCode();
            // handle unsuccessful TMdB response code
        } catch (TmdbException exception) {
            // handle unknown-cause exception
        }
    }
}

```

We chose to throw exceptions rather than returning `null`, so you have more control over what you do
with each failure case. E.g. with the
example above, you may want to display an error message to the user about failing authentication.

## Project Logging

This project uses [SLF4J](http://www.slf4j.org) to abstract the logging in the project. To use the
logging in your own
project you should add one of the provided [adapter bindings](http://www.slf4j.org/manual.html).

## ProGuard / R8 rules

This library provides built-in ProGuard / R8 rules for Android projects.

Model classes are located under the `app.moviso.tmdb4j.model` package and rely on
reflection-based JSON deserialization. To prevent these classes from being removed
or obfuscated during code shrinking, the required rules are automatically bundled
with the library.

No additional configuration is required for most Android projects.

## Notes & Acknowledgements

The library was developed for [Moviso](https://moviso.app) to interact with TMDb services.
This library has been inspired by [themoviedbapi](https://github.com/c-eg/themoviedbapi) but
has been rewritten to provide a cleaner API, and to expose more features of the TMDb JSON API.

## Versioning

TMDb4J follows semantic versioning (SemVer).

Version `1.0.0` marks the first stable release under the new package name
and artifact coordinates.
