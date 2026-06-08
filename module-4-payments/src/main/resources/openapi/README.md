# OpenAPI Specs

This folder holds the TMF OpenAPI specs (`TMF676-Payment`, `TMF670-PaymentMethod`) used to generate the API stubs.

To regenerate the API/model code from these specs, run `mvn clean generate-sources` from the `module-4-payments` directory. The generated sources land in `target/generated-sources/openapi/`.

To compile those generated sources into bytecode, run `mvn clean compile` (or `mvn clean install` to compile and package).
