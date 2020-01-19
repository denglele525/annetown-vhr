package net.shopxx.shopxxhr.utils;

import net.shopxx.shopxxhr.model.Position;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class POIUtils {

    public static ResponseEntity<byte[]> employee2Excel(List<net.shopxx.shopxxhr.model.Employee> list) {
        //创建excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建文档摘要
        workbook.createInformationProperties();
        //获取并配置文档摘要信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("员工信息");
        //文档管理员
        docInfo.setManager("javaboy");
        //设置公司信息
        docInfo.setCompany("www.shopxx.net");
        //获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();
        //文档标题
        summInfo.setTitle("员工信息表");
        //文档作者
        summInfo.setAuthor("邓乐乐");
        //文档备注
        summInfo.setComments("本文档由邓乐乐提供");

        //创建样式
        //创建标题行的样式
        HSSFCellStyle headStyle = workbook.createCellStyle();
        headStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFSheet sheet = workbook.createSheet("员工信息表");
        //列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 5 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 10 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 16 * 256);
        sheet.setColumnWidth(9, 12 * 256);
        sheet.setColumnWidth(10, 15 * 256);
        sheet.setColumnWidth(11, 20 * 256);
        sheet.setColumnWidth(12, 16 * 256);
        sheet.setColumnWidth(13, 14 * 256);
        sheet.setColumnWidth(14, 14 * 256);
        sheet.setColumnWidth(15, 12 * 256);
        sheet.setColumnWidth(16, 8 * 256);
        sheet.setColumnWidth(17, 20 * 256);
        sheet.setColumnWidth(18, 20 * 256);
        sheet.setColumnWidth(19, 15 * 256);
        sheet.setColumnWidth(20, 8 * 256);
        sheet.setColumnWidth(21, 25 * 256);
        sheet.setColumnWidth(22, 14 * 256);
        sheet.setColumnWidth(23, 15 * 256);
        sheet.setColumnWidth(24, 15 * 256);
        sheet.setColumnWidth(25, 15 * 256);
        //创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(headStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellValue("姓名");
        c1.setCellStyle(headStyle);
        HSSFCell c2 = r0.createCell(2);
        c2.setCellValue("工号");
        c2.setCellStyle(headStyle);
        HSSFCell c3 = r0.createCell(3);
        c3.setCellValue("性别");
        c3.setCellStyle(headStyle);
        HSSFCell c4 = r0.createCell(4);
        c4.setCellValue("出生日期");
        c4.setCellStyle(headStyle);
        HSSFCell c5 = r0.createCell(5);
        c5.setCellValue("身份证号码");
        c5.setCellStyle(headStyle);
        HSSFCell c6 = r0.createCell(6);
        c6.setCellValue("婚姻状况");
        c6.setCellStyle(headStyle);
        HSSFCell c7 = r0.createCell(7);
        c7.setCellValue("民族");
        c7.setCellStyle(headStyle);
        HSSFCell c8 = r0.createCell(8);
        c8.setCellValue("籍贯");
        c8.setCellStyle(headStyle);
        HSSFCell c9 = r0.createCell(9);
        c9.setCellValue("政治面貌");
        c9.setCellStyle(headStyle);
        HSSFCell c10 = r0.createCell(10);
        c10.setCellValue("电话号码");
        c10.setCellStyle(headStyle);
        HSSFCell c11 = r0.createCell(11);
        c11.setCellValue("联系地址");
        c11.setCellStyle(headStyle);
        HSSFCell c12 = r0.createCell(12);
        c12.setCellValue("所属部门");
        c12.setCellStyle(headStyle);
        HSSFCell c13 = r0.createCell(13);
        c13.setCellValue("职称");
        c13.setCellStyle(headStyle);
        HSSFCell c14 = r0.createCell(14);
        c14.setCellValue("职位");
        c14.setCellStyle(headStyle);
        HSSFCell c15 = r0.createCell(15);
        c15.setCellValue("聘用形式");
        c15.setCellStyle(headStyle);
        HSSFCell c16 = r0.createCell(16);
        c16.setCellValue("最高学历");
        c16.setCellStyle(headStyle);
        HSSFCell c17 = r0.createCell(17);
        c17.setCellValue("专业");
        c17.setCellStyle(headStyle);
        HSSFCell c18 = r0.createCell(18);
        c18.setCellValue("毕业院校");
        c18.setCellStyle(headStyle);
        HSSFCell c19 = r0.createCell(19);
        c19.setCellValue("入职日期");
        c19.setCellStyle(headStyle);
        HSSFCell c20 = r0.createCell(20);
        c20.setCellValue("在职状态");
        c20.setCellStyle(headStyle);
        HSSFCell c21 = r0.createCell(21);
        c21.setCellValue("邮箱");
        c21.setCellStyle(headStyle);
        HSSFCell c22 = r0.createCell(22);
        c22.setCellValue("合同期限(年)");
        c22.setCellStyle(headStyle);
        HSSFCell c23 = r0.createCell(23);
        c23.setCellValue("合同起始日期");
        c23.setCellStyle(headStyle);
        HSSFCell c24 = r0.createCell(24);
        c24.setCellValue("合同终止日期");
        c24.setCellStyle(headStyle);
        HSSFCell c25 = r0.createCell(25);
        c25.setCellValue("合同转正日期");
        c25.setCellStyle(headStyle);

        for (int i = 0; i < list.size(); i++) {
            net.shopxx.shopxxhr.model.Employee emp = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getName());
            row.createCell(2).setCellValue(emp.getWorkId());
            row.createCell(3).setCellValue(emp.getGender());
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellStyle(dateCellStyle);
            cell4.setCellValue(emp.getBirthday());
            row.createCell(5).setCellValue(emp.getIdCard());
            row.createCell(6).setCellValue(emp.getWedlock().name());
            row.createCell(7).setCellValue(emp.getNation().getName());
            row.createCell(8).setCellValue(emp.getNativePlace());
            row.createCell(9).setCellValue(emp.getPolitic().getName());
            row.createCell(10).setCellValue(emp.getPhone());
            row.createCell(11).setCellValue(emp.getAddress());
            row.createCell(12).setCellValue(emp.getDepartment().getName());
            row.createCell(13).setCellValue(emp.getJoblevel().getName());
            row.createCell(14).setCellValue(emp.getPos().getName());
            row.createCell(15).setCellValue(emp.getEngageForm());
            row.createCell(16).setCellValue(emp.getTiptopDegree().name());
            row.createCell(17).setCellValue(emp.getSpecialty());
            row.createCell(18).setCellValue(emp.getSchool());
            HSSFCell cell19 = row.createCell(19);
            cell19.setCellStyle(dateCellStyle);
            cell19.setCellValue(emp.getBeginDate());
            row.createCell(20).setCellValue(emp.getWorkState().name());
            row.createCell(21).setCellValue(emp.getEmail());
            row.createCell(22).setCellValue(emp.getContractTerm());
            HSSFCell cell23 = row.createCell(23);
            cell23.setCellStyle(dateCellStyle);
            cell23.setCellValue(emp.getContractTerm());
            HSSFCell cell24 = row.createCell(24);
            cell24.setCellStyle(dateCellStyle);
            cell24.setCellValue(emp.getEndContract());
            HSSFCell cell25 = row.createCell(25);
            cell25.setCellStyle(dateCellStyle);
            cell25.setCellValue(emp.getConversionTime());
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("员工表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    public static List<net.shopxx.shopxxhr.model.Employee> excel2Employee(MultipartFile file, List<net.shopxx.shopxxhr.model.Nation> allNations, List<net.shopxx.shopxxhr.model.Politicsstatus> allPoliticsstatuses, List<net.shopxx.shopxxhr.model.Department> allDepartments, List<Position> allPositions, List<net.shopxx.shopxxhr.model.JobLevel> allJobLevels) {
        List<net.shopxx.shopxxhr.model.Employee> list = new ArrayList<>();
        try {
            net.shopxx.shopxxhr.model.Employee employee = null;
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;
                    }
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    employee = new net.shopxx.shopxxhr.model.Employee();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellType()) {
                            case STRING:
                                String cellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 1:
                                        employee.setName(cellValue);
                                        break;
                                    case 2:
                                        employee.setWorkId(Integer.parseInt(cellValue));
                                        break;
                                    case 3:
                                        employee.setGender(cellValue);
                                        break;
                                    case 5:
                                        employee.setIdCard(cellValue);
                                        break;
                                    case 6:
                                        employee.setWedlock(net.shopxx.shopxxhr.model.Employee.Wedlock.valueOf(cellValue));
                                        break;
                                    case 7:
                                        int nationIndex = allNations.indexOf(new net.shopxx.shopxxhr.model.Nation(cellValue));
                                        employee.setNation(allNations.get(nationIndex));
                                        break;
                                    case 8:
                                        employee.setNativePlace(cellValue);
                                        break;
                                    case 9:
                                        int politicsstatusIndex = allPoliticsstatuses.indexOf(new net.shopxx.shopxxhr.model.Politicsstatus(cellValue));
                                        employee.setPolitic(allPoliticsstatuses.get(politicsstatusIndex));
                                        break;
                                    case 10:
                                        employee.setPhone(cellValue);
                                        break;
                                    case 11:
                                        employee.setAddress(cellValue);
                                        break;
                                    case 12:
                                        int departmentIndex = allDepartments.indexOf(new net.shopxx.shopxxhr.model.Department(cellValue));
                                        employee.setDepartment(allDepartments.get(departmentIndex));
                                        break;
                                    case 13:
                                        int jobLevelIndex = allJobLevels.indexOf(new net.shopxx.shopxxhr.model.JobLevel(cellValue));
                                        employee.setJoblevel(allJobLevels.get(jobLevelIndex));
                                        break;
                                    case 14:
                                        int positionIndex = allPositions.indexOf(new Position(cellValue));
                                        employee.setPos(allPositions.get(positionIndex));
                                        break;
                                    case 15:
                                        employee.setEngageForm(cellValue);
                                        break;
                                    case 16:
                                        employee.setTiptopDegree(net.shopxx.shopxxhr.model.Employee.TiptopDegree.valueOf(cellValue));
                                        break;
                                    case 17:
                                        employee.setSpecialty(cellValue);
                                        break;
                                    case 18:
                                        employee.setSchool(cellValue);
                                        break;
                                    case 20:
                                        employee.setWorkState(net.shopxx.shopxxhr.model.Employee.WorkState.valueOf(cellValue));
                                        break;
                                    case 21:
                                        employee.setEmail(cellValue);
                                        break;
                                }
                                break;
                            default: {
                                switch (k) {
                                    case 4:
                                        employee.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 19:
                                        employee.setBeginDate(cell.getDateCellValue());
                                        break;
                                    case 23:
                                        employee.setBeginContract(cell.getDateCellValue());
                                        break;
                                    case 24:
                                        employee.setEndContract(cell.getDateCellValue());
                                        break;
                                    case 22:
                                        employee.setContractTerm(cell.getNumericCellValue());
                                        break;
                                    case 25:
                                        employee.setConversionTime(cell.getDateCellValue());
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    list.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
