plugins {
    `java-library`
    id("com.diffplug.spotless") version "6.25.0"
}

repositories {
    mavenCentral()
}

dependencies {
    // This dependency is exported to consumers, that is to say found on their compile classpath.
    //api(libs.commons.math3)

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    //implementation(libs.guava)
    implementation(libs.jackson.core)
    implementation(libs.jackson.annotations)
    implementation(libs.jackson.databind)
}

spotless {
    java {
	      removeUnusedImports()
	      eclipse()
	      formatAnnotations()
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
