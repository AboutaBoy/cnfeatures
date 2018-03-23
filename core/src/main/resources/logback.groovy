import ch.qos.logback.classic.Level

def log_pattern = "%d{yyyy-MM-dd HH:mm:ss} [%level][%thread{20}][%logger{36}:%line]: %msg%n"

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = log_pattern
    }
}

logger("org.springframework", Level.INFO)

root(INFO, ["STDOUT"])