import java.io.*;
import java.util.ArrayList;

/**
 * Created by Admin on 2/1/2018.
 */
public class EPGUtilities {


//    public static void main(String[] args) {
//
//        EPGUtilities epgUtilities = new EPGUtilities();
//        epgUtilities.parseEPGCMDLog("D:\\Java\\MyProjects\\EPC_Report\\res\\Almaza_EPG.txt");
//    }

    public EPG parseEPGCMDLog(File file) {

        EPG myEPG = new EPG();

        myEPG.addCard(exeShowCard(file));
        myEPG.setMemory(exeShowMemory(file));
        myEPG.setEpgStatistics(exeStatistics(file));
        myEPG.addNotification(exeActiveNotifications(file));


        boolean readSlot = false;
        boolean readredundancy = false;
        boolean readPort = false;

        EPGCard epgCard2 = new EPGCard();


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                //redundancy
                if (line.contains(">show redundancy")) {
                    readredundancy = true;
                    myEPG.setRedundancyStatus("Active");
                    continue;
                } else if (line.contains("[local]") && readredundancy) {
                    readredundancy = false;
                }

                if (readredundancy && !line.contains("--") && !line.contains("This vRP") && !line.equals("") && !line.contains("Switch")) {
//                    System.out.println("##" + line);
                    if (!line.contains("YES") && !line.contains("SUCCESS")) {
                        myEPG.setRedundancyStatus("Not Active");
                    }
                }

//

                //slots
                if (line.contains(">show card")) {
                    readSlot = true;
                } else if (line.contains("[local]") && !line.contains(">show card")) {
                    readSlot = false;
                }

                if (readSlot) {
//                    System.out.println(line);
                    if (line.contains(":") && !line.contains("Slot")) {
                        String slotName = "";
                        String adminStatus = "";

                        //prepare line
                        line = line.trim().replaceAll("  +", ",").replace(" : ", ",");

                        slotName = line.split(",")[1];
                        slotName = slotName.equals("n/a") ? line.split(",")[0] : slotName + "(" + line.split(",")[0] + ")";

                        adminStatus = line.split(",")[4];

//                        System.out.println(slotName + "," + adminStatus);

                        EPGSlot epgSlot = new EPGSlot();
                        epgSlot.setName(slotName);
                        epgSlot.setAdminStatus(adminStatus);

                        myEPG.addSlot(epgSlot);
                    }
                }

                if (line.contains(">show port all")) {
                    readPort = true;
                    continue;
                } else if (readPort && line.contains("[local]")) {
                    readPort = false;
                }

                if (readPort && !line.equals("") && !line.contains("Slot/Port") && !line.contains("---") && !line.contains("Unconfigured")) {
                    line = line.trim().replaceAll(" +", ",");
//                    System.out.println("##############" +line);
                    EPGPort epgPort = new EPGPort();
                    epgPort.setName(line.split(",")[0]);
                    epgPort.setType(line.split(",")[1]);
                    epgPort.setState(line.split(",")[2]);

                    myEPG.addPort(epgPort);

                }



            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("EPG: " + myEPG);
//        System.out.println("Red:" + myEPG.getRedundancyStatus());
        return myEPG;
    }


