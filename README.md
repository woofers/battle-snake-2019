

# Battlesnake

<img height="120" width="120" src="screenshots/advanced.png" />

A simple [Battlesnake](https://www.battlesnake.io) written in Java.

To be entered in the veteran division of the Battlesnake: Stay Home and Code online tournament as‏‏‎  🚚🦴🐶 𝗪𝗔𝗟𝗧𝗘𝗥 👑 🚒.

Deployed to [https://battlesnake-liquid.herokuapp.com/](https://battlesnake-liquid.herokuapp.com/)

Battlesnake documentation can be found at <https://docs.battlesnake.io>.

[![img](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Competition History

Variations of this snake have participated in multiple Battlesnake competitions.

* To compete in the veteran division of Battlesnake: Stay Home and Code as  🚚🦴🐶 𝗪𝗔𝗟𝗧𝗘𝗥 👑 🚒

* Competed in the expert division of Battlesnake 2019 & Battlesnake 2019 Winter Classic as  🐍 ‏‏‎𝙎𝙐𝙋𝙀𝙍 𝙎𝙇𝙄𝙈𝙀𝙔 ‏🐍 - [View Snake](https://github.com/woofers/battlesnake-2019/tree/battlesnake-2019)

* Competed in the intermediate division Battlesnake 2018 as **Solid Snake** - [View Snake](https://github.com/woofers/battlesnake-2019/tree/battlesnake-2018)

## Usage


### Prerequisites

1.  Install JDK 11 or higher
2.  Install Docker + Docker compose (required for [Docker container method](#orgfd68ec6))
3.  Install Heroku CLI (required for [Heroku CLI method](#org8843ce7))
4.  Install .war Heroku deployment plug-in `heroku plugins:install heroku-cli-deploy` ) (required for [Heroku CLI method](#org8843ce7))
5.  Create a Heroku App online or using the Heroku CLI with `heroku create <name>`

    (alternatively any other hosting service can be used)


### Test Board

**Online**

Goto [play.battlesnake.io](https://play.battlesnake.io)


### Run Locally

**Gradle**

1.  Run the project using either `./gradle run` or `gradlew run` for UNIX and Windows platforms respectively.  This will build and run the project as a \`JAR\` using [Webapp Runner](https://github.com/jsimone/webapp-runner).
2.  Use `http://localhost:8080` as the snake URL.

**Docker**
<a id="orgfd68ec6"></a>

1.  Build the project using either `./gradle build` or `gradlew build` for UNIX and Windows platforms respectively.
2.  Run the Docker Tomcat image in a container with `docker-compose up`.
3.  Use `http://localhost:8080/battlesnake` as the snake URL.


### Deployment

**Heroku-GitHub Integration**

1.  Go the dashboard for the Heroku app.
2.  Click on the `deploy` tab.
3.  Scroll down to the `Deployment method` and select `GitHub`.
4.  Enter the repository name and click `Connect`.

**Heroku CLI**
<a id="org8843ce7"></a>

1.  Build .war file `./gradlew build`
2.  Deploy to Heroku `heroku war:deploy build/libs/battlesnake.war --app <name>`
3.  Use `https://[name].herokuapp.com/` as the snake URL.


## Acknowledgments

-   **Built by** [Jaxson Van Doorn](https://github.com/woofers) and [Ben Austin](https://github.com/austinben)
-   **Adapted from** [tflinz's snake](https://github.com/tflinz/BasicBattleSnake2018)
-   **Designed for** [Battlesnake.io](https://github.com/battlesnakeio) competition


<img align="left" height="120" width="120" src="screenshots/advanced.png" />
