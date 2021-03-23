package de.jan.r6statsjava;

public class Demo {
    public static void main(String[] args) {
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

    }
}
