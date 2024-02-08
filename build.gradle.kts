plugins {
    id("java")
}

group = "qinomed"
version = "1.0"

val launcherPath = "D:/Crystal-Launcher/"

repositories {
    mavenCentral()
}

dependencies {
    implementation(fileTree(mapOf("dir" to File("${launcherPath}launcherLibraries"), "include" to listOf("*.jar"))))

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.register("runLauncher") {
    copy {
        from(tasks.jar)
        into("${launcherPath}plugins")
    }
    project.exec {
        commandLine("${launcherPath}launcher.exe")
    }
}

tasks.jar {
    from("$resources")
}

tasks.test {
    useJUnitPlatform()
}