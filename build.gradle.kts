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
    implementation("com.typesafe.akka", "akka-http_2.12", "10.1.10")
    implementation("com.typesafe.akka", "akka-stream_2.12", "2.5.26")
    testImplementation("org.scalatest", "scalatest_2.12", "3.0.8")
    testImplementation("junit", "junit", "4.12")

}