    public ArrayList<EPGCard> exeShowCard(File file) {

        boolean readCard = false;
        boolean readBoard = false;

        ArrayList<EPGCard> cards = new ArrayList<>();
        EPGCard epgCard = new EPGCard();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            boolean pLine = false;

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                //Cards
                if (line.contains(">ManagedElement=1,Epg=1,Node=1,status")) {
                    readCard = true;
                    continue;
                } else if (readCard && line.contains("(exec)")) {
                    readCard = false;
                    continue;
                }

                //inside one board
                if (readCard && line.contains("board-information:")) {
                    readBoard = true;
                    epgCard = new EPGCard();
                    continue;
                }

                if (readBoard && line.contains("board:")) {
                    epgCard.setServiceInterface(line.trim().split(":")[1].trim());
                }

                if (readBoard && line.contains("start-time:")) {
                    epgCard.setStartTime(line.trim().split(": ")[1].trim());
                }

                if (readBoard && line.contains("function-name:")) {
                    epgCard.setFunction(line.trim().split(":")[1].trim());
                    readBoard = false;
                    cards.add(epgCard);
                }

            }
//                System.out.println(">>>>>>>>" + line);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cards);
        return cards;
    }


    public EPGMemory exeShowMemory(File file) {


        EPGMemory myEPGMemory = new EPGMemory();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            boolean pLine = false;

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                //// code here

                // GetMemory
                if (line.contains("Memory") && line.contains("Total") && line.contains("Free")) {
                    System.out.println("MEMORY");
                    int totalMemory = Integer.parseInt(line.split(" ")[2].replace("k,", ""));
                    int usedMemory = Integer.parseInt(line.split(" ")[4].replace("k,", ""));
                    int freeMemory = Integer.parseInt(line.split(" ")[6].replace("k,", ""));


                    System.out.println("Total: " + totalMemory);
                    System.out.println("Used: " + usedMemory);
                    System.out.println("Free: " + freeMemory);
                    myEPGMemory = new EPGMemory();
                    myEPGMemory.setTotalMemory(totalMemory);
                    myEPGMemory.setUsedMemory(usedMemory);
                    myEPGMemory.setFreeMemory(freeMemory);


                    System.out.println("EPGMemory: " + myEPGMemory);

                }


                // code end here

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(myEPGMemory);
        return myEPGMemory;
    }


    public EPGStatistics exeStatistics(File file) {


        EPGStatistics epgStatistics = new EPGStatistics();


        boolean readUplinkgn = false;
        boolean readUplinks5 = false;
        boolean readDownlinkgn = false;
        boolean readDownlinks5 = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            boolean pLine = false;

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                //// code here

                //pdp data

                if (line.contains("pdp-active:")) {
                    int pdpActive = Integer.parseInt(line.split(":")[1].replace(" ", ""));

                    epgStatistics.setNoPdpActive(pdpActive);
                    System.out.println(pdpActive);
                }

                //eps-active-bearer
                if (line.contains("eps-active-bearer:")) {
                    int noEpsActiveBearer = Integer.parseInt(line.split(":")[1].replace(" ", ""));

                    epgStatistics.setNoEpsActiveBearer(noEpsActiveBearer);
                    System.out.println(noEpsActiveBearer);
                }

                //uplink/downlink
                if (line.contains("uplink-gn")) {
                    readUplinkgn = true;
                } else if (line.contains("uplink-s5")) {
                    readUplinks5 = true;
                } else if (line.contains("downlink-gn")) {
                    readDownlinkgn = true;
                } else if (line.contains("downlink-s5")) {
                    readDownlinks5 = true;
                }

                if (line.equals("")) {
                    readUplinkgn = false;
                    readUplinks5 = false;
                    readDownlinkgn = false;
                    readDownlinks5 = false;
                }

                if (readUplinkgn || readUplinks5 || readDownlinkgn || readDownlinks5) {
                    if (line.contains("bytes:")) {
                        double bytes = Double.parseDouble(line.trim().replaceAll(" +", "").split(":")[1].trim());

                        if (readUplinkgn) {
                            epgStatistics.setUplinkGn(bytes);
                        } else if (readUplinks5) {
                            epgStatistics.setUplinkS5(bytes);
                        } else if (readDownlinkgn) {
                            epgStatistics.setDownlinkGn(bytes);
                        } else if (readDownlinks5) {
                            epgStatistics.setDownlinkS5(bytes);
                        }
                    }
                }

                // code end here

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(epgStatistics);
        return epgStatistics;
    }

    //activeNotifications
    public ArrayList<EPGNotification> exeActiveNotifications(File file) {


        ArrayList<EPGNotification> epgNotifications = new ArrayList<>();

        EPGNotification epgNotification = new EPGNotification();

        boolean readNotification = false;


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            boolean pLine = false;

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                //// code here


                //notifications

                if (line.contains("notification:")) {
                    readNotification = true;
                    epgNotification = new EPGNotification();
                    continue;
                } else if (readNotification && line.equals("")) {
                    readNotification = false;
                    epgNotifications.add(epgNotification);
                }


                if (readNotification && line.contains("fault-id:")) {
                    epgNotification.setFaultId(line.trim().split(": ")[1]);
                } else if (readNotification && line.contains("alarm-severity:")) {
                    epgNotification.setAlarmSeverity(line.trim().split(": ")[1]);
                } else if (readNotification && line.contains("specific-problem:")) {
                    epgNotification.setSpecificProblem(line.trim().split(": ")[1]);
                } else if (readNotification && line.contains("managed-object:")) {
                    epgNotification.setManagedObject(line.trim().split(": ")[1]);
                } else if (readNotification && line.contains("additional-text:")) {
                    epgNotification.setAdditionalText(line.trim().split(": ")[1]);
                } else if (readNotification && line.contains("event-time:")) {
                    epgNotification.setEventTime(line.trim().split(": ")[1]);
                }

                // code end here

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(epgNotifications);
        return epgNotifications;
    }


}
