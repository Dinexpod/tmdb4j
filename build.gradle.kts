plugins {
    `java-library`
    checkstyle
    `maven-publish`
    signing
    id("com.gradleup.nmcp") version "0.0.9"
}

group = "io.github.dinexpod"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    // logging
    implementation(platform("org.slf4j:slf4j-bom:2.0.17"))
    implementation("org.slf4j:slf4j-api")

    // testing
    testImplementation(platform("org.junit:junit-bom:5.13.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")  // gradle bundled version is incompatible with 5.12

    testImplementation(platform("org.mockito:mockito-bom:5.21.0"))
    testImplementation("org.mockito:mockito-core")

    // util
    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
    testCompileOnly("org.projectlombok:lombok:1.18.42")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.42")

    implementation(platform("com.fasterxml.jackson:jackson-bom:2.20.1"))
    implementation("com.fasterxml.jackson.core:jackson-annotations")
    implementation("com.fasterxml.jackson.core:jackson-core")
    implementation("com.fasterxml.jackson.core:jackson-databind")

    implementation("org.apache.commons:commons-lang3:3.20.0")
    testImplementation("commons-io:commons-io:2.21.0")
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.test {
    useJUnitPlatform()
}

checkstyle {
    toolVersion = "10.17.0"
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
                        name = "Levitskyi Anatolii"
                        email = "dinexpod@gmail.com"
                        url = "https://github.com/dinexpod"
                    }
                }
            }
        }
    }
}

nmcp {
    publish("mavenJava") {
        username.set(System.getenv("SONATYPE_USERNAME") ?: project.findProperty("SONATYPE_USERNAME") as String?)
        password.set(System.getenv("SONATYPE_PASSWORD") ?: project.findProperty("SONATYPE_PASSWORD") as String?)

        publicationType = "USER_MANAGED"
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
