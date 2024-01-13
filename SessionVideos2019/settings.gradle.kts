plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "ClassLectures"
include("src:main:Session2")
findProject(":src:main:Session2")?.name = "Session2"
