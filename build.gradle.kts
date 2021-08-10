import java.io.RandomAccessFile

plugins {
    java
}

group = "org.glavo"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.compileJava {
    modularity.inferModulePath.set(true)
    options.release.set(9)
    options.isWarnings = false
    doLast {
        val tree = fileTree(destinationDirectory)
        tree.include("**/*.class")
        tree.exclude("module-info.class")
        tree.forEach {
            RandomAccessFile(it, "rw").use { rf ->
                rf.seek(7)   // major version
                rf.write(52)   // java 8
                rf.close()
            }
        }
    }
}

java {
    withSourcesJar()
    // withJavadocJar()
}