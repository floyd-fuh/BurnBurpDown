plugins {
    kotlin("jvm") version "2.0.20"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "ch.pentagrid"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("net.portswigger.burp.extensions:montoya-api:+")
    //implementation(kotlin("stdlib", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}