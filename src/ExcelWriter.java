import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * Created by Admin on 2/2/2018.
 */
public class ExcelWriter {

    public static void main(String[] args) {
        EPG almazaEpg = new EPG("D:\\Java\\MyProjects\\EPC_Report\\res\\Almaza_EPG.txt");
        EPG octEpg = new EPG("D:\\Java\\MyProjects\\EPC_Report\\res\\OCT2EPGPCI.txt");


        EPGUtilities epgUtilities = new EPGUtilities();
        almazaEpg = epgUtilities.parseEPGCMDLog(almazaEpg.getCmdOutFile());
        octEpg = epgUtilities.parseEPGCMDLog(octEpg.getCmdOutFile());
        ExcelWriter excelWriter = new ExcelWriter();
        excelWriter.writeData(almazaEpg,"ALMAZA-EPG01");
        excelWriter.writeData(octEpg,"OCT-EPG01");
    }

    private void writeData(EPG epg,String sheetName) {
        //Read the spreadsheet that needs to be updated




        try {

            InputStream inp = new FileInputStream("D:\\Java\\MyProjects\\EPC_Report\\res\\IPWork_EPG_report.xlsx");
            Workbook wb = WorkbookFactory.create(inp);

            Sheet sheet = wb.getSheet(sheetName);
            //write slots .. row 4 .. column 1,2
            int r = 4;
            for(EPGSlot epgSlot:epg.getSlots()) {
                sheet.getRow(r).getCell(1).setCellValue(epgSlot.getName());
                sheet.getRow(r).getCell(2).setCellValue(epgSlot.getAdminStatus());
                r++;
            }

            //write ports .. row 4 .. column 4,5
            r=4;
            for(EPGPort epgPort:epg.getPorts()) {
                sheet.getRow(r).getCell(4).setCellValue(epgPort.getName());
                sheet.getRow(r).getCell(5).setCellValue(epgPort.getState());
                r++;
            }


            //write cards .. row 4 .. column 7,8,9
            r=4;
            for(EPGCard epgCard:epg.getCards()) {
                sheet.getRow(r).getCell(7).setCellValue(epgCard.getServiceInterface());
                sheet.getRow(r).getCell(8).setCellValue(epgCard.getFunction());
                sheet.getRow(r).getCell(9).setCellValue(epgCard.getStartTime());
                r++;
            }


            // redundancy
            sheet.getRow(32).getCell(1).setCellValue(epg.getRedundancyStatus());

            // pdp
            sheet.getRow(32).getCell(5).setCellValue(epg.getEpgStatistics().getNoPdpActive());
            sheet.getRow(33).getCell(5).setCellValue(epg.getEpgStatistics().getNoEpsActiveBearer());

            // gtp statistics
            sheet.getRow(32).getCell(8).setCellValue(epg.getEpgStatistics().getUplinkGn());
            sheet.getRow(33).getCell(8).setCellValue(epg.getEpgStatistics().getUplinkS5());
            sheet.getRow(34).getCell(8).setCellValue(epg.getEpgStatistics().getDownlinkGn());
            sheet.getRow(35).getCell(8).setCellValue(epg.getEpgStatistics().getDownlinkS5());

            //memory
            sheet.getRow(35).getCell(2).setCellValue(epg.getMemory().getTotalMemory());
            sheet.getRow(36).getCell(2).setCellValue(epg.getMemory().getUsedMemory());
            sheet.getRow(37).getCell(2).setCellValue(epg.getMemory().getFreeMemory());
            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

            sheet.getRow(38).getCell(2).setCellValue(evaluator.evaluate(sheet.getRow(38).getCell(2)).getNumberValue());

            XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
            style.setFillForegroundColor(new XSSFColor(new java.awt.Color(221, 235, 247)));
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);


            // active notification
            r=43;
            for(EPGNotification epgNotification:epg.getNotifications()) {
                System.out.println("Row: " + r);

                sheet.getRow(r).createCell(2).setCellValue("fault-id");
                sheet.getRow(r).getCell(2).setCellStyle(style);

                sheet.getRow(r).createCell(3).setCellValue(epgNotification.getFaultId());
                sheet.getRow(r).getCell(3).setCellStyle(style);

                r++;

                sheet.getRow(r).createCell(2).setCellValue("alarm-severity");
                sheet.getRow(r).getCell(2).setCellStyle(style);


                sheet.getRow(r).createCell(3).setCellValue(epgNotification.getAlarmSeverity());
                sheet.getRow(r).getCell(3).setCellStyle(style);

                r++;

                sheet.getRow(r).createCell(2).setCellValue("specific-problem");
                sheet.getRow(r).getCell(2).setCellStyle(style);


                sheet.getRow(r).createCell(3).setCellValue(epgNotification.getSpecificProblem());
                sheet.getRow(r).getCell(3).setCellStyle(style);

                r++;

                sheet.getRow(r).createCell(2).setCellValue("managed-object");
                sheet.getRow(r).getCell(2).setCellStyle(style);

                sheet.getRow(r).createCell(3).setCellValue(epgNotification.getManagedObject());
                sheet.getRow(r).getCell(3).setCellStyle(style);

                r++;

                sheet.getRow(r).createCell(2).setCellValue("additional-text");
                sheet.getRow(r).getCell(2).setCellStyle(style);


                sheet.getRow(r).createCell(3).setCellValue(epgNotification.getAdditionalText());
                sheet.getRow(r).getCell(3).setCellStyle(style);

                r++;

                sheet.getRow(r).createCell(2).setCellValue("event-time");
                sheet.getRow(r).getCell(2).setCellStyle(style);


                sheet.getRow(r).createCell(3).setCellValue(epgNotification.getEventTime());
                sheet.getRow(r).getCell(3).setCellStyle(style);

                r++; r++;
            }









            //shift rows ... at the end
            //get count of rows to remove
            // 25 - max of slots/ports/cards > no to delete
            // remove start = 4 + max of slots
            // remove end = 28
            // remove count = 25 - max
            // shift start = 4 + max + 1

//            int max =epg.getSlots().size();
//            max = max>epg.getPorts().size()?max:epg.getPorts().size();
//            max = max>epg.getCards().size()?max:epg.getCards().size();
//
//            System.out.println("Max: " + max);
//
//
//            for(int i=4+max;i<=28;i++) {
//                System.out.println("removing ... " + i);
//                sheet.removeRow(sheet.getRow(i));
//            }
//
//            // start to delete at
//
//            sheet.shiftRows(29,50,-(25 - max));



            FileOutputStream fileOut = new FileOutputStream("D:\\Java\\MyProjects\\EPC_Report\\res\\IPWork_EPG_report.xlsx");
            wb.write(fileOut);

            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }


    }


}
