plugins {
    id("java")
    id("application")
}

group = "fr.univamu"
version = "1.0-SNAPSHOT"

application {
    mainClass = "fr.univamu.csvparser.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}