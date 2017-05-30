// The simplest possible sbt build file is just one line:
scalaVersion := "2.11.11"

// adding two sub-projects for jvm and native
name := "hello-world"
organization := "org.scala-native"
version := "1.0"

lazy val hello =
  crossProject(JVMPlatform, NativePlatform).
    crossType(CrossType.Pure).
    in(file(".")).
    settings(scalaVersion := "2.11.11").
    nativeSettings(
      // set to "release" for maximum performance
      nativeMode := "debug"
    )
// from sbt command line to run:
// helloJVM/run
lazy val helloJVM    = hello.jvm
// helloNative/run
lazy val helloNative = hello.native
