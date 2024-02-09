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

task<Copy>("copyToPlugins") {
    from(tasks.jar.map { it.archiveFile })
    into("${launcherPath}plugins")
}

task("runLauncher", JavaExec::class) {
    workingDir(file(launcherPath))

    classpath = files("${launcherPath}launcherLibraries/*")
    jvmArgs("-Dnetbeans.debug=true")
    mainClass.set("ovh.crystallauncher.crystal.Bootstrap")
}.dependsOn(tasks.getByName("copyToPlugins"))

tasks.jar {
    from("$resources")
}

tasks.test {
    useJUnitPlatform()
}
