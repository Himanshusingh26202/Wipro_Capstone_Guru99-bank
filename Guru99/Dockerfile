# Java + Maven
FROM maven:3.9.6-eclipse-temurin-21

# Install Google Chrome
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    unzip \
    curl \
    && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google.gpg \
    && echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable

# Project directory
WORKDIR /app

# Copy project
COPY . .

# Download dependencies
RUN mvn dependency:resolve

# Build project
RUN mvn clean compile

# Execute tests
CMD ["mvn", "test"]