plugins {
    kotlin("jvm") version "1.7.10"
    java
    `maven-publish`
}

group = "hu.nemaberci"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

publishing {
    publications {
        // todo: add publications
        create<MavenPublication>("maven") {

            from(components["java"])
        }
    }
}