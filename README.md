# Kyubey's site

## Running

```bash
# Clone the repo
$ git clone https://github.com/Kyuubey/site kyubey-site && cd kyubey-site

# Config
$ cp -v config.example.yml config.yml
# Use your favorite editor to edit the config

# Build it
$ ./gradlew build

# Run it
$ java -jar build/libs/KyubeySite.jar
```