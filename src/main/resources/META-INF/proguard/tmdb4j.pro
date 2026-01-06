# TMDb4J ProGuard / R8 rules
# These rules prevent model classes from being removed or obfuscated,
# which is required for correct JSON deserialization (Jackson).

-keep class app.moviso.tmdb4j.model.** { *; }
