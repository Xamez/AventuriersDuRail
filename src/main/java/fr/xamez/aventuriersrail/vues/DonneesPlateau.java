package fr.xamez.aventuriersrail.vues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class DonneesPlateau {

    private final static Map<String, ArrayList<DonneesLayout>> routes;
    private final static Map<String, DonneesLayout> villes;

    public static final double largeurInitialePlateau = 1701.0,
                               hauteurInitialePlateau = 1097.0,
                               largeurRectangle = 60,
                               hauteurRectangle = 20,
                               xInitial = -30,
                               yInitial = -10,
                               rayonInitial = 12;

    static {
        routes = new HashMap<>();
        routes.put("Amsterdam - Bruxelles", new ArrayList<>(){{
            add(new DonneesLayout(504.5, 361.5));
        }});
        routes.put("Amsterdam - Essen", new ArrayList<>(){{
            add(new DonneesLayout(528.5, 276));
            add(new DonneesLayout(574, 265));
            add(new DonneesLayout(629, 300));
        }});
        routes.put("Amsterdam - Frankfurt", new ArrayList<>(){{
            add(new DonneesLayout(562, 358.5));
            add(new DonneesLayout(606, 403));
        }});
        routes.put("Amsterdam - London", new ArrayList<>(){{
            add(new DonneesLayout(405, 312));
            add(new DonneesLayout(469, 314.5));
        }});
        routes.put("Angora - Constantinople", new ArrayList<>(){{
            add(new DonneesLayout(1399, 959));
            add(new DonneesLayout(1452, 998));
        }});
        routes.put("Angora - Erzurum", new ArrayList<>(){{
            add(new DonneesLayout(1533.5, 1046));
            add(new DonneesLayout(1597, 1059.5));
            add(new DonneesLayout(1635.5, 1031.5));
        }});
        routes.put("Angora - Smyrna", new ArrayList<>(){{
            add(new DonneesLayout(1329.5, 1072.5));
            add(new DonneesLayout(1392.5, 1072));
            add(new DonneesLayout(1455.5, 1054));
        }});
        routes.put("Athina - Brindisi", new ArrayList<>(){{
            add(new DonneesLayout(957, 928));
            add(new DonneesLayout(982, 986.5));
            add(new DonneesLayout(1027.5, 1030.5));
            add(new DonneesLayout(1093.5, 1036));
        }});
        routes.put("Athina - Sarajevo", new ArrayList<>(){{
            add(new DonneesLayout(1052.5, 859));
            add(new DonneesLayout(1049, 922.5));
            add(new DonneesLayout(1045.5, 986.5));
            add(new DonneesLayout(1087.5, 1007));
        }});
        routes.put("Athina - Smyrna", new ArrayList<>(){{
            add(new DonneesLayout(1180.5, 1022));
            add(new DonneesLayout(1244.5, 1036.5));
        }});
        routes.put("Athina - Sofia", new ArrayList<>(){{
            add(new DonneesLayout(1136, 861));
            add(new DonneesLayout(1109.5, 921));
            add(new DonneesLayout(1123, 983));
        }});
        routes.put("Barcelona - Madrid", new ArrayList<>(){{
            add(new DonneesLayout(221.5, 954.5));
            add(new DonneesLayout(285.5, 956.5));
        }});
        routes.put("Barcelona - Marseille", new ArrayList<>(){{
            add(new DonneesLayout(370.5, 926));
            add(new DonneesLayout(415.5, 881.5));
            add(new DonneesLayout(467.5, 843.5));
            add(new DonneesLayout(525, 818));
        }});
        routes.put("Barcelona - Pamplona", new ArrayList<>(){{
            add(new DonneesLayout(322.5, 852.5));
            add(new DonneesLayout(329.5, 917.5));
        }});
        routes.put("Berlin - Danzig", new ArrayList<>(){{
            add(new DonneesLayout(842.5, 306.5));
            add(new DonneesLayout(867.5, 246.5));
            add(new DonneesLayout(922.5, 210));
            add(new DonneesLayout(987, 210));
        }});
        routes.put("Berlin - Essen", new ArrayList<>(){{
            add(new DonneesLayout(726.5, 331.5));
            add(new DonneesLayout(789.5, 339));
        }});
        routes.put("Berlin - Frankfurt(1)", new ArrayList<>(){{
            add(new DonneesLayout(686.5, 452.5));
            add(new DonneesLayout(743, 424.5));
            add(new DonneesLayout(800, 397.5));
        }});
        routes.put("Berlin - Frankfurt(2)", new ArrayList<>(){{
            add(new DonneesLayout(676, 432.5));
            add(new DonneesLayout(734, 405.5));
            add(new DonneesLayout(790.5, 378));
        }});
        routes.put("Berlin - Warszawa(1)", new ArrayList<>(){{
            add(new DonneesLayout(877, 365.5));
            add(new DonneesLayout(940, 350.5));
            add(new DonneesLayout(1003, 347));
            add(new DonneesLayout(1065.5, 350.5));
        }});
        routes.put("Berlin - Warszawa(2)", new ArrayList<>(){{
            add(new DonneesLayout(875.5, 341.5));
            add(new DonneesLayout(939.5, 326.5));
            add(new DonneesLayout(1002, 322));
            add(new DonneesLayout(1067, 327));
        }});
        routes.put("Berlin - Wien", new ArrayList<>(){{
            add(new DonneesLayout(847, 408.5));
            add(new DonneesLayout(870.5, 467));
            add(new DonneesLayout(906, 520.5));
        }});
        routes.put("Brest - Dieppe", new ArrayList<>(){{
            add(new DonneesLayout(225, 482.5));
            add(new DonneesLayout(287.5, 464));
        }});
        routes.put("Brest - Pamplona", new ArrayList<>(){{
            add(new DonneesLayout(229.5, 549.5));
            add(new DonneesLayout(280, 591));
            add(new DonneesLayout(302, 652));
            add(new DonneesLayout(306, 716));
        }});
        routes.put("Brest - Paris", new ArrayList<>(){{
            add(new DonneesLayout(235, 521));
            add(new DonneesLayout(298.5, 529));
            add(new DonneesLayout(360.5, 536.5));
        }});
        routes.put("Brindisi - Palermo", new ArrayList<>(){{
            add(new DonneesLayout(880.5, 1047.5));
            add(new DonneesLayout(923, 998.5));
            add(new DonneesLayout(936.5, 937));
        }});
        routes.put("Brindisi - Roma", new ArrayList<>(){{
            add(new DonneesLayout(832.5, 833));
            add(new DonneesLayout(892.5, 856));
        }});
        routes.put("Bruxelles - Dieppe", new ArrayList<>(){{
            add(new DonneesLayout(387, 447.5));
            add(new DonneesLayout(440, 411));
        }});
        routes.put("Bruxelles - Frankfurt", new ArrayList<>(){{
            add(new DonneesLayout(528.5, 403));
            add(new DonneesLayout(590.5, 420));
        }});
        routes.put("Bruxelles - Paris(1)", new ArrayList<>(){{
            add(new DonneesLayout(432.5, 495));
            add(new DonneesLayout(462.5, 439));
        }});
        routes.put("Bruxelles - Paris(2)", new ArrayList<>(){{
            add(new DonneesLayout(452.5, 505.5));
            add(new DonneesLayout(482.5, 449.5));
        }});
        routes.put("Bucuresti - Budapest", new ArrayList<>(){{
            add(new DonneesLayout(1058, 613.5));
            add(new DonneesLayout(1114.5, 644));
            add(new DonneesLayout(1170, 674));
            add(new DonneesLayout(1227, 703.5));
        }});
        routes.put("Bucuresti - Constantinople", new ArrayList<>(){{
            add(new DonneesLayout(1289.5, 766));
            add(new DonneesLayout(1314.5, 824));
            add(new DonneesLayout(1339, 882));
        }});
        routes.put("Bucuresti - Kyiv", new ArrayList<>(){{
            add(new DonneesLayout(1337, 492));
            add(new DonneesLayout(1317.5, 552));
            add(new DonneesLayout(1298, 612.5));
            add(new DonneesLayout(1278, 672));
        }});
        routes.put("Bucuresti - Sevastopol", new ArrayList<>(){{
            add(new DonneesLayout(1307.5, 690.5));
            add(new DonneesLayout(1365, 657.5));
            add(new DonneesLayout(1430.5, 665));
            add(new DonneesLayout(1480.5, 705));
        }});
        routes.put("Bucuresti - Sofia", new ArrayList<>(){{
            add(new DonneesLayout(1209.5, 809.5));
            add(new DonneesLayout(1250, 762.5));
        }});
        routes.put("Budapest - Kyiv", new ArrayList<>(){{
            add(new DonneesLayout(1037.5, 561));
            add(new DonneesLayout(1084, 518));
            add(new DonneesLayout(1139, 483.5));
            add(new DonneesLayout(1197.5, 459));
            add(new DonneesLayout(1260, 446));
            add(new DonneesLayout(1324, 446.5));
        }});
        routes.put("Budapest - Sarajevo", new ArrayList<>(){{
            add(new DonneesLayout(1026, 646.5));
            add(new DonneesLayout(1035, 709));
            add(new DonneesLayout(1044.5, 772));
        }});
        routes.put("Budapest - Wien(1)", new ArrayList<>(){{
            add(new DonneesLayout(973.5, 578));
        }});
        routes.put("Budapest - Wien(2)", new ArrayList<>(){{
            add(new DonneesLayout(962, 596));
        }});
        routes.put("Budapest - Zagrab", new ArrayList<>(){{
            add(new DonneesLayout(987.5, 639));
            add(new DonneesLayout(946.5, 689.5));
        }});
        routes.put("Cadiz - Lisboa", new ArrayList<>(){{
            add(new DonneesLayout(50, 1025.5));
            add(new DonneesLayout(100, 1063.5));
        }});
        routes.put("Cadiz - Madrid", new ArrayList<>(){{
            add(new DonneesLayout(189, 1062));
            add(new DonneesLayout(222.5, 1027.5));
            add(new DonneesLayout(184.5, 976));
        }});
        routes.put("Constantinople - Sevastopol", new ArrayList<>(){{
            add(new DonneesLayout(1490.5, 791.5));
            add(new DonneesLayout(1471, 852.5));
            add(new DonneesLayout(1428.5, 874));
            add(new DonneesLayout(1386.5, 896.5));
        }});
        routes.put("Constantinople - Smyrna", new ArrayList<>(){{
            add(new DonneesLayout(1301.5, 1026.5));
            add(new DonneesLayout(1330.5, 968.5));
        }});
        routes.put("Constantinople - Sofia", new ArrayList<>(){{
            add(new DonneesLayout(1206, 853));
            add(new DonneesLayout(1262, 883));
            add(new DonneesLayout(1317, 913.5));
        }});
        routes.put("Danzig - Riga", new ArrayList<>(){{
            add(new DonneesLayout(1041.5, 182.5));
            add(new DonneesLayout(1071, 125.5));
            add(new DonneesLayout(1123.5, 89));
        }});
        routes.put("Danzig - Warszawa", new ArrayList<>(){{
            add(new DonneesLayout(1068, 247));
            add(new DonneesLayout(1103.5, 299));
        }});
        routes.put("Dieppe - London(1)", new ArrayList<>(){{
            add(new DonneesLayout(330.5, 419.5));
            add(new DonneesLayout(336.5, 358));
        }});
        routes.put("Dieppe - London(2)", new ArrayList<>(){{
            add(new DonneesLayout(354.5, 422.5));
            add(new DonneesLayout(360, 359.5));
        }});
        routes.put("Dieppe - Paris", new ArrayList<>(){{
            add(new DonneesLayout(379.5, 500.5));
        }});
        routes.put("Edinburgh - London(1)", new ArrayList<>(){{
            add(new DonneesLayout(276.5, 96));
            add(new DonneesLayout(301, 154.5));
            add(new DonneesLayout(325, 212));
            add(new DonneesLayout(349.5, 269.5));
        }});
        routes.put("Edinburgh - London(2)", new ArrayList<>(){{
            add(new DonneesLayout(255.5, 105.5));
            add(new DonneesLayout(280.5, 163.5));
            add(new DonneesLayout(305, 220));
            add(new DonneesLayout(329, 277.5));
        }});
        routes.put("Erzurum - Sevastopol", new ArrayList<>(){{
            add(new DonneesLayout(1514, 792));
            add(new DonneesLayout(1518.5, 854));
            add(new DonneesLayout(1542, 914));
            add(new DonneesLayout(1588.5, 960));
        }});
        routes.put("Erzurum - Sochi", new ArrayList<>(){{
            add(new DonneesLayout(1653.5, 817));
            add(new DonneesLayout(1644.5, 880));
            add(new DonneesLayout(1635.5, 942.5));
        }});
        routes.put("Essen - Frankfurt", new ArrayList<>(){{
            add(new DonneesLayout(666, 412));
            add(new DonneesLayout(698, 374.5));
        }});
        routes.put("Essen - Kobenhavn(1)", new ArrayList<>(){{
            add(new DonneesLayout(677, 288));
            add(new DonneesLayout(713, 235));
            add(new DonneesLayout(748, 182));
        }});
        routes.put("Essen - Kobenhavn(2)", new ArrayList<>(){{
            add(new DonneesLayout(695.5, 300));
            add(new DonneesLayout(731, 246));
            add(new DonneesLayout(765.5, 196));
        }});
        routes.put("Frankfurt - Munchen", new ArrayList<>(){{
            add(new DonneesLayout(654, 500));
            add(new DonneesLayout(684.5, 534.5));
        }});
        routes.put("Frankfurt - Paris(1)", new ArrayList<>(){{
            add(new DonneesLayout(494, 553.5));
            add(new DonneesLayout(552, 527));
            add(new DonneesLayout(605.5, 491.5));
        }});
        routes.put("Frankfurt - Paris(2)", new ArrayList<>(){{
            add(new DonneesLayout(482.5, 533));
            add(new DonneesLayout(541, 506.5));
            add(new DonneesLayout(594, 471.5));
        }});
        routes.put("Kharkov - Kyiv", new ArrayList<>(){{
            add(new DonneesLayout(1386, 482));
            add(new DonneesLayout(1428, 531));
            add(new DonneesLayout(1490.5, 547.5));
            add(new DonneesLayout(1554, 540));
        }});
        routes.put("Kharkov - Moskva", new ArrayList<>(){{
            add(new DonneesLayout(1628.5, 491));
            add(new DonneesLayout(1661.5, 437));
            add(new DonneesLayout(1666, 372));
            add(new DonneesLayout(1647, 309.5));
        }});
        routes.put("Kharkov - Rostov", new ArrayList<>(){{
            add(new DonneesLayout(1651, 528));
            add(new DonneesLayout(1670.5, 573.5));
        }});
        routes.put("Kobenhavn - Stockholm(1)", new ArrayList<>(){{
            add(new DonneesLayout(808.5, 114));
            add(new DonneesLayout(855, 70.5));
            add(new DonneesLayout(908, 34));
        }});
        routes.put("Kobenhavn - Stockholm(2)", new ArrayList<>(){{
            add(new DonneesLayout(825, 132));
            add(new DonneesLayout(870, 87.5));
            add(new DonneesLayout(923.5, 50.5));
        }});
        routes.put("Kyiv - Smolensk", new ArrayList<>(){{
            add(new DonneesLayout(1418.5, 440.5));
            add(new DonneesLayout(1477.5, 417));
            add(new DonneesLayout(1492, 355.5));
        }});
        routes.put("Kyiv - Warszawa", new ArrayList<>(){{
            add(new DonneesLayout(1143.5, 376.5));
            add(new DonneesLayout(1196, 413));
            add(new DonneesLayout(1258.5, 422.5));
            add(new DonneesLayout(1322.5, 423.5));
        }});
        routes.put("Kyiv - Wilno", new ArrayList<>(){{
            add(new DonneesLayout(1344, 330.5));
            add(new DonneesLayout(1372, 389.5));
        }});
        routes.put("Lisboa - Madrid", new ArrayList<>(){{
            add(new DonneesLayout(30, 940));
            add(new DonneesLayout(49.5, 896));
            add(new DonneesLayout(111, 917.5));
        }});
        routes.put("Madrid - Pamplona(1)", new ArrayList<>(){{
            add(new DonneesLayout(186, 920.5));
            add(new DonneesLayout(229, 874));
            add(new DonneesLayout(278.5, 833));
        }});
        routes.put("Madrid - Pamplona(2)", new ArrayList<>(){{
            add(new DonneesLayout(171, 905));
            add(new DonneesLayout(212.5, 857));
            add(new DonneesLayout(261, 817));
        }});
        routes.put("Marseille - Pamplona", new ArrayList<>(){{
            add(new DonneesLayout(367.5, 823));
            add(new DonneesLayout(401, 790.5));
            add(new DonneesLayout(452.5, 753.5));
            add(new DonneesLayout(516.5, 770.5));
        }});
        routes.put("Marseille - Paris", new ArrayList<>(){{
            add(new DonneesLayout(553, 756));
            add(new DonneesLayout(505.5, 713.5));
            add(new DonneesLayout(457, 670.5));
            add(new DonneesLayout(436.5, 608.5));
        }});
        routes.put("Marseille - Roma", new ArrayList<>(){{
            add(new DonneesLayout(620, 778));
            add(new DonneesLayout(671, 741.5));
            add(new DonneesLayout(712, 762.5));
            add(new DonneesLayout(750, 813.5));
        }});
        routes.put("Marseille - Zurich", new ArrayList<>(){{
            add(new DonneesLayout(615, 683.5));
            add(new DonneesLayout(599, 746.5));
        }});
        routes.put("Moskva - Petrograd", new ArrayList<>(){{
            add(new DonneesLayout(1504, 79.5));
            add(new DonneesLayout(1561, 110));
            add(new DonneesLayout(1600, 161));
            add(new DonneesLayout(1617, 222));
        }});
        routes.put("Moskva - Smolensk", new ArrayList<>(){{
            add(new DonneesLayout(1526, 314));
            add(new DonneesLayout(1587, 295.5));
        }});
        routes.put("Munchen - Venezia", new ArrayList<>(){{
            add(new DonneesLayout(742, 587));
            add(new DonneesLayout(754, 651));
        }});
        routes.put("Munchen - Wien", new ArrayList<>(){{
            add(new DonneesLayout(768.5, 566));
            add(new DonneesLayout(826, 594.5));
            add(new DonneesLayout(887, 574.5));
        }});
        routes.put("Munchen - Zurich", new ArrayList<>(){{
            add(new DonneesLayout(656.5, 609.5));
            add(new DonneesLayout(702.5, 564));
        }});
        routes.put("Palermo - Roma", new ArrayList<>(){{
            add(new DonneesLayout(864, 1032));
            add(new DonneesLayout(884.5, 972));
            add(new DonneesLayout(866, 911));
            add(new DonneesLayout(818, 867.5));
        }});
        routes.put("Palermo - Smyrna", new ArrayList<>(){{
            add(new DonneesLayout(1236.5, 1069));
            add(new DonneesLayout(1172.5, 1069));
            add(new DonneesLayout(1110.5, 1069));
            add(new DonneesLayout(1048.5, 1069));
            add(new DonneesLayout(984, 1069));
            add(new DonneesLayout(920, 1069));
        }});
        routes.put("Pamplona - Paris(1)", new ArrayList<>(){{
            add(new DonneesLayout(321.5, 763));
            add(new DonneesLayout(353.5, 706.5));
            add(new DonneesLayout(374, 647));
            add(new DonneesLayout(387.5, 584));
        }});
        routes.put("Pamplona - Paris(2)", new ArrayList<>(){{
            add(new DonneesLayout(343.5, 770.5));
            add(new DonneesLayout(376, 713));
            add(new DonneesLayout(397, 654));
            add(new DonneesLayout(410.5, 592));
        }});
        routes.put("Paris - Zurich", new ArrayList<>(){{
            add(new DonneesLayout(468.5, 594));
            add(new DonneesLayout(515.5, 636.5));
            add(new DonneesLayout(578.5, 650));
        }});
        routes.put("Petrograd - Riga", new ArrayList<>(){{
            add(new DonneesLayout(1216.5, 73));
            add(new DonneesLayout(1281, 74));
            add(new DonneesLayout(1344, 72));
            add(new DonneesLayout(1407, 71.5));
        }});
        routes.put("Petrograd - Stockholm", new ArrayList<>(){{
            add(new DonneesLayout(994, 57));
            add(new DonneesLayout(1040, 48));
            add(new DonneesLayout(1099.5, 26.5));
            add(new DonneesLayout(1163, 26.5));
            add(new DonneesLayout(1226.5, 25.5));
            add(new DonneesLayout(1289.5, 26));
            add(new DonneesLayout(1352.5, 26.5));
            add(new DonneesLayout(1416.5, 39));
        }});
        routes.put("Petrograd - Wilno", new ArrayList<>(){{
            add(new DonneesLayout(1326, 261));
            add(new DonneesLayout(1364, 209.5));
            add(new DonneesLayout(1400.5, 158));
            add(new DonneesLayout(1437, 107.5));
        }});
        routes.put("Riga - Wilno", new ArrayList<>(){{
            add(new DonneesLayout(1167, 119));
            add(new DonneesLayout(1175, 182));
            add(new DonneesLayout(1216, 230.5));
            add(new DonneesLayout(1270, 264.5));
        }});
        routes.put("Roma - Venezia", new ArrayList<>(){{
            add(new DonneesLayout(772.5, 740));
            add(new DonneesLayout(784, 803.5));
        }});
        routes.put("Rostov - Sevastopol", new ArrayList<>(){{
            add(new DonneesLayout(1526, 703));
            add(new DonneesLayout(1534.5, 640));
            add(new DonneesLayout(1561, 598));
            add(new DonneesLayout(1623.5, 609));
        }});
        routes.put("Rostov - Sochi", new ArrayList<>(){{
            add(new DonneesLayout(1667.5, 663));
            add(new DonneesLayout(1664, 726.5));
        }});
        routes.put("Sarajevo - Sofia", new ArrayList<>(){{
            add(new DonneesLayout(1096, 793));
            add(new DonneesLayout(1143.5, 792));
        }});
        routes.put("Sarajevo - Zagrab", new ArrayList<>(){{
            add(new DonneesLayout(913.5, 761.5));
            add(new DonneesLayout(946, 815.5));
            add(new DonneesLayout(1010, 825.5));
        }});
        routes.put("Sevastopol - Sochi", new ArrayList<>(){{
            add(new DonneesLayout(1554, 753));
            add(new DonneesLayout(1616, 763));
        }});
        routes.put("Smolensk - Wilno", new ArrayList<>(){{
            add(new DonneesLayout(1344.5, 274.5));
            add(new DonneesLayout(1386, 251));
            add(new DonneesLayout(1438, 289));
        }});
        routes.put("Venezia - Zagrab", new ArrayList<>(){{
            add(new DonneesLayout(808, 680.5));
            add(new DonneesLayout(870.5, 691.5));
        }});
        routes.put("Venezia - Zurich", new ArrayList<>(){{
            add(new DonneesLayout(664.5, 659.5));
            add(new DonneesLayout(721.5, 689));
        }});
        routes.put("Warszawa - Wien", new ArrayList<>(){{
            add(new DonneesLayout(966.5, 531.5));
            add(new DonneesLayout(1016.5, 493.5));
            add(new DonneesLayout(1059.5, 446));
            add(new DonneesLayout(1094, 392.5));
        }});
        routes.put("Warszawa - Wilno", new ArrayList<>(){{
            add(new DonneesLayout(1142.5, 310.5));
            add(new DonneesLayout(1194, 272));
            add(new DonneesLayout(1257, 285));
        }});
        routes.put("Wien - Zagrab", new ArrayList<>(){{
            add(new DonneesLayout(912.5, 667));
            add(new DonneesLayout(916.5, 604.5));
        }});
    }

    public static ArrayList<DonneesLayout> getRoute(String id) {
        return routes.get(id);
    }

    static {
        villes = new HashMap<>();
        villes.put("Cadiz", new DonneesLayout(144, 1072));
        villes.put("Madrid", new DonneesLayout(147, 946));
        villes.put("Barcelona", new DonneesLayout(336, 961));
        villes.put("Lisboa", new DonneesLayout(32, 981));
        villes.put("Pamplona", new DonneesLayout(318, 805));
        villes.put("Paris", new DonneesLayout(425, 544));
        villes.put("Dieppe", new DonneesLayout(341, 467));
        villes.put("Brest", new DonneesLayout(188, 516));
        villes.put("London", new DonneesLayout(358, 313));
        villes.put("Amsterdam", new DonneesLayout(524, 319));
        villes.put("Bruxelles", new DonneesLayout(485, 399));
        villes.put("Edinburgh", new DonneesLayout(245, 56));
        villes.put("Zurich", new DonneesLayout(622, 638));
        villes.put("Marseille", new DonneesLayout(575, 797));
        villes.put("Frankfurt", new DonneesLayout(638, 454));
        villes.put("Munchen", new DonneesLayout(737, 530));
        villes.put("Wien", new DonneesLayout(930, 559));
        villes.put("Venezia", new DonneesLayout(763, 694));
        villes.put("Roma", new DonneesLayout(779, 849));
        villes.put("Brindisi", new DonneesLayout(925, 892));
        villes.put("Palermo", new DonneesLayout(841, 1072));
        villes.put("Athina", new DonneesLayout(1136, 1024));
        villes.put("Sofia", new DonneesLayout(1167, 830));
        villes.put("Sarajevo", new DonneesLayout(1053, 815));
        villes.put("Zagrab", new DonneesLayout(908, 714));
        villes.put("Budapest", new DonneesLayout(1014, 602));
        villes.put("Kyiv", new DonneesLayout(1370, 438));
        villes.put("Warszawa", new DonneesLayout(1113, 345));
        villes.put("Wilno", new DonneesLayout(1302, 303));
        villes.put("Smolensk", new DonneesLayout(1479, 310));
        villes.put("Moskva", new DonneesLayout(1625, 269));
        villes.put("Kharkov", new DonneesLayout(1600, 528));
        villes.put("Rostov", new DonneesLayout(1671, 618));
        villes.put("Sochi", new DonneesLayout(1660, 770));
        villes.put("Erzurum", new DonneesLayout(1628, 986));
        villes.put("Constantinople", new DonneesLayout(1358, 932));
        villes.put("Angora", new DonneesLayout(1492, 1026));
        villes.put("Smyrna", new DonneesLayout(1282, 1068));
        villes.put("Essen", new DonneesLayout(663, 335));
        villes.put("Berlin", new DonneesLayout(834, 359));
        villes.put("Kobenhavn", new DonneesLayout(784, 155));
        villes.put("Stockholm", new DonneesLayout(963, 22));
        villes.put("Riga", new DonneesLayout(1169, 71));
        villes.put("Petrograd", new DonneesLayout(1458, 64));
        villes.put("Danzig", new DonneesLayout(1028, 226));
        villes.put("Bucuresti", new DonneesLayout(1271, 721));
        villes.put("Sevastopol", new DonneesLayout(1508, 746));
    }

    public static DonneesLayout getVille(String id) {
        return villes.get(id);
    }

    public static class DonneesLayout {
        double layoutX, layoutY;

        public DonneesLayout(double layoutX, double layoutY) {
            this.layoutX = layoutX;
            this.layoutY = layoutY;
        }

        public double getLayoutX() {
            return layoutX;
        }

        public double getLayoutY() {
            return layoutY;
        }
    }
}
