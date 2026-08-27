#!/usr/bin/env sh
set -e
JAVA_OPTS="${JAVA_OPTS:-}"
cd "$(dirname "$0")"
exec ./gradle/wrapper/gradle-wrapper.jar "$@"
