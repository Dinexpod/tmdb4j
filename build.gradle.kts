plugins {
    `java-library`
    checkstyle
    `maven-publish`
    signing
    id("com.gradleup.nmcp") version "1.5.0"
}

group = "io.github.dinexpod"
version = "2.0.1"

repositories {
    mavenCentral()
}

dependencies {
    val lombok = "org.projectlombok:lombok:1.18.46"

    // logging
    implementation(platform("org.slf4j:slf4j-bom:2.0.18"))
    implementation("org.slf4j:slf4j-api")

    // testing
    testImplementation(platform("org.junit:junit-bom:6.0.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation(platform("org.mockito:mockito-bom:5.23.0"))
    testImplementation("org.mockito:mockito-core")

    // util
    compileOnly(lombok)
    annotationProcessor(lombok)
    testCompileOnly(lombok)
    testAnnotationProcessor(lombok)

    api("com.fasterxml.jackson.core:jackson-annotations:2.21")
    api("tools.jackson.core:jackson-core:3.1.3")
    api("tools.jackson.core:jackson-databind:3.1.3")

    implementation(platform("com.squareup.okhttp3:okhttp-bom:5.3.2"))
    implementation("com.squareup.okhttp3:okhttp")

    implementation("org.apache.commons:commons-lang3:3.20.0")
    testImplementation("commons-io:commons-io:2.22.0")
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(17)
}

tasks.test {
    useJUnitPlatform()
}

checkstyle {
    toolVersion = "13.4.2"
    configFile = file("config/checkstyle/checkstyle.xml")
}
tasks.checkstyleMain {
    source = fileTree("src/main/java")
}
tasks.checkstyleTest {
    source = fileTree("src/test/java")
}
tasks.withType<Checkstyle>().configureEach {
    reports {
        html.required = true
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name = "tmdb4j"
                description =
                    "A Java wrapper around the JSON API provided by The Movie Database (TMDB)"
                url = "https://github.com/dinexpod/tmdb4j"

                licenses {
                    license {
                        name = "BSD 2-Clause License"
                        url = "https://opensource.org/licenses/BSD-2-Clause"
                        distribution = "repo"
                        comments = "This library is BSD 2-Clause licensed."
                    }
                }

                scm {
                    url = "https://github.com/dinexpod/tmdb4j.git"
                    connection = "scm:git:https://github.com/dinexpod/tmdb4j.git"
                    developerConnection = "scm:git:ssh://github.com/dinexpod/tmdb4j.git"
                }

                developers {
                    developer {
                        id = "dinexpod"
                        name = "Anatolii Levitskyi"
                        email = "support@moviso.app"
                        url = "https://github.com/Dinexpod"
                    }
                }
            }
        }
    }
}

nmcp {
    publishAllPublicationsToCentralPortal {
        username.set(
            providers.environmentVariable("SONATYPE_USERNAME")
                .orElse(providers.gradleProperty("SONATYPE_USERNAME"))
        )
        password.set(
            providers.environmentVariable("SONATYPE_PASSWORD")
                .orElse(providers.gradleProperty("SONATYPE_PASSWORD"))
        )
        publishingType.set("USER_MANAGED")
    }
}

signing {
    useGpgCmd()
    sign(publishing.publications["mavenJava"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

tasks {
    javadoc {
        options {
            (this as CoreJavadocOptions).addBooleanOption("Xdoclint:none", true)
        }
    }
}
