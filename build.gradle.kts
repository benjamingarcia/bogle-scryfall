plugins {
    scala
    application
}

application {
	mainClassName = "org.bogle.Bogle"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback", "logback-classic", "1.2.3")
    implementation("org.scala-lang", "scala-library", "2.12.9")
    implementation("com.typesafe.akka", "akka-http_2.13", "10.1.11")
    implementation("com.typesafe.akka", "akka-stream_2.13", "2.6.1")
    testImplementation("org.scalatest", "scalatest_2.13", "3.0.8")
    testImplementation("junit", "junit", "4.12")
}
