# R6StatsJava
A complete R6Stats api client for java\
_Requires an api key which you can get from the discord server from [R6Stats](https://r6stats.com)_
If you have an idea or found a bug create a pull request or an issue

# Examples:

```java
R6Stats r6 = new R6Stats("apiKey");
R6Player player = r6.getR6PlayerStats("TheRealJanPANDA", R6Stats.Platform.PC);

System.out.println(player.getGeneralStats().getKills());
System.out.println(player.getGamemodeStats().getBombStats().getWins());
System.out.println(player.getRankedStats().getKills());

R6SeasonalStats seasonal = r6.getR6PlayerSeasonalStats("TheRealJanPANDA", R6Stats.Platform.PC);

System.out.println(seasonal.getCrimsonHeist().getKills());
//...
R6Leaderboard leaderboard = r6.getR6Leaderboard(R6Stats.Platform.PC, R6Stats.Region.ALL);
System.out.println(leaderboard.getPlayerAtPosition(1).getKd());
```
You can also sort the lists at R6OperatorStats, R6WeaponStats, R6WeaponCategoryStats. Examples:
```java
r6.getR6OperatorStats("TheRealJanPANDA", R6Stats.Platform.PC).sortOperatorsBy(R6Operator.SortValue.KILLS)
r6.getR6OperatorStats("TheRealJanPANDA", R6Stats.Platform.PC).sortAttackersBy(R6Operator.SortValue.KILLS)

r6.getR6WeaponStats("TheRealJanPANDA", R6Stats.Platform.PC).sortWeaponsBy(R6Weapon.SortValue.KILLS)
```

-> These are not all features there are much more. You have to test around yourself.

# Installation:

### Maven

```xml
<repositories>
  <repository>
	 <id>jitpack.io</id>
	 <url>https://jitpack.io</url>
 </repository>
</repositories>
```
```xml
<dependency>
  <groupId>com.github.jan-tennert</groupId>
  <artifactId>R6StatsJava</artifactId>
  <version>1.2</version>
</dependency>
```

### Gradle

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
```gradle
dependencies {
      implementation 'com.github.jan-tennert:R6StatsJava:1.2'
}
```
