plugins {
    scala
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang", "scala-library", "2.12.9")
    testImplementation("org.scalatest", "scalatest_2.12", "3.0.8")
}
