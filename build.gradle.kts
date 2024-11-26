plugins {
    kotlin("jvm") version "2.0.21"
    id("org.jetbrains.dokka") version "1.9.20" apply false
    id("org.owasp.dependencycheck") version "8.2.1" apply false
    id("io.gitlab.arturbosch.detekt") version "1.23.0" apply false
    id("com.vanniktech.maven.publish") version "0.28.0" apply false
}

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("XXX") {
                afterEvaluate { from(components["java"]) }
                // artifact(sourcesJar)
                // artifact(dokkaJavadocJar)
                //artifact(dokkaHtmlJar)
            }
        }
        repositories {
            maven {
                name = "XXX"
                url = uri("${project.buildDir}/repo")
            }
        }
    }
}
